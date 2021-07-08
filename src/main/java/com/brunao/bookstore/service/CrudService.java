package com.brunao.bookstore.service;

import java.util.List;

public interface CrudService<E> {

	public <T> List<E> findAll();
	public <T> Object findOne(Integer id);
	public <T> Object save(E entity);
	public <T> Object update(E entity);
	public void delete(Integer id);
	
}
