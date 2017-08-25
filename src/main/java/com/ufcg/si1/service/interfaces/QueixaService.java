package com.ufcg.si1.service.interfaces;

import java.util.Collection;

import com.ufcg.si1.model.Queixa;
import com.ufcg.si1.model.enums.QueixaSituacao;
import com.ufcg.si1.model.enums.SituacaoGeralQueixas;

public interface QueixaService {

	Collection<Queixa> getQueixas();

	Queixa procuraQueixaId(Long id);

	boolean deletaQueixaId(Long id);

	SituacaoGeralQueixas consultaSituacaoGeral();

	Queixa addQueixa(Queixa queixa);

	Queixa atualizaQueixa(Queixa queixa, String comentario, QueixaSituacao queixaSituacao);

	public void deletaTodasQueixas();

}