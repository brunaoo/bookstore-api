package com.brunao.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.brunao.bookstore.entity.Livro;

public interface LivroRepository extends CrudRepository<Livro, Integer>{

	
	@Query("SELECT l FROM Livro l where  l.categoria.id = :idCategoria order by l.titulo")
	public List<Livro> findAllBycategoria(@Param(value ="idCategoria") Integer idCategoria);

}
