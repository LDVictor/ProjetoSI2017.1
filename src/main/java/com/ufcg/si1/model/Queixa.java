package com.ufcg.si1.model;

import javax.persistence.*;

import com.ufcg.si1.model.enums.QueixaSituacao;
import com.ufcg.si1.model.enums.QueixaTipo;

@Entity
@Table(name = "tb_queixa")
public class Queixa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_queixa")
	private Long id;

	@Column(name = "descricao_queixa")
	private String descricao;

	@ManyToOne(cascade = CascadeType.ALL)
	private Pessoa solicitante;

	@Column(name = "comentario_queixa")
	private String comentario;

	@Column(name = "tipo_queixa")
	private QueixaTipo tipo;

	@Column(name = "situacao_queixa")
	private QueixaSituacao situacao;

	@ManyToOne(cascade = CascadeType.ALL)
	private Endereco endereco;

	public Queixa() {
		this.situacao = QueixaSituacao.ABERTA;
	}

	public Queixa(String descricao, String nome, String email, String rua, String bairro, String uf, String cidade,
			QueixaTipo tipo) {
		
		this.solicitante = new Pessoa(nome, email);
		this.endereco = new Endereco(rua, bairro, uf, cidade);
		this.descricao = descricao;
		this.situacao = QueixaSituacao.ABERTA;
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

	public QueixaSituacao getSituacao() {
		return this.situacao;
	}

	public void setSituacao(QueixaSituacao situacao) {
		this.situacao = situacao;
	}

	public QueixaTipo getTipo() {
		return tipo;
	}

	public void setTipo(QueixaTipo tipo) {
		this.tipo = tipo;
	}

	public void abrir() {
		if (this.verificaSituacaoAbrir())
			this.setSituacao(QueixaSituacao.ABERTA);
	}

	private boolean verificaSituacaoAbrir() {
		return this.getSituacao() != QueixaSituacao.EM_ANDAMENTO;
	}

	public void fechar(String coment) {
		if (this.verificaSituacaoFechar()) {
			this.setSituacao(QueixaSituacao.FECHADA);
			this.comentario = coment;
		}
	}

	private boolean verificaSituacaoFechar() {
		return this.getSituacao() == QueixaSituacao.EM_ANDAMENTO || this.getSituacao() == QueixaSituacao.ABERTA;
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