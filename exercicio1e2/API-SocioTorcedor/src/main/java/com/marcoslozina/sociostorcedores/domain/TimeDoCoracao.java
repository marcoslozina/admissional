package com.marcoslozina.sociostorcedores.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class TimeDoCoracao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "O nome deve ser preenchido.")
    @Size(max = 30, message = "O nome não pode contar mais de 30 caracteres.")
    String nome;
    @OneToMany(mappedBy = "timeDoCoracao")
    private List<TimeCampanha> timeCampanhas;

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

    public List<TimeCampanha> getTimeCampanhas() {
	return timeCampanhas;
    }

    public void setTimeCampanhas(List<TimeCampanha> timeCampanhas) {
	this.timeCampanhas = timeCampanhas;
    }

}
