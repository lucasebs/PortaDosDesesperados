package br.com.portadosdesesperados;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Conexao {
    public void cliente () {
//        try {
////            Socket sock = new Socket("192.168.15.7",6013);
////            InputStream in = sock.getInputStream();
////            BufferedReader bin = new BufferedReader(new InputStreamReader(in));
////
////            System.out.println("=== Cliente iniciado ===\n");
////
////            String line = bin.readLine();
////            System.out.println("O servidor me disse:" + line);
////
////            PrintWriter pout = new PrintWriter(sock.getOutputStream(), true);
////            pout.println(new Date().toString() + " Lucas"  );
////
////            sock.close();
//        } catch (IOException ioe) {
//            System.err.println(ioe);
//        }
//
//
//

    }

    public void servidor () {
//        try {
////            ServerSocket sock = new ServerSocket(6013);
////
////            System.out.println("=== Servidor iniciado ===\n");
////            // escutando por conexões
////            while (true) {
////                Socket client = sock.accept();
////                // Se chegou aqui, foi porque algum cliente se comunicou
////                System.out.println("Servidor recebeu comunicação do ip: " + client.getInetAddress() + "-" + client.getPort());
////                PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
////
////                // Escreve a data atual no socket
////                pout.println(new Date().toString() + "-Boa noite alunos!");
////
////                InputStream in = client.getInputStream();
////                BufferedReader bin = new BufferedReader(new InputStreamReader(in));
////
////                String line = bin.readLine();
////                System.out.println("O cliente me disse: " + line);
////
////                // fechar o socket e volta no loop para escutar novas conexões
////                client.close();
////            }
//        } catch (IOException ioe) {
//            System.err.println(ioe);
//        }
    }
}
