package com.marcoslozina.sociostorcedores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcoslozina.sociostorcedores.domain.TimeCampanha;

public interface TimeCampanhaRepository extends JpaRepository<TimeCampanha, Long> {

    // @Query(value = "select c from Campanha c where c.dataFim >= :dataFim")
    // List<TimeDoCoracao> findByVigenciaAtiva(@Param("dataFim") LocalDate
    // dataFim);

}
