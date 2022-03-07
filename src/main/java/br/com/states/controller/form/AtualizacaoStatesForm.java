package br.com.states.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.states.modelo.States;
import br.com.states.repository.StatesRepository;

public class AtualizacaoStatesForm {
	
	@NotNull @NotEmpty @Length(min = 5)
	private String nome;
	
	@NotNull @NotEmpty @Length(min = 10)
	private String regiao;

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

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	private String capital;

	public States atualizar(Long id, StatesRepository statesRepository) {
		States states = statesRepository.getOne(id);
		
		states.setNome(this.nome);
		states.setRegiao(this.regiao);
		states.setCapital(this.capital);
		return states;
	}
	
}
