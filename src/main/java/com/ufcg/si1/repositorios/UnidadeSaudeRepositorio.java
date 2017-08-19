package com.ufcg.si1.repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.model.UnidadeSaude;

@Repository
public interface UnidadeSaudeRepositorio extends JpaRepository<UnidadeSaude, Long> {
	
	public Collection<Especialidade> findByDescricao(String descricaoEsp);
	public Collection<UnidadeSaude> findByBairro(String bairro);
}
