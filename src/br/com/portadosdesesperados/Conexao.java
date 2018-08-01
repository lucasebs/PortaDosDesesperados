package br.com.portadosdesesperados;

import java.io.*;
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
        Integer tipo = sc.nextInt();
        if (tipo == 1 ) {
            this.transfer = new Server();
        } else if (tipo == 2 ) {
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
