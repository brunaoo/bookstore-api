package com.brunao.bookstore.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunao.bookstore.domain.Categoria;
import com.brunao.bookstore.repository.CategoriaRepository;

@Service
public class CategoriaService implements CrudService<Categoria> {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public  List<Categoria> findAll() {
		List<Categoria> list = new LinkedList<>();
		categoriaRepository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public Categoria findOne(Integer id) {
		Optional<Categoria>  obj =  categoriaRepository.findById(id);
		return obj.orElse(null);
	}

	@Override
	public Categoria save(Categoria entity) {
		return categoriaRepository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		categoriaRepository.deleteById(id);
	}

}
