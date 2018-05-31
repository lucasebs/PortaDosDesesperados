package br.com.portadosdesesperados;

public class Level {
    private Integer quantidadeMonstros;
    private String nivelDificuldade;

    public Level(Integer quantidadeMonstros, String nivelDificuldade) {
        this.quantidadeMonstros = quantidadeMonstros;
        this.nivelDificuldade = nivelDificuldade;
    }

    public Integer getQuantidadeMonstros() {
        return quantidadeMonstros;
    }

    public void setQuantidadeMonstros(Integer quantidadeMonstros) {
        this.quantidadeMonstros = quantidadeMonstros;
    }

    public String getNivelDificuldade() {
        return nivelDificuldade;
    }

    public void setNivelDificuldade(String nivelDificuldade) {
        this.nivelDificuldade = nivelDificuldade;
    }
}
