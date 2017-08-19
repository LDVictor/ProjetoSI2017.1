package com.ufcg.si1.model.enums;

public enum SituacaoGeralQueixas {
	
	RUIM(0), REGULAR(1), BOM(2);
	
	private final int situacao;

    SituacaoGeralQueixas(int situacao) {
        this.situacao = situacao;
    }

	public int getSituacao() {
		return situacao;
	}
}
