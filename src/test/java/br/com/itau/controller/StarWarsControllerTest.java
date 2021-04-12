package br.com.itau.controller;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
				mockMvc.perform(MockMvcRequestBuilders.get(uri))
				.andExpect(MockMvcResultMatchers.status().is(200));

	}

	@Test
	public void deveriaDevolver200BuscaPlanetaid10() throws Exception {
		Long idPesquisado = 10L;
		URI uri = new URI("/starwars/planeta/" + idPesquisado);
		
		mockMvc.perform(MockMvcRequestBuilders.get(uri))
				.andExpect(MockMvcResultMatchers.status().is(200));

	}
	
	@Test
	public void deveriaDevolver400BuscaPlanetaid100() throws Exception {
		Long idPesquisado = 100L;
		URI uri = new URI("/starwars/planeta/" + idPesquisado);
		
		mockMvc.perform(MockMvcRequestBuilders.get(uri))
				.andExpect(MockMvcResultMatchers.status().is(400));
		
	}

}
