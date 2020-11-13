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
public class NaveVo {

	private String nome;
	private String model;
	private String starship_class;
	private String manufacturer;
	private String cost_in_credits;
	private String length;
	private String crew;
	private String passengers;
	private String max_atmosphering_speed;
	private String hyperdrive_rating;
	private String mglt;
	private String cargo_capacity;
	private String consumables;
	private List<String> films;
	private List<String> pilots;
	private String url;
	private String created;
	private String edited;
	private List<String> navesRelacionadasPilotos;
}
