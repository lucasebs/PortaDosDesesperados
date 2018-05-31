package br.com.portadosdesesperados;

import java.util.ArrayList;

public class Palco {
    private Integer quantidadePortas;
    private ArrayList<Porta> portas = new ArrayList<Porta>();

    public Integer getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(Integer quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    public ArrayList<Porta> getPortas() {
        return portas;
    }

    public void setPortas(ArrayList<Porta> portas) {
        this.portas = portas;
    }
}
