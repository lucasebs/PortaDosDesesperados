package br.com.portadosdesesperados;

import javax.sound.sampled.Port;
import java.util.ArrayList;

public class Partida {
//    private ArrayList<Premio> premios = new ArrayList<>();
    private Palco palco;
    private Level level;

    public Partida() {
        Level level = new Level(1,"Facil demais!");
        this.palco = new Palco(5, level);
        this.level = level;
    }

//    public ArrayList<Premio> getPremios() {
//        return premios;
//    }
//
//    public void setPremios(ArrayList<Premio> premios) {
//        this.premios = premios;
//    }

    public Porta escolherPorta(Integer numeroDaPorta) throws Exception {
        if (numeroDaPorta > this.palco.getQuantidadePortas()){
            throw new Exception("Esta porta não está no palco!");
//            System.out.println("Porta Invalida");
        }

//        if (numeroDaPorta !=5 || numeroDaPorta != 4 || numeroDaPorta != 1 || numeroDaPorta !=2 || numeroDaPorta !=3 ){
//            throw new Exception("Porta Inválida!");
////            System.out.println("Valor invalido tente novamente");
//        }

        Porta porta = palco.getPortas().get(numeroDaPorta - 1);

        if (porta.getNumero() == "X"){
            throw new Exception("Você já escolheu essa porta!");
        }

        return porta;
    }

    public String abrirPorta(Jogador jogador, Porta porta) {
        if (porta.isMonstro()) {
            return "\n- É um monstro!!! Você perdeu!\n";
        } else {
            jogador.setPontuacao(jogador.getPontuacao() + (10 * getLevel().getQuantidadeMonstros()));
            aumentarLevel();
            return "\n- É um Prêmio!!!!\n  Prêmio: " + porta.getPremio().getTipoPremio() + "\n";
        }
    }

    public void aumentarLevel() {
        if ( this.level.getQuantidadeMonstros() == 1 ) {
            this.level = new Level(2, "Tranquilo");
        } else if ( this.level.getQuantidadeMonstros() == 2 ) {
            this.level = new Level(3, "Ruim");
        } else if ( this.level.getQuantidadeMonstros() == 3 ) {
            this.level = new Level(4, "Impossível");
        }
    };


    public Palco getPalco() {
        return palco;
    }

    public void setPalco(Palco palco) {
        this.palco = palco;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}

