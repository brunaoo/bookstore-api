package com.brunao.bookstore.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brunao.bookstore.entity.Livro;
import com.brunao.bookstore.entity.dto.LivroDTO;
import com.brunao.bookstore.service.LivroService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Livros")
@CrossOrigin(value = "*")
@RestController
@RequestMapping("/v1/livros")
public class LivroController {
	
	@Autowired
	LivroService livroService;
	
	@ApiOperation(value = "Livro pelo seu id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id){
		Livro livro = livroService.findOne(id);
		return ResponseEntity.ok().body(livro);
	}
	
	@ApiOperation(value = "Todos os livros")
	@GetMapping(value = "/all")
	public ResponseEntity<List<Livro>> findAll(){
		List<Livro> list = livroService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value = "Delete livro pelo seu id")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		livroService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Todos os livro pelo id da categoria")
	@GetMapping(value = "/allbycategoria/")
	public ResponseEntity<List<LivroDTO>> findAllbyCategoria(@RequestParam(value = "categoria", defaultValue = "0") Integer idCategoria){
		List<Livro> listaLivros = livroService.findAllByCategoria(idCategoria);
		List<LivroDTO> listaDTO = listaLivros.stream().map(l -> new LivroDTO(l)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@ApiOperation(value = "Novo livro")
	@PostMapping
	public ResponseEntity<Livro> create(@RequestParam(value = "categoria", defaultValue = "0" ) Integer idcat, @Valid @RequestBody Livro livro){
		Livro novoLivro = livroService.save(livro, idcat);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/v1/livros/{id}").buildAndExpand(novoLivro.getId()).toUri();
		return ResponseEntity.created(uri).body(novoLivro);
	}
	
		
	@ApiOperation(value = "Atualizar dados do livro")
	@PutMapping(value = "{id}")
	public ResponseEntity<Livro> update(@PathVariable Integer id, @Valid @RequestBody Livro livro){
		livro = livroService.update(id, livro);
		return ResponseEntity.ok().body(livro);
	}
	
}
