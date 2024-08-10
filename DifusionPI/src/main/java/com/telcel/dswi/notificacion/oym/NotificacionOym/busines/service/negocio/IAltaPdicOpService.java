package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.service.negocio;

import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.controller.payload.Request.AltaPdicOprReq;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dto.OperadorDto;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.Operador;

import java.util.List;

public interface IAltaPdicOpService {

    List<OperadorDto> operadoresExistentes(List<OperadorDto> listaOperadores);
    Integer altaPdicOperador(AltaPdicOprReq altaPdicOprReq);
    Integer ultimoIdPdic();
    Integer ultimoIdOperador();
    List<OperadorDto> listaOperadoresExistentes();
}
