package cl.duoc.agenciaconnectapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "organizaciones")
public class Organizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String nombre;

    @Column(nullable = false, length = 60)
    private String tipo;

    @Column(nullable = false, length = 100)
    private String rubro;

    @Column(nullable = false, length = 80)
    private String comuna;

    @Column(nullable = false, length = 80)
    private String region;

    @Column(nullable = false, length = 150)
    private String sitioWeb = "";

    @Column(nullable = false, length = 150)
    private String publicoAsociado;

    @Column(nullable = false, length = 500)
    private String observaciones = "";
}
