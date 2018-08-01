package br.com.portadosdesesperados;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayerVsPlayer {
    public static void inicio(Jogador jogador, Transfer transmissor) {
        Partida partida = new Partida();
        Palco palco = partida.getPalco();

        Boolean vencedor = false;
        Integer jogadorDaVez = 1;

        Jogador jogadorServidor = null;
        Jogador jogadorCliente = null;

        try {
            if (transmissor.getTipoTransfer() == "Servidor"){
                jogadorServidor = jogador;
                transmissor.transmitir(1, jogadorServidor.getNome());
                jogadorCliente = new Jogador( transmissor.receber(1) );
            } else {
                jogadorCliente = jogador;
                transmissor.transmitir(1, jogadorCliente.getNome());
                jogadorServidor = new Jogador( transmissor.receber(1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n========= Modo Player vs Player =========\n");
        System.out.println(Jogo.regras());
        Jogo.aguardar(5);

        System.out.println("O jogo iniciará em...");
        for (int i = 3; i <= 1; i--){
            System.out.println(i);
            Jogo.aguardar(1);
        }

        System.out.println("Disputa " + jogadorServidor.getNome() + " x " + jogadorCliente.getNome());

        while1:

        while (true) {
            Boolean numeroInvalido = true;

            System.out.println(palco);
            Jogo.aguardar(1);
            System.out.println("O Nível é " + partida.getLevel().getNivelDificuldade() + "\n");
            Jogo.aguardar(1);

            System.out.println(jogadorServidor);
            System.out.println(jogadorCliente);
            Jogo.aguardar(1);

            try {
                if (jogadorDaVez == 1) {
                    if ( transmissor.getTipoTransfer() == "Servidor" ) {
                        System.out.println("Sérgio Mallandro: '" + jogadorServidor.getNome() + " qual porta você quer?");
                        while (numeroInvalido) {
                            numeroInvalido = false;

                            System.out.print("- Digite o número da porta: ");
                            Scanner sc = new Scanner(System.in);
                            Integer numeroDaPorta = sc.nextInt();

                            transmissor.transmitir(1, String.valueOf(numeroDaPorta));

                            Porta porta = partida.escolherPorta(numeroDaPorta);
                            porta.setNumero("X");
                            try {
                                System.out.println(partida.abrirPorta(jogadorServidor, porta));
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                                transmissor.transmitir(1, "fim");
                                break while1;
                            }
                        }
                    }
                    if (transmissor.getTipoTransfer() == "Cliente") {
                        System.out.println("Aguarde! É a vez de " + jogadorServidor.getNome() + " jogar!" );
                        Porta porta = null;

                        while (porta == null) {
                            String mensagem = transmissor.receber(1);
                            if (mensagem == "fim") {
                                System.out.println(jogadorServidor.getNome() + " perdeu!!!!");
                                vencedor = true;
                                break while1;
                            }
                            porta = partida.escolherPorta(Integer.valueOf(mensagem));
                        }
                        porta.setNumero("X");
                    }
                    jogadorDaVez = 2;
                } else if (jogadorDaVez == 2) {
                    if ( transmissor.getTipoTransfer() == "Cliente" ) {
                        System.out.println("Sérgio Mallandro: '" + jogadorCliente.getNome() + " qual porta você quer?");
                        while (numeroInvalido) {
                            numeroInvalido = false;

                            System.out.print("- Digite o número da porta: ");
                            Scanner sc = new Scanner(System.in);
                            Integer numeroDaPorta = sc.nextInt();

                            transmissor.transmitir(1, String.valueOf(numeroDaPorta));

                            Porta porta = partida.escolherPorta(numeroDaPorta);
                            porta.setNumero("X");
                            try {
                                System.out.println(partida.abrirPorta(jogadorServidor, porta));
                            } catch (Exception ex) {
                                System.out.println(ex.getMessage());
                                transmissor.transmitir(1, "fim");
                                break while1;
                            }
                        }
                    }
                    if (transmissor.getTipoTransfer() == "Servidor") {
                        System.out.println("Aguarde! É a vez de " + jogadorCliente.getNome() + " jogar!" );
                        Porta porta = null;

                        while (porta == null) {
                            String mensagem = transmissor.receber(1);
                            if (mensagem == "fim") {
                                System.out.println(jogadorServidor.getNome() + " perdeu!!!!");
                                vencedor = true;
                                break while1;
                            }
                            porta = partida.escolherPorta(Integer.valueOf(mensagem));
                        }
                        porta.setNumero("X");
                    }
                    jogadorDaVez = 1;
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

        System.out.println(palco);

        verificaVencedor(vencedor);

        System.out.println("Você fez " + jogador.getPontuacao() + " pontos!!!");

    }
    private static void verificaVencedor(Boolean vencedor){
        if (vencedor) {
            System.out.println("\nAcabou o jogo! Você venceu!!!");
        } else {
            System.out.println("\nAcabou o jogo!");
        }
    }
}
