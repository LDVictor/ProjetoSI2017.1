package com.ufcg.si1.service.interfaces;

import java.util.Collection;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.model.UnidadeSaude;

public interface UnidadeSaudeService {

	Collection<UnidadeSaude> retornaTodasUS();

	UnidadeSaude insereUS(UnidadeSaude us);

	UnidadeSaude atualizarUS(UnidadeSaude us);

	void deletarUS(UnidadeSaude us);

	boolean existeUS(Long id);

	UnidadeSaude procuraUSpeloID(Long id);

	Collection<UnidadeSaude> procuraUSpeloBairro(String bairro);

	Collection<Especialidade> procuraEspecialidadeNaUS(String descricaoEsp);

	double calcularMediaMedicoPaciente(Long id);
}