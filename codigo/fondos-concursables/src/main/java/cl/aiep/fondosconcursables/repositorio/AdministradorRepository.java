package cl.aiep.fondosconcursables.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.aiep.fondosconcursables.modelo.Administrador;

public interface AdministradorRepository extends JpaRepository<Administrador, String> {

}
