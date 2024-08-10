package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dto.log;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class LogPdicDto {

    private Integer idPuntoInterconexion;
    private String nombrePdic;
    private String descripcionPdic;
    private Integer region;
    private String contactosCorporativos;
    private String contactosOperadores;
    private Integer estatus;
    private Date fechaRegistro;
}
