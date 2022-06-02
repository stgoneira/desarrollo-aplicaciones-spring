package cl.aiep.java.archivos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.aiep.java.archivos.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
