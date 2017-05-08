package com.marcoslozina.sociostorcedores.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.marcoslozina.sociostorcedores.domain.TimeDoCoracao;
import com.marcoslozina.sociostorcedores.repository.TimeDoCoracaoRepository;
import com.marcoslozina.sociostorcedores.services.exceptions.TimeDoCoracaoExistenteException;
import com.marcoslozina.sociostorcedores.services.exceptions.TimeDoCoracaoNaoEncontradoException;

@Service
public class TimeDoCoracaoService {

    @Autowired
    private TimeDoCoracaoRepository timeDoCoracaoRepository;

    public List<TimeDoCoracao> listar() {

	return timeDoCoracaoRepository.findAll();
    }

    public TimeDoCoracao salvar(TimeDoCoracao timedocoracao) {

	if (timedocoracao.getId() != null) {
	    TimeDoCoracao a = timeDoCoracaoRepository.findOne(timedocoracao.getId());

	    if (a != null) {
		throw new TimeDoCoracaoExistenteException("o time do coracao já existe.");
	    }
	}

	return timeDoCoracaoRepository.save(timedocoracao);

    }

    public TimeDoCoracao buscar(Long id) {
	TimeDoCoracao time = timeDoCoracaoRepository.findOne(id);

	if (time == null) {
	    throw new TimeDoCoracaoNaoEncontradoException("O time do coracao não pôde ser encontrado.");
	}
	return time;
    }

    public void deletar(Long id) {
	try {
	    timeDoCoracaoRepository.delete(id);
	} catch (EmptyResultDataAccessException e) {
	    throw new TimeDoCoracaoNaoEncontradoException("O time do coracao não pôde ser encontrado.");
	}
    }

    public void atualizar(TimeDoCoracao timedocoracao) {
	verificarExistencia(timedocoracao);
	timeDoCoracaoRepository.save(timedocoracao);
    }

    private void verificarExistencia(TimeDoCoracao timedocoracao) {
	buscar(timedocoracao.getId());
    }
}