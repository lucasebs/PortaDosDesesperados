package br.com.portadosdesesperados;

import java.util.ArrayList;
import java.util.Random;

public class Palco {
    private Integer quantidadePortas;
    private ArrayList<Porta> portas = new ArrayList<>();
    private ArrayList<String> listaPremios = new ArrayList<>();

    public Palco(Integer quantidadePortas, Level level) {
        this.createListaPremios();
        this.setQuantidadePortas(quantidadePortas);
        Integer quantidadeMonstros = level.getQuantidadeMonstros();

        for (int i = 1; i <= quantidadePortas; i++) {
            portas.add(new Porta(String.valueOf(i), false,
                    new Premio(listaPremios.get(this.numeroAleatorio(0,listaPremios.size()-1)))));
        }

        for (int i = 0; i < quantidadeMonstros; i++) {
            portas.get(this.numeroAleatorio(0,quantidadePortas-1)).setMonstro(true);
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
        this.listaPremios.add("Viagem");
        this.listaPremios.add("Celular");
        this.listaPremios.add("Notebook");
        this.listaPremios.add("Passeio de balão");
        this.listaPremios.add("Salto de paraquedas");
        this.listaPremios.add("Tablet");
        this.listaPremios.add("Óculos");
        this.listaPremios.add("Bicicleta");
        this.listaPremios.add("Prancha de surf");
        this.listaPremios.add("Skate");
        this.listaPremios.add("Patins");
        this.listaPremios.add("Videogame");
        this.listaPremios.add("Cafeteira");
    }


    public void setQuantidadePortas(Integer quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    public ArrayList<Porta> getPortas() {
        return portas;
    }

    public Integer numeroAleatorio(int min, int max){
        Random random = new Random();
        return random.ints(min,(max+1)).findFirst().getAsInt();
    }

    @Override
    public String toString() {
        String mensagem = "---------------------------------------------\n" +
                          "           Porta Dos Desesperados!           \n" +
                          "---------------------------------------------\n\n" +
                          "                -  Portas  -                 \n" +
                          "            ";
        for (Porta porta : portas) {
            mensagem += "|" + porta.getNumero() + "| " ;
        }
        mensagem += " \n";
        return mensagem;
    }
}
