package cl.hcs.spring.dao;

import java.util.List;

import cl.hcs.spring.modelo.Persona;

public interface PersonaDAO {

	public List<Persona> findAll();
	
	public Persona findById(int id);

	public void create(Persona persona);
	
	public void edit(Persona persona);
}
