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

    public void inicio() {
//        System.out.print("Digite 'EU' para começar: ");
        Partida partida = new Partida();

        System.out.println("O jogo funciona da seguinte forma:\n" +
                "- Você escolhe uma porta do palco\n" +
                "- Dentro da porta tem um monstro ou um prêmio\n" +
                "- Se for um prêmio você ganha pontos\n" +
                "- Se for um monstro você se vira\n\n" +
                "Obs:\n 1 - Existem níveis diferentes de dificuldade.\n" +
                "2 - Quanto maior o nível mais monstros!!!!!\n\n" +
                "Boa sorte!!!\n" +
                "---------------------------------------------------");

        Integer cont = 0;
        while (true) {
            System.out.println(partida.getPalco());

            System.out.println("Sérgio Malandro: 'Qual porta você quer?'\n\nDigite o número da porta: ");

            Scanner sc = new Scanner(System.in);

            Porta porta = partida.escolherPorta(sc.nextInt());
            porta.setNumero(0);
            if (porta.isMonstro()) {
                System.out.println("- É um monstro!!!");

            } else {
                System.out.println("- É um Prêmio!!!!\n- Prêmio: " + porta.getPremio().getTipoPremio());
            }

            cont ++;
            if (cont == 2) {break;}
        }



    }

    public String boasvindas() {
        String mensagem;
        mensagem = "\n'Quem quer abrir a Porta dos Desesperados?'\n";
        mensagem += "                        MALANDRO, Serginho\n\n";
        mensagem += "-------------------------------------------\n";
        mensagem += "    Bem vindo a Porta dos Desesperados! \n";
        mensagem += "-------------------------------------------\n";
        mensagem += "\nDigite 'EU'(ou seu nome) para começar: ";
        return mensagem;
    }

    public static void main(String[] args) {
        Jogo jogo = new Jogo();

        System.out.println(jogo.boasvindas());
        Scanner sc = new Scanner(System.in);
        Jogador jogador = new Jogador(sc.next());

        System.out.println("\nBem vindo, " + jogador.getNome() + "! Vamos ao jogo!\n" +
                "--------------------------------\n");

        jogo.inicio();
    }

}
