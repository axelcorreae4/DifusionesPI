package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.service.persistence;

import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dto.OperadorDto;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.Operador;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.Pdic;

import java.util.List;

public interface IOperadorService {

    Operador save(OperadorDto operadorDto);
    OperadorDto findById(Integer id);
    List<Operador> listaOperadores();
    Boolean existsOperador(Integer id);
    List<Operador> saveAllOperadores(List<OperadorDto> listaOperadores, Pdic pdic);
}
