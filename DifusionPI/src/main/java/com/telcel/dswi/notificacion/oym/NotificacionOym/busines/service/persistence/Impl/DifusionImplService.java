package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.service.persistence.Impl;

import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dao.DifusionOYMDao;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dto.DifusionOYMDto;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.DifusionOYM;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.service.persistence.IDifusionOYMService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DifusionImplService implements IDifusionOYMService {

    private DifusionOYMDao difusionOYMDao;

    public DifusionImplService(DifusionOYMDao difusionOYMDao) {
        this.difusionOYMDao = difusionOYMDao;
    }

    @Transactional
    @Override
    public DifusionOYM save(DifusionOYMDto difusionOYMDto) {
        DifusionOYM difusionOYM = DifusionOYM.builder().
                numeroEmpleado(difusionOYMDto.getNumeroEmpleado())
                .idMensaje(difusionOYMDto.getIdMensaje())
                .nombreAutor(difusionOYMDto.getNombreAutor())
                .emailAutor(difusionOYMDto.getEmailAutor())
                .tituloMensaje(difusionOYMDto.getTituloMensaje())
                .pdicDestinatario(difusionOYMDto.getPdicDestinatario())
                .cuerpoMensaje(difusionOYMDto.getCuerpoMensaje())
                .destinatarios(difusionOYMDto.getDestinatarios())
                .estatus(difusionOYMDto.getEstatus())
                .perfilAutor(difusionOYMDto.getPerfilAutor())
                .codeDeptoUsuario(difusionOYMDto.getCodeDeptoUsuario())
                .fechaProgramacion(difusionOYMDto.getFechaProgramacion())
                .fechaEnvio(difusionOYMDto.getFechaEnvio())
                .fechaMantenimiento(difusionOYMDto.getFechaMantenimiento())
                .build();
        return difusionOYMDao.save(difusionOYM);
    }

    @Override
    public DifusionOYMDto findById(String id) {
        DifusionOYMDto difusionOYMDto = null;

        //Consultamos la difucion, si no existe retorna un null
        DifusionOYM difusionOYM = difusionOYMDao.findById(id).orElse(null);
        if (difusionOYM != null) {
            difusionOYMDto = DifusionOYMDto.builder().
                    numeroEmpleado(difusionOYM.getNumeroEmpleado()).
                    idMensaje(difusionOYM.getIdMensaje())
                    .nombreAutor(difusionOYM.getNombreAutor())
                    .emailAutor(difusionOYM.getEmailAutor())
                    .tituloMensaje(difusionOYM.getTituloMensaje())
                    .pdicDestinatario(difusionOYM.getPdicDestinatario())
                    .cuerpoMensaje(difusionOYM.getCuerpoMensaje())
                    .destinatarios(difusionOYM.getDestinatarios())
                    .estatus(difusionOYM.getEstatus())
                    .perfilAutor(difusionOYM.getPerfilAutor())
                    .codeDeptoUsuario(difusionOYM.getCodeDeptoUsuario())
                    .fechaProgramacion(difusionOYM.getFechaProgramacion())
                    .fechaEnvio(difusionOYM.getFechaEnvio())
                    .fechaMantenimiento(difusionOYM.getFechaMantenimiento())
                    .build();
        }

        return difusionOYMDto;
    }

    @Override
    public List<DifusionOYM> listaDifusionOym() {
        return difusionOYMDao.findAll();
    }

    @Override
    public Boolean existsDif(String id) {
        return difusionOYMDao.existsById(id);
    }


}
