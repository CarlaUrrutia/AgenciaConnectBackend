package cl.duoc.agenciaconnectapi.service;

import cl.duoc.agenciaconnectapi.model.Contacto;
import cl.duoc.agenciaconnectapi.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoService {
    @Autowired
    private ContactoRepository contactoRepository;

    public List<Contacto> findAll() {
        return contactoRepository.findAllByOrderByNombreCompletoAsc();
    }

    public Contacto buscarPorId(Long id) {
        return contactoRepository.findById(id).orElse(null);
    }

    public Contacto registrar(Contacto contacto) {
        contacto.setId(null);
        return contactoRepository.save(contacto);
    }

    public Contacto actualizar(Long id, Contacto detalles) {
        return contactoRepository.findById(id).map(c -> {
            c.setNombreCompleto(detalles.getNombreCompleto());
            c.setOrganizacionId(detalles.getOrganizacionId());
            c.setCargo(detalles.getCargo());
            c.setArea(detalles.getArea());
            c.setCorreo(detalles.getCorreo());
            c.setTelefono(detalles.getTelefono() != null ? detalles.getTelefono() : "");
            c.setMedioPreferido(detalles.getMedioPreferido());
            c.setObservaciones(detalles.getObservaciones() != null ? detalles.getObservaciones() : "");
            return contactoRepository.save(c);
        }).orElse(null);
    }

    public boolean borrar(Long id) {
        if (contactoRepository.existsById(id)) {
            contactoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
