package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.service.persistence.Impl;

import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dao.log.LogDifusionDao;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dao.log.LogOperadorDao;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dao.log.LogPdicDao;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dto.log.LogDifusionDto;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dto.log.LogOperadorDto;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dto.log.LogPdicDto;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.log.LogDifusion;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.log.LogOperador;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.log.LogPdic;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.service.persistence.ILogsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogsImplService implements ILogsService {

    private LogPdicDao logPdicDao;
    private LogOperadorDao logOperadorDao;
    private LogDifusionDao logDifusionDao;

    LogsImplService(LogPdicDao logPdicDao,
                    LogOperadorDao logOperadorDao,
                    LogDifusionDao logDifusionDao){
        this.logPdicDao = logPdicDao;
        this.logOperadorDao = logOperadorDao;
        this.logDifusionDao = logDifusionDao;
    }

    @Transactional
    @Override
    public LogPdic saveLogPdic(LogPdicDto logPdicDto) {
        LogPdic logPdicSave = LogPdic.builder()
                .idPdic(logPdicDto.getIdPuntoInterconexion())
                .nombre(logPdicDto.getNombrePdic())
                .descripcion(logPdicDto.getDescripcionPdic())
                .region(logPdicDto.getRegion())
                .contactosCorpo(logPdicDto.getContactosCorporativos())
                .contactosOperador(logPdicDto.getContactosOperadores())
                .estatus(logPdicDto.getEstatus())
                .fechaRegistro(logPdicDto.getFechaRegistro())
                .build();

        return logPdicDao.save(logPdicSave);
    }

    @Transactional
    @Override
    public LogOperador saveLogOperador(LogOperadorDto logOperadorDto) {
        LogOperador logOperadorSave = LogOperador.builder()
                .idOperador(logOperadorDto.getIdOperador())
                .nombre(logOperadorDto.getNombreOperador())
                .descripcion(logOperadorDto.getDescripcionOperador())
                .idServicio(logOperadorDto.getIdServicio())
                .idPdic(logOperadorDto.getIdPdic())
                .estatus(logOperadorDto.getEstatus())
                .fechaRegistro(logOperadorDto.getFechaRegistro())
                .build();

        return logOperadorDao.save(logOperadorSave);
    }

    @Transactional
    @Override
    public LogDifusion saveLogDifusion(LogDifusionDto logDifusionDto) {
        LogDifusion logDifusionSave = LogDifusion.builder()
                .numeroEmpleado(logDifusionDto.getNumeroEmpleado())
                .idMensaje(logDifusionDto.getIdMensaje())
                .nombre(logDifusionDto.getNombre())
                .emailAutor(logDifusionDto.getEmailAutor())
                .tituloMensaje(logDifusionDto.getTituloMensaje())
                .estatus(logDifusionDto.getEstatus())
                .tipo(logDifusionDto.getTipo())
                .perfilAutor(logDifusionDto.getPerfilAutor())
                .codeDeptoAutor(logDifusionDto.getCodeDeptoAutor())
                .fechaRegistro(logDifusionDto.getFechaRegistro())
                .fechaProgramacion(logDifusionDto.getFechaProgramacion())
                .fechaEnvio(logDifusionDto.getFechaEnvio())
                .fechaMantenimiento(logDifusionDto.getFechaMantenimiento())
                .build();

        return logDifusionDao.save(logDifusionSave);
    }
}
