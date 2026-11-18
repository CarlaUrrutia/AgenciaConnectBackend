package cl.duoc.agenciaconnectapi.service;

import cl.duoc.agenciaconnectapi.model.Usuario;
import cl.duoc.agenciaconnectapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public List<Usuario> obtenerEjecutivos() {
        return usuarioRepository.findByRolOrderByNombreAsc("EJECUTIVO");
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario autenticar(String correo, String contrasena) {
        return usuarioRepository.findByCorreoAndContrasena(correo.trim(), contrasena).orElse(null);
    }

    public Usuario registrar(Usuario usuario) {
        usuario.setId(null);
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizar(Long id, Usuario detalles) {
        return usuarioRepository.findById(id).map(u -> {
            u.setNombre(detalles.getNombre());
            u.setCorreo(detalles.getCorreo());
            u.setContrasena(detalles.getContrasena());
            u.setRol(detalles.getRol());
            return usuarioRepository.save(u);
        }).orElse(null);
    }

    public boolean borrar(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
