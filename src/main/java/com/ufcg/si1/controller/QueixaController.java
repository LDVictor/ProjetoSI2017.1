package com.ufcg.si1.controller;

import com.ufcg.si1.model.*;
import com.ufcg.si1.model.enums.SituacaoGeralQueixas;
import com.ufcg.si1.service.QueixaServiceImpl;
import com.ufcg.si1.service.interfaces.QueixaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collection;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class QueixaController {

	@Autowired
	private QueixaService queixaService = new QueixaServiceImpl();
	
	@RequestMapping(value = "/queixa/listarTodasQueixas", method = RequestMethod.GET)
	public ResponseEntity<Collection<Queixa>> listaTodasQueixas() {
		Collection<Queixa> queixas = queixaService.getQueixas();

		if (queixas.isEmpty()) {
			return new ResponseEntity<Collection<Queixa>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Collection<Queixa>>(queixas, HttpStatus.OK);
	}

	@RequestMapping(value = "/queixa/", method = RequestMethod.POST)
	public ResponseEntity<Queixa> abrirQueixa(@RequestBody Queixa queixa, UriComponentsBuilder ucBuilder) {

		this.queixaService.addQueixa(queixa);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/queixa/{id}").buildAndExpand(queixa.getId()).toUri());
		return new ResponseEntity<Queixa>(queixa, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/queixa/{id}", method = RequestMethod.GET)
	public ResponseEntity<Queixa> consultarQueixa(@PathVariable("id") Long id) {

		Queixa queixa = queixaService.procuraQueixaId(id);
		return new ResponseEntity<Queixa>(queixa, HttpStatus.OK);
	}

	@RequestMapping(value = "/queixa/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Queixa> atualizarQueixa(@PathVariable("id") Long id, @RequestBody Queixa queixa) {

		queixaService.atualizaQueixa(queixa);
		return new ResponseEntity<Queixa>(queixa, HttpStatus.OK);
	}

	@RequestMapping(value = "/queixa/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Queixa> deletarQueixa(@PathVariable("id") Long id) {

		queixaService.deletaQueixaId(id);
		return new ResponseEntity<Queixa>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/queixa/fechamento", method = RequestMethod.POST)
	public ResponseEntity<Queixa> fecharQueixa(@RequestBody Queixa queixaAFechar) {

		queixaService.atualizaQueixa(queixaAFechar);
		return new ResponseEntity<Queixa>(queixaAFechar, HttpStatus.OK);
	}

	@RequestMapping(value = "/geral/situacao", method = RequestMethod.GET)
	public ResponseEntity<SituacaoGeralQueixas> consultaSituacaoGeral() {

		SituacaoGeralQueixas situacao = this.queixaService.consultaSituacaoGeral();

		return new ResponseEntity<SituacaoGeralQueixas>(situacao, HttpStatus.OK);
	}

}