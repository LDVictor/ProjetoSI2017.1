package com.ufcg.si1.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufcg.si1.model.Queixa;
import com.ufcg.si1.model.enums.QueixaSituacao;

@Repository
public interface QueixaRepositorio extends JpaRepository<Queixa, Long> {
	
	long countBySituacao(QueixaSituacao situacao);
}
