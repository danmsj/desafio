package br.com.itau.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.itau.feign.FeignStarWars;
import br.com.itau.model.Contador;
import br.com.itau.repository.ContadorRepository;
import br.com.itau.validator.ValidatorExpection;
import br.com.itau.vo.AcessosVo;
import br.com.itau.vo.EspecieVo;
import br.com.itau.vo.FilmeVo;
import br.com.itau.vo.NaveVo;
import br.com.itau.vo.PersonagemVo;
import br.com.itau.vo.PlanetaVo;
import br.com.itau.vo.ResultadoEspecieVo;
import br.com.itau.vo.ResultadoFilmeVo;
import br.com.itau.vo.ResultadoNaveVo;
import br.com.itau.vo.ResultadoPersonagemVo;
import br.com.itau.vo.ResultadoPlanetaVo;
import br.com.itau.vo.ResultadoVeiculoVo;
import br.com.itau.vo.VeiculoVo;

@Service
public class StarWarsService {
	public static final String URL_PERSONAGEM = "http://localhost:8080/starwars/personagem/";
	public static final String URL_PLANETA = "http://localhost:8080/starwars/planeta/";
	public static final String URL_FILME = "http://localhost:8080/starwars/filme/";
	public static final String URL_NAVE = "http://localhost:8080/starwars/nave/";
	public static final String URL_VEICULO = "http://localhost:8080/starwars/veiculo/";
	public static final String URL_ESPECIE = "http://localhost:8080/starwars/especie/";

	@Autowired
	private FeignStarWars feignStarWars;
	@Autowired
	private ContadorRepository contadorRepository;

	public PersonagemVo findByIdPersonagem(Long id) {

		PersonagemVo planetaPersonagem = new PersonagemVo();
		try {
			planetaPersonagem = this.feignStarWars.findByIdPersonagem(id);
		} catch (Exception e) {
			throw ValidatorExpection.newException("O ID " + id + " PESQUISADO NÃO EXISTE NA API BASE ");
		}

		String[] planeta = planetaPersonagem.getHomeworld().split("/");
		Long idPlaneta = Long.parseLong(planeta[planeta.length - 1]);
		PlanetaVo planetaVo = findByIdPlanetaRelacionados(idPlaneta);

		String urlPersonagem = URL_PERSONAGEM;

		List<String> url = new ArrayList<String>();
		int contador = 0;
		for (String personagemRelacionados : planetaVo.getResidents()) {
			if (contador < 3) {
				String[] personagem = personagemRelacionados.split("/");
				Long idPersonagem = Long.parseLong(personagem[personagem.length - 1]);

				if (id.compareTo(idPersonagem) != 0) {
					url.add(urlPersonagem + idPersonagem);
					contador++;
				}
			}

		}
		setContadorAcesso(URL_PERSONAGEM + id);

		planetaPersonagem.setPersonagemRelacionadoPlaneta(url);

		return planetaPersonagem;

	}

	public ResultadoPersonagemVo findAllPersonagem() {

		return this.feignStarWars.findAllPersonagem();
	}

	public ResultadoPersonagemVo findAllPersonagemPagina(Long idPagina) {
		if (idPagina <= 1) {
			return this.feignStarWars.findAllPersonagem();
		} else {
			return this.feignStarWars.findAllPersonagemPagina(idPagina);
		}
	}

	public PlanetaVo findByIdPlaneta(Long id) {
		PlanetaVo planetaFilme = new PlanetaVo();
		try {
			planetaFilme = this.feignStarWars.findByIdPlaneta(id);
		} catch (Exception e) {
			throw ValidatorExpection.newException("O ID " + id + " PESQUISADO NÃO EXISTE NA API BASE ");
		}
		List<Long> guardaIdFilmes = new ArrayList<Long>();
		for (String separaListaFilmes : planetaFilme.getFilms()) {
			String filmes = separaListaFilmes;
			String[] separaUrlFilmes = filmes.split("/");
			Long idFilmesPlaneta = Long.parseLong(separaUrlFilmes[separaUrlFilmes.length - 1]);
			guardaIdFilmes.add(idFilmesPlaneta);

		}

		for (Long filmeId : guardaIdFilmes) {
			FilmeVo filme = findByIdFilmeRelacionados(filmeId);

			String urlPlaneta = URL_PLANETA;

			List<String> url = new ArrayList<String>();
			int contador = 0;
			for (String planetaRelacionados : filme.getPlanets()) {

				if (contador < 3) {
					String[] planeta = planetaRelacionados.split("/");
					Long idPlaneta = Long.parseLong(planeta[planeta.length - 1]);

					if (id.compareTo(idPlaneta) != 0) {
						url.add(urlPlaneta + idPlaneta);
						contador++;
					}
				}
				planetaFilme.setPlanetaRelacionadoFilme(url);
			}

		}

		setContadorAcesso(URL_PLANETA + id);
		return planetaFilme;

	}

