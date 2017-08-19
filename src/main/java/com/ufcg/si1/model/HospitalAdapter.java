package com.ufcg.si1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_hospital")
public class HospitalAdapter extends UnidadeSaude {

	@Column(name = "medicos_hospital")
	private int medicos;

	@Column(name = "numero_pacientes_dia")
	private int pacientes;

	public HospitalAdapter() {

	}

	public HospitalAdapter(String descricao, String bairro, int medicos, int numPacientesDia) {
		super(descricao, bairro, "Hospital");
		this.medicos = medicos;
		this.pacientes = numPacientesDia;
	}

	@Override
	public int calculaMediaMedicoPaciente() {
		if (this.medicos > 0) {
			return (this.pacientes / this.medicos);
		}
		return 0;
	}
}
