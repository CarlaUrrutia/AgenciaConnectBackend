package cl.duoc.agenciaconnectapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "seguimientos")
public class Seguimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long oportunidadId;

    @Column(nullable = false, length = 120)
    private String usuarioNombre;

    @Column(nullable = false, length = 100)
    private String tipoAccion;

    @Column(nullable = false, length = 40)
    private String fechaHora;

    @Column(nullable = false, length = 300)
    private String resultado;

    @Column(nullable = false, length = 300)
    private String proximaAccion;

    @Column(nullable = false, length = 500)
    private String observaciones = "";
}
