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

        System.out.println("Disputa " + jogadorServidor.getNome() + " x " + jogadorCliente.getNome() + "\n");

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
                        System.out.println("Sérgio Mallandro: '" + jogadorServidor.getNome() + ", qual porta você quer?");
                        while (numeroInvalido) {
                            numeroInvalido = false;
                            Porta porta = escolherPorta(partida);
                            if (invalidarPorta(partida,jogadorServidor,porta,transmissor)) {
                                break while1;
                            }
                            porta.setNumero("X");
                        }
                    }
                    if (transmissor.getTipoTransfer() == "Cliente") {
                        System.out.println("Aguarde! É a vez de " + jogadorServidor.getNome() + " jogar!" );
                        Porta porta = escutarPorta(transmissor, jogadorServidor, partida);
                        if (porta == null) {
                            break while1;
                        }
                        porta.setNumero("X");
                    }
                    jogadorDaVez = 2;
                } else if (jogadorDaVez == 2) {
                    if ( transmissor.getTipoTransfer() == "Cliente" ) {
                        System.out.println("Sérgio Mallandro: '" + jogadorCliente.getNome() + ", qual porta você quer?");
                        while (numeroInvalido) {
                            numeroInvalido = false;
                            Porta porta = escolherPorta(partida);
                            if(invalidarPorta(partida,jogadorCliente,porta,transmissor)) {
                                break while1;
                            }
                            porta.setNumero("X");
                        }
                    }
                    if (transmissor.getTipoTransfer() == "Servidor") {
                        System.out.println("Aguarde! É a vez de " + jogadorCliente.getNome() + " jogar!" );
                        Porta porta = escutarPorta(transmissor, jogadorCliente, partida);
                        if (porta == null) {
                            break while1;
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
        }
        Jogo.aguardar(2);
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

    private static Porta escolherPorta(Partida partida) throws Exception {
        System.out.print("- Digite o número da porta: ");
        Scanner sc = new Scanner(System.in);
        Integer numeroDaPorta = sc.nextInt();
        return partida.escolherPorta(numeroDaPorta);
    }

    private static boolean invalidarPorta(Partida partida, Jogador jogador, Porta porta, Transfer transmissor) throws IOException {
        try {
            System.out.println(partida.abrirPorta(jogador, porta));
        } catch (Exception ex) {
            transmissor.transmitir(1, "fim");
            System.out.println(ex.getMessage());
            return true;
        }
        transmissor.transmitir(1, String.valueOf(porta.getNumero()));
        return false;
    }

    private static Porta escutarPorta(Transfer transmissor, Jogador jogador, Partida partida) throws Exception {
        Porta porta = null;
        String mensagem = "";

        while (true) {
            mensagem = transmissor.receber(1);
            if (mensagem.equals("fim")) {
                System.out.println(jogador.getNome() + " perdeu!!!!");
                return null;
            } else {
                break;
            }
        }
        return partida.escolherPorta(Integer.valueOf(mensagem));

    }
}
