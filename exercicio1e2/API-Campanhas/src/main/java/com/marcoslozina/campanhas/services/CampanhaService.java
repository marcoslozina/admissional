package com.marcoslozina.campanhas.services;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.marcoslozina.campanhas.domain.Auditoria;
import com.marcoslozina.campanhas.domain.Campanha;
import com.marcoslozina.campanhas.repository.AuditoriasRepository;
import com.marcoslozina.campanhas.repository.CampanhasRepository;
import com.marcoslozina.campanhas.services.exceptions.CampanhaExistenteException;
import com.marcoslozina.campanhas.services.exceptions.CampanhaNaoEncontradaException;

@Service
public class CampanhaService {

    @Autowired
    private CampanhasRepository campanhasRepository;

    @Autowired
    private AuditoriasRepository auditoriasRepository;

    public List<Campanha> listar() {

	return campanhasRepository.findByVigenciaAtiva(LocalDate.now());
    }

    public Campanha salvar(Campanha campanha) {

	if (campanha.getId() != null) {
	    Campanha a = campanhasRepository.findOne(campanha.getId());

	    if (a != null) {
		throw new CampanhaExistenteException("a campanha já existe.");
	    }
	}

	while (!isPeriodoVigenteDisponivel(campanha)) {
	    realizarMudancasDoPeriodoDeCampanhasExistentes();

	}
	return campanhasRepository.save(campanha);

    }

    private void realizarMudancasDoPeriodoDeCampanhasExistentes() {
	Auditoria auditoria;
	for (Iterator<Campanha> iterator = campanhasRepository.findAll().iterator(); iterator.hasNext();) {
	    auditoria = new Auditoria();
	    Campanha campanha = iterator.next();

	    auditoria.setDataDaMundanca(LocalDate.now());
	    auditoria.setDataFimAntiga(campanha.getDataFim());
	    auditoria.setIdCampanha(campanha.getId());
	    campanha.setDataFim(campanha.getDataFim().plusDays(1));
	    auditoria.setDataFimNova(campanha.getDataFim());

	    auditoriasRepository.save(auditoria);

	}

    }

    private boolean isPeriodoVigenteDisponivel(Campanha campanha) {
	List<Campanha> campanhas = campanhasRepository.findAll();

	for (Campanha campanhaCadastrada : campanhas) {
	    if (campanhaCadastrada.getDataFim().isEqual(campanha.getDataFim()))
		return false;
	}
	return true;
    }

    public Campanha buscar(Long id) {
	Campanha campanha = campanhasRepository.findOne(id);

	if (campanha == null) {
	    throw new CampanhaNaoEncontradaException("A campanha não pôde ser encontrada.");
	}
	return campanha;
    }

    public void deletar(Long id) {
	try {
	    campanhasRepository.delete(id);
	} catch (EmptyResultDataAccessException e) {
	    throw new CampanhaNaoEncontradaException("A campanha não pôde ser encontrada.");
	}
    }

    public void atualizar(Campanha campanha) {
	verificarExistencia(campanha);
	campanhasRepository.save(campanha);
    }

    private void verificarExistencia(Campanha campanha) {
	buscar(campanha.getId());
    }
}