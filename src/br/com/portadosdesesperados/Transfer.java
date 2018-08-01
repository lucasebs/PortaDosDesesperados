package br.com.portadosdesesperados;

import java.io.IOException;

public interface Transfer {
    void transmitir(Integer chave, String mensagem) throws IOException;
    String receber(Integer chave) throws IOException;
    void desconectar() throws IOException;
    void conectar() throws IOException;
    String getTipoTransfer();
}
