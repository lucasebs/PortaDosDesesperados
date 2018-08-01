package br.com.portadosdesesperados;

import javax.imageio.IIOException;
import java.io.IOException;
import java.net.SocketException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Survivor {
    public static void inicio(Jogador jogador, Transfer transfer) {
        Transfer transmissor = transfer;
        Partida partida = new Partida();
        Palco palco = partida.getPalco();
        Boolean vencedor = false;

        System.out.println("\n========= Modo Survivor =========\n");

        System.out.println(Jogo.regras());

        Jogo.aguardar(5);

        System.out.println("Pressione 'Enter' para começar...");
        Scanner enter = new Scanner(System.in);
        enter.nextLine();

        try {
            transmissor.transmitir(0, "Você está jogando contra " + jogador.getNome());
            System.out.println(transmissor.receber(0));

            for1:
            for (int i = 1; i < palco.getQuantidadePortas() ; i++) {
                Boolean numeroInvalido = true;

                System.out.println(palco);
                Jogo.aguardar(1);
                System.out.println("O Nível é " + partida.getLevel().getNivelDificuldade() + "\n");
                Jogo.aguardar(1);

                transmissor.transmitir(0,jogador.toString());
                System.out.println(jogador);
                System.out.println(transmissor.receber(0));

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
                            break for1;
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
                if (i == 4) {
                    vencedor = true;
                }
            }
            Jogo.aguardar(1);

            System.out.println(palco);

            if (vencedor) {
                System.out.println("\nAcabou o jogo! Você venceu!!!");
            } else {
                System.out.println("\nAcabou o jogo!");
            }
            System.out.println("Você fez " + jogador.getPontuacao() + " pontos!!!");

//            while (true) {
//                String mensagem = transmissor.receber();
//                if (mensagem == null) {
//                    break;
//                }
//                System.out.println(mensagem);
//            }

        } catch (SocketException e) {
            System.out.println("\nJogo encerrado! Seu oponente perdeu!\n");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
