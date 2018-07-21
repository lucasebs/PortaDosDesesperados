package br.com.portadosdesesperados;

import java.util.ArrayList;

public class Palco {
    private Integer quantidadePortas;
    private ArrayList<Porta> portas = new ArrayList<>();
    private ArrayList<String> listaPremios = new ArrayList<>();

    public Palco(Integer quantidadePortas, Level level) {
        this.createListaPremios();
        this.setQuantidadePortas(quantidadePortas);
        Integer lvl = level.getQuantidadeMonstros();




        for (int i = 1; i <= quantidadePortas; i++) {
            portas.add(new Porta(i, true,new Premio(listaPremios.get(i-1))));
        }
    }

    public Integer getQuantidadePortas() {
        return quantidadePortas;
    }

    public void createListaPremios() {
        this.listaPremios.add("Pente");
        this.listaPremios.add("Boneca/Bola");
        this.listaPremios.add("Televisao");
        this.listaPremios.add("Moto");
        this.listaPremios.add("Carro");
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

    @Override
    public String toString() {
        String mensagem = "    Palco!!!\n\n";
        for (Porta porta : portas) {
            mensagem += "|" + porta.getNumero() + "| " ;
        }
        return mensagem;
    }
}
