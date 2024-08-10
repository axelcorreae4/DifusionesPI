package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.controller.payload.Response;

import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dto.OperadorDto;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.Operador;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AltaPdicOprResp {

    private Integer estatus;
    private String mensaje;
    private Integer operadoresRegistrados;
    private List<OperadorDto> operadoresNoRegistrados;
}
