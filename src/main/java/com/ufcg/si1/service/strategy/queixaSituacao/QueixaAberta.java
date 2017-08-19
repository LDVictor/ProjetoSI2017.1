package com.ufcg.si1.service.strategy.queixaSituacao;

public class QueixaAberta implements QueixaStatus {

	private final static String ABERTA = "ABERTA";
	
	@Override
	public String queixaStatus() {
		return ABERTA;
	}
}
