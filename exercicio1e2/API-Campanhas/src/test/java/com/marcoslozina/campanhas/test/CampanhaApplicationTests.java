package com.marcoslozina.campanhas.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.marcoslozina.campanhas.CampanhaApplication;
import com.marcoslozina.campanhas.domain.Campanha;
import com.marcoslozina.campanhas.repository.CampanhasRepository;
import com.marcoslozina.campanhas.services.CampanhaService;
import com.marcoslozina.campanhas.services.exceptions.CampanhaExistenteException;
import com.marcoslozina.campanhas.services.exceptions.CampanhaNaoEncontradaException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CampanhaApplication.class)
@WebAppConfiguration
public class CampanhaApplicationTests {

    @InjectMocks
    private CampanhaService campanhaService;

    @Mock
    private CampanhasRepository campanhasRepository;

    @Spy
    List<Campanha> campanhas = new ArrayList<Campanha>();

    @Before
    public void setup() {
	MockitoAnnotations.initMocks(this);
    }

    @Test
    public void teste_quando_existen_campanhas_vigentes() throws ParseException {
	campanhas = getTresCampanhasVigentes();
	when(campanhasRepository.findByVigenciaAtiva(LocalDate.now())).thenReturn(campanhas);

	assertEquals(3, campanhaService.listar().size());
	verify(campanhasRepository, atLeastOnce()).findByVigenciaAtiva(LocalDate.now());
    }

    @Test(expected = CampanhaExistenteException.class)
    public void teste_quando_campanha_ja_existe() {
	Campanha campanha1 = new Campanha(99L, "campanha1", LocalDate.of(2017, 05, 01), LocalDate.of(2017, 05, 05));
	when(campanhasRepository.findOne(anyLong())).thenReturn(campanha1);
	campanhaService.salvar(campanha1);

    }

    @Test(expected = CampanhaNaoEncontradaException.class)
    public void teste_quando_campanha_nao_existe() {
	when(campanhasRepository.findOne(anyLong())).thenReturn(null);
	campanhaService.buscar(anyLong());

    }

    @Test
    public void teste_deve_salvar_a_campanha() throws ParseException {
	Campanha campanha1 = new Campanha(null, "campanha1", LocalDate.of(2017, 05, 01), LocalDate.of(2017, 05, 05));
	when(campanhasRepository.findOne(anyLong())).thenReturn(campanha1);
	campanhaService.salvar(campanha1);
	verify(campanhasRepository, atLeastOnce()).save(any(Campanha.class));
    }

    public List<Campanha> getTresCampanhasVigentes() throws ParseException {
	Campanha campanha1, campanha2, campanha3;
	campanha1 = new Campanha("campanha1", LocalDate.of(2017, 05, 01), LocalDate.now());
	campanha2 = new Campanha("campanha2", LocalDate.of(2017, 05, 02), LocalDate.now().plusDays(1));
	campanha3 = new Campanha("campanha3", LocalDate.of(2017, 05, 03), LocalDate.now().plusDays(2));

	this.campanhas.add(campanha1);
	this.campanhas.add(campanha2);
	this.campanhas.add(campanha3);

	return campanhas;
    }

}
