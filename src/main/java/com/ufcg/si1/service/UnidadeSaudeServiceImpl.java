package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.model.UnidadeSaude;
import com.ufcg.si1.repositorios.UnidadeSaudeRepositorio;
import com.ufcg.si1.service.interfaces.UnidadeSaudeService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("unidadeSaudeService")
public class UnidadeSaudeServiceImpl implements UnidadeSaudeService {

	@Autowired
	private UnidadeSaudeRepositorio usRepository;

	private static final Log LOGGER = LogFactory.getLog(UnidadeSaudeServiceImpl.class);

	@Override
	public Collection<UnidadeSaude> retornaTodasUS() {
		LOGGER.debug("Retornando todas as Unidades de Saudes do sistema.");
		return this.usRepository.findAll();
	}

	@Override
	public UnidadeSaude insereUS(UnidadeSaude us) {
		LOGGER.debug("Salvando Unidade de Saude: " + us.getId() + " no sistema.");
		return this.usRepository.save(us);
	}

	public UnidadeSaude atualizarUS(UnidadeSaude us) {
		if (this.usRepository.exists(us.getId())) {
			LOGGER.debug("Atualizando Unidade Saude " + us.getDescricao());
			us.setDescricao(us.getDescricao());
			us.setBairro(us.getBairro());
			this.usRepository.save(us);
			return us;
		}
		return null;
	}

	@Override
	public boolean existeUS(Long id) {
		LOGGER.debug("Unidade de Saude está sendo verificada pelo id");
		return this.usRepository.exists(id);
	}

	@Override
	public UnidadeSaude procuraUSpeloID(Long id) {
		LOGGER.debug("Unidade de Saude está sendo retornada pelo id");
		return this.usRepository.findOne(id);
	}

	@Override
	public Collection<UnidadeSaude> procuraUSpeloBairro(String bairro) {
		LOGGER.debug("Retornando Unidade de Saude existentes no bairro: " + bairro);
		return this.usRepository.findByBairro(bairro);
	}

	public void deletarUS(UnidadeSaude us) {
		LOGGER.debug("Deletando Unidade de Saude: " + us.getId() + " no sistema.");
		this.usRepository.delete(us);
	}

	@Override
	public double calcularMediaMedicoPaciente(Long id) {
		UnidadeSaude us = this.usRepository.findOne(id);
		LOGGER.debug("Calculando Media Medico por Paciente por Dia na Unidade de Saude " + us.getDescricao());
		return us.calculaMediaMedicoPaciente();
	}

	@Override
	// Gambiarrinha basica poderosa kkkk
	public Collection<UnidadeSaude> procuraEspecialidadeNaUS(String descricaoEsp) {
		LOGGER.debug("Retornando Unidades de Saude que atende a Especialidade: " + descricaoEsp);
		List<UnidadeSaude> us = this.usRepository.findAll();
		List<UnidadeSaude> retorno = new ArrayList<UnidadeSaude>();
		for (UnidadeSaude unidadeSaude : us) {
			for (Especialidade especialidade : unidadeSaude.getEspecialidades()) {
				if (especialidade.getDescricao().equalsIgnoreCase(descricaoEsp)) {
					retorno.add(unidadeSaude);
				}

			}
		}
		return retorno;
	}

}