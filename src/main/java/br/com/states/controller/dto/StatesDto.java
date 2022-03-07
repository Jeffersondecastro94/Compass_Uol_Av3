package br.com.states.controller.dto;

import br.com.states.modelo.States;

public class StatesDto {
	private Long id;
	private String nome;
	private String regiao;
	private int populacao;
	private String capital;
	private double area;

	public StatesDto() {
	};

	public StatesDto(States states) {
		// TODO Auto-generated constructor stub
		this.id = states.getId();
		this.nome = states.getNome();
		this.regiao = states.getRegiao();
		this.populacao = states.getPopulacao();
		this.capital = states.getCapital();
		this.area = states.getArea();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getRegiao() {
		return regiao;
	}

	public int getPopulacao() {
		return populacao;
	}

	public String getCapital() {
		return capital;
	}

	public double getArea() {
		return area;
	}
	/*
	 * public static List<TopicoDto> converter(List<Topico> topicos) { return
	 * topicos.stream().map(TopicoDto::new).collect(Collectors.toList()); }
	 */
}
