package com.fiap.exercicio.exception;

public class DepartamentoNaoEncontradoException extends RuntimeException {
    public DepartamentoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
