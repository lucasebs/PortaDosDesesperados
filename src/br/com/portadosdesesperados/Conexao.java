package br.com.portadosdesesperados;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Conexao {
    private Transfer transfer;

    public Conexao() throws IOException {
        System.out.println("= Iniciando Conexão =");
        this.setTransfer();

        this.transfer.conectar();
    }

//    public void conectar() {
//        System.out.println("= Iniciando Conexão =");
//
//    }

    public void setTransfer() {
        System.out.println("Você é:\n" +
                "1 - Servidor\n" +
                "2 - Cliente\n");
        System.out.print("$");
        Scanner sc = new Scanner(System.in);

        if (sc.nextInt() == 1 || sc.next().equalsIgnoreCase("servidor")) {
            this.transfer = new Server();
        } else if (sc.nextInt() == 2 || sc.next().equalsIgnoreCase("cliente")) {
            this.transfer = new Client();
        }
    }

    public Transfer getTransfer() {
        return this.transfer;
    }

    public void encerrar() throws IOException {
        this.transfer.desconectar();
    }
}
