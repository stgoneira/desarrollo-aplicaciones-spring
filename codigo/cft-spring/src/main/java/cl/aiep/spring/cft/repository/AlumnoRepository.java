package cl.aiep.spring.cft.repository;

import java.util.List;

import cl.aiep.spring.cft.modelo.Alumno;

public interface AlumnoRepository {

	public List<Alumno> findAll();
	public Alumno findById(int id);
	public void create(Alumno alumno);
	public void edit(Alumno alumno);
	public void delete(int id);
	
}
