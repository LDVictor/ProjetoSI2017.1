package com.ufcg.si1.model.enums;

public enum QueixaTipo {
	ANIMAL("Animal"), ALIMENTAR("Alimentar"), SERVICO_GERAL("Serviço Geral");

	private final String queixaTipo;

	QueixaTipo(String queixaTipo) {
		this.queixaTipo = queixaTipo;
	}

	public String getTipoQueixa() {
		return queixaTipo;
	}
	
	
}
