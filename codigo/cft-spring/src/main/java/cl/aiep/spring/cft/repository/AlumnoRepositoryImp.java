package cl.aiep.spring.cft.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cl.aiep.spring.cft.modelo.Alumno;
import cl.aiep.spring.cft.modelo.Carrera;

@Repository
public class AlumnoRepositoryImp implements AlumnoRepository {

	private static final String TABLA = "alumnos";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired 
	CarreraRepository carreraRepository;
	
	public Alumno makeObject(ResultSet rs, int row) throws SQLException {
		int carreraId = rs.getInt("carrera_id");
		Carrera carrera = carreraRepository.findById(carreraId);
		return new Alumno(rs.getInt("id"), rs.getString("nombre"), rs.getObject("fecha_nacimiento", LocalDate.class), carrera);
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
		String sql = String.format("INSERT INTO %s(nombre, fecha_nacimiento, carrera_id) VALUES(?, ?, ?)", TABLA);
		jdbcTemplate.update(sql, alumno.getNombre(), alumno.getFechaNacimiento(), alumno.getCarrera().getId());
	}

	@Override
	public void edit(Alumno alumno) {
		String sql = String.format("UPDATE %s SET nombre = ?, fecha_nacimiento = ?, carrera_id = ? WHERE id = ?", TABLA);
		jdbcTemplate.update(sql, alumno.getNombre(), alumno.getFechaNacimiento(), alumno.getCarrera().getId(), alumno.getId());
	}

	@Override
	public void delete(int id) {
		String sql = String.format("DELETE FROM %s WHERE id = ?", TABLA);
		jdbcTemplate.update(sql, id);
	}

}
