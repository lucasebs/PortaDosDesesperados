package br.com.portadosdesesperados;

public class Porta {
    private Boolean monstro;
    private Premio premio;

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
