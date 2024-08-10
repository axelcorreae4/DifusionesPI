package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "PDICOYM")
public class Pdic {

    @Id()
    @Column(name = "IDPDIC", nullable = false)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPdic;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "REGION", nullable = false)
    private Integer region;

    @Column(name = "TIPO", nullable = false)
    private Integer tipo;

    @Column(name = "CONTACTOSCORPO", nullable = false)
    @Lob
    private String contactosCorpo;

    @Column(name = "CONTACTOSOPERADORES", nullable = false)
    @Lob
    private String contactosOperadores;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pdic", cascade = CascadeType.ALL)
    private List<Operador> operadores;

}
