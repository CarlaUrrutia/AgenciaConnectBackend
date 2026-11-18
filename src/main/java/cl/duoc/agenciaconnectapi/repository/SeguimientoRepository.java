package cl.duoc.agenciaconnectapi.repository;

import cl.duoc.agenciaconnectapi.model.Seguimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeguimientoRepository extends JpaRepository<Seguimiento, Long> {
    List<Seguimiento> findByOportunidadIdOrderByIdDesc(Long oportunidadId);
    List<Seguimiento> findAllByOrderByIdDesc();
}
