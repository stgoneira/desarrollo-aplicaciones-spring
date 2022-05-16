package cl.santiago.spring.tesoreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.santiago.spring.tesoreria.model.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

}
