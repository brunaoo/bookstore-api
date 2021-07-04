package com.brunao.bookstore.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunao.bookstore.domain.Categoria;
import com.brunao.bookstore.domain.dto.CategoriaDTO;
import com.brunao.bookstore.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias/")
public class CategoriaController {

	@Autowired
	private CategoriaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id){
		Categoria categoria = service.findOne(id);
		return ResponseEntity.ok().body(categoria);
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		List<Categoria> listCat = service.findAll();
		List<CategoriaDTO> listDTO =listCat.stream().map(c -> new CategoriaDTO(c)).collect(Collectors.toList()); 
	
		return ResponseEntity.ok().body(listDTO);
	}
}
