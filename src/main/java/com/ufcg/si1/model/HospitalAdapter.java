package com.ufcg.si1.model;

import javax.persistence.Entity;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.edu.ufcg.Hospital;

@Entity
public class HospitalAdapter extends UnidadeSaude {

	@JsonIgnore
	@Transient
	private Hospital hospital;

	public HospitalAdapter() {

	}

	public HospitalAdapter(String descricao, String bairro, int medicos, int numPacientesDia) {
		super(descricao, bairro);
		this.hospital = new Hospital(descricao, medicos, numPacientesDia);
	}

	@Override
	public double calculaMediaMedicoPaciente() {
		if (this.hospital.getNumeroPacientesDia() > 0) {
			return this.hospital.getNumeroMedicos() / this.hospital.getNumeroPacientesDia();
		}
		return 0.0;
	}
}
