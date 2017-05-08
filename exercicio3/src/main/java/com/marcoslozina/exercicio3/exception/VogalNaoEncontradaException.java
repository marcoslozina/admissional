package com.marcoslozina.exercicio3.exception;

public class VogalNaoEncontradaException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public VogalNaoEncontradaException() {
	super("Vogal não encontrada na String");
    }

}
