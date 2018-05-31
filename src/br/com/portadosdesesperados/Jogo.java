package br.com.portadosdesesperados;

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
        System.out.println(boasvindas());
        System.out.print("Digite 'EU' para começar: ");
    }

    public String boasvindas() {
        String mensagem;
        mensagem = "\n'Quem quer abrir a Porta dos Desesperados?'\n";
        mensagem += "                        MALANDRO, Serginho\n\n";
        mensagem += "-------------------------------------------\n";
        mensagem += "    Bem vindo a Porta dos Desesperados! \n";
        mensagem += "-------------------------------------------\n";
        return mensagem;
    }
}
