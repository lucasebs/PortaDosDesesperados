package br.com.portadosdesesperados;

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

    public Porta escolherPorta(Integer numeroDaPorta) {
        Porta porta = palco.getPortas().get(numeroDaPorta - 1);
        return porta;
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

