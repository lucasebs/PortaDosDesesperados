package br.com.portadosdesesperados;

public class Porta {
    private String numero;
    private Boolean monstro;
    private Premio premio;

    public Porta(String numero, Boolean monstro, Premio premio) {
        this.numero = numero;
        this.monstro = monstro;
        this.premio = premio;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
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
