package com.marcoslozina.campanhas.resources;

import java.net.URI;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcoslozina.campanhas.domain.Campanha;
import com.marcoslozina.campanhas.services.CampanhaService;

@RestController
@RequestMapping("/campanhas")
public class CampanhasResources {

    @Autowired
    private CampanhaService campanhaService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Campanha>> listar() {
	return ResponseEntity.status(HttpStatus.OK).body(campanhaService.listar());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@Valid @RequestBody Campanha campanha) {
	campanha = campanhaService.salvar(campanha);

	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(campanha.getId())
		.toUri();

	return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
	Campanha campanha = campanhaService.buscar(id);

	CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);

	return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(campanha);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
	campanhaService.deletar(id);
	return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar(@RequestBody Campanha campanha, @PathVariable("id") Long id) {
	campanha.setId(id);
	campanhaService.atualizar(campanha);

	return ResponseEntity.noContent().build();
    }

}
