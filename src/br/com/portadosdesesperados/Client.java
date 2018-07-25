package br.com.portadosdesesperados;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class Client implements Transfer {
    private Socket sock;
    private InputStream in;
    private BufferedReader bin;


    @Override
    public void transmitir() throws IOException {
        PrintWriter pout = new PrintWriter(this.sock.getOutputStream(), true);
        pout.println(new Date().toString() + " Lucas"  );
    }

    @Override
    public String receber() throws IOException {
        String line = this.bin.readLine();
        System.out.println("O servidor me disse:" + line);
        return null;
    }

    @Override
    public void desconectar() throws IOException {
        this.sock.close();
    }

    @Override
    public void conectar() throws IOException {
        System.out.println("== Cliente Iniciado ==\n");
        this.sock = new Socket("192.168.15.7",6013);
        this.in = this.sock.getInputStream();
        this.bin = new BufferedReader(new InputStreamReader(this.in));
        System.out.println("=== Cliente Conectado ===\n");
    }
}
