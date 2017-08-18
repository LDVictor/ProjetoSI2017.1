package com.ufcg.si1.service.interfaces;

import com.ufcg.si1.model.Especialidade;

import java.util.Collection;

public interface EspecialidadeService {

	Especialidade procuraPeloID(Long id);

	Collection<Especialidade> getListaEspecialidade();

	Especialidade insereEspecialidade(Especialidade esp);

	boolean deletaEspecialidade(Long id);

	boolean existeEspecialidade(Long id);

	boolean atualizaEspecialidade(Especialidade esp);

	Collection<Especialidade> procuraPelaDescricao(String descricao);

}