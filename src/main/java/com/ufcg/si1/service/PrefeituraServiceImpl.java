package com.ufcg.si1.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.si1.model.Prefeitura;
import com.ufcg.si1.repositorios.PrefeituraRepositorio;
import com.ufcg.si1.service.interfaces.PrefeituraService;

@Service("prefeituraService")
public class PrefeituraServiceImpl implements PrefeituraService {

	@Autowired
	private PrefeituraRepositorio prefeituraRepositorio;
	
	private static final Log LOGGER = LogFactory.getLog(PrefeituraService.class);
	
	@Override
	public void modificaSituacaoPrefeitura(String situacao) {
		LOGGER.debug("Modificando situacao da Prefeitura para:" + situacao);
		Prefeitura prefeitura = Prefeitura.getInstance();
		
		if (situacao == "Normal")
			prefeitura.setSituacaoNormal();
		if (situacao == "Extra")
			prefeitura.setSituacaoExtra();
		if (situacao == "Caos")
			prefeitura.setSituacaoCaos();
		
		this.prefeituraRepositorio.save(prefeitura);
	}

}
