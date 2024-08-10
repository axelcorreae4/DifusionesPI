package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class OperadorDto {
    private Integer idOperador;
    private String nombreOperador;
    private String descripcionOperador;
    private String idServicioOperador;
    private Integer idPdic;
    private Integer idPuntoInterconexion;
}
