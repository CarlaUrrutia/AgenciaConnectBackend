package cl.duoc.agenciaconnectapi.repository;

import cl.duoc.agenciaconnectapi.model.Oportunidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OportunidadRepository extends JpaRepository<Oportunidad, Long> {
    List<Oportunidad> findAllByOrderByIdDesc();
}
