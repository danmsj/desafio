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
public class EspecieVo {

	
	private String name;
	private String classification;
	private String designation;
	private String avarageHeigt;
	private String avarageLifespan;
	private String eyeColors;
	private String hairColors;
	private String skinColors;
	private String language;
	private String homewolrd;
	private List<String> people;
	private List<String> films;
	private String url;
	private String created;
	private String edited;
	private List<String> especiesRelacionadoPersonagem;
}

