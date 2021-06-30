package com.brunao.bookstore.service;

import java.util.Arrays;

import org.apache.tomcat.util.digester.ArrayStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunao.bookstore.domain.Categoria;
import com.brunao.bookstore.domain.Livro;
import com.brunao.bookstore.repository.CategoriaRepository;
import com.brunao.bookstore.repository.LivroRepository;

@Service
public class DBService {

	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	LivroRepository livroRepository;
	
	public void instanciaDBservice() {
		
		Categoria cat1 = new Categoria(null, "Informática", "programação");
		Categoria cat2 = new Categoria(null, "ficção cientifica", "xxxx");
		Categoria cat3 = new Categoria(null, "Terror", "Maiores de 18 anos");
		
		Livro l1 = new Livro(null, "codigo limpo", "não sei", "xxxxxxxsx", cat1);
		Livro l2 = new Livro(null, "eu robo", "não sei", "yyyyyyyyy", cat2);
		Livro l3 = new Livro(null, "dominando android", "nelson glauber", "xxxxxx", cat1);
		Livro l4 = new Livro(null, "it a coisa", "stephen king", "A coisa", cat3);
		Livro l5 = new Livro(null, "A torre negra", "stephen king", "A torre negra", cat3);
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4,l5));
	
	}
}
