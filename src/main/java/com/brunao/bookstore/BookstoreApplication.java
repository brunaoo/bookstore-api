package com.brunao.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brunao.bookstore.domain.Categoria;
import com.brunao.bookstore.domain.Livro;
import com.brunao.bookstore.repository.CategoriaRepository;
import com.brunao.bookstore.repository.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{

	@Autowired
	CategoriaRepository categoriaRepository;
	@Autowired
	LivroRepository livroRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Infórmatica", "programação");
		Livro l1 =new Livro(null, "clean code", "Robert", "Loream ipsum", cat1);
		cat1.getLivros().add(l1);
		
		categoriaRepository.save(cat1);
		livroRepository.save(l1);
		
		
	}
	
	

}
