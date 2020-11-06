package br.com.itau.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

@FeignClient(name = "feignStarWars", url = "https://swapi.dev/api")
public interface FeignStarWars {

	@RequestMapping(value = "/people/{id}/",method= RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	PersonagemVo findByIdPersonagemRelacionados(@PathVariable("id") Long id);
	
	@RequestMapping(value = "/people/{id}/",method= RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	PersonagemVo findByIdPersonagem(@PathVariable("id") Long id);
	
	@RequestMapping(value= "/people/", method= RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	ResultadoPersonagemVo findAllPersonagem(@RequestParam(value="name",required = false)  String name);
	

	
	
	@RequestMapping(value = "/planets/{id}/",method= RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	PlanetaVo findByIdPlanetaRelacionados(@PathVariable("id") Long id);
	
	@RequestMapping(value = "/planets/{id}/",method= RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	PlanetaVo findByIdPlaneta(@PathVariable("id") Long id);
	
	@RequestMapping(value = "/planets/",method= RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	ResultadoPlanetaVo findAllPlaneta(@RequestParam(value="name",required = false)  String name);
	

	
	
	@RequestMapping(value = "/films/{id}/",method= RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	FilmeVo findByIdFilmeRelacionados(@PathVariable("id") Long id);
	
	@RequestMapping(value = "/films/{id}/",method= RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	FilmeVo findByIdFilme(@PathVariable("id") Long id);
	
	@RequestMapping(value= "/films/", method= RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	ResultadoFilmeVo findAllFilme(@RequestParam(value="name",required = false)  String name);
	

	
	
	@RequestMapping(value = "/species/{id}/",method= RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	EspecieVo findByIdEspecie(@PathVariable("id") Long id);
	
	@RequestMapping(value = "/species/",method= RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	ResultadoEspecieVo findAllEspecie(@RequestParam(value="name",required = false)  String name);
	
	
	
	
	
	@RequestMapping(value = "/starships/{id}/",method= RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	NaveVo findByIdNave(@PathVariable("id") Long id);
	
	@RequestMapping(value= "/starships/", method= RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	ResultadoNaveVo findAllNave(@RequestParam(value="name",required = false)  String name);
	

	

	@RequestMapping(value = "/vehicles/{id}/",method= RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	VeiculoVo findByIdVeiculo(@PathVariable("id") Long id);
	
	@RequestMapping(value = "/vehicles/",method= RequestMethod.GET,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	ResultadoVeiculoVo findAllVeiculo(@RequestParam(value="name",required = false)  String name);
	

}
