package com.ufcg.si1.service.strategy.prefeituraSituacao;

import com.ufcg.si1.model.enums.SituacaoGeralQueixas;

public class SituacaoExtra implements SituacaoPrefeitura {

	@Override
	public SituacaoGeralQueixas situacaoQueixas(double porcentagemQueixasAbertas) {

		if (porcentagemQueixasAbertas > 10.0) {
			return SituacaoGeralQueixas.RUIM;
		} else if (porcentagemQueixasAbertas > 5.0) {
			return SituacaoGeralQueixas.REGULAR;
		} else {
			return SituacaoGeralQueixas.BOM;
		}
	}
}