package br.com.portadosdesesperados;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server implements Transfer {
    private ServerSocket sock;
    private Socket client;
    private InputStream in;
    private BufferedReader bin;


    @Override
    public void transmitir() throws IOException {
        PrintWriter pout = new PrintWriter(this.client.getOutputStream(), true);
        pout.println(new Date().toString() + "-Boa noite alunos!");
    }

    @Override
    public String receber() throws IOException {
        String line = this.bin.readLine();
        System.out.println("O cliente me disse: " + line);
        return null;
    }

    @Override
    public void desconectar() throws IOException {
        this.client.close();
    }

    @Override
    public void conectar() throws IOException {
        this.sock = new ServerSocket(6013);
        this.in = this.client.getInputStream();
        this.bin = new BufferedReader(new InputStreamReader(this.in));
        System.out.println("=== Servidor iniciado ===\n");
        Socket client = this.sock.accept();
        System.out.println("Servidor recebeu comunicação do ip: " + client.getInetAddress() + "-" + client.getPort());
    }
}