	public ResultadoPlanetaVo findAllPlaneta() {

		return this.feignStarWars.findAllPlaneta();
	}

	public ResultadoPlanetaVo findAllPlanetaPagina(Long idPagina) {
		if (idPagina <= 1) {
			return this.feignStarWars.findAllPlaneta();
		} else {
			return this.feignStarWars.findAllPlanetaPagina(idPagina);
		}
	}
	
	public VeiculoVo findByIdVeiculo(Long id) {

		VeiculoVo veiculoFilme = new VeiculoVo();
		try {
			veiculoFilme = this.feignStarWars.findByIdVeiculo(id);
		} catch (Exception e) {
			throw ValidatorExpection.newException("O ID " + id + " PESQUISADO NÃO EXISTE NA API BASE ");
		}
		List<Long> guardaIdFilmes = new ArrayList<Long>();
		for (String separaListaFilmes : veiculoFilme.getFilms()) {
			String filmes = separaListaFilmes;
			String[] separaUrlFilmes = filmes.split("/");
			Long idFilmesVeiculo = Long.parseLong(separaUrlFilmes[separaUrlFilmes.length - 1]);
			guardaIdFilmes.add(idFilmesVeiculo);

		}

		for (Long filmeId : guardaIdFilmes) {
			FilmeVo filme = findByIdFilmeRelacionados(filmeId);

			String urlVeiculo = URL_VEICULO;

			List<String> url = new ArrayList<String>();
			int contador = 0;
			for (String veiculoRelacionados : filme.getVehicles()) {

				if (contador < 3) {
					String[] veiculo = veiculoRelacionados.split("/");
					Long idVeiculo = Long.parseLong(veiculo[veiculo.length - 1]);

					if (id.compareTo(idVeiculo) != 0) {
						url.add(urlVeiculo + idVeiculo);
						contador++;
					}
				}
				veiculoFilme.setVeiculoRelacionadoFilme(url);
			}

		}

		setContadorAcesso(URL_VEICULO + id);
		return veiculoFilme;

	}

	public ResultadoVeiculoVo findAllVeiculo() {

		return this.feignStarWars.findAllVeiculo();
	}

	public ResultadoVeiculoVo findAllVeiculoPagina(Long idPagina) {
		if (idPagina <= 1) {
			return this.feignStarWars.findAllVeiculo();
		} else {
			return this.feignStarWars.findAllVeiculoPagina(idPagina);
		}
	}
	public NaveVo findByIdNave(Long id) {

		NaveVo navePiloto = new NaveVo();
		try {
			navePiloto = this.feignStarWars.findByIdNave(id);
		} catch (Exception e) {
			throw ValidatorExpection.newException("O ID " + id + " PESQUISADO NÃO EXISTE NA API BASE ");
		}
		List<Long> guardaIdPiloto = new ArrayList<Long>();
		for (String separaListaPilotos : navePiloto.getPilots()) {
			String piloto = separaListaPilotos;
			String[] separaUrlPiloto = piloto.split("/");
			Long IdPilotoNave = Long.parseLong(separaUrlPiloto[separaUrlPiloto.length - 1]);
			guardaIdPiloto.add(IdPilotoNave);

		}

		for (Long pilotoId : guardaIdPiloto) {
			PersonagemVo piloto = findByIdPersonagemRelacionados(pilotoId);

			String urlNave = URL_NAVE;

			List<String> url = new ArrayList<String>();
			int contador = 0;
			for (String naveRelacionados : piloto.getStarships()) {

				if (contador < 3) {
					String[] nave = naveRelacionados.split("/");
					Long idNave = Long.parseLong(nave[nave.length - 1]);

					if (id.compareTo(idNave) != 0) {
						url.add(urlNave + idNave);
						contador++;
					}
				}
				navePiloto.setNavesRelacionadasPilotos(url);
			}

		}

		setContadorAcesso(URL_NAVE + id);
		return navePiloto;

	}

	public ResultadoNaveVo findAllNave() {

		return this.feignStarWars.findAllNave();
	}

	public ResultadoNaveVo findAllNavePagina(Long idPagina) {
		if (idPagina <= 1) {
			return this.feignStarWars.findAllNave();
		} else {
			return this.feignStarWars.findAllNavePagina(idPagina);
		}
	}
	
