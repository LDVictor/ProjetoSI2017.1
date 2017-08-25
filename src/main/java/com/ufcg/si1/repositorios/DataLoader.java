package com.ufcg.si1.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ufcg.si1.model.Administrador;
import com.ufcg.si1.model.Especialidade;
import com.ufcg.si1.model.HospitalAdapter;
import com.ufcg.si1.model.PostoSaude;
import com.ufcg.si1.model.Prefeitura;
import com.ufcg.si1.model.Queixa;
import com.ufcg.si1.model.UnidadeSaude;
import com.ufcg.si1.model.enums.QueixaSituacao;
import com.ufcg.si1.model.enums.QueixaTipo;

@Component
public class DataLoader {

	private QueixaRepositorio queixaRepositorio;
	private UnidadeSaudeRepositorio usRepositorio;
	private EspecialidadeRepositorio especialidadeRepositorio;
	private PrefeituraRepositorio prefeituraRepositorio;
	private AdministradorRepositorio adminRespositorio;

	@Autowired
	public DataLoader(QueixaRepositorio queixaRepo, UnidadeSaudeRepositorio usRepo, EspecialidadeRepositorio espRepo,
			PrefeituraRepositorio prefRepo, AdministradorRepositorio adminRepositorio) {
		this.queixaRepositorio = queixaRepo;
		this.usRepositorio = usRepo;
		this.especialidadeRepositorio = espRepo;
		this.prefeituraRepositorio = prefRepo;
		this.adminRespositorio = adminRepositorio;
		this.load();
	}

	private void load() {
		Prefeitura prefeitura = Prefeitura.getInstance();
		UnidadeSaude postoSaude = new PostoSaude("Posto Saude do Ze Pinheiro", "Ze Pinheiro", 10, 100);
		UnidadeSaude postoSaude2 = new PostoSaude("Posto Saude do Catole", "catole", 6, 2);
		UnidadeSaude hospital = new HospitalAdapter("Hospital Joao 23", "Prata", 100, 300);
		Especialidade ginecologista = new Especialidade("Ginecologista");
		Especialidade pediatria = new Especialidade("Pediatria");
		Queixa queixa = new Queixa("Animal Perdido na av. Canal", "Mateus", "mateus@ccc.ufcg", "av. Canal 257",
				"Centro", "Cavalo Manco Preto", "C. Grande", QueixaTipo.ANIMAL);

		Queixa queixa2 = new Queixa("Comida Estragada no Restaurante", "Lucas Amigao", "amigao@ccc.ufcg",
				"av. Getulio Vargas 366", "Centro", "PB", "C. Grande", QueixaTipo.ALIMENTAR);

		Queixa queixa3 = new Queixa("Mal atendimento", "Quel", "quel@ccc.ufcg", "UFCG", "Universitario", "PB",
				"C. Grande", QueixaTipo.SERVICO_GERAL);

		Administrador admin1 = new Administrador("Victor", "1234"); // ab156455rt
		Administrador admin2 = new Administrador("Mateus", "1234"); // ch478955wb
		Administrador admin3 = new Administrador("Raquel", "1234"); // bn549033mn
		Administrador admin4 = new Administrador("Lucas", "1234"); // pb990552in
		Administrador admin5 = new Administrador("Massoni", "1234"); // yu445720ip
		Administrador admin6 = new Administrador("Melina", "1234"); // xc781206bb

		postoSaude.adicionarEspecialidade(pediatria);
		postoSaude.adicionarEspecialidade(ginecologista);

		this.queixaRepositorio.save(queixa);
		this.queixaRepositorio.save(queixa2);
		this.queixaRepositorio.save(queixa3);
		this.usRepositorio.save(postoSaude);
		this.usRepositorio.save(postoSaude2);
		this.usRepositorio.save(hospital);
		this.especialidadeRepositorio.save(ginecologista);
		this.especialidadeRepositorio.save(pediatria);
		this.prefeituraRepositorio.save(prefeitura);
		this.adminRespositorio.save(admin1);
		this.adminRespositorio.save(admin2);
		this.adminRespositorio.save(admin3);
		this.adminRespositorio.save(admin4);
		this.adminRespositorio.save(admin5);
		this.adminRespositorio.save(admin6);
	}
}
