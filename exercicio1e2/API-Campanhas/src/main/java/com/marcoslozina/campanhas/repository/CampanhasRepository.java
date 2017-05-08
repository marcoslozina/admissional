package com.marcoslozina.campanhas.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.marcoslozina.campanhas.domain.Campanha;

public interface CampanhasRepository extends JpaRepository<Campanha, Long> {

    @Query(value = "select c from Campanha c where c.dataFim >= :dataFim")
    List<Campanha> findByVigenciaAtiva(@Param("dataFim") LocalDate dataFim);

}
