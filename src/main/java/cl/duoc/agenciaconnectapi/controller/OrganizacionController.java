package cl.duoc.agenciaconnectapi.controller;

import cl.duoc.agenciaconnectapi.model.Organizacion;
import cl.duoc.agenciaconnectapi.service.OrganizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizaciones")
@CrossOrigin("*")
public class OrganizacionController {

    @Autowired
    private OrganizacionService organizacionService;

    @GetMapping
    public ResponseEntity<List<Organizacion>> listar() {
        return ResponseEntity.ok(organizacionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organizacion> buscarPorId(@PathVariable Long id) {
        Organizacion org = organizacionService.buscarPorId(id);
        if (org == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(org);
    }

    @PostMapping
    public ResponseEntity<Organizacion> registrar(@RequestBody Organizacion organizacion) {
        Organizacion nueva = organizacionService.registrar(organizacion);
        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Organizacion> actualizar(@PathVariable Long id, @RequestBody Organizacion organizacion) {
        Organizacion actualizada = organizacionService.actualizar(id, organizacion);
        if (actualizada != null) return ResponseEntity.ok(actualizada);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id) {
        if (organizacionService.borrar(id)) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}
