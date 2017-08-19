package com.ufcg.si1.service.strategy.queixaSituacao;

public class QueixaEmAndamento implements QueixaStatus {
	
	private final static String EM_ANDAMENTO = "EM_ANDAMENTO";
	
	@Override
	public String queixaStatus() {
		return EM_ANDAMENTO;
	}
}
