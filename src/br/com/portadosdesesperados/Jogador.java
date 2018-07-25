package br.com.portadosdesesperados;

public class Jogador {
    private String nome;
    private Integer pontuacao = 0;

    public Jogador(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + " - Pontuação: " + this.pontuacao + "\n";
    }
}
