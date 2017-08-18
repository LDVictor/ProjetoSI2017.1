package com.ufcg.si1.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.model.HospitalAdapter;
import com.ufcg.si1.model.PostoSaude;
import com.ufcg.si1.model.Prefeitura;
import com.ufcg.si1.model.Queixa;
import com.ufcg.si1.model.UnidadeSaude;
import com.ufcg.si1.model.enums.TipoQueixa;

@Component
public class DataLoader {

	private QueixaRepositorio queixaRepositorio;
	private UnidadeSaudeRepositorio usRepositorio;
	private EspecialidadeRepositorio especialidadeRepositorio;
	private PrefeituraRepositorio prefeituraRepositorio;

	@Autowired
	public DataLoader(QueixaRepositorio queixaRepo, UnidadeSaudeRepositorio usRepo, EspecialidadeRepositorio espRepo,
			PrefeituraRepositorio prefRepo) {
		this.queixaRepositorio = queixaRepo;
		this.usRepositorio = usRepo;
		this.especialidadeRepositorio = espRepo;
		this.prefeituraRepositorio = prefRepo;
		this.load();
	}

	private void load() {
		UnidadeSaude postoSaude = new PostoSaude("Posto Saude do Ze Pinheiro", "Ze Pinheiro", 10, 100);
		UnidadeSaude postoSaude2 = new PostoSaude("Posto Saude do Catole", "catole", 6, 2);
		UnidadeSaude hospital = new HospitalAdapter("Hospital Joao 23", "Prata", 100, 300);
		Especialidade ginecologista = new Especialidade("Ginecologista");
		Especialidade pediatria = new Especialidade("Pediatria");
		postoSaude.adicionarEspecialidade(pediatria);
		postoSaude.adicionarEspecialidade(ginecologista);
		Queixa queixa1 = new Queixa("Comida Estragada", "Mateus Mangueira", "mateus@hotmail.com", "Agamenon Magalhaes",
				"PB", "CG", TipoQueixa.ALIMENTAR);
		Queixa queixa2 = new Queixa("Cachorro Perdido", "Lucas Amigao", "amigao@hotmail.com", "Maltes Branco", "Campina Grande",
				"PB", TipoQueixa.ANIMAL);
		
		Queixa queixa3 = new Queixa("Internet muito lenta", "Raquel", "raquel_rohit@hotmail.com",  "av. Canal", "Vivo Empresa", "CG", TipoQueixa.SERVICO_GERAL);
		this.prefeituraRepositorio.save(new Prefeitura());
		this.usRepositorio.save(postoSaude);
		this.usRepositorio.save(postoSaude2);
		this.usRepositorio.save(hospital);
		this.especialidadeRepositorio.save(ginecologista);
		this.especialidadeRepositorio.save(pediatria);
		this.queixaRepositorio.save(queixa1);
		this.queixaRepositorio.save(queixa2);
		this.queixaRepositorio.save(queixa3);
	}
}
