package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name="DIFUSIONESOYM")
public class DifusionOYM implements Serializable {


    @Column(name ="NUMEROEMPLEADO")
    private String numeroEmpleado;
    @Id
    @Column(name = "IDMENSAJE")
    private String idMensaje;
    @Column(name = "NOMBREAUTOR")
    private String nombreAutor;
    @Column(name = "EMAILAUTOR")
    private String emailAutor;
    @Column(name = "TITULOMENSAJE")
    private String tituloMensaje;
    @Column(name = "PDICMDESTINATARIO")
    private String pdicDestinatario;
    @Column(name = "CUERPOMENSASJE")
    @Lob
    private String cuerpoMensaje;
    @Column(name = "DESTINATARIOS")
    @Lob
    private String destinatarios;
    @Column(name = "ESTATUS")
    private Integer estatus;
    @Column(name = "PERFILAUTOR")
    private String perfilAutor;
    @Column(name = "CODEDEPTOAUTOR")
    private String codeDeptoUsuario;

    @Column(name = "FECHAPROGRAMACION")
    @JsonFormat()
    private Date fechaProgramacion;

    @Column(name = "FECHAENVIO")
    @JsonFormat()
    private Date fechaEnvio;

    @Column(name = "FECHAMANTENIMIENTO")
    @JsonFormat()
    private Date fechaMantenimiento;


}
