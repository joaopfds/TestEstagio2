package com.algaworks.contato.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
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

import com.algaworks.contato.model.Contato;
import com.algaworks.contato.model.Matematica;
import com.algaworks.contato.repository.Contatos;
import com.algaworks.contato.repository.Matematicas;

@RestController
@RequestMapping("/matematica")
public class MatematicaResource {
	
	@Autowired
	private Matematicas matematicas;
	
	@PostMapping
	public Matematica adicionar(@Valid @RequestBody Matematica matematica) {
		return matematicas.save(matematica);
	}
	
	@GetMapping
	public List<Matematica> listar() {
		return matematicas.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Matematica> buscar(@PathVariable Long id) {
		Matematica matematica = matematicas.getOne(id);
		
		if (matematica == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(matematica);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Matematica> atualizar(@PathVariable Long id, 
			@Valid @RequestBody Contato contato) {
		Matematica existente = matematicas.getOne(id);
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(contato, existente, "id");
		
		existente = matematicas.save(existente);
		
		return ResponseEntity.ok(existente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		Matematica matematica = matematicas.getOne(id);
		
		if (matematica == null) {
			return ResponseEntity.notFound().build();
		}
		
		matematicas.delete(matematica);
		
		return ResponseEntity.noContent().build();
	}
}