package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dto.log;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class LogOperadorDto {

    private Integer idOperador;
    private String nombreOperador;
    private String descripcionOperador;
    private String idServicio;
    private Integer idPdic;
    private Integer estatus;
    private Date fechaRegistro;
}
