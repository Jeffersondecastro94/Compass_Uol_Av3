package br.com.states.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.states.controller.dto.StatesDto;
import br.com.states.controller.form.AtualizacaoStatesForm;
import br.com.states.controller.form.StatesForm;
import br.com.states.modelo.States;
import br.com.states.repository.StatesRepository;

@RestController
@RequestMapping("/api/states")

public class StatesController {
	@Autowired
	private StatesRepository StatesRepository;

	@GetMapping
	public List<States> lista(String nomes) {
		if (nomes == null) {
			List<States> estados = StatesRepository.findAll();
			return estados;
		} else {

			List<States> nomesStates = StatesRepository.findByRegiao(nomes);//
			return nomesStates;
		}

	}
	@GetMapping("/regiao/{regiao}")
	public List<States> listaPorRegiao(@PathVariable String regiao) {
		List<States> cidadesPorRegiao = StatesRepository.findByRegiao(regiao);
		return  cidadesPorRegiao;
	}

	@PostMapping
	public ResponseEntity<StatesDto> cadastrar(@RequestBody @Valid StatesForm form, UriComponentsBuilder uriBuilder) {
		States states = form.converter();
		StatesRepository.save(states);
		URI uri = uriBuilder.path("/{id}").buildAndExpand(states.getId()).toUri();
		return ResponseEntity.created(uri).body(new StatesDto(states));

	}

	@GetMapping("/{id}")
	public List<States> listaPorId(@PathVariable Long id) {
		List<States> statesId = StatesRepository.findByid(id);//
		return statesId;

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<StatesDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoStatesForm form) {
		Optional<States> optional = StatesRepository.findById(id);
		if (optional.isPresent()) {
			States states = form.atualizar(id, StatesRepository);
			return ResponseEntity.ok(new StatesDto(states));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<States> optional = StatesRepository.findById(id);
		if (optional.isPresent()) {
			StatesRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}
