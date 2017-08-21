package com.ufcg.si1.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "tb_unidade_saude")
public abstract class UnidadeSaude {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_unidade_saude", nullable = false, unique = true)
	private Long id;

	@Column(name = "descricao_unidade_saude")
	private String descricao;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Especialidade> especialidades;

	@Column(name = "bairro_unidade_saude")
	private String bairro;
	

	public UnidadeSaude() {

	}

	public UnidadeSaude(String descricao, String bairro) {
		this.especialidades = new ArrayList<Especialidade>();
		this.bairro = bairro;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Especialidade> getEspecialidades() {
		return this.especialidades;
	}

	public void adicionarEspecialidade(Especialidade esp) {
		this.especialidades.add(esp);
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long cod) {
		this.id = cod;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public abstract double calculaMediaMedicoPaciente();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnidadeSaude other = (UnidadeSaude) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}