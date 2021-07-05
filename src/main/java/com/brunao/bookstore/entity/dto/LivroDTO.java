package com.brunao.bookstore.entity.dto;

import java.io.Serializable;

import com.brunao.bookstore.entity.Livro;

public class LivroDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String titulo;
	
	public LivroDTO() {
		super();
	}

	public LivroDTO(Livro l) {
		super();
		this.id = l.getId();
		this.titulo = l.getTitulo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
