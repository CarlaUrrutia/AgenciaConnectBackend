package cl.duoc.agenciaconnectapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "eventos")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(nullable = false, length = 500)
    private String descripcion;

    @Column(nullable = false, length = 20)
    private String fecha;

    @Column(nullable = false, length = 150)
    private String ubicacion;

    @Column(nullable = false, length = 150)
    private String organizacion;

    @Column(nullable = false, length = 500)
    private String imagenUri = "";
}
