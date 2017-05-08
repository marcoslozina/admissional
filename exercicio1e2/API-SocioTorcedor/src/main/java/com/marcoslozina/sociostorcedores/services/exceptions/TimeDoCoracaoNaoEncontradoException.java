package com.marcoslozina.sociostorcedores.services.exceptions;

public class TimeDoCoracaoNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1869300553614629710L;

	public TimeDoCoracaoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public TimeDoCoracaoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
