package com.example.jerseryspring.persistence;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> {

	T save(T entity);
	
	T findById(Serializable id);
	
	List<T> findAll();
	
	void delete(T entity);
}
