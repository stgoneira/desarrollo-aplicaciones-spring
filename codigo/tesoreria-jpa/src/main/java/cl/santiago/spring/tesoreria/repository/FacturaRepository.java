package cl.santiago.spring.tesoreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.santiago.spring.tesoreria.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long> {

}
