package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.log;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "LOGPDICOYM")
public class LogPdic {

    @Id
    @Column(name = "LOGPDICOYM")
    private Integer idPdic;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "REGION")
    private Integer region;
    @Column(name = "CONTACTOSCORPO")
    @Lob
    private String contactosCorpo;
    @Column(name = "CONTACTOSOPERADORES")
    @Lob
    private String contactosOperador;
    @Column(name = "ESTATUS")
    private Integer estatus;
    @Column(name = "FECHAREGISTRO")
    private Date fechaRegistro;
}
