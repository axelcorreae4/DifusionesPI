package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PdicDto {
    private Integer idPuntoInterconexion;
    private String nombrePdic;
    private String descripcionPdic;
    private Integer region;
    private Integer tipo;
    private String contactosCorporativo;
    private String contactosOperadores;
}
