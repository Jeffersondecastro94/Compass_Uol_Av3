package br.com.states.controller.form;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.states.modelo.States;

public class StatesForm {
	@NotNull @NotEmpty
	private String nome;
	

	@NotNull @NotEmpty
	private String regiao;
	@NotNull 
	private int populacao;
	@NotNull @NotEmpty
	private String capital;
	@NotNull 
	private double area;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public int getPopulacao() {
		return populacao;
	}

	public void setPopulacao(int populacao) {
		this.populacao = populacao;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public States converter() {
		// TODO Auto-generated method stub
		return new States(nome, regiao, populacao, capital, area);
	}
}
