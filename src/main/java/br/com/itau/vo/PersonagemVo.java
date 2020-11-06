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
	private String birthYear;
	private String eyeColor;
	private String gender;
	private String hairColor;
	private String height;
	private String mass;
	private String skinColor;
	private String homeworld;
	private List<String> films;
	private List<String> species;
	private List<String> starships;
	private List<String> vehicles;
	private String url;
	private String created;
	private String edited;
	private List<String> personagemRelacionadoPlaneta;
}
