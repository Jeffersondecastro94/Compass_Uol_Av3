package br.com.states.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.states.modelo.States;


public interface StatesRepository extends JpaRepository<States, Long> {


	List<States> findByNome(String nomeStates);

	List<States> findByRegiao(String nomeStates);

	List<States> findByid(Long id);



	
}
