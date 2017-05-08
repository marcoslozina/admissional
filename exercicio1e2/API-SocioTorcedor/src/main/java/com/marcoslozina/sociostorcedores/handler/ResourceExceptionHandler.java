package com.marcoslozina.sociostorcedores.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.marcoslozina.sociostorcedores.domain.DetalhesErro;
import com.marcoslozina.sociostorcedores.services.exceptions.SocioTorcedorExistenteException;
import com.marcoslozina.sociostorcedores.services.exceptions.SocioTorcedorNaoEncontradoException;
import com.marcoslozina.sociostorcedores.services.exceptions.TimeDoCoracaoExistenteException;
import com.marcoslozina.sociostorcedores.services.exceptions.TimeDoCoracaoNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(TimeDoCoracaoNaoEncontradoException.class)
    public ResponseEntity<DetalhesErro> handleTimeDoCoracaoNaoEncontradaException(TimeDoCoracaoNaoEncontradoException e,
	    HttpServletRequest request) {

	DetalhesErro erro = new DetalhesErro();
	erro.setStatus(404l);
	erro.setTitulo("O time do coração não pôde ser encontrado");
	erro.setMensagemDesenvolvedor("http://erros.mydomain.com/404");
	erro.setTimestamp(System.currentTimeMillis());

	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(TimeDoCoracaoExistenteException.class)
    public ResponseEntity<DetalhesErro> handleTimeDoCoracaoExistenteException(TimeDoCoracaoExistenteException e,
	    HttpServletRequest request) {

	DetalhesErro erro = new DetalhesErro();
	erro.setStatus(409l);
	erro.setTitulo("O time do coração já existente");
	erro.setMensagemDesenvolvedor("http://erros.mydomain.com/409");
	erro.setTimestamp(System.currentTimeMillis());

	return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }

    @ExceptionHandler(SocioTorcedorNaoEncontradoException.class)
    public ResponseEntity<DetalhesErro> handleSocioTorcedorNaoEncontradaException(SocioTorcedorNaoEncontradoException e,
	    HttpServletRequest request) {

	DetalhesErro erro = new DetalhesErro();
	erro.setStatus(404l);
	erro.setTitulo("O socio torcedor não pôde ser encontrado");
	erro.setMensagemDesenvolvedor("http://erros.mydomain.com/404");
	erro.setTimestamp(System.currentTimeMillis());

	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(SocioTorcedorExistenteException.class)
    public ResponseEntity<DetalhesErro> SocioTorcedor(SocioTorcedorExistenteException e, HttpServletRequest request) {

	DetalhesErro erro = new DetalhesErro();
	erro.setStatus(409l);
	erro.setTitulo("O socio torcedor já existente");
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