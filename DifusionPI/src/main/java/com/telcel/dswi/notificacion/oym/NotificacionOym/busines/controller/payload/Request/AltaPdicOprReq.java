package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.controller.payload.Request;

import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dto.OperadorDto;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dto.PdicDto;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AltaPdicOprReq {

    private PdicDto puntoInterconexion;
    private List<OperadorDto> operadores;

}
