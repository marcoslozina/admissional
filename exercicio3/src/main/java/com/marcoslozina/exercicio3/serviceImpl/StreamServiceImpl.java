package com.marcoslozina.exercicio3.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.marcoslozina.exercicio3.exception.ConsoanteNaoExisteException;
import com.marcoslozina.exercicio3.exception.VogalNaoEncontradaException;
import com.marcoslozina.exercicio3.service.StreamService;

public class StreamServiceImpl implements StreamService {

    private static final String VOGAL_MATCHER = "^A|E|I|O|U$";

    private int vogalIndex;
    private int index;
    private String input;

    public StreamServiceImpl(String input) {
	this.index = 0;
	this.input = input;
	List<String> chars = Arrays.asList(this.input.split("")).stream().map(String::toUpperCase)
		.collect(Collectors.toList());
	String consoante = chars.stream().filter(s -> !s.matches(VOGAL_MATCHER)).findFirst()
		.orElseThrow(ConsoanteNaoExisteException::new);

	int consoanteIndex = chars.indexOf(consoante);

	String vogal = chars.subList(consoanteIndex, chars.size()).stream().filter(filtraVogalUnica(chars)).findFirst()
		.orElseThrow(VogalNaoEncontradaException::new);
	this.vogalIndex = chars.indexOf(vogal);
    }

    @Override
    public char getNext() {
	return this.input.charAt(this.index++);
    }

    @Override
    public boolean hasNext() {
	return this.index <= this.input.length() && this.vogalIndex == -1 || this.index <= this.vogalIndex;
    }

    private Predicate<? super String> filtraVogalUnica(List<String> chars) {
	return s -> s.matches(VOGAL_MATCHER) && chars.stream().filter(v -> v.equals(s)).count() == 1;
    }

}
