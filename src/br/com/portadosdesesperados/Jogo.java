package br.com.portadosdesesperados;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Jogo {

    public void inicio_solo(Jogador jogador) {
        Partida partida = new Partida();
        Palco palco = partida.getPalco();
        Boolean vencedor = false;

        System.out.println("\nModo Solo\n");

        System.out.println(this.regras());

        this.aguardar(5);

        System.out.println("Pressione 'Enter' para começar...");
        Scanner enter = new Scanner(System.in);
        enter.nextLine();

        for1:
        for (int i = 1; i < palco.getQuantidadePortas() ; i++) {
            Boolean numeroInvalido = true;

            System.out.println(palco);
            this.aguardar(1);
            System.out.println("O Nível é " + partida.getLevel().getNivelDificuldade() + "\n");
            this.aguardar(1);
            System.out.println(jogador);

            this.aguardar(2);
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
                this.aguardar(1);
            }
            this.aguardar(1);
            if (i == 4) {
                vencedor = true;
            }
        }
        this.aguardar(1);

        System.out.println(palco);

        if (vencedor) {
            System.out.println("\nAcabou o jogo! Você venceu!!!");
        } else {
            System.out.println("\nAcabou o jogo!");
        }
        System.out.println("Você fez " + jogador.getPontuacao() + " pontos!!!");
    }

    private void inicio_player_vs_player(Jogador jogador, Conexao conexao) {

    }

    private void inicio_survivor(Jogador jogador, Conexao conexao) {

    }

    public String boasvindas() {
        return  "\n'Quem quer abrir a Porta dos Desesperados?'\n" +
                "                            MALLANDRO, Sergio\n\n" +
                "---------------------------------------------\n" +
                "     Bem vindo a Porta dos Desesperados! \n" +
                "---------------------------------------------\n" +
                "\nDigite 'EU'(ou seu nome) para começar: ";
    }

    public String regras() {
        return "O jogo funciona da seguinte forma:\n" +
                "- Você escolhe uma porta do palco\n" +
                "- Dentro da porta tem um monstro ou um prêmio\n" +
                "- Se for um prêmio você ganha pontos\n" +
                "- Se for um monstro você se vira\n\n" +
                "Obs1 - Existem níveis diferentes de dificuldade.\n" +
                "Obs2 - Quanto maior o nível mais monstros!!!!!\n\n" +
                "Boa sorte!!!\n";
    }

    public void aguardar(Integer segundos) {
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
        if (sc.nextInt() == 1){
            return 1;
        } else if (sc.nextInt() == 2) {
            System.out.print("Qual o modo Multiplayer:" +
                    "\n1 - Player vs Player" +
                    "\n2 - Survivor" +
                    "\n = ");
            Scanner mp = new Scanner(System.in);
            if (mp.nextInt() == 1){
                return 2;
            } else if (mp.nextInt() == 2) {
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
                jogo.inicio_solo(jogador);
            } else if (modoDeJogo == 2){
                conexao = jogo.iniciarConexao();

                jogo.inicio_player_vs_player(jogador, conexao);

                jogo.encerrarConexao(conexao);
            } else if (modoDeJogo == 3){
                conexao = jogo.iniciarConexao();

                jogo.inicio_survivor(jogador, conexao);

                jogo.encerrarConexao(conexao);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }



    }




}
