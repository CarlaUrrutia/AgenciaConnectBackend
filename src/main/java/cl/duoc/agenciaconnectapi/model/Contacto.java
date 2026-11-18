package cl.duoc.agenciaconnectapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contactos")
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String nombreCompleto;

    @Column(nullable = false)
    private Long organizacionId;

    @Column(nullable = false, length = 100)
    private String cargo;

    @Column(nullable = false, length = 100)
    private String area;

    @Column(nullable = false, length = 120)
    private String correo;

    @Column(nullable = false, length = 30)
    private String telefono = "";

    @Column(nullable = false, length = 60)
    private String medioPreferido;

    @Column(nullable = false, length = 500)
    private String observaciones = "";
}
