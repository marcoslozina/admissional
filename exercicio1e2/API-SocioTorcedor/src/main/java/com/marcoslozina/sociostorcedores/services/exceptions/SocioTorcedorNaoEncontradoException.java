package com.marcoslozina.sociostorcedores.services.exceptions;

public class SocioTorcedorNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1869300553614629710L;

	public SocioTorcedorNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public SocioTorcedorNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
	
}
