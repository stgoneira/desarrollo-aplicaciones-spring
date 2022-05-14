package cl.aiep.spring.cft.repository;

import java.util.List;

import cl.aiep.spring.cft.modelo.Carrera;

public interface CarreraRepository {
	
	public List<Carrera> findAll();
	public Carrera findById(int id);
	public void create(Carrera carrera);
	public void edit(Carrera carrera);
	public void delete(int id);
}
