package com.ufcg.si1.model;

import javax.persistence.*;

import com.ufcg.si1.model.enums.SituacaoQueixa;
import com.ufcg.si1.model.enums.TipoQueixa;

@Entity
@Table(name = "tb_queixa")
public class Queixa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_queixa")
	private Long id;

	@Column(name = "descricao_queixa")
	private String descricao;

	@OneToOne(cascade = CascadeType.ALL)
	private Pessoa solicitante;

	@Column(name = "comentario_queixa")
	private String comentario;

	@Column(name = "tipo_queixa")
	@Enumerated(EnumType.STRING)
	private TipoQueixa tipo;

	@Column(name = "situacao_queixa")
	@Enumerated(EnumType.STRING)
	private SituacaoQueixa situacao;

	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;

	public Queixa() {

	}

	public Queixa(String descricao, String nome, String email, String rua, String uf, String cidade, TipoQueixa tipo) {
		this.solicitante = new Pessoa(nome, email);
		this.endereco = new Endereco(rua, uf, cidade);
		this.descricao = descricao;
		this.situacao = SituacaoQueixa.ABERTO;
		this.tipo = tipo;
		this.comentario = "";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public SituacaoQueixa getSituacao() {
		return this.situacao;
	}

	public void setSituacao(SituacaoQueixa situacao) {
		this.situacao = situacao;
	}

	public TipoQueixa getTipo() {
		return tipo;
	}

	public void setTipo(TipoQueixa tipo) {
		this.tipo = tipo;
	}

	public void abrir() {
		if (this.verificaSituacaoAbrir())
			this.setSituacao(SituacaoQueixa.ABERTO);
	}

	private boolean verificaSituacaoAbrir() {
		return this.getSituacao() != SituacaoQueixa.EM_ANDAMENTO;
	}

	public void fechar(String coment) {
		if (this.verificaSituacaoFechar()) {
			this.setSituacao(SituacaoQueixa.FECHADO);
			this.comentario = coment;
		}
	}

	private boolean verificaSituacaoFechar() {
		return this.getSituacao() == SituacaoQueixa.EM_ANDAMENTO || this.getSituacao() == SituacaoQueixa.ABERTO;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Pessoa getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Pessoa solicitante) {
		this.solicitante = solicitante;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Queixa other = (Queixa) obj;
		if (id != other.id)
			return false;
		return true;
	}
}