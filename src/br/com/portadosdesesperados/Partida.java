package br.com.portadosdesesperados;

import java.util.ArrayList;

public class Partida {
    private ArrayList<Premio> premios = new ArrayList<Premio>();
    private Palco palco;
    private Level level;

    public ArrayList<Premio> getPremios() {
        return premios;
    }

    public void setPremios(ArrayList<Premio> premios) {
        this.premios = premios;
    }

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

