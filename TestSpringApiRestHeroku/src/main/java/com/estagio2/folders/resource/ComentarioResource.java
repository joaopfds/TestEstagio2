package com.estagio2.folders.resource;

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

import com.estagio2.folders.model.Comentario;
import com.estagio2.folders.repository.Comentarios;

@RestController
@RequestMapping("/comentarios")
public class ComentarioResource {
	
	@Autowired
	private Comentarios comentarios;
	
	@PostMapping
	public Comentario adicionar(@Valid @RequestBody Comentario comentario) {
		return comentarios.save(comentario);
	}
	
	@GetMapping
	public List<Comentario> listar() {
		return comentarios.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Comentario> buscar(@PathVariable Long id) {
		Comentario comentario = comentarios.getOne(id);
		
		if (comentario == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(comentario);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Comentario> atualizar(@PathVariable Long id, 
			@Valid @RequestBody Comentario comentario) {
		Comentario existente = comentarios.getOne(id);
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(comentario, existente, "id");
		
		existente = comentarios.save(existente);
		
		return ResponseEntity.ok(existente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		Comentario comentario = comentarios.getOne(id);
		
		if (comentario == null) {
			return ResponseEntity.notFound().build();
		}
		
		comentarios.delete(comentario);
		
		return ResponseEntity.noContent().build();
	}
}