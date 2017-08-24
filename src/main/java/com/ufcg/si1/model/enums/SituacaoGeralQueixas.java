package com.ufcg.si1.model.enums;

public enum SituacaoGeralQueixas {
	
	RUIM("Ruim"), REGULAR("Regular"), BOM("Bom");
	
	private final String situacaoGeralQueixas;

    SituacaoGeralQueixas(String situacaoGeralQueixas) {
        this.situacaoGeralQueixas = situacaoGeralQueixas;
    }

	public String getSituacao() {
		return situacaoGeralQueixas;
	}
}
