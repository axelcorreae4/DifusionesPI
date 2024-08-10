package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dao.log;

import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.log.LogDifusion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogDifusionDao extends JpaRepository<LogDifusion, String> {
}
