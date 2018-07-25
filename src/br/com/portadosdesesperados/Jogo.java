package br.com.portadosdesesperados;

import java.io.IOException;
import java.util.Scanner;

public class Jogo {

    public void inicio(Jogador jogador) {
        Partida partida = new Partida();
        Palco palco = partida.getPalco();

        System.out.println("O jogo funciona da seguinte forma:\n" +
                "- Você escolhe uma porta do palco\n" +
                "- Dentro da porta tem um monstro ou um prêmio\n" +
                "- Se for um prêmio você ganha pontos\n" +
                "- Se for um monstro você se vira\n\n" +
                "Obs:\n1 - Existem níveis diferentes de dificuldade.\n" +
                "2 - Quanto maior o nível mais monstros!!!!!\n\n" +
                "Boa sorte!!!\n");

        for (int i = 1; i <= palco.getQuantidadePortas(); i++) {
            Boolean numeroInvalido = true;
            System.out.println(palco);
            System.out.println("Nível: " + partida.getLevel().getNivelDificuldade() + "\n");
            System.out.println(jogador);

//
//            System.out.print("Sérgio Mallandro: 'Qual porta você quer?'\n- Digite o número da porta: ");
//            Scanner sc = new Scanner(System.in);

            System.out.println("Sérgio Mallandro: 'Qual porta você quer?");
            while (numeroInvalido) {
                numeroInvalido = false;

                System.out.print("- Digite o número da porta: ");
                Scanner sc = new Scanner(System.in);

                try {
                    Porta porta = partida.escolherPorta(sc.nextInt());
                    porta.setNumero("X");
                    System.out.println(partida.abrirPorta(jogador, porta));

//                    if (porta.isMonstro()) {
//                        System.out.println("\n- É um monstro!!! Você perdeu!\n");
//                        break;
//
//                    } else {
//                        System.out.println("\n- É um Prêmio!!!!\n  Prêmio: " + porta.getPremio().getTipoPremio() + "\n");
//                        jogador.setPontuacao(jogador.getPontuacao() + (10 * partida.getLevel().getQuantidadeMonstros()));
//                        partida.aumentarLevel();
//                    }

                }catch (Exception ex){
                    numeroInvalido = true;
                    System.out.println("Muita calma nesta hora!!! " + ex.getMessage() + " Escolha outra porta!\n");
                }

            }

        }

        System.out.println(palco);
        System.out.println("\nAcabou o jogo!\n" +
                           "Você fez " + jogador.getPontuacao() + " pontos!!!");


    }

    public String boasvindas() {
        String mensagem;
        mensagem = "\n'Quem quer abrir a Porta dos Desesperados?'\n";
        mensagem += "                            MALLANDRO, Sergio\n\n";
        mensagem += "---------------------------------------------\n";
        mensagem += "     Bem vindo a Porta dos Desesperados! \n";
        mensagem += "---------------------------------------------\n";
        mensagem += "\nDigite 'EU'(ou seu nome) para começar: ";
        return mensagem;
    }

//    public Integer escolheModoDeJogo() {
//        return null;
//    }

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        Conexao conexao = null;

        System.out.println(jogo.boasvindas());
        Scanner sc = new Scanner(System.in);
        Jogador jogador = new Jogador(sc.next());

        System.out.println("\nBem vindo, " + jogador.getNome() + "! Vamos ao jogo!\n\n" +
                "---------------------------------------------\n");

//        try {
//            conexao = new Conexao();
//        } catch (IOException ioe) {
//            System.out.println(ioe);
//        }

        jogo.inicio(jogador);

//        try {
//            conexao.encerrar();
//        } catch (IOException ioe) {
//            System.out.println(ioe);
//        }
    }

}
