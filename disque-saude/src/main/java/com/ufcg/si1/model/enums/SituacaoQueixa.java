package com.ufcg.si1.model.enums;

public enum SituacaoQueixa {
	ABERTO("Aberto"), EM_ANDAMENTO("Em Andamento"), FECHADO("Fechado");

	private final String situacaoQueixa;

	SituacaoQueixa(String situacao) {
		this.situacaoQueixa = situacao;
	}

	public String getTipoQueixa() {
		return this.situacaoQueixa;
	}
}
