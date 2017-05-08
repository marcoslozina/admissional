package com.marcoslozina.sociostorcedores.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class TimeCampanha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "time_idtime")
    private TimeDoCoracao timeDoCoracao;
    @NotNull(message = "O id da campanha não pode ser nulo")
    private Long idcampanha;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public TimeDoCoracao getTimeDoCoracao() {
	return timeDoCoracao;
    }

    public void setTimeDoCoracao(TimeDoCoracao timeDoCoracao) {
	this.timeDoCoracao = timeDoCoracao;
    }

    public Long getIdcampanha() {
	return idcampanha;
    }

    public void setIdcampanha(Long idcampanha) {
	this.idcampanha = idcampanha;
    }

}
