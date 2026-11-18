package cl.duoc.agenciaconnectapi.controller;

import cl.duoc.agenciaconnectapi.model.Seguimiento;
import cl.duoc.agenciaconnectapi.service.SeguimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seguimientos")
@CrossOrigin("*")
public class SeguimientoController {

    @Autowired
    private SeguimientoService seguimientoService;

    @GetMapping
    public ResponseEntity<List<Seguimiento>> listar(
            @RequestParam(required = false) Long oportunidadId
    ) {
        if (oportunidadId != null) {
            return ResponseEntity.ok(seguimientoService.findByOportunidadId(oportunidadId));
        }
        return ResponseEntity.ok(seguimientoService.findAll());
    }

    @GetMapping("/oportunidad/{oportunidadId}")
    public ResponseEntity<List<Seguimiento>> listarPorOportunidad(@PathVariable Long oportunidadId) {
        return ResponseEntity.ok(seguimientoService.findByOportunidadId(oportunidadId));
    }

    @PostMapping
    public ResponseEntity<Seguimiento> registrar(@RequestBody Seguimiento seguimiento) {
        Seguimiento nuevo = seguimientoService.registrar(seguimiento);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Long id) {
        if (seguimientoService.borrar(id)) return ResponseEntity.noContent().build();
        return ResponseEntity.notFound().build();
    }
}
