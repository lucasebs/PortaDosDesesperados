package br.com.portadosdesesperados;

public class Porta {
    private Integer numero;
    private Boolean monstro;
    private Premio premio;

    public Porta(Integer numero, Boolean monstro, Premio premio) {
        this.numero = numero;
        this.monstro = monstro;
        this.premio = premio;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Boolean isMonstro() {
        return this.monstro;
    }

    public void setMonstro(Boolean monstro) {
        this.monstro = monstro;
    }

    public Premio getPremio() {
        return premio;
    }

    public void setPremio(Premio premio) {
        this.premio = premio;
    }
}
