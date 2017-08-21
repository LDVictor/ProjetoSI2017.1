package com.ufcg.si1.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PostoSaude extends UnidadeSaude {

	@Column(name = "atendentes_postoSaude")
	private int atendentes;

	@Column(name = "taxa_diaria_postoSaude")
	private int taxaAtendimento;

	public PostoSaude() {

	}

	public PostoSaude(String descricao, String bairro, int atendentes, int taxaAtendimento) {
		super(descricao, bairro);
		this.atendentes = atendentes;
		this.taxaAtendimento = taxaAtendimento;
	}

	public int getMedicos() {
		return atendentes;
	}

	public void setMedicos(int medicos) {
		this.atendentes = medicos;
	}

	public int getPacientes() {
		return taxaAtendimento;
	}

	public void setPacientes(int pacientes) {
		this.taxaAtendimento = pacientes;
	}

	@Override
	public double calculaMediaMedicoPaciente() {
		if (this.atendentes > 0.0) {
			return this.taxaAtendimento / this.atendentes;
		}
		return 0;
	}
}