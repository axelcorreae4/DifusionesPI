package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.controller;

import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dto.PdicDto;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.Pdic;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.controller.payload.Response.MensajeResponse;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.service.persistence.IPdicService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/identidad")
public class PdicController {

    private IPdicService iPdicService;

    public PdicController(IPdicService iPdicService){
        this.iPdicService = iPdicService;
    }

    @PostMapping("/nuevoPdic")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createPdic(@RequestBody PdicDto pdicDto){
        System.out.println("Es la petición que llega: " + pdicDto.toString());
        Pdic pdic = null;
        try{
            pdic = iPdicService.save(pdicDto);
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Registro de Punto de interconexion con exito")
                    .objectc(pdicDto)
                    .status(1).build(), HttpStatus.OK);
        }catch(DataAccessException ex){
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("No se pudo registrar el punto de interconexion")
                    .objectc(null)
                    .status(2).build(), HttpStatus.OK);
        }
    }
}
