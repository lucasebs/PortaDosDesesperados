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


    @Override
    public void transmitir(String mensagem) throws IOException {
        PrintWriter pout = new PrintWriter(this.client.getOutputStream(), true);
        pout.println(mensagem);
    }

    @Override
    public String receber() throws IOException {
        this.in = this.client.getInputStream();
        if (in == null){
            return null;
        }
        this.bin = new BufferedReader(new InputStreamReader(this.in));
        String line = this.bin.readLine();
        return line + "\n";
    }

    @Override
    public void desconectar() throws IOException {
        this.client.close();
    }

    @Override
    public void conectar() throws IOException {
        System.out.println("== Servidor Iniciado ==\n");
        this.sock = new ServerSocket(6013);
        System.out.println("== Servidor Iniciado ==\n");
        this.client = this.sock.accept();
        System.out.println("Cliente conectado do IP "+ this.client.getInetAddress().getHostAddress());
        System.out.println("== Servidor Iniciado ==\n");
    }
}

//        System.out.println("Servidor recebeu comunicação do ip: " + client.getInetAddress() + "-" + client.getPort());