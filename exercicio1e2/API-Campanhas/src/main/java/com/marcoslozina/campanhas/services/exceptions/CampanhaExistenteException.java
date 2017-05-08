package com.marcoslozina.campanhas.services.exceptions;

public class CampanhaExistenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1869300553614629710L;

	public CampanhaExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public CampanhaExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
