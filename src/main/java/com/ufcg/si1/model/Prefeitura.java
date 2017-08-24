package com.ufcg.si1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.ufcg.si1.model.enums.SituacaoGeralQueixas;
import com.ufcg.si1.service.strategy.prefeituraSituacao.SituacaoCaos;
import com.ufcg.si1.service.strategy.prefeituraSituacao.SituacaoExtra;
import com.ufcg.si1.service.strategy.prefeituraSituacao.SituacaoNormal;
import com.ufcg.si1.service.strategy.prefeituraSituacao.SituacaoPrefeitura;

@Entity
@Table(name = "tb_prefeitura")
public class Prefeitura {

	private static Prefeitura singleton;

	public static Prefeitura getInstance() {
		if (singleton == null) {
			singleton = new Prefeitura();
		}
		return singleton;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prefeitura")
	private Long id;

	@Transient
	private SituacaoPrefeitura situacao;

	public Prefeitura() {
		this.situacao = new SituacaoNormal();
	}

	public SituacaoPrefeitura getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoPrefeitura situacao) {
		this.situacao = situacao;
	}
	
	public void setSituacaoNormal() {
		this.situacao = new SituacaoNormal();
	}
	
	public void setSituacaoExtra() {
		this.situacao = new SituacaoExtra();
	}
	
	public void setSituacaoCaos() {
		this.situacao = new SituacaoCaos();
	}

	public SituacaoGeralQueixas getSituacaoDasQueixas(double porcentagemQueixasAbertas) {
		return situacao.situacaoQueixas(porcentagemQueixasAbertas);
	}

}