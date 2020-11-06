package br.com.itau.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.itau.feign.FeignStarWars;
import br.com.itau.model.Contador;
import br.com.itau.param.ParamEspecie;
import br.com.itau.param.ParamFilme;
import br.com.itau.param.ParamNave;
import br.com.itau.param.ParamPersonagem;
import br.com.itau.param.ParamPlaneta;
import br.com.itau.param.ParamVeiculo;
import br.com.itau.repository.ContadorRepository;
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

	public PersonagemVo findByIdPersonagem(Long id) throws Exception {

		try {
			PersonagemVo planetaPersonagem = new PersonagemVo();
			planetaPersonagem = this.feignStarWars.findByIdPersonagem(id);
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
		} catch (Exception e) {
			throw new Exception("O ID" + id + " PESQUISADO NÃO EXISTE NA API BASE ");
		}
	}

	public ResultadoPersonagemVo findAllPersonagem(ParamPersonagem params) {

		return this.feignStarWars.findAllPersonagem(params.getName());
	}

	public PlanetaVo findByIdPlaneta(Long id) throws Exception {

		try {
			PlanetaVo planetaFilme = new PlanetaVo();
			planetaFilme = this.feignStarWars.findByIdPlaneta(id);

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
		} catch (Exception e) {
			throw new Exception("O ID" + id + " PESQUISADO NÃO EXISTE NA API BASE ");
		}
	}

	public ResultadoPlanetaVo findAllPlaneta(ParamPlaneta params) {

		return this.feignStarWars.findAllPlaneta(params.getName());
	}

	public VeiculoVo findByIdVeiculo(Long id) throws Exception {
		try {
			VeiculoVo veiculoFilme = new VeiculoVo();
			veiculoFilme = this.feignStarWars.findByIdVeiculo(id);

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
		} catch (Exception e) {
			throw new Exception("O ID" + id + " PESQUISADO NÃO EXISTE NA API BASE ");
		}
	}

	public ResultadoVeiculoVo findAllVeiculo(ParamVeiculo params) {

		return this.feignStarWars.findAllVeiculo(params.getName());
	}

	public NaveVo findByIdNave(Long id) throws Exception {

		try {
			NaveVo navePiloto = new NaveVo();
			navePiloto = this.feignStarWars.findByIdNave(id);

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
		} catch (Exception e) {
			throw new Exception("O ID" + id + " PESQUISADO NÃO EXISTE NA API BASE ");
		}
	}

	public ResultadoNaveVo findAllNave(ParamNave params) {

		return this.feignStarWars.findAllNave(params.getName());
	}

	public EspecieVo findByIdEspecie(Long id) throws Exception {
		try {
			EspecieVo especiePersonagem = new EspecieVo();
			especiePersonagem = this.feignStarWars.findByIdEspecie(id);

			List<Long> guardaIdPersonagem = new ArrayList<Long>();
			for (String separaListaPersonagem : especiePersonagem.getFilms()) {
				String personagem = separaListaPersonagem;
				String[] separaUrlPersonagem = personagem.split("/");
				Long IdPersonagemEspecie = Long.parseLong(separaUrlPersonagem[separaUrlPersonagem.length - 1]);
				guardaIdPersonagem.add(IdPersonagemEspecie);

			}

			for (Long personagemId : guardaIdPersonagem) {
				PersonagemVo personagem = findByIdPersonagemRelacionados(personagemId);

				String urlEspecie = URL_ESPECIE;

				List<String> url = new ArrayList<String>();
				int contador = 0;
				for (String especieRelacionado : personagem.getSpecies()) {

					if (contador < 3) {
						String[] especie = especieRelacionado.split("/");
						Long idEspecie = Long.parseLong(especie[especie.length - 1]);

						if (id.compareTo(idEspecie) != 0) {
							url.add(urlEspecie + idEspecie);
							contador++;
						}
					}
					especiePersonagem.setEspeciesRelacionadoPersonagem(url);
				}

			}

			setContadorAcesso(URL_ESPECIE + id);
			return especiePersonagem;
		} catch (Exception e) {
			throw new Exception("O ID" + id + " PESQUISADO NÃO EXISTE NA API BASE ");
		}
	}

	public ResultadoEspecieVo findAllEspecie(ParamEspecie params) {

		return this.feignStarWars.findAllEspecie(params.getName());
	}

	public FilmeVo findByIdFilme(Long id) throws Exception {
		try {
			FilmeVo filmePersonagem = new FilmeVo();
			filmePersonagem = this.feignStarWars.findByIdFilme(id);

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
		} catch (Exception e) {
			throw new Exception("O ID" + id + " PESQUISADO NÃO EXISTE NA API BASE ");
		}
	}

	
	
	public ResultadoFilmeVo findAllFilme(ParamFilme params) {

		return this.feignStarWars.findAllFilme(params.getName());
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
