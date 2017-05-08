package com.marcoslozina.campanhas.services.exceptions;

public class AuditoriaNaoEncontradaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1869300553614629710L;

	public AuditoriaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public AuditoriaNaoEncontradaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
