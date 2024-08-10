package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DifusionOYMDto implements Serializable
{
    private String numeroEmpleado;
    private String idMensaje;
    private String nombreAutor;
    private String emailAutor;
    private String tituloMensaje;
    private String pdicDestinatario;
    private String cuerpoMensaje;
    private String destinatarios;
    private Integer estatus;
    private String perfilAutor;
    private String codeDeptoUsuario;
    private Date fechaProgramacion;
    private Date fechaEnvio;
    private Date fechaMantenimiento;
}
