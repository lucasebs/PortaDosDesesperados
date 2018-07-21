package br.com.portadosdesesperados;

import java.util.Scanner;

public class Jogo {
    private Jogador jogador1;
    private Jogador jogador2;

    public Jogador getJogador1() {
        return jogador1;
    }

    public void setJogador1(Jogador jogador1) {
        this.jogador1 = jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }

    public void setJogador2(Jogador jogador2) {
        this.jogador2 = jogador2;
    }

    public void inicio() {
//        System.out.print("Digite 'EU' para começar: ");
        Partida partida = new Partida();
        System.out.println(partida.getPalco());
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
        System.out.println("Bem vindo, " + jogador.getNome() + "!\n\n");

        jogo.inicio();
    }

}
