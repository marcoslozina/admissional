package com.marcoslozina.campanhas.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.marcoslozina.campanhas.domain.DetalhesErro;
import com.marcoslozina.campanhas.services.exceptions.CampanhaExistenteException;
import com.marcoslozina.campanhas.services.exceptions.CampanhaNaoEncontradaException;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(CampanhaNaoEncontradaException.class)
    public ResponseEntity<DetalhesErro> handleCampanhaNaoEncontradaException(CampanhaNaoEncontradaException e,
	    HttpServletRequest request) {

	DetalhesErro erro = new DetalhesErro();
	erro.setStatus(404l);
	erro.setTitulo("A campanha não pôde ser encontrada");
	erro.setMensagemDesenvolvedor("http://erros.mydomain.com/404");
	erro.setTimestamp(System.currentTimeMillis());

	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(CampanhaExistenteException.class)
    public ResponseEntity<DetalhesErro> handleCampanhaExistenteException(CampanhaExistenteException e,
	    HttpServletRequest request) {

	DetalhesErro erro = new DetalhesErro();
	erro.setStatus(409l);
	erro.setTitulo("Campanha já existente");
	erro.setMensagemDesenvolvedor("http://erros.mydomain.com/409");
	erro.setTimestamp(System.currentTimeMillis());

	return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<DetalhesErro> handleDataIntegrityViolationException(DataIntegrityViolationException e,
	    HttpServletRequest request) {

	DetalhesErro erro = new DetalhesErro();
	erro.setStatus(400l);
	erro.setTitulo("Requisição inválida");
	erro.setMensagemDesenvolvedor("http://erros.mydomain.com/400");
	erro.setTimestamp(System.currentTimeMillis());

	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}