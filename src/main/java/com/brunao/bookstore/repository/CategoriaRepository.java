package com.brunao.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.brunao.bookstore.entity.Categoria;


public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {

}
