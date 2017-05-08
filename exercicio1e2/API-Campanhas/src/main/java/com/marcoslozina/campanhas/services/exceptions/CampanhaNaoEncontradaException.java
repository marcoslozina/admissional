package com.marcoslozina.campanhas.services.exceptions;

public class CampanhaNaoEncontradaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1869300553614629710L;

	public CampanhaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public CampanhaNaoEncontradaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
