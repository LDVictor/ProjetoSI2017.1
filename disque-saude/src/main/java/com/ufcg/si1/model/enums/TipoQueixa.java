package com.ufcg.si1.model.enums;

public enum TipoQueixa {
	ANIMAL("Animal"), ALIMENTAR("Alimentar"), SERVICO_GERAL("Serviço Geral");

	private final String tipoQueixa;

	TipoQueixa(String tipoQueixa) {
		this.tipoQueixa = tipoQueixa;
	}

	public String getTipoQueixa() {
		return tipoQueixa;
	}
	
	
}
