package com.marcoslozina.sociostorcedores.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.marcoslozina.sociostorcedores.domain.TimeCampanha;
import com.marcoslozina.sociostorcedores.repository.TimeCampanhaRepository;
import com.marcoslozina.sociostorcedores.services.exceptions.TimeDoCoracaoExistenteException;
import com.marcoslozina.sociostorcedores.services.exceptions.TimeDoCoracaoNaoEncontradoException;

@Service
public class TimeCampanhaService {

    @Autowired
    private TimeCampanhaRepository timeCampanhaRepository;

    public List<TimeCampanha> listar() {

	return timeCampanhaRepository.findAll();
    }

    public TimeCampanha salvar(TimeCampanha timeCampanha) {

	if (timeCampanha.getId() != null) {
	    TimeCampanha a = timeCampanhaRepository.findOne(timeCampanha.getId());

	    if (a != null) {
		throw new TimeDoCoracaoExistenteException("o time do coracao já existe.");
	    }
	}

	return timeCampanhaRepository.save(timeCampanha);

    }

    public TimeCampanha buscar(Long id) {
	TimeCampanha time = timeCampanhaRepository.findOne(id);

	if (time == null) {
	    throw new TimeDoCoracaoNaoEncontradoException("O time do coracao não pôde ser encontrado.");
	}
	return time;
    }

    public void deletar(Long id) {
	try {
	    timeCampanhaRepository.delete(id);
	} catch (EmptyResultDataAccessException e) {
	    throw new TimeDoCoracaoNaoEncontradoException("O time do coracao não pôde ser encontrado.");
	}
    }

    public void atualizar(TimeCampanha timeCampanha) {
	verificarExistencia(timeCampanha);
	timeCampanhaRepository.save(timeCampanha);
    }

    private void verificarExistencia(TimeCampanha timeCampanha) {
	buscar(timeCampanha.getId());
    }
}