package com.qa.nba.service;

import java.util.List;

public interface ServiceMethods<T> {

	T create(T shark);
	
	List<T> readAll();
	
	T readById(long id);
	
	T update(long id, T duck);
	
	boolean delete(long id);
}