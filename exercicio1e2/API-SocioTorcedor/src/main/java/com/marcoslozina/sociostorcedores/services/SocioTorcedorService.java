package com.marcoslozina.sociostorcedores.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.marcoslozina.sociostorcedores.domain.SocioTorcedor;
import com.marcoslozina.sociostorcedores.repository.SocioTorcedorRepository;
import com.marcoslozina.sociostorcedores.services.exceptions.SocioTorcedorExistenteException;
import com.marcoslozina.sociostorcedores.services.exceptions.SocioTorcedorNaoEncontradoException;

@Service
public class SocioTorcedorService {

    @Autowired
    private SocioTorcedorRepository socioTorcedorRepository;

    public List<SocioTorcedor> listar() {

	return socioTorcedorRepository.findAll();
    }

    public SocioTorcedor salvar(SocioTorcedor socioTorcedor) {

	if (socioTorcedor.getEmail() != null) {
	    SocioTorcedor a = socioTorcedorRepository.findByEmail(socioTorcedor.getEmail().trim());

	    if (a != null) {
		throw new SocioTorcedorExistenteException("O socio torcedor  já existe.");
	    }
	}

	return socioTorcedorRepository.save(socioTorcedor);

    }

    public SocioTorcedor buscar(Long id) {
	SocioTorcedor socioTorcedor = socioTorcedorRepository.findOne(id);

	if (socioTorcedor == null) {
	    throw new SocioTorcedorNaoEncontradoException("O socio torcedor não pôde ser encontrado.");
	}
	return socioTorcedor;
    }

    public SocioTorcedor buscar(String email) {
	SocioTorcedor socioTorcedor = socioTorcedorRepository.findByEmail(email);

	if (socioTorcedor == null) {
	    throw new SocioTorcedorNaoEncontradoException("O socio torcedor não pôde ser encontrado.");
	}
	return socioTorcedor;
    }

    public void deletar(Long id) {
	try {
	    socioTorcedorRepository.delete(id);
	} catch (EmptyResultDataAccessException e) {
	    throw new SocioTorcedorNaoEncontradoException("O socio torcedor não pôde ser encontrado.");
	}
    }

    public void atualizar(SocioTorcedor sociotorcedor) {
	verificarExistencia(sociotorcedor);
	socioTorcedorRepository.save(sociotorcedor);
    }

    private void verificarExistencia(SocioTorcedor sociotorcedor) {
	buscar(sociotorcedor.getId());
    }
}