package cl.duoc.agenciaconnectapi.repository;

import cl.duoc.agenciaconnectapi.model.Organizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrganizacionRepository extends JpaRepository<Organizacion, Long> {
    List<Organizacion> findAllByOrderByIdDesc();
}
