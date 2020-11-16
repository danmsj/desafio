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
public class VeiculoVo {

	private String name;
	private String model;
	private String vehicle_class;
	private String manufacturer; 
	private String lenght;
	private String cost_in_credits;
	private String crew; 
	private String passengers; 
	private String max_atmosphering_speed;
	private String cargo_capacity;
	private String consumables; 
	private List<String> films;
	private List<String> pilots; 
	private String url; 
	private String created; 
	private String edited;
	private TreeSet<String> veiculoRelacionadoFilme;
}
