package com.marcoslozina.campanhas.resources;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.marcoslozina.campanhas.domain.Auditoria;
import com.marcoslozina.campanhas.services.AuditoriaService;

@RestController
@RequestMapping("/auditorias")
public class AuditoriasResources {

    @Autowired
    private AuditoriaService auditoriaService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Auditoria>> listar() {
	return ResponseEntity.status(HttpStatus.OK).body(auditoriaService.listar());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
	Auditoria auditoria = auditoriaService.buscar(id);

	CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);

	return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(auditoria);
    }

}
