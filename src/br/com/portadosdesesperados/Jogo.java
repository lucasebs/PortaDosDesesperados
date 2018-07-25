package br.com.portadosdesesperados;

import java.io.IOException;
import java.util.Scanner;

public class Jogo {

    public String boasvindas() {
        return  "\n'Quem quer abrir a Porta dos Desesperados?'\n" +
                "                            MALLANDRO, Sergio\n\n" +
                "---------------------------------------------\n" +
                "     Bem vindo a Porta dos Desesperados! \n" +
                "---------------------------------------------\n" +
                "\nDigite 'EU'(ou seu nome) para começar: ";
    }

    public static String regras() {
        return "O jogo funciona da seguinte forma:\n" +
                "- Você escolhe uma porta do palco\n" +
                "- Dentro da porta tem um monstro ou um prêmio\n" +
                "- Se for um prêmio você ganha pontos\n" +
                "- Se for um monstro você se vira\n\n" +
                "Obs1 - Existem níveis diferentes de dificuldade.\n" +
                "Obs2 - Quanto maior o nível mais monstros!!!!!\n\n" +
                "Boa sorte!!!\n";
    }

    public static void aguardar(Integer segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Integer escolheModoDeJogo() throws Exception {
        System.out.print("Vamos começar escolhendo o modo do Jogo:" +
                "\n1 - Solo" +
                "\n2 - Multiplayer" +
                "\n = ");
        Scanner sc = new Scanner(System.in);
        Integer modo = sc.nextInt();
        if (modo == 1){
            return 1;
        } else if (modo == 2) {
            System.out.print("Qual o modo Multiplayer:" +
                    "\n1 - Player vs Player" +
                    "\n2 - Survivor" +
                    "\n = ");
            Integer multiplayer = sc.nextInt();
            if (multiplayer == 1){
                return 2;
            } else if (multiplayer == 2) {
                return 3;
            } else {
                throw new Exception("Modo de Jogo Invalido!");
            }
        } else {
            throw new Exception("Modo de Jogo Invalido!");
        }
    }

    public Conexao iniciarConexao(){
        Conexao conexao = null;
        try {
            conexao = new Conexao();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
        return conexao;
    }

    public void encerrarConexao(Conexao conexao) {
        try {
            conexao.encerrar();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        Conexao conexao = null;

        System.out.println(jogo.boasvindas());
        Scanner sc = new Scanner(System.in);
        Jogador jogador = new Jogador(sc.next());

        System.out.println("\nBem vindo, " + jogador.getNome() + "! Vamos ao jogo!\n\n" +
                "---------------------------------------------\n");

        try {
            Integer modoDeJogo = jogo.escolheModoDeJogo();
            if (modoDeJogo == 1) {
                Solo.inicio(jogador);
            } else if (modoDeJogo == 2){
                conexao = jogo.iniciarConexao();
                PlayerVsPlayer.inicio(jogador, conexao.getTransfer());
                jogo.encerrarConexao(conexao);
            } else if (modoDeJogo == 3){
                conexao = jogo.iniciarConexao();
                Survivor.inicio(jogador, conexao.getTransfer());
                jogo.encerrarConexao(conexao);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}
