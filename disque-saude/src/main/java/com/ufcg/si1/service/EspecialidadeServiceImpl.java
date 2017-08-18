package com.ufcg.si1.service;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.repositorios.EspecialidadeRepositorio;
import com.ufcg.si1.service.interfaces.EspecialidadeService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("especialidadeService")
public class EspecialidadeServiceImpl implements EspecialidadeService {

	@Autowired
	private EspecialidadeRepositorio especialidadeRepository;

	private static final Log LOGGER = LogFactory.getLog(EspecialidadeService.class);

	@Override
	public Especialidade insereEspecialidade(Especialidade esp) {
		LOGGER.debug("Especialidade " + esp.getDescricao() + " criada");
		return this.especialidadeRepository.save(esp);
	}

	@Override
	public boolean existeEspecialidade(Long id) {
		LOGGER.debug("Especialidade está sendo verificada pelo id");
		return this.especialidadeRepository.exists(id);

	}

	@Override
	public Especialidade procuraPeloID(Long id) {
		LOGGER.debug("Especialidade está sendo retornada pelo id");
		return this.especialidadeRepository.findOne(id);
	}

	@Override
	public boolean atualizaEspecialidade(Especialidade esp) {
		if (this.especialidadeRepository.exists(esp.getId())) {
			LOGGER.debug("Atualizando especialidade " + esp.getDescricao());
			this.especialidadeRepository.save(esp);
			return true;
		}
		return false;
	}

	@Override
	public boolean deletaEspecialidade(Long id) {
		if (this.especialidadeRepository.exists(id)) {
			LOGGER.debug("Deletando Especialidade");
			this.especialidadeRepository.delete(id);
			return true;
		}
		return false;
	}

	@Override
	public Collection<Especialidade> getListaEspecialidade() {
		LOGGER.debug("Retornando todos os tipos de Especialidades");
		return this.especialidadeRepository.findAll();
	}

	@Override
	public Collection<Especialidade> procuraPelaDescricao(String descricao) {
		LOGGER.debug("Retornando Especialidades existentes do tipo: " + descricao);
		return this.especialidadeRepository.findByDescricao(descricao);
	}
}