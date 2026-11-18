package cl.duoc.agenciaconnectapi.service;

import cl.duoc.agenciaconnectapi.model.Oportunidad;
import cl.duoc.agenciaconnectapi.repository.OportunidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OportunidadService {
    @Autowired
    private OportunidadRepository oportunidadRepository;

    public List<Oportunidad> findAll() {
        return oportunidadRepository.findAllByOrderByIdDesc();
    }

    public Oportunidad buscarPorId(Long id) {
        return oportunidadRepository.findById(id).orElse(null);
    }

    public Oportunidad registrar(Oportunidad oportunidad) {
        oportunidad.setId(null);
        return oportunidadRepository.save(oportunidad);
    }

    public Oportunidad actualizar(Long id, Oportunidad detalles) {
        return oportunidadRepository.findById(id).map(op -> {
            op.setNombre(detalles.getNombre());
            op.setTipo(detalles.getTipo());
            op.setOrganizacionId(detalles.getOrganizacionId());
            op.setEventoId(detalles.getEventoId() != null ? detalles.getEventoId() : 0L);
            op.setPrioridad(detalles.getPrioridad());
            op.setPotencial(detalles.getPotencial());
            op.setEstado(detalles.getEstado());
            op.setResponsable(detalles.getResponsable());
            op.setObservaciones(detalles.getObservaciones() != null ? detalles.getObservaciones() : "");
            op.setFechaDeteccion(detalles.getFechaDeteccion() != null ? detalles.getFechaDeteccion() : "");
            return oportunidadRepository.save(op);
        }).orElse(null);
    }

    public boolean borrar(Long id) {
        if (oportunidadRepository.existsById(id)) {
            oportunidadRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
