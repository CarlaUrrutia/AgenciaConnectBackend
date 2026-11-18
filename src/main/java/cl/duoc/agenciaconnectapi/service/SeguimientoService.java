package cl.duoc.agenciaconnectapi.service;

import cl.duoc.agenciaconnectapi.model.Seguimiento;
import cl.duoc.agenciaconnectapi.repository.SeguimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeguimientoService {
    @Autowired
    private SeguimientoRepository seguimientoRepository;

    public List<Seguimiento> findAll() {
        return seguimientoRepository.findAllByOrderByIdDesc();
    }

    public List<Seguimiento> findByOportunidadId(Long oportunidadId) {
        return seguimientoRepository.findByOportunidadIdOrderByIdDesc(oportunidadId);
    }

    public Seguimiento registrar(Seguimiento seguimiento) {
        seguimiento.setId(null);
        return seguimientoRepository.save(seguimiento);
    }

    public boolean borrar(Long id) {
        if (seguimientoRepository.existsById(id)) {
            seguimientoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
