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
public class VeiculoVo {

	private String name;
	private String model;
	private String vehicleClass;
	private String manufacturer; 
	private String lenght;
	private String costInCredits;
	private String crew; 
	private String passengers; 
	private String maxAtmospheringSpeed;
	private String cargoCapacity;
	private String consumables; 
	private List<String> films;
	private List<String> pilots; 
	private String url; 
	private String created; 
	private String edited;
	private List<String> veiculoRelacionadoFilme;
}
