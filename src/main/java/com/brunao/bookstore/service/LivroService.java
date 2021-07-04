package com.brunao.bookstore.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunao.bookstore.domain.Livro;
import com.brunao.bookstore.exception.ObjectNotFoundException;
import com.brunao.bookstore.repository.LivroRepository;

@Service
public class LivroService implements CrudService<Livro>{

	@Autowired
	LivroRepository livroRepository;

	@Override
	public List<Livro> findAll() {
		List<Livro> listLivro = new LinkedList<>();
		livroRepository.findAll().forEach(l -> listLivro.add(l));
		return listLivro;
	}

	@Override
	public Livro findOne(Integer id) {
		Optional<Livro> livro = livroRepository.findById(id);
		return livro.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado, id: "+id +" tipo: "+Livro.class.getName()));
	}

	@Override
	public Livro save(Livro entity) {
		return livroRepository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		findOne(id);
		livroRepository.deleteById(id);
	}
	
	
}
