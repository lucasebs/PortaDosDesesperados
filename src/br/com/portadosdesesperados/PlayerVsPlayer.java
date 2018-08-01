package br.com.portadosdesesperados;

import jdk.nashorn.api.tree.WhileLoopTree;

import java.io.IOException;
import java.net.SocketException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayerVsPlayer {
    public static void inicio(Jogador jogador, Transfer transmissor) {
        Partida partida = new Partida();
        Palco palco = partida.getPalco();
        Boolean vencedor = false;
        Boolean encerrarPartida = false;
        Jogador jogador1 = jogador;
        Jogador jogador2 = null;
        try {
            transmissor.transmitir(1, jogador);
            jogador2 = (Jogador) transmissor.receber(1);

        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("\n========= Modo Player vs Player =========\n");

        System.out.println(Jogo.regras());

        Jogo.aguardar(5);

        System.out.println("O jogo iniciará em...");
        for (int i = 5; i <= 1; i--){
            System.out.println(i);
        }

        //            transmissor.transmitir(0,"Você está jogando contra " + jogador.getNome());
//            System.out.println(transmissor.receber(0));
        System.out.println("Você está jogando contra " + jogador2.getNome());

        while1:

        while (true) {
//            for (int i = 1; i < palco.getQuantidadePortas() ; i++) {
            Boolean numeroInvalido = true;

            System.out.println(palco);
            Jogo.aguardar(1);
            System.out.println("O Nível é " + partida.getLevel().getNivelDificuldade() + "\n");
            Jogo.aguardar(1);

            System.out.println(jogador);
            System.out.println(jogador2);

            Jogo.aguardar(1);

            System.out.println("Sérgio Mallandro: 'Qual porta você quer?");
            while (numeroInvalido) {
                numeroInvalido = false;

                System.out.print("- Digite o número da porta: ");
                Scanner sc = new Scanner(System.in);

                try {
                    Porta porta = partida.escolherPorta(sc.nextInt());
                    porta.setNumero("X");
                    try {
                        System.out.println(partida.abrirPorta(jogador, porta));
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                        break while1;
                    }

                } catch (InputMismatchException ex ) {
                    System.out.println("\nMuita calma nesta hora!!! Porta Inválida! Escolha outra porta!\n");
                } catch (Exception ex){
                    numeroInvalido = true;
                    System.out.println("\nMuita calma nesta hora!!! " + ex.getMessage() + " Escolha outra porta!\n");
                }
                Jogo.aguardar(1);
            }
            Jogo.aguardar(1);
//            if (partida.getLevel().getQuantidadeMonstros() == 5) {
//                vencedor = true;
//            }
//            }

        }

        Jogo.aguardar(1);

        System.out.println(palco);

        if (vencedor) {
            System.out.println("\nAcabou o jogo! Você venceu!!!");
        } else {
            System.out.println("\nAcabou o jogo!");
        }
        System.out.println("Você fez " + jogador.getPontuacao() + " pontos!!!");

    }
}
