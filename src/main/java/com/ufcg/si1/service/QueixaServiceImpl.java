package com.ufcg.si1.service;

import com.ufcg.si1.model.Prefeitura;
import com.ufcg.si1.model.Queixa;
import com.ufcg.si1.model.enums.SituacaoGeralQueixas;
import com.ufcg.si1.model.enums.SituacaoQueixa;
import com.ufcg.si1.repositorios.QueixaRepositorio;
import com.ufcg.si1.service.interfaces.QueixaService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("queixaService")
public class QueixaServiceImpl implements QueixaService {

	@Autowired
	private QueixaRepositorio queixaRepository;

	private static final Log LOGGER = LogFactory.getLog(QueixaService.class);

	@Override
	public Queixa addQueixa(Queixa queixa) {
		LOGGER.debug("Queixa " + queixa.getDescricao() + " adicionada com id: " + queixa.getId());
		return this.queixaRepository.save(queixa);
	}

	@Override
	public boolean atualizaQueixa(Queixa queixa) {
		if (this.queixaRepository.exists(queixa.getId())) {
			LOGGER.debug("Atualizando Queixa " + queixa.getDescricao());
			queixa.setDescricao(queixa.getDescricao());
			queixa.setComentario(queixa.getComentario());
			queixa.setSituacao(queixa.getSituacao());
			this.queixaRepository.save(queixa);
			return true;
		}
		return false;
	}

	@Override
	public Collection<Queixa> getQueixas() {
		LOGGER.debug("Retornando todas as Queixas do sistema");
		return this.queixaRepository.findAll();
	}

	@Override
	public void deletaTodasQueixas() {
		this.queixaRepository.deleteAll();
	}

	@Override
	public Queixa procuraQueixaId(Long id) {
		LOGGER.debug("Queixa esta sendo retornada pelo id");
		return this.queixaRepository.getOne(id);
	}

	@Override
	public boolean deletaQueixaId(Long id) {
		if (this.queixaRepository.exists(id)) {
			LOGGER.debug("Deletando Queixa.");
			this.queixaRepository.delete(id);
			return true;
		}
		return false;
	}

	@Override
	public SituacaoGeralQueixas consultaSituacaoGeral() {

		Prefeitura prefeitura = Prefeitura.getInstance();

		double porcentagemQueixasAbertas = (this.quantidadeQueixasAbertas() / getQueixas().size()) * 100;

		SituacaoGeralQueixas situacao = prefeitura.getSituacaoDasQueixas(porcentagemQueixasAbertas);

		return situacao;
	}

	@Override
	public long quantidadeQueixasAbertas() {
		return this.queixaRepository.countBySituacao(SituacaoQueixa.ABERTO);
	}
}