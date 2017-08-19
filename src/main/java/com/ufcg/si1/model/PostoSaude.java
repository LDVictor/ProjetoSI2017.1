package com.ufcg.si1.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PostoSaude extends UnidadeSaude {

	@Column(name = "atendentes_postoSaude")
	private int medicos;

	@Column(name = "taxa_diaria_postoSaude")
	private int pacientes;

	public PostoSaude() {

	}

	public PostoSaude(String descricao, String bairro, int medicos, int pacientes) {
		super(descricao, bairro, "Posto de Saúde");
		this.medicos = medicos;
		this.pacientes = pacientes;
	}

	public int getMedicos() {
		return medicos;
	}

	public void setMedicos(int medicos) {
		this.medicos = medicos;
	}

	public int getPacientes() {
		return pacientes;
	}

	public void setPacientes(int pacientes) {
		this.pacientes = pacientes;
	}

	@Override
	public int calculaMediaMedicoPaciente() {
		if (this.medicos > 0.0) {
			return this.pacientes / this.medicos;
		}
		return 0;
	}
}