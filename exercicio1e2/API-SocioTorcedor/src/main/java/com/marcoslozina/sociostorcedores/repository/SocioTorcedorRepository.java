package com.marcoslozina.sociostorcedores.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.marcoslozina.sociostorcedores.domain.SocioTorcedor;

public interface SocioTorcedorRepository extends JpaRepository<SocioTorcedor, Long> {

    @Query(value = "select s from SocioTorcedor s where LOWER(s.email) LIKE LOWER(:email)")
    SocioTorcedor findByEmail(@Param("email") String email);

}
