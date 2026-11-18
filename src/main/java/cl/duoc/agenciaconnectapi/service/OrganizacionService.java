package cl.duoc.agenciaconnectapi.service;

import cl.duoc.agenciaconnectapi.model.Organizacion;
import cl.duoc.agenciaconnectapi.repository.OrganizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizacionService {
    @Autowired
    private OrganizacionRepository organizacionRepository;

    public List<Organizacion> findAll() {
        return organizacionRepository.findAllByOrderByIdDesc();
    }

    public Organizacion buscarPorId(Long id) {
        return organizacionRepository.findById(id).orElse(null);
    }

    public Organizacion registrar(Organizacion organizacion) {
        organizacion.setId(null);
        return organizacionRepository.save(organizacion);
    }

    public Organizacion actualizar(Long id, Organizacion detalles) {
        return organizacionRepository.findById(id).map(org -> {
            org.setNombre(detalles.getNombre());
            org.setTipo(detalles.getTipo());
            org.setRubro(detalles.getRubro());
            org.setComuna(detalles.getComuna());
            org.setRegion(detalles.getRegion());
            org.setSitioWeb(detalles.getSitioWeb() != null ? detalles.getSitioWeb() : "");
            org.setPublicoAsociado(detalles.getPublicoAsociado());
            org.setObservaciones(detalles.getObservaciones() != null ? detalles.getObservaciones() : "");
            return organizacionRepository.save(org);
        }).orElse(null);
    }

    public boolean borrar(Long id) {
        if (organizacionRepository.existsById(id)) {
            organizacionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
