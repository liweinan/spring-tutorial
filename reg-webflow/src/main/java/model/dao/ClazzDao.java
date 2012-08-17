package model.dao;

import java.util.List;

import model.Clazz;

public interface ClazzDao {
	public void store(Clazz clazz);

	public List<Clazz> load();

	public Clazz findById(String id);
	
	public Clazz create();
}
