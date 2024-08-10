package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.service.persistence;

import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dto.log.LogDifusionDto;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dto.log.LogOperadorDto;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dto.log.LogPdicDto;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.log.LogDifusion;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.log.LogOperador;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.log.LogPdic;

public interface ILogsService {

    LogPdic saveLogPdic(LogPdicDto pdicDto);
    LogOperador saveLogOperador(LogOperadorDto operadorDto);
    LogDifusion saveLogDifusion(LogDifusionDto logDifusionDto);
}
