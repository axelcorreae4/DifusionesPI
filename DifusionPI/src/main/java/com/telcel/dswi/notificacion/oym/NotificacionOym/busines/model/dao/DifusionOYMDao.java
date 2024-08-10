package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dao;

import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.DifusionOYM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DifusionOYMDao extends JpaRepository<DifusionOYM, String> {
}
