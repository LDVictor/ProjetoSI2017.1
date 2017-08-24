package com.ufcg.si1.model.enums;

public enum QueixaSituacao {
	ABERTA("Aberta"), EM_ANDAMENTO("Em Andamento"), FECHADA("Fechada");

	private final String queixaSituacao;

	QueixaSituacao(String queixaSituacao) {
		this.queixaSituacao = queixaSituacao;
	}

	public String getTipoQueixa() {
		return this.queixaSituacao;
	}
}
