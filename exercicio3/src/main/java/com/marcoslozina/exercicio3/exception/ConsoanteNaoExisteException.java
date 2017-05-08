package com.marcoslozina.exercicio3.exception;

public class ConsoanteNaoExisteException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ConsoanteNaoExisteException() {
	super("Consoante não encontrada na String");
    }

}
