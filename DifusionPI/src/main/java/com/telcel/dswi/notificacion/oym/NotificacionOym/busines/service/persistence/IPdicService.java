package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.service.persistence;

import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dto.PdicDto;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.Pdic;

import java.util.List;

public interface IPdicService {

    Pdic save(PdicDto pdicDto);
    PdicDto findById(Integer id);
    List<Pdic> listaPdic();
    Boolean existsPdic(Integer id);
}
