package cl.aiep.spring.cft.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.aiep.spring.cft.modelo.Alumno;

@Repository
public class AlumnoRepositoryImp implements AlumnoRepository {

	private static final String TABLA = "alumnos";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Alumno makeObject(ResultSet rs, int row) throws SQLException {
		return new Alumno(rs.getInt("id"), rs.getString("nombre"));
	}
	
	@Override
	public List<Alumno> findAll() {
		final String sql = String.format("SELECT * FROM %s", TABLA);
		return jdbcTemplate.query(sql, this::makeObject);
	}

	@Override
	public Alumno findById(int id) {
		final String sql = String.format("SELECT * FROM %s WHERE id = ?", TABLA);
		return jdbcTemplate.queryForObject(sql, this::makeObject, id);
	}

	@Override
	public void create(Alumno alumno) {
		String sql = String.format("INSERT INTO %s(nombre) VALUES(?)", TABLA);
		jdbcTemplate.update(sql, alumno.getNombre());
	}

	@Override
	public void edit(Alumno alumno) {
		String sql = String.format("UPDATE %s SET nombre = ? WHERE id = ?", TABLA);
		jdbcTemplate.update(sql, alumno.getNombre(), alumno.getId());
	}

	@Override
	public void delete(int id) {
		String sql = String.format("DELETE FROM %s WHERE id = ?", TABLA);
		jdbcTemplate.update(sql, id);
	}

}
