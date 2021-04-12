package br.com.itau.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonagemVo {
	
	private String name;
	private String birth_year;
	private String eye_color;
	private String gender;
	private String hair_color;
	private String height;
	private String mass;
	private String skin_color;
	private String homeworld;
	private List<String> films;
	private List<String> species;
	private List<String> starships;
	private List<String> vehicles;
	private String created;
	private String edited;
	private String url;
	private List<String> personagemRelacionadoPlaneta;
	
}
