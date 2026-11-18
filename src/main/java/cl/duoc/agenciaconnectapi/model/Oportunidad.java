package cl.duoc.agenciaconnectapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "oportunidades")
public class Oportunidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(nullable = false, length = 60)
    private String tipo;

    @Column(nullable = false)
    private Long organizacionId;

    @Column(nullable = false)
    private Long eventoId = 0L;

    @Column(nullable = false, length = 30)
    private String prioridad;

    @Column(nullable = false, length = 30)
    private String potencial;

    @Column(nullable = false, length = 60)
    private String estado;

    @Column(nullable = false, length = 120)
    private String responsable;

    @Column(nullable = false, length = 500)
    private String observaciones = "";

    @Column(nullable = false, length = 20)
    private String fechaDeteccion = "";
}
