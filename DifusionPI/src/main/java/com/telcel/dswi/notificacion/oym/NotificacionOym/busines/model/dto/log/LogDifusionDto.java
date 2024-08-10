package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dto.log;


import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class LogDifusionDto {

    private String numeroEmpleado;
    private String idMensaje;
    private String nombre;
    private String emailAutor;
    private String tituloMensaje;
    private Integer estatus;
    private Integer tipo;
    private String perfilAutor;
    private String codeDeptoAutor;
    private Date fechaRegistro;
    private Date fechaProgramacion;
    private Date fechaEnvio;
    private Date fechaMantenimiento;
}
