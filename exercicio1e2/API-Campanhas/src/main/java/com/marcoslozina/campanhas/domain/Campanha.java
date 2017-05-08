package com.marcoslozina.campanhas.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Campanha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "O nome deve ser preenchido.")
    @Size(max = 30, message = "O nome não pode contar mais de 30 caracteres.")
    String nome;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dataInicio;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dataFim;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public LocalDate getDataInicio() {
	return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
	this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
	return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
	this.dataFim = dataFim;
    }

    public Campanha(String nome, LocalDate dataInicio, LocalDate dataFim) {
	this.nome = nome;
	this.dataInicio = dataInicio;
	this.dataFim = dataFim;
    }

    public Campanha(Long id, String nome, LocalDate dataInicio, LocalDate dataFim) {
	this.id = id;
	this.nome = nome;
	this.dataInicio = dataInicio;
	this.dataFim = dataFim;
    }

    public Campanha() {

    }

}