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
@Table(name = "LOGDIFUSIONESOYM")
public class LogDifusion {

    @Id
    @Column(name = "NUMEROEMPLEADO")
    private String numeroEmpleado;
    @Column(name = "IDMENSAJE")
    private String idMensaje;
    @Column(name = "NOMBREAUTOR")
    private String nombre;
    @Column(name = "EMAILAUTOR")
    private String emailAutor;
    @Column(name = "TITULOMENSAJE")
    private String tituloMensaje;
    @Column(name = "ESTATUS")
    private Integer estatus;
    @Column(name = "TIPO")
    private Integer tipo;
    @Column(name = "PERFILAUTOR")
    private String perfilAutor;
    @Column(name = "CODEDEPTOAUTOR")
    private String codeDeptoAutor;
    @Column(name = "FECHAREGISTRO")
    private Date fechaRegistro;
    @JsonFormat()
    @Column(name = "FECHAPROGRAMACION")
    private Date fechaProgramacion;
    @Column(name = "FECHAENVIO")
    @JsonFormat()
    private Date fechaEnvio;
    @Column(name = "FECHAMANTENIMIENTO")
    @JsonFormat()
    private Date fechaMantenimiento;
}
