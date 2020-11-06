package br.com.itau.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.param.ParamEspecie;
import br.com.itau.param.ParamFilme;
import br.com.itau.param.ParamNave;
import br.com.itau.param.ParamPersonagem;
import br.com.itau.param.ParamPlaneta;
import br.com.itau.param.ParamVeiculo;
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

	@ApiOperation(value="Relação de termos mais buscados")
	@GetMapping("/acessos")
	public List<AcessosVo> findAllAcessos() {
		return this.starWarsService.findAllAcessos();

	}
	@ApiOperation(value="Consulta pelo ID do personagem, retornando o personagem e sugestão relacionada por planeta")
	@GetMapping("/personagem/{id}")
	public PersonagemVo findByIdPersonagem(@PathVariable Long id) throws Exception {
		return this.starWarsService.findByIdPersonagem(id);

	}
	@ApiOperation(value="Consulta todos os personagens")
	@GetMapping("/personagem")
	public ResultadoPersonagemVo findAllPersonagem(@ModelAttribute ParamPersonagem params) {
		return this.starWarsService.findAllPersonagem(params);

	}
	@ApiOperation(value="Consulta pelo ID do planeta, retornando o planeta e sugestão relacionada por filme")
	@GetMapping("/planeta/{id}")
	public PlanetaVo findByIdPlaneta(@PathVariable Long id) throws Exception {
		return this.starWarsService.findByIdPlaneta(id);

	}
	@ApiOperation(value="Consulta todos os planetas")
	@GetMapping("/planeta")
	public ResultadoPlanetaVo findAllPlaneta(@ModelAttribute ParamPlaneta params) {
		return this.starWarsService.findAllPlaneta(params);
	}
	@ApiOperation(value="Consulta pelo ID do veículo, retornando o veículo e sugestão relacionada por filme")
	@GetMapping("/veiculo/{id}")
	public VeiculoVo findByIdVeiculo(@PathVariable Long id) throws Exception {
		return this.starWarsService.findByIdVeiculo(id);

	}
	@ApiOperation(value="Consulta todos os veículos")
	@GetMapping("/veiculo")
	public ResultadoVeiculoVo findAllVeiculo(@ModelAttribute ParamVeiculo params) {
		return this.starWarsService.findAllVeiculo(params);

	}
	@ApiOperation(value="Consulta pelo ID da nave, retornando a nave e sugestão relacionada por piloto")
	@GetMapping("/nave/{id}")
	public NaveVo findByIdNave(@PathVariable Long id) throws Exception {
		return this.starWarsService.findByIdNave(id);

	}
	@ApiOperation(value="Consulta todas as naves")
	@GetMapping("/nave")
	public ResultadoNaveVo findAllNave(@ModelAttribute ParamNave params) {
		return this.starWarsService.findAllNave(params);

	}
	@ApiOperation(value="Consulta pelo ID da espécies, retornando a espécie e sugestão relacionada por personagem")
	@GetMapping("/especie/{id}")
	public EspecieVo findByIdEspecie(@PathVariable Long id) throws Exception {
		return this.starWarsService.findByIdEspecie(id);

	}
	@ApiOperation(value="Consulta todas as espécies")
	@GetMapping("/especie")
	public ResultadoEspecieVo findAllEspecie(@ModelAttribute ParamEspecie params) {
		return this.starWarsService.findAllEspecie(params);

	}
	@ApiOperation(value="Consulta pelo ID do filme, retornando o filme e sugestão relacionada por personagem")
	@GetMapping("/filme/{id}")
	public FilmeVo findByIdFilme(@PathVariable Long id) throws Exception {
		return this.starWarsService.findByIdFilme(id);

	}
	@ApiOperation(value="Consulta todos os filmes")
	@GetMapping("/filme")
	public ResultadoFilmeVo findAllFilme(@ModelAttribute ParamFilme params) {
		return this.starWarsService.findAllFilme(params);

	}
}
