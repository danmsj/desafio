package br.com.itau.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.service.StarWarsService;
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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/starwars", produces = { MediaType.APPLICATION_JSON_VALUE })
@Api(value = "Desafio-Itaú", tags = { "Desafio-Itaú" })
public class StarWarsController {

	@Autowired
	private StarWarsService starWarsService;

	@ApiOperation(value="Relação de urls mais buscados")
	@GetMapping("/acessos")
	public List<AcessosVo> findAllAcessos() {
		return this.starWarsService.findAllAcessos();

	}
	
	
	@ApiOperation(value="Consulta pelo ID do personagem, retornando o personagem e sugestão relacionada por planeta")
	@GetMapping("/personagem/{id}")
	public PersonagemVo findByIdPersonagem(@PathVariable Long id) throws Exception {
		return this.starWarsService.findByIdPersonagem(id);

	}
	@ApiOperation(value="Consulta personagens por página")
	@GetMapping("/personagem/pagina={pagina}")
	public ResultadoPersonagemVo findAllPersonagemPagina(@PathVariable Long pagina) {
		return this.starWarsService.findAllPersonagemPagina(pagina);

	}
	
	@ApiOperation(value="Consulta default personagens página 1")
	@GetMapping("/personagem")
	public ResultadoPersonagemVo findAllPersonagem() {
		return this.starWarsService.findAllPersonagem();

	}

	
	
	@ApiOperation(value="Consulta pelo ID do planeta, retornando o planeta e sugestão relacionada por filme")
	@GetMapping("/planeta/{id}")
	public PlanetaVo findByIdPlaneta(@PathVariable Long id) throws Exception {
		return this.starWarsService.findByIdPlaneta(id);

	}
	
	@ApiOperation(value="Consulta planeta por página")
	@GetMapping("/planeta/pagina={pagina}")
	public ResultadoPlanetaVo findAllPlanetaPagina(@PathVariable Long pagina) {
		return this.starWarsService.findAllPlanetaPagina(pagina);

	}
	
	@ApiOperation(value="Consulta default planetas página 1")
	@GetMapping("/planeta")
	public ResultadoPlanetaVo findAllPlaneta() {
		return this.starWarsService.findAllPlaneta();
	}
	
	@ApiOperation(value="Consulta pelo ID do veículo, retornando o veículo e sugestão relacionada por filme")
	@GetMapping("/veiculo/{id}")
	public VeiculoVo findByIdVeiculo(@PathVariable Long id) throws Exception {
		return this.starWarsService.findByIdVeiculo(id);

	}
	
	@ApiOperation(value="Consulta veiculo por página")
	@GetMapping("/veiculo/pagina={pagina}")
	public ResultadoVeiculoVo findAllVeiculoPagina(@PathVariable Long pagina) {
		return this.starWarsService.findAllVeiculoPagina(pagina);

	}
	
	@ApiOperation(value="Consulta default veículos página 1")
	@GetMapping("/veiculo")
	public ResultadoVeiculoVo findAllVeiculo() {
		return this.starWarsService.findAllVeiculo();

	}
	@ApiOperation(value="Consulta pelo ID da nave, retornando a nave e sugestão relacionada por piloto")
	@GetMapping("/nave/{id}")
	public NaveVo findByIdNave(@PathVariable Long id) throws Exception {
		return this.starWarsService.findByIdNave(id);

	}
	
	@ApiOperation(value="Consulta nave por página")
	@GetMapping("/nave/pagina={pagina}")
	public ResultadoNaveVo findAllNavePagina(@PathVariable Long pagina) {
		return this.starWarsService.findAllNavePagina(pagina);

	}
	@ApiOperation(value="Consulta default naves página 1")
	@GetMapping("/nave")
	public ResultadoNaveVo findAllNave() {
		return this.starWarsService.findAllNave();

	}
	@ApiOperation(value="Consulta pelo ID da espécies, retornando a espécie e sugestão relacionada por filme")
	@GetMapping("/especie/{id}")
	public EspecieVo findByIdEspecie(@PathVariable Long id) throws Exception {
		return this.starWarsService.findByIdEspecie(id);

	}
	
	@ApiOperation(value="Consulta espécie por página")
	@GetMapping("/especie/pagina={pagina}")
	public ResultadoEspecieVo findAllEspeciePagina(@PathVariable Long pagina) {
		return this.starWarsService.findAllEspeciePagina(pagina);

	}
	@ApiOperation(value="Consulta default especies página 1")
	@GetMapping("/especie")
	public ResultadoEspecieVo findAllEspecie() {
		return this.starWarsService.findAllEspecie();

	}
	@ApiOperation(value="Consulta pelo ID do filme, retornando o filme e sugestão relacionada por personagem")
	@GetMapping("/filme/{id}")
	public FilmeVo findByIdFilme(@PathVariable Long id) throws Exception {
		return this.starWarsService.findByIdFilme(id);

	}
	
	@ApiOperation(value="Consulta filmes por página")
	@GetMapping("/filme/pagina={pagina}")
	public ResultadoFilmeVo findAllFilmePagina(@PathVariable Long pagina) {
		return this.starWarsService.findAllFilmePagina(pagina);

	}
	@ApiOperation(value="Consulta default filmes página 1")
	@GetMapping("/filme")
	public ResultadoFilmeVo findAllFilme() {
		return this.starWarsService.findAllFilme();

	}
}
