package com.brunao.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunao.bookstore.domain.Categoria;
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
	public Iterable<Categoria> findAll(){
		return service.findAll();
	}
}
