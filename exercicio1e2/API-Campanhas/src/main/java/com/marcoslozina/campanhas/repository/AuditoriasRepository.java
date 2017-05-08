package com.marcoslozina.campanhas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcoslozina.campanhas.domain.Auditoria;

public interface AuditoriasRepository extends JpaRepository<Auditoria, Long> {

}
