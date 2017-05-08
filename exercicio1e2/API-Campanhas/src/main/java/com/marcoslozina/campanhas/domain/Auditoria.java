package com.marcoslozina.campanhas.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "O id da campanha é obrigatorio.")
    private Long idCampanha;
    @NotNull(message = "A data e a hora da modificações são obrigatorios.")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataDaMundanca;
    @NotNull(message = "A data antiga é obrigatorio.")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataFimAntiga;
    @NotNull(message = "A data nova é obrigatorio.")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataFimNova;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Long getIdCampanha() {
	return idCampanha;
    }

    public void setIdCampanha(Long idCampanha) {
	this.idCampanha = idCampanha;
    }

    public LocalDate getDataDaMundanca() {
	return dataDaMundanca;
    }

    public void setDataDaMundanca(LocalDate dataDaMundanca) {
	this.dataDaMundanca = dataDaMundanca;
    }

    public LocalDate getDataFimAntiga() {
	return dataFimAntiga;
    }

    public void setDataFimAntiga(LocalDate dataFimAntiga) {
	this.dataFimAntiga = dataFimAntiga;
    }

    public LocalDate getDataFimNova() {
	return dataFimNova;
    }

    public void setDataFimNova(LocalDate dataFimNova) {
	this.dataFimNova = dataFimNova;
    }

    public Auditoria(Long idCampanha, LocalDate dataDaMundanca, LocalDate dataFimAntiga, LocalDate dataFimNova) {
	this.idCampanha = idCampanha;
	this.dataDaMundanca = dataDaMundanca;
	this.dataFimAntiga = dataFimAntiga;
	this.dataFimNova = dataFimNova;
    }

    public Auditoria() {

    }

}
