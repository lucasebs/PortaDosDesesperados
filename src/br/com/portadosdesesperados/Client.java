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
    public void transmitir(String mensagem) throws IOException {
        PrintWriter pout = new PrintWriter(this.sock.getOutputStream(), true);
        pout.println(mensagem);
    }

    @Override
    public String receber() throws IOException, SocketException {
        this.in = this.sock.getInputStream();
        if (in == null){
            return null;
        }
        this.bin = new BufferedReader(new InputStreamReader(this.in));
        String line = this.bin.readLine();
        return line + "\n";

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
