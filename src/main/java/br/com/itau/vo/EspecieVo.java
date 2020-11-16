package br.com.itau.vo;

import java.util.List;
import java.util.TreeSet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EspecieVo {

	
	private String name;
	private String classification;
	private String designation;
	private String avarage_heigt;
	private String avarage_lifespan;
	private String eye_colors;
	private String hair_colors;
	private String skin_colors;
	private String language;
	private String homewolrd;
	private List<String> people;
	private List<String> films;
	private String url;
	private String created;
	private String edited;
	private TreeSet<String> especiesRelacionadoFilme;
}

