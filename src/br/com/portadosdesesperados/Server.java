package br.com.portadosdesesperados;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server implements Transfer {
    private ServerSocket sock;
    private Socket client;
    private InputStream in;
    private BufferedReader bin;
    private String tipoTransfer = "Servidor";

    @Override
    public void transmitir(Integer chave, String mensagem) throws IOException {
        PrintWriter pout = new PrintWriter(this.client.getOutputStream(), true);
        pout.println(mensagem);

//        if (chave == 0) {
//            PrintWriter pout = new PrintWriter(this.client.getOutputStream(), true);
//            pout.println(mensagem);
//        }
//        if (chave == 1) {
////            ObjectOutputStream output = new ObjectOutputStream(this.client.getOutputStream());
////            output.writeObject(mensagem);
//            PrintWriter pout = new PrintWriter(this.client.getOutputStream(), true);
//            pout.println(mensagem);
//        }
    }


    @Override
    public String receber(Integer chave) throws IOException {
        this.in = this.client.getInputStream();
        if (in == null){
            return null;
        }
        this.bin = new BufferedReader(new InputStreamReader(this.in));
        String line = this.bin.readLine();
        return line;
//        this.in = this.client.getInputStream();
//        if (in == null){
//            return null;
//        }
//        this.bin = new BufferedReader(new InputStreamReader(this.in));
//        if (chave == 0){
////            this.bin = new BufferedReader(new InputStreamReader(this.in));
//            String line = this.bin.readLine();
//            return line + "\n";
//        }
//        if (chave == 1){
//            ObjectInputStream input = new ObjectInputStream(this.in);
//            Object objInput = null;
//            try {
//                objInput = input.readObject();
//            } catch (ClassNotFoundException e) {
//                System.out.println(e.getMessage());
////                e.printStackTrace();
//            }
//            return objInput;
//        }
//        return null;
    }

    @Override
    public void desconectar() throws IOException {
        this.client.close();
    }

    @Override
    public void conectar() throws IOException {
        System.out.println("== Servidor Iniciado ==\n");
        this.sock = new ServerSocket(6013);
//        System.out.println("== Servidor Iniciado ==\n");
        this.client = this.sock.accept();
        System.out.println("=== Servidor Conectado ===\n");
        System.out.println("Cliente conectado do IP "+ this.client.getInetAddress().getHostAddress());

    }

    public String getTipoTransfer() {
        return tipoTransfer;
    }
}

//        System.out.println("Servidor recebeu comunicação do ip: " + client.getInetAddress() + "-" + client.getPort());