package cl.hcs.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.hcs.spring.modelo.Persona;

@Repository
public class PersonaDAOImp implements PersonaDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private Persona makeObject(ResultSet rs, int rowNum) throws SQLException {
		return new Persona(rs.getInt("id"), rs.getString("nombre"));
	}
	
	@Override
	public List<Persona> findAll() {
		return jdbcTemplate.query("SELECT * FROM alumnos", this::makeObject);
	}

	@Override
	public Persona findById(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM alumnos WHERE id = ?", this::makeObject, id);
	}

	@Override
	public void create(Persona persona) {
		jdbcTemplate.update("INSERT INTO alumnos(nombre) VALUES(?)", persona.getNombre());
	}

	@Override
	public void edit(Persona persona) {
		jdbcTemplate.update("UPDATE alumnos SET nombre = ? WHERE id = ?", persona.getNombre(), persona.getId());		
	}
	
}
