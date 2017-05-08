package com.marcoslozina.sociostorcedores.resources;

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

import com.marcoslozina.sociostorcedores.domain.SocioTorcedor;
import com.marcoslozina.sociostorcedores.services.SocioTorcedorService;

@RestController
@RequestMapping("/sociotorcedores")
public class SocioTorcedorResources {

    @Autowired
    private SocioTorcedorService socioTorcedorService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<SocioTorcedor>> listar() {
	return ResponseEntity.status(HttpStatus.OK).body(socioTorcedorService.listar());

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@Valid @RequestBody SocioTorcedor sociotorcedor) {
	sociotorcedor = socioTorcedorService.salvar(sociotorcedor);

	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sociotorcedor.getId())
		.toUri();

	return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
	SocioTorcedor sociotorcedor = socioTorcedorService.buscar(id);

	CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);

	return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(sociotorcedor);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
	socioTorcedorService.deletar(id);
	return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar(@RequestBody SocioTorcedor sociotorcedor, @PathVariable("id") Long id) {
	sociotorcedor.setId(id);
	socioTorcedorService.atualizar(sociotorcedor);

	return ResponseEntity.noContent().build();
    }

}
