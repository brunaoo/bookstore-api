package com.brunao.bookstore.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brunao.bookstore.entity.Livro;
import com.brunao.bookstore.entity.dto.LivroDTO;
import com.brunao.bookstore.service.LivroService;

@RestController
@RequestMapping("/v1/livros/")
public class LivroController {
	
	@Autowired
	LivroService livroService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id){
		Livro livro = livroService.findOne(id);
		return ResponseEntity.ok().body(livro);
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Livro>> findAll(){
		List<Livro> list = livroService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		livroService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value = "/allbycategoria/")
	public ResponseEntity<List<LivroDTO>> findAllbyCategoria(@RequestParam(value = "categoria", defaultValue = "0") Integer idCategoria){
		List<Livro> listaLivros = livroService.findAllByCategoria(idCategoria);
		List<LivroDTO> listaDTO = listaLivros.stream().map(l -> new LivroDTO(l)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listaDTO);
	}
	
}
