package cl.hcs.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.hcs.spring.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

}
