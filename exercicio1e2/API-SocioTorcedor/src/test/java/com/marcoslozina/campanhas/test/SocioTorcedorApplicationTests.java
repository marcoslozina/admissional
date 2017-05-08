package com.marcoslozina.campanhas.test;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

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

import com.marcoslozina.sociostorcedores.SocioTorcedorApplication;
import com.marcoslozina.sociostorcedores.domain.SocioTorcedor;
import com.marcoslozina.sociostorcedores.domain.TimeDoCoracao;
import com.marcoslozina.sociostorcedores.repository.SocioTorcedorRepository;
import com.marcoslozina.sociostorcedores.repository.TimeDoCoracaoRepository;
import com.marcoslozina.sociostorcedores.services.SocioTorcedorService;
import com.marcoslozina.sociostorcedores.services.TimeDoCoracaoService;
import com.marcoslozina.sociostorcedores.services.exceptions.SocioTorcedorExistenteException;
import com.marcoslozina.sociostorcedores.services.exceptions.SocioTorcedorNaoEncontradoException;
import com.marcoslozina.sociostorcedores.services.exceptions.TimeDoCoracaoExistenteException;
import com.marcoslozina.sociostorcedores.services.exceptions.TimeDoCoracaoNaoEncontradoException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SocioTorcedorApplication.class)
@WebAppConfiguration
public class SocioTorcedorApplicationTests {

    @InjectMocks
    private SocioTorcedorService socioTorcedorService;

    @InjectMocks
    private TimeDoCoracaoService timeDoCoracaoService;

    @Mock
    private SocioTorcedorRepository socioTorcedorRepository;

    @Mock
    private TimeDoCoracaoRepository timeDoCoracaoRepository;

    @Spy
    List<SocioTorcedor> socioTorcedor = new ArrayList<SocioTorcedor>();

    @Before
    public void setup() {
	MockitoAnnotations.initMocks(this);
    }

    @Test(expected = SocioTorcedorExistenteException.class)
    public void teste_quando_torcedor_ja_existe() {
	SocioTorcedor socioTorcedor = new SocioTorcedor();
	socioTorcedor.setEmail("some@some.com");
	when(socioTorcedorRepository.findByEmail(anyString())).thenReturn(socioTorcedor);
	socioTorcedorService.salvar(socioTorcedor);

    }

    @Test(expected = SocioTorcedorNaoEncontradoException.class)
    public void teste_quando_torcedor_nao_existe() {
	when(socioTorcedorRepository.findByEmail(anyString())).thenReturn(null);
	socioTorcedorService.buscar(anyString());

    }

    @Test(expected = TimeDoCoracaoExistenteException.class)
    public void teste_quando_time_ja_existe() {
	TimeDoCoracao time = new TimeDoCoracao();
	time.setId(99L);
	when(timeDoCoracaoRepository.findOne(anyLong())).thenReturn(time);
	timeDoCoracaoService.salvar(time);

    }

    @Test(expected = TimeDoCoracaoNaoEncontradoException.class)
    public void teste_quando_time_nao_existe() {
	TimeDoCoracao time = new TimeDoCoracao();
	time.setId(99L);
	when(timeDoCoracaoRepository.findOne(anyLong())).thenReturn(null);
	timeDoCoracaoService.buscar(time.getId());

    }

}
