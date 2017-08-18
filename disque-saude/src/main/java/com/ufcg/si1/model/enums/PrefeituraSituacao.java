package com.ufcg.si1.model.enums;

public enum PrefeituraSituacao {
	NORMAL("Normal"), EXTRA("Extra"), CAOS("Caos");

	private final String prefeituraSituacao;

	PrefeituraSituacao(String prefeituraSituacao) {
		this.prefeituraSituacao = prefeituraSituacao;
	}

	public String getPrefeituraSituacao() {
		return prefeituraSituacao;
	}
}
