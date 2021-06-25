package com.brunao.bookstore.repository;

import org.springframework.data.repository.CrudRepository;

import com.brunao.bookstore.domain.Livro;

public interface LivroRepository extends CrudRepository<Livro, Integer>{

}
