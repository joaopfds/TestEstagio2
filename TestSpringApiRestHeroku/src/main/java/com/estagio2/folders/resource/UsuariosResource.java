package com.estagio2.folders.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.estagio2.folders.model.Usuario;
import com.estagio2.folders.repository.Posts;
import com.estagio2.folders.repository.Usuarios;

@RestController
@RequestMapping("/usuario")
public class UsuariosResource {
	
	@Autowired
	private Usuarios usuarios;
	
	@Autowired
	private Posts posts;
	
	@PostMapping
	public Usuario adicionar(@Valid @RequestBody Usuario usuario) {
		return usuarios.save(usuario);
	}
	
	@GetMapping
	public List<Usuario> listar() {
		return usuarios.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
		Usuario usuario = usuarios.getOne(id);
		
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(usuario);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long id, 
			@Valid @RequestBody Usuario usuario) {
		Usuario existente = usuarios.getOne(id);
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(usuario, existente, "id");
		
		existente = usuarios.save(existente);
		
		return ResponseEntity.ok(existente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		Usuario usuario = usuarios.getOne(id);
		
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		
		usuarios.delete(usuario);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}/comentarios")
	public ResponseEntity<?> buscarComentariosPorUsuario(
			@PathVariable(name = "id") Long id) {
		ResponseEntity<?> response = null;

		Optional<Usuario> opt = usuarios.findById(id);
		if (opt.isPresent()) {
			Usuario usuario = opt.get();
			List<Post> posts = usuario.getPosts();
			
			if (posts.isEmpty()) {
				response = new ResponseEntity<>(posts, HttpStatus.NO_CONTENT);
			} else {
				response = new ResponseEntity<>(posts, HttpStatus.OK);
			}
		} else {
			response = new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

		return response;
	}
	
	
	/*@PostMapping("/series/{serieId}/comments")
	public ResponseEntity<?> salvarComentario(
			@PathVariable(name = "serieId")Long serieId, 
			@RequestBody Comment comment) {
		
		Serie serie = new Serie();
		serie.setId(serieId);
		
		comment.setSerie(serie);
		
		comment = commentRepository.save(comment);

		return new ResponseEntity<>(comment, HttpStatus.OK);
	}*/
	
}