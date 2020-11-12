package br.com.itau.controller;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StarWarsControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void deveriaDevolver200BuscaPorPersonagemid1() throws Exception {
		Long idPesquisado = 1L;
		URI uri = new URI("/starwars/personagem/" + idPesquisado);
		String json = "{\r\n" + "    \"name\": \"Luke Skywalker\",\r\n" + "    \"birthYear\": null,\r\n"
				+ "    \"eyeColor\": null,\r\n" + "    \"gender\": \"male\",\r\n" + "    \"hairColor\": null,\r\n"
				+ "    \"height\": \"172\",\r\n" + "    \"mass\": \"77\",\r\n" + "    \"skinColor\": null,\r\n"
				+ "    \"homeworld\": \"http://swapi.dev/api/planets/1/\",\r\n" + "    \"films\": [\r\n"
				+ "        \"http://swapi.dev/api/films/1/\",\r\n" + "        \"http://swapi.dev/api/films/2/\",\r\n"
				+ "        \"http://swapi.dev/api/films/3/\",\r\n" + "        \"http://swapi.dev/api/films/6/\"\r\n"
				+ "    ],\r\n" + "    \"species\": [],\r\n" + "    \"starships\": [\r\n"
				+ "        \"http://swapi.dev/api/starships/12/\",\r\n"
				+ "        \"http://swapi.dev/api/starships/22/\"\r\n" + "    ],\r\n" + "    \"vehicles\": [\r\n"
				+ "        \"http://swapi.dev/api/vehicles/14/\",\r\n"
				+ "        \"http://swapi.dev/api/vehicles/30/\"\r\n" + "    ],\r\n"
				+ "    \"url\": \"http://swapi.dev/api/people/1/\",\r\n"
				+ "    \"created\": \"2014-12-09T13:50:51.644000Z\",\r\n"
				+ "    \"edited\": \"2014-12-20T21:17:56.891000Z\",\r\n" + "    \"personagemRelacionadoPlaneta\": [\r\n"
				+ "        \"http://localhost:8080/starwars/personagem/2\",\r\n"
				+ "        \"http://localhost:8080/starwars/personagem/4\",\r\n"
				+ "        \"http://localhost:8080/starwars/personagem/6\"\r\n" + "    ]\r\n" + "}";

		mockMvc.perform(MockMvcRequestBuilders.get(uri).content(json).contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200));
		
	}
	

		@Test
		public void deveriaDevolver200BuscaPlanetaid10() throws Exception {
			Long idPesquisado = 10L;
			URI uri = new URI("/starwars/planeta/" + idPesquisado);
			String json = "{\r\n" + 
					"    \"name\": \"Kamino\",\r\n" + 
					"    \"diameter\": \"19720\",\r\n" + 
					"    \"rotationPeriod\": null,\r\n" + 
					"    \"orbitalPeriod\": null,\r\n" + 
					"    \"gravity\": \"1 standard\",\r\n" + 
					"    \"population\": \"1000000000\",\r\n" + 
					"    \"climate\": \"temperate\",\r\n" + 
					"    \"terrain\": \"ocean\",\r\n" + 
					"    \"surfaceWater\": null,\r\n" + 
					"    \"residents\": [\r\n" + 
					"        \"http://swapi.dev/api/people/22/\",\r\n" + 
					"        \"http://swapi.dev/api/people/72/\",\r\n" + 
					"        \"http://swapi.dev/api/people/73/\"\r\n" + 
					"    ],\r\n" + 
					"    \"films\": [\r\n" + 
					"        \"http://swapi.dev/api/films/5/\"\r\n" + 
					"    ],\r\n" + 
					"    \"url\": \"http://swapi.dev/api/planets/10/\",\r\n" + 
					"    \"created\": \"2014-12-10T12:45:06.577000Z\",\r\n" + 
					"    \"edited\": \"2014-12-20T20:58:18.434000Z\",\r\n" + 
					"    \"planetaRelacionadoFilme\": [\r\n" + 
					"        \"http://localhost:8080/starwars/planeta/1\",\r\n" + 
					"        \"http://localhost:8080/starwars/planeta/8\",\r\n" + 
					"        \"http://localhost:8080/starwars/planeta/9\"\r\n" + 
					"    ]\r\n" + 
					"}";

			mockMvc.perform(MockMvcRequestBuilders.get(uri).content(json).contentType(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.status().is(200));

	}

}
