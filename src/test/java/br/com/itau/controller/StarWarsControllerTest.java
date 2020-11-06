package br.com.itau.controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.itau.vo.FilmeVo;
import br.com.itau.vo.PersonagemVo;
import br.com.itau.vo.PlanetaVo;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles
public class StarWarsControllerTest {

	@Autowired
	private StarWarsController personagemConsultado;
	@Autowired
	private StarWarsController filmeConsultado;
	@Autowired
	private StarWarsController planetaConsultado;

	public static final String URL_SWAPI_PEOPLE = "http://swapi.dev/api/people/";
	public static final String URL_SWAPI_PLANET = "http://swapi.dev/api/planets/";
	public static final String URL_SWAPI_FILM = "http://swapi.dev/api/films/";

	@Test
	public void deveriaBuscarPersonagemId1() throws Exception {

		Long id1 = 1L;

		PersonagemVo personagem = personagemConsultado.findByIdPersonagem(id1);

		Assert.assertNotNull(personagem);
		Assert.assertEquals(URL_SWAPI_PEOPLE + id1 + "/", personagem.getUrl());

	}

	@Test
	public void deveriaBuscarPersonagemId8() throws Exception {

		Long id8 = 8L;

		PersonagemVo personagem = personagemConsultado.findByIdPersonagem(id8);

		Assert.assertNotNull(personagem);
		Assert.assertEquals(URL_SWAPI_PEOPLE + id8 + "/", personagem.getUrl());

	}

	@Test
	public void deveriaBuscarPlanetaId10() throws Exception {

		Long id10 = 10L;

		PlanetaVo planeta = planetaConsultado.findByIdPlaneta(id10);

		Assert.assertNotNull(planeta);
		Assert.assertEquals(URL_SWAPI_PLANET + id10 + "/", planeta.getUrl());

	}

	

	@Test
	public void deveriaBuscarFilmsId3() throws Exception {

		Long id3 = 3L;

		FilmeVo filme = filmeConsultado.findByIdFilme(id3);

		Assert.assertNotNull(filme);
		Assert.assertEquals(URL_SWAPI_FILM + id3 + "/", filme.getUrl());

	}
}
