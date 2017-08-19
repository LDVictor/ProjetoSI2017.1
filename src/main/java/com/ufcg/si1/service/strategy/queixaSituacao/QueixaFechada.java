package com.ufcg.si1.service.strategy.queixaSituacao;

public class QueixaFechada implements QueixaStatus {
	
	private final static String FECHADA = "FECHADA";
	
	@Override
	public String queixaStatus() {
		return FECHADA;
	}
}
