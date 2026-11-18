package cl.duoc.agenciaconnectapi.repository;

import cl.duoc.agenciaconnectapi.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long> {
    List<Contacto> findAllByOrderByNombreCompletoAsc();
}
