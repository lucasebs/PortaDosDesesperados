package br.com.portadosdesesperados;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Solo {
    public static void inicio(Jogador jogador) {
        Partida partida = new Partida();
        Palco palco = partida.getPalco();
        Boolean vencedor = false;

        System.out.println("\n========= Modo Solo =========\n");

        System.out.println(Jogo.regras());

        Jogo.aguardar(5);

        System.out.println("Pressione 'Enter' para começar...");
        Scanner enter = new Scanner(System.in);
        enter.nextLine();

        for1:
        for (int i = 1; i < palco.getQuantidadePortas() ; i++) {
            Boolean numeroInvalido = true;

            System.out.println(palco);
            Jogo.aguardar(1);
            System.out.println("O Nível é " + partida.getLevel().getNivelDificuldade() + "\n");
            Jogo.aguardar(1);
            System.out.println(jogador);

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
    }
}
