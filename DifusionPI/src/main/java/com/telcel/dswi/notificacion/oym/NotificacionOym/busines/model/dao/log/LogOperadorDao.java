package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dao.log;

import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.log.LogOperador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogOperadorDao extends JpaRepository<LogOperador, Integer> {
}
