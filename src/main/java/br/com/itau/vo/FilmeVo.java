package br.com.itau.vo;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilmeVo {

	private String title;
	private int episodeId;
	private String openingCrawl;
	private String director;
	private String producer;
	private Date realeaseDate;
	private List<String> species;
	private List<String> starships;
	private List<String> vehicles;
	private List<String> characters;
	private List<String> planets;
	private String url;
	private String created;
	private String edited;
	private List<String> filmeRelacionadoPersonagem;

}
