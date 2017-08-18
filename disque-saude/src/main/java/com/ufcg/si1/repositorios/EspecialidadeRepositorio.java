package com.ufcg.si1.repositorios;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ufcg.si1.model.Especialidade;

@Repository
public interface EspecialidadeRepositorio extends JpaRepository<Especialidade, Long> {
	
	Collection<Especialidade> findByDescricao(String descricao);
}
