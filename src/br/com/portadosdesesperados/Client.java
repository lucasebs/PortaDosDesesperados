package br.com.portadosdesesperados;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Client implements Transfer {
    private Socket sock;
    private InputStream in;
    private BufferedReader bin;


    @Override
    public void transmitir(Integer chave, Object mensagem) throws IOException {
        if (chave == 0){
            PrintWriter pout = new PrintWriter(this.sock.getOutputStream(), true);
            pout.println(mensagem);
        }

    }

    @Override
    public Object receber(Integer chave) throws IOException, SocketException {
        if (chave == 0){
            this.in = this.sock.getInputStream();
            if (in == null){
                return null;
            }
            this.bin = new BufferedReader(new InputStreamReader(this.in));
            String line = this.bin.readLine();
            return line + "\n";
        }
        return null;
    }

    @Override
    public void desconectar() throws IOException {
        this.sock.close();
    }

    @Override
    public void conectar() throws IOException {
        System.out.println("== Cliente Iniciado ==\n");
        this.sock = new Socket("192.168.15.16",6013);
        System.out.println("=== Cliente Conectado ===\n");
    }
}
