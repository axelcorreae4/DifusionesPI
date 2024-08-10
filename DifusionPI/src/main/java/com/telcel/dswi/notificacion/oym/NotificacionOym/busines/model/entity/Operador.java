package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "OPERADOROYM")
public class Operador {

    @EmbeddedId
    private OperadorOymPk idPk;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "IDSERVICIO", nullable = false)
    private String idServicio;

    @Column(name = "ESTATUS", nullable = false)
    private Integer estatus;

    @Column(name = "FECHAREGISTRO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPdic")
    private Pdic pdic;

}
