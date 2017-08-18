package com.ufcg.si1.service.strategy.prefeituraSituacao;

import com.ufcg.si1.model.enums.SituacaoGeralQueixas;

public interface SituacaoPrefeitura {

	public SituacaoGeralQueixas situacaoQueixas(double porcentagemQueixasAbertas);

}
