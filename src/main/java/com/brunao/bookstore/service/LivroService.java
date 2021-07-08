package com.brunao.bookstore.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunao.bookstore.entity.Categoria;
import com.brunao.bookstore.entity.Livro;
import com.brunao.bookstore.exception.ObjectNotFoundException;
import com.brunao.bookstore.repository.LivroRepository;

@Service
public class LivroService implements CrudService<Livro>{

	@Autowired
	LivroRepository livroRepository;
	
	@Autowired
	CategoriaService categoriaService;

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
		entity.setId(null);
		return livroRepository.save(entity);
	}
	
	public Livro save(Livro livro, Integer idCategoria) {
		livro.setId(null);
		Categoria categoria = categoriaService.findOne(idCategoria);
		livro.setCategoria(categoria);
		return livroRepository.save(livro);
	}

	@Override
	public void delete(Integer id) {
		findOne(id);
		livroRepository.deleteById(id);
	}

	
	public List<Livro> findAllByCategoria(Integer idCategoria) {
		categoriaService.findOne(idCategoria);
		return livroRepository.findAllBycategoria(idCategoria);
	}

	@Override
	public Livro update(Livro entity) {
		findOne(entity.getId());
		return livroRepository.save(entity);
	}

	public Livro update(Integer id, Livro livro) {
		Livro newl = findOne(id);
		newl.setTitulo(livro.getTitulo());
		newl.setNomeAutor(livro.getNomeAutor());
		newl.setTexto(livro.getTexto());
		return livroRepository.save(newl);
	}
	
	
}
