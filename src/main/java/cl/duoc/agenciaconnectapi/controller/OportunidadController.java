package cl.duoc.agenciaconnectapi.controller;

import cl.duoc.agenciaconnectapi.model.Oportunidad;
import cl.duoc.agenciaconnectapi.service.OportunidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/oportunidades")
@CrossOrigin("*")
public class OportunidadController {

    @Autowired
    private OportunidadService oportunidadService;

    @GetMapping
    public ResponseEntity<List<Oportunidad>> listar() {
        return ResponseEntity.ok(oportunidadService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Oportunidad> buscarPorId(@PathVariable Long id) {
        Oportunidad op = oportunidadService.buscarPorId(id);
        if (op == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(op);
    }

    @PostMapping
    public ResponseEntity<Oportunidad> registrar(@RequestBody Oportunidad oportunidad) {
        Oportunidad nueva = oportunidadService.registrar(oportunidad);
        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Oportunidad> actualizar(@PathVariable Long id, @RequestBody Oportunidad oportunidad) {
        Oportunidad actualizada = oportunidadService.actualizar(id, oportunidad);
        if (actualizada != null) return ResponseEntity.ok(actualizada);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id) {
        if (oportunidadService.borrar(id)) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}
