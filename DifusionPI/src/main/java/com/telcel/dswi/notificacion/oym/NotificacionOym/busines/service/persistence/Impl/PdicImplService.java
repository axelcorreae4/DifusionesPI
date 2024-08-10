package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.service.persistence.Impl;

import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dao.PdicDao;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dto.PdicDto;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.Pdic;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.service.persistence.IPdicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PdicImplService implements IPdicService {

    PdicDao pdicDao;

    public PdicImplService(PdicDao pdicDao){
        this.pdicDao = pdicDao;
    }

    @Transactional
    @Override
    public Pdic save(PdicDto pdicDto) {
        Pdic pdic = Pdic.builder()
                .idPdic(pdicDto.getIdPuntoInterconexion())
                .nombre(pdicDto.getNombrePdic())
                .descripcion(pdicDto.getDescripcionPdic())
                .region(pdicDto.getRegion())
                .tipo(pdicDto.getTipo())
                .contactosCorpo(pdicDto.getContactosCorporativo())
                .contactosOperadores(pdicDto.getContactosOperadores())
                .build();
        System.out.println("Datos desde el service: " + pdic.toString());
        return pdicDao.save(pdic);
    }

    @Override
    public PdicDto findById(Integer id) {
        PdicDto pdicDto = null;

        //Consultamos los puntos de interconexion
        Pdic pdic = pdicDao.findById(id).orElse(null);
        if (pdic != null){
            pdicDto = PdicDto.builder()
                    .idPuntoInterconexion(pdic.getIdPdic())
                    .nombrePdic(pdicDto.getNombrePdic())
                    .descripcionPdic(pdic.getDescripcion())
                    .contactosCorporativo(pdic.getContactosCorpo())
                    .contactosOperadores(pdic.getContactosOperadores())
                    .build();
        }
        return pdicDto;
    }

    @Override
    public List<Pdic> listaPdic() {
        return pdicDao.findAll();
    }

    @Override
    public Boolean existsPdic(Integer id) {
        return pdicDao.existsById(id);
    }
}
