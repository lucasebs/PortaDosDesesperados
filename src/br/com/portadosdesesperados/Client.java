package br.com.portadosdesesperados;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Client implements Transfer {
    private Socket sock;
    private InputStream in;
    private BufferedReader bin;
    private String tipoTransfer = "Cliente";


    @Override
    public void transmitir(Integer chave, String mensagem) throws IOException {
//        if (chave == 0){
            PrintWriter pout = new PrintWriter(this.sock.getOutputStream(), true);
            pout.println(mensagem);
//        }
//        if (chave == 1) {
//            ObjectOutputStream output = new ObjectOutputStream(this.sock.getOutputStream());
//            output.writeObject(mensagem);
////            PrintWriter pout = new PrintWriter(this.sock.getOutputStream(), true);
////            pout.println(mensagem);
//        }
    }

    @Override
    public String receber(Integer chave) throws IOException, SocketException {
        this.in = this.sock.getInputStream();
        if (in == null){
            return null;
        }
        this.bin = new BufferedReader(new InputStreamReader(this.in));
        String line = this.bin.readLine();
        return line;
//        if (chave == 0){
//            this.in = this.sock.getInputStream();
//            if (in == null){
//                return null;
//            }
//            this.bin = new BufferedReader(new InputStreamReader(this.in));
//            String line = this.bin.readLine();
//            return line + "\n";
//        }
//        return null;
//        this.in = this.sock.getInputStream();
//        if (in == null){
//            return null;
//        }
//        this.bin = new BufferedReader(new InputStreamReader(this.in));
//        if (chave == 0){
//            this.bin = new BufferedReader(new InputStreamReader(this.in));
//            String line = this.bin.readLine();
//            return line;
//        }
//        if (chave == 1){
//            ObjectInputStream input = new ObjectInputStream(this.in);
//            Object objInput = null;
//            try {
//                objInput = input.readObject();
//            } catch (ClassNotFoundException e) {
//                System.out.println(e.getMessage());
//                e.printStackTrace();
//            }
//            return objInput;
//        }
//        return null;
    }

    @Override
    public void desconectar() throws IOException {
        this.sock.close();
    }

    @Override
    public void conectar() throws IOException {
        System.out.println("== Cliente Iniciado ==\n");
        this.sock = new Socket("127.0.0.1",6013);
        System.out.println("=== Cliente Conectado ===\n");
    }

    public String getTipoTransfer() {
        return tipoTransfer;
    }
}
