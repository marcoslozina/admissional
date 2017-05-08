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

import com.marcoslozina.sociostorcedores.domain.TimeCampanha;
import com.marcoslozina.sociostorcedores.services.TimeCampanhaService;

@RestController
@RequestMapping("/timecampanha")
public class TimeCampanhaResources {

    @Autowired
    private TimeCampanhaService timecampanhaService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TimeCampanha>> listar() {
	return ResponseEntity.status(HttpStatus.OK).body(timecampanhaService.listar());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@Valid @RequestBody TimeCampanha timeCampanha) {
	timeCampanha = timecampanhaService.salvar(timeCampanha);

	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(timeCampanha.getId())
		.toUri();

	return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable("id") Long id) {
	TimeCampanha timeCampanha = timecampanhaService.buscar(id);

	CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);

	return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(timeCampanha);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
	timecampanhaService.deletar(id);
	return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizar(@RequestBody TimeCampanha timeCampanha, @PathVariable("id") Long id) {
	timeCampanha.setId(id);
	timecampanhaService.atualizar(timeCampanha);

	return ResponseEntity.noContent().build();
    }

}
