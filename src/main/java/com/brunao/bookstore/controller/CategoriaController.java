package com.brunao.bookstore.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brunao.bookstore.entity.Categoria;
import com.brunao.bookstore.entity.dto.CategoriaDTO;
import com.brunao.bookstore.service.CategoriaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Categorias")
@RestController
@RequestMapping(value = "/v1/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;
	
	@ApiOperation(value = "Categoria pelo seu id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id){
		Categoria categoria = service.findOne(id);
		return ResponseEntity.ok().body(categoria);
	}
	
	@ApiOperation(value = "Todas as categorias")
	@GetMapping(value = "/all")
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		List<Categoria> listCat = service.findAll();
		List<CategoriaDTO> listDTO =listCat.stream().map(c -> new CategoriaDTO(c)).collect(Collectors.toList()); 
	
		return ResponseEntity.ok().body(listDTO);
	}
	
	@ApiOperation(value = "Nova Categoria")
	@PostMapping
	public ResponseEntity<Categoria> create(@RequestBody Categoria categoria){
		categoria = service.save(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).body(categoria);
	}
	
	@ApiOperation(value = "Atualiza dados da categoria")
	@PutMapping
	public ResponseEntity<Categoria> update(@RequestBody Categoria categoria){
		categoria = service.update(categoria);
		return ResponseEntity.ok().body(categoria);
	}
	
	@ApiOperation(value = "Deletar categoria pelo id")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}




