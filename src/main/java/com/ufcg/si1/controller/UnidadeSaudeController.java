package com.ufcg.si1.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.model.HospitalAdapter;
import com.ufcg.si1.model.PostoSaude;
import com.ufcg.si1.model.UnidadeSaude;
import com.ufcg.si1.service.UnidadeSaudeServiceImpl;
import com.ufcg.si1.service.interfaces.UnidadeSaudeService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UnidadeSaudeController {

	@Autowired
	private UnidadeSaudeService unidadeSaudeService = new UnidadeSaudeServiceImpl();

	@RequestMapping(value = "/especialidade/unidades/{descricao}", method = RequestMethod.GET)
	public ResponseEntity<Collection<Especialidade>> consultaEspecialidadeNaUnidadeSaude(
			@PathVariable String descricao) {

		Collection<Especialidade> especialidades = this.unidadeSaudeService.procuraEspecialidadeNaUS(descricao);

		return new ResponseEntity<Collection<Especialidade>>(especialidades, HttpStatus.OK);
	}

	@RequestMapping(value = "/unidade/listartodasus", method = RequestMethod.GET)
	public ResponseEntity<Collection<UnidadeSaude>> mostraTodasUnidadeSaude() {

		Collection<UnidadeSaude> unidades = unidadeSaudeService.retornaTodasUS();
		return new ResponseEntity<Collection<UnidadeSaude>>(unidades, HttpStatus.OK);
	}

	@RequestMapping(value = "/unidade/", method = RequestMethod.POST)
	public ResponseEntity<String> incluirPostoSaude(@RequestBody PostoSaude us, UriComponentsBuilder ucBuilder) {
		this.unidadeSaudeService.insereUS(us);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/unidade/{bairro}").buildAndExpand(us.getBairro()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/unidade/hospital", method = RequestMethod.POST)
	public ResponseEntity<String> incluirHospital(@RequestBody HospitalAdapter us, UriComponentsBuilder ucBuilder) {
		this.unidadeSaudeService.insereUS(us);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/unidade/{bairro}").buildAndExpand(us.getBairro()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/unidade/{bairro}", method = RequestMethod.GET)
	public ResponseEntity<Collection<UnidadeSaude>> consultarUnidadeSaudePorBairro(
			@PathVariable("bairro") String bairro) {

		Collection<UnidadeSaude> us = unidadeSaudeService.procuraUSpeloBairro(bairro);
		return new ResponseEntity<Collection<UnidadeSaude>>(us, HttpStatus.OK);
	}

	@RequestMapping(value = "/geral/medicos/{id}", method = RequestMethod.GET)
	public ResponseEntity<Double> calcularMediaMedicoPacienteDia(@PathVariable("id") Long id) {
		double media = this.unidadeSaudeService.calcularMediaMedicoPaciente(id);
		return new ResponseEntity<Double>(media, HttpStatus.OK);
	}
}
