package br.com.portadosdesesperados;

import java.io.IOException;

public interface Transfer {
    void transmitir(Integer chave, Object mensagem) throws IOException;
    Object receber(Integer chave) throws IOException;
    void desconectar() throws IOException;
    void conectar() throws IOException;

}
