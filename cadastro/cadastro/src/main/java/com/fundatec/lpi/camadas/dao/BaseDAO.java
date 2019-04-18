package com.fundatec.lpi.camadas.dao;

import java.io.IOException;

public interface BaseDAO<T> {
	
	public void save(T objeto) throws IOException;
	public void delete(T objeto) throws IOException;
	public void update(T objeto) throws IOException;
	public void list(T objeto)throws IOException;
}
