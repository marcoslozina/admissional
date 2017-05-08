package com.marcoslozina.sociostorcedores.services.exceptions;

public class TimeDoCoracaoExistenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1869300553614629710L;

	public TimeDoCoracaoExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public TimeDoCoracaoExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
