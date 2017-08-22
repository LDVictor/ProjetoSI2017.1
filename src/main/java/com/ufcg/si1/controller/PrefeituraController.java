package com.ufcg.si1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.si1.service.interfaces.PrefeituraService;
import com.ufcg.si1.service.strategy.prefeituraSituacao.SituacaoPrefeitura;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PrefeituraController {
	
	@Autowired
	private PrefeituraService prefeituraService;
	
	@RequestMapping(value = "/prefeitura/", method = RequestMethod.POST)
	public void modificarSituacaoPrefeitura(SituacaoPrefeitura situacao) {
		this.prefeituraService.modificaSituacaoPrefeitura(situacao);
		new ResponseEntity<>(HttpStatus.OK);
	}
}
