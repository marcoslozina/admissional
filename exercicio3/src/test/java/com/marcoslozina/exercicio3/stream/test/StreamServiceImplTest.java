package com.marcoslozina.exercicio3.stream.test;

import org.junit.Assert;
import org.junit.Test;

import com.marcoslozina.exercicio3.exception.ConsoanteNaoExisteException;
import com.marcoslozina.exercicio3.exception.VogalNaoEncontradaException;
import com.marcoslozina.exercicio3.service.StreamService;
import com.marcoslozina.exercicio3.serviceImpl.StreamServiceImpl;

public class StreamServiceImplTest {
    @Test(expected = ConsoanteNaoExisteException.class)
    public void teste_quando_nao_contem_consoante() {
	new StreamServiceImpl("AaeEUiOiU");
    }

    @Test(expected = VogalNaoEncontradaException.class)
    public void teste_quando_nao_contem_vogal() {
	new StreamServiceImpl("FWstRL");
    }

    @Test(expected = VogalNaoEncontradaException.class)
    public void teste_quando_nao_contem_vogal_apos_a_consoante() {
	new StreamServiceImpl("AEeiUFWstRL");
    }

    @Test(expected = VogalNaoEncontradaException.class)
    public void teste_quando_todas_as_vogais_se_repetem() {
	new StreamServiceImpl("AcTaEiteIOuUo");
    }

    @Test
    public void teste_deve_achar_a_vogal_e_retonar_false_quando_ela_for_o_ultimo_caracter() {
	String input = "aAbBABacfe";
	StreamService stream = new StreamServiceImpl(input);
	for (int i = 0; i < input.length(); i++) {
	    if (i == (input.length() - 1)) {
		Assert.assertNotNull(stream.getNext());
		Assert.assertFalse(stream.hasNext());
	    } else {
		Assert.assertNotNull(stream.getNext());
		Assert.assertTrue(stream.hasNext());
	    }
	}
    }

    @Test
    public void teste_deve_achar_a_vogal_e_retonar_false_quando_ela_nao_for_o_ultimo_caracter() {
	String input = "aAbBABacfeAfU";
	StreamService stream = new StreamServiceImpl(input);
	int index = 0;
	do {
	    stream.getNext();
	    index++;
	} while (stream.hasNext());
	Assert.assertEquals(10, index);
    }

    @Test
    public void teste_deve_achar_a_vogal_e_retonar_false_quando_ela_for_o_segundo_caracter() {
	String input = "TaEbBiBIcfeOfU";
	StreamService stream = new StreamServiceImpl(input);
	int index = 0;
	do {
	    stream.getNext();
	    index++;
	} while (stream.hasNext());
	Assert.assertEquals(2, index);
    }

}
