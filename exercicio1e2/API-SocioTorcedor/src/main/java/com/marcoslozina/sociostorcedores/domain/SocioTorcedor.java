package com.marcoslozina.sociostorcedores.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class SocioTorcedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "O nome deve ser preenchido.")
    @Size(max = 30, message = "O nome não pode contar mais de 30 caracteres.")
    String nome;
    @NotEmpty(message = "O email deve ser preenchido.")
    @Size(max = 50, message = "O email não pode contar mais de 30 caracteres.")
    String email;

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dataNacimento;

    @OneToOne
    @JoinColumn(name = "id_timedocoracao")
    TimeDoCoracao timeDoCoracao;

    public SocioTorcedor(Long id, String nome, String email, LocalDate dataNacimento, TimeDoCoracao timeDoCoracao) {
	this.id = id;
	this.nome = nome;
	this.email = email;
	this.dataNacimento = dataNacimento;
	this.timeDoCoracao = timeDoCoracao;
    }

    public SocioTorcedor(String nome, String email, LocalDate dataNacimento, TimeDoCoracao timeDoCoracao) {
	this.nome = nome;
	this.email = email;
	this.dataNacimento = dataNacimento;
	this.timeDoCoracao = timeDoCoracao;
    }

    public SocioTorcedor() {
    }

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

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public LocalDate getDataNacimento() {
	return dataNacimento;
    }

    public void setDataNacimento(LocalDate dataNacimento) {
	this.dataNacimento = dataNacimento;
    }

    public TimeDoCoracao getTimeDoCoracao() {
	return timeDoCoracao;
    }

    public void setTimeDoCoracao(TimeDoCoracao timeDoCoracao) {
	this.timeDoCoracao = timeDoCoracao;
    }

}