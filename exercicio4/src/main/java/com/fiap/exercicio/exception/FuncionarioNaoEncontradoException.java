package com.fiap.exercicio.exception;

public class FuncionarioNaoEncontradoException extends RuntimeException{
    public FuncionarioNaoEncontradoException (String mensagem) {
        super(mensagem);
    }
}
