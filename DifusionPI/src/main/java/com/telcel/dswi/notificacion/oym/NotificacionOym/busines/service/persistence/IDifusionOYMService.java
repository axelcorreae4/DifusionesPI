package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.service.persistence;

import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dto.DifusionOYMDto;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.DifusionOYM;

import java.util.List;

public interface IDifusionOYMService {

    DifusionOYM save(DifusionOYMDto difusionOYMDto);
    DifusionOYMDto findById(String id);
    List<DifusionOYM> listaDifusionOym();
    Boolean existsDif(String id);
}
