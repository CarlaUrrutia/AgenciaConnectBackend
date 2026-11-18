package cl.duoc.agenciaconnectapi.service;

import cl.duoc.agenciaconnectapi.model.Evento;
import cl.duoc.agenciaconnectapi.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> findAll() {
        return eventoRepository.findAllByOrderByIdDesc();
    }

    public Evento buscarPorId(Long id) {
        return eventoRepository.findById(id).orElse(null);
    }

    public Evento registrar(Evento evento) {
        evento.setId(null);
        return eventoRepository.save(evento);
    }

    public Evento actualizar(Long id, Evento detalles) {
        return eventoRepository.findById(id).map(e -> {
            e.setNombre(detalles.getNombre());
            e.setDescripcion(detalles.getDescripcion());
            e.setFecha(detalles.getFecha());
            e.setUbicacion(detalles.getUbicacion());
            e.setOrganizacion(detalles.getOrganizacion());
            e.setImagenUri(detalles.getImagenUri() != null ? detalles.getImagenUri() : "");
            return eventoRepository.save(e);
        }).orElse(null);
    }

    public boolean borrar(Long id) {
        if (eventoRepository.existsById(id)) {
            eventoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
