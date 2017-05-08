package com.marcoslozina.sociostorcedores.services.exceptions;

public class SocioTorcedorExistenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1869300553614629710L;

	public SocioTorcedorExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public SocioTorcedorExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
