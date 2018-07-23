package br.com.portadosdesesperados;

import java.util.Scanner;

public class Jogo {
//    private Jogador jogador = new Jogador()
//    private Jogador jogador2;

//    public Jogador getJogador() {
//        return jogador;
//    }
//
//    public void setJogador(Jogador jogador) {
//        this.jogador = jogador;
//    }

//    public Jogador getJogador2() {
//        return jogador2;
//    }

//    public void setJogador2(Jogador jogador2) {
//        this.jogador2 = jogador2;
//    }

    public void inicio(Jogador jogador) {
//        System.out.print("Digite 'EU' para começar: ");
        Partida partida = new Partida();
        Palco palco = partida.getPalco();
        jogador.setPontuacao(0);

        System.out.println("O jogo funciona da seguinte forma:\n" +
                "- Você escolhe uma porta do palco\n" +
                "- Dentro da porta tem um monstro ou um prêmio\n" +
                "- Se for um prêmio você ganha pontos\n" +
                "- Se for um monstro você se vira\n\n" +
                "Obs:\n1 - Existem níveis diferentes de dificuldade.\n" +
                "2 - Quanto maior o nível mais monstros!!!!!\n\n" +
                "Boa sorte!!!\n");

        for (int i = 1; i <= palco.getQuantidadePortas(); i++) {
            System.out.println(palco);
            System.out.println(jogador);

            System.out.print("Sérgio Mallandro: 'Qual porta você quer?'\n\nDigite o número da porta: ");
            Scanner sc = new Scanner(System.in);
            Porta porta = partida.escolherPorta(sc.nextInt());

            porta.setNumero("X");
            if (porta.isMonstro()) {
                System.out.println("\n- É um monstro!!!\n");
                break;

            } else {
                System.out.println("\n- É um Prêmio!!!!\n  Prêmio: " + porta.getPremio().getTipoPremio() + "\n");
                jogador.setPontuacao(jogador.getPontuacao() + (10 * partida.getLevel().getQuantidadeMonstros()));
            }
        }

        System.out.println("\nAcabou o jogo!\n" +
                           "Você fez \" + jogador.getPontuacao() + \"pontos!!!");


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

    public static void main(String[] args) {
        Jogo jogo = new Jogo();

        System.out.println(jogo.boasvindas());
        Scanner sc = new Scanner(System.in);
        Jogador jogador = new Jogador(sc.next());

        System.out.println("\nBem vindo, " + jogador.getNome() + "! Vamos ao jogo!\n\n" +
                "---------------------------------------------\n");

        jogo.inicio(jogador);
    }

}
