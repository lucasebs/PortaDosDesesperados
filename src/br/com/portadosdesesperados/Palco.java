package br.com.portadosdesesperados;

import java.util.ArrayList;

public class Palco {
    private Integer quantidadePortas;
    private ArrayList<Porta> portas = new ArrayList<>();
    private ArrayList<String> listaPremios = new ArrayList<>();
//    private ArrayList<Integer> monstros = new ArrayList<>();

    public Palco(Integer quantidadePortas, Level level) {
        this.createListaPremios();
        this.setQuantidadePortas(quantidadePortas);
        Integer quantidadeMonstros = level.getQuantidadeMonstros();

        for (int i = 1; i <= quantidadePortas; i++) {
            portas.add(new Porta(String.valueOf(i), false,new Premio(listaPremios.get(i-1))));
        }

        for (int i = 1; i <= quantidadeMonstros; i++) {
            portas.get(this.posicaoMonstro(1,quantidadeMonstros)).setMonstro(true);
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

//    public ArrayList<Integer> getMontros() {
//        return montros;
//    }
//
//    public void setMontros(ArrayList<Integer> montros) {
//        this.montros = montros;
//    }

    public Integer posicaoMonstro(int min, int max){
        int randomNum = min + (int)(Math.random() * (max - min));

        return randomNum;
    }

    @Override
    public String toString() {
        String mensagem = "-------------\n" +
                          "- Palco!!!!\n" +
                          "-------------\n\n";
        for (Porta porta : portas) {
            mensagem += "|" + porta.getNumero() + "| " ;
        }
        mensagem += "\n";
        return mensagem;
    }
}