	public EspecieVo findByIdEspecie(Long id) {

		EspecieVo especieFilme = new EspecieVo();
		try {
			especieFilme = this.feignStarWars.findByIdEspecie(id);
		} catch (Exception e) {
			throw ValidatorExpection.newException("O ID " + id + " PESQUISADO NÃO EXISTE NA API BASE ");
		}
		List<Long> guardaIdFilme = new ArrayList<Long>();
		for (String separaListaFilme : especieFilme.getFilms()) {
			String filme = separaListaFilme;
			String[] separaUrlFilme = filme.split("/");
			Long IdFilmeEspecie = Long.parseLong(separaUrlFilme[separaUrlFilme.length - 1]);
			guardaIdFilme.add(IdFilmeEspecie);

		}

		for (Long filmeId : guardaIdFilme) {
			FilmeVo filme = findByIdFilmeRelacionados(filmeId);

			String urlEspecie = URL_ESPECIE;

			List<String> url = new ArrayList<String>();
			int contador = 0;
			for (String especieRelacionado : filme.getSpecies()) {

				if (contador < 3) {
					String[] especie = especieRelacionado.split("/");
					Long idEspecie = Long.parseLong(especie[especie.length - 1]);

					if (id.compareTo(idEspecie) != 0) {
						url.add(urlEspecie + idEspecie);
						contador++;
					}
				}
				especieFilme.setEspeciesRelacionadoFilme(url);
			}

		}

		setContadorAcesso(URL_ESPECIE + id);
		return especieFilme;

	}

	public ResultadoEspecieVo findAllEspecie() {

		return this.feignStarWars.findAllEspecie();
	}
	
	public ResultadoEspecieVo findAllEspeciePagina(Long idPagina) {
		if (idPagina <= 1) {
			return this.feignStarWars.findAllEspecie();
		} else {
			return this.feignStarWars.findAllEspeciesPagina(idPagina);
		}
	}

	public FilmeVo findByIdFilme(Long id) {

		FilmeVo filmePersonagem = new FilmeVo();
		try {
			filmePersonagem = this.feignStarWars.findByIdFilme(id);
		} catch (Exception e) {
			throw ValidatorExpection.newException("O ID " + id + " PESQUISADO NÃO EXISTE NA API BASE ");
		}
		List<Long> guardaIdPersonagem = new ArrayList<Long>();
		for (String separaListaPersonagem : filmePersonagem.getCharacters()) {
			String personagem = separaListaPersonagem;
			String[] separaUrlPersonagem = personagem.split("/");
			Long IdPersonagemFilme = Long.parseLong(separaUrlPersonagem[separaUrlPersonagem.length - 1]);
			guardaIdPersonagem.add(IdPersonagemFilme);

		}

		for (Long personagemId : guardaIdPersonagem) {
			PersonagemVo personagem = findByIdPersonagemRelacionados(personagemId);

			String urlFilme = URL_FILME;

			List<String> url = new ArrayList<String>();
			int contador = 0;
			for (String filmeRelacionado : personagem.getFilms()) {

				if (contador < 3) {
					String[] filme = filmeRelacionado.split("/");
					Long idFilme = Long.parseLong(filme[filme.length - 1]);

					if (id.compareTo(idFilme) != 0) {
						url.add(urlFilme + idFilme);
						contador++;
					}
				}
				filmePersonagem.setFilmeRelacionadoPersonagem(url);
			}

		}

		setContadorAcesso(URL_FILME + id);
		return filmePersonagem;

	}

	public ResultadoFilmeVo findAllFilme() {

		return this.feignStarWars.findAllFilme();
	}
	
	public ResultadoFilmeVo findAllFilmePagina(Long idPagina) {
		if (idPagina <= 1) {
			return this.feignStarWars.findAllFilme();
		} else {
			return this.feignStarWars.findAllFilmePagina(idPagina);
		}
	}
	
	

	private PersonagemVo findByIdPersonagemRelacionados(Long idPersonagem) {
		return this.feignStarWars.findByIdPersonagemRelacionados(idPersonagem);
	}

	private FilmeVo findByIdFilmeRelacionados(Long idFilme) {
		return this.feignStarWars.findByIdFilmeRelacionados(idFilme);
	}

	private PlanetaVo findByIdPlanetaRelacionados(Long idPlaneta) {
		return this.feignStarWars.findByIdPlanetaRelacionados(idPlaneta);
	}

	
	
	public void setContadorAcesso(String path) {
		Contador contador = null;
		contador = this.contadorRepository.findFirstByUrlOrderByIdDesc(path).orElse(null);
		if (contador != null) {
			contador.setContador(contador.getContador() + 1);
		} else {
			contador = Contador.builder().url(path).contador(1L).build();
		}
		this.contadorRepository.saveAndFlush(contador);
	}

	public List<AcessosVo> findAllAcessos() {
		List<AcessosVo> acessosOrdenados = new ArrayList<AcessosVo>();
		List<Contador> contador = this.contadorRepository.findAll(Sort.by(Direction.DESC, "contador"));
		for (Contador c : contador) {
			AcessosVo acesso = new AcessosVo();
			acesso.setUrl(c.getUrl());
			acesso.setContador(c.getContador());
			acessosOrdenados.add(acesso);
		}
		return acessosOrdenados;
	}

}
