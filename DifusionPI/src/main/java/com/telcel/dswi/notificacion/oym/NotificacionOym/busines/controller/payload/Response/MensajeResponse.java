package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.controller.payload.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class MensajeResponse {
    private String mensaje;
    private int status;
    private Object objectc;
}
