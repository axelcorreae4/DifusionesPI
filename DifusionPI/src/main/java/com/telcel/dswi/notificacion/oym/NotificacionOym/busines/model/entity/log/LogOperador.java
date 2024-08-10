package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.log;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "LOGOPERADOROYM")
public class LogOperador {

    @Id
    @Column(name = "IDOPERADOR")
    private Integer idOperador;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "IDSERVICIO")
    private String idServicio;
    @Column(name = "IDPDIC")
    private Integer idPdic;
    @Column(name = "ESTATUS")
    private Integer estatus;
    @Column(name = "FECHAREGISTRO")
    @JsonFormat()
    private Date fechaRegistro;
}
