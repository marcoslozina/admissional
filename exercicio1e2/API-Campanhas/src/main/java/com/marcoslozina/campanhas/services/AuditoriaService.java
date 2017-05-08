package com.marcoslozina.campanhas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcoslozina.campanhas.domain.Auditoria;
import com.marcoslozina.campanhas.repository.AuditoriasRepository;
import com.marcoslozina.campanhas.services.exceptions.AuditoriaNaoEncontradaException;

@Service
public class AuditoriaService {

    @Autowired
    private AuditoriasRepository auditoriasRepository;

    public Auditoria salvar(Auditoria auditoria) {
	return auditoriasRepository.save(auditoria);

    }

    public List<Auditoria> listar() {

	return auditoriasRepository.findAll();
    }

    public Auditoria buscar(Long id) {
	Auditoria auditoria = auditoriasRepository.findOne(id);

	if (auditoria == null) {
	    throw new AuditoriaNaoEncontradaException("A auditoria não pôde ser encontrada.");
	}
	return auditoria;
    }

}