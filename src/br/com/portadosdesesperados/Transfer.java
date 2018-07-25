package br.com.portadosdesesperados;

import java.io.IOException;

public interface Transfer {
    void transmitir(String mensagem) throws IOException;
    String receber() throws IOException;
    void desconectar() throws IOException;
    void conectar() throws IOException;

}
