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
import com.estagio2.folders.model.Post;
import com.estagio2.folders.repository.Posts;

@RestController
@RequestMapping("/posts")
public class PostsResource {
	
	@Autowired
	private Posts posts;
	
	@PostMapping
	public Post adicionar(@Valid @RequestBody Post post) {
		return posts.save(post);
	}
	
	@GetMapping
	public List<Post> listar() {
		return posts.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> buscar(@PathVariable Long id) {
		Post post = posts.getOne(id);
		
		if (post == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(post);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Post> atualizar(@PathVariable Long id, 
			@Valid @RequestBody Post post) {
		Post existente = posts.getOne(id);
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(post, existente, "id");
		
		existente = posts.save(existente);
		
		return ResponseEntity.ok(existente);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		Post post = posts.getOne(id);
		
		if (post == null) {
			return ResponseEntity.notFound().build();
		}
		
		posts.delete(post);
		
		return ResponseEntity.noContent().build();
	}

}
