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
import com.ufcg.si1.service.interfaces.EspecialidadeService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EspecialidadeController {

	@Autowired
	private EspecialidadeService especialidadeService;

	@RequestMapping(value = "/especialidade/", method = RequestMethod.POST)
	public ResponseEntity<String> incluirEspecialidade(@RequestBody Especialidade esp, UriComponentsBuilder ucBuilder) {

		this.especialidadeService.insereEspecialidade(esp);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/especialidade/{id}").buildAndExpand(esp.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/especialidade/{id}", method = RequestMethod.GET)
	public ResponseEntity<Especialidade> consultarEspecialidade(@PathVariable("id") Long id) {

		Especialidade especialidade = especialidadeService.procuraPeloID(id);
		return new ResponseEntity<Especialidade>(especialidade, HttpStatus.OK);
	}

	@RequestMapping(value = "/especialidade/{descricao}", method = RequestMethod.GET)
	public ResponseEntity<Collection<Especialidade>> consultarEspecialidadePelaDescricao(
			@PathVariable("descricao") String descricao) {

		Collection<Especialidade> especialidades = this.especialidadeService.procuraPelaDescricao(descricao);
		return new ResponseEntity<Collection<Especialidade>>(especialidades, HttpStatus.OK);
	}

}
