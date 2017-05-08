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

import com.marcoslozina.sociostorcedores.domain.TimeDoCoracao;
import com.marcoslozina.sociostorcedores.services.TimeDoCoracaoService;

@RestController
@RequestMapping("/timedocoracao")
public class TimeDoCoracaoResources {

    @Autowired
    private TimeDoCoracaoService timeDoCoracaoService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TimeDoCoracao>> listar() {
	return ResponseEntity.status(HttpStatus.OK).body(timeDoCoracaoService.listar());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@Valid @RequestBody TimeDoCoracao timedocoracao) {
	timedocoracao = timeDoCoracaoService.salvar(timedocoracao);

	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(timedocoracao.getId())
		.toUri();

	return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
	TimeDoCoracao timedocoracao = timeDoCoracaoService.buscar(id);

	CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);

	return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(timedocoracao);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
	timeDoCoracaoService.deletar(id);
	return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar(@RequestBody TimeDoCoracao timedocoracao, @PathVariable("id") Long id) {
	timedocoracao.setId(id);
	timeDoCoracaoService.atualizar(timedocoracao);

	return ResponseEntity.noContent().build();
    }

}
