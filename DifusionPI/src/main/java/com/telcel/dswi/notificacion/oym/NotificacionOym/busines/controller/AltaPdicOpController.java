package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.controller;

import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.controller.payload.Request.AltaPdicOprReq;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.controller.payload.Response.AltaPdicOprResp;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.service.negocio.IAltaPdicOpService;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.service.persistence.IOperadorService;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.service.persistence.IPdicService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping("/identidad/api/v1")
public class AltaPdicOpController {

    private IAltaPdicOpService iAltaPdicOpService;

    AltaPdicOpController(IAltaPdicOpService iAltaPdicOpService){
        this.iAltaPdicOpService = iAltaPdicOpService;
    }

    @PostMapping("/nuevoPdic1")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<AltaPdicOprResp> altaPdicOperador(@RequestBody AltaPdicOprReq altaPdicOprReq){

        Integer esExitoso;
        try{
            //Validamos el resultado del registro para generar el response
            esExitoso =iAltaPdicOpService.altaPdicOperador(altaPdicOprReq);
            if (esExitoso == 0){
                //El registro Pdic y sus Operadores es exitoso
                return new ResponseEntity<>(AltaPdicOprResp.builder()
                        .estatus(0)
                        .mensaje("Se ha registrado el PDIC y sus Operadores exitosamente")
                        .operadoresRegistrados(altaPdicOprReq.getOperadores().size())
                        .build(), HttpStatus.OK);
            }
            else if(esExitoso == 1){
                return new ResponseEntity<>(AltaPdicOprResp.builder()
                        .estatus(1)
                        .mensaje("El PDIC ya existe")
                        .operadoresRegistrados(0)
                        .build(), HttpStatus.OK);
            }
            else if (esExitoso == 2){
                return new ResponseEntity<>(AltaPdicOprResp.builder()
                        .estatus(2)
                        .mensaje("Ya existen operadores y no se pudieron registrar")
                        .operadoresNoRegistrados(iAltaPdicOpService.listaOperadoresExistentes())
                        .build(), HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(AltaPdicOprResp.builder()
                        .estatus(3)
                        .mensaje("Error al registrar la informacion")
                        .build(), HttpStatus.BAD_REQUEST);
            }
        }catch(DataAccessException ex){
            return new ResponseEntity<AltaPdicOprResp>(AltaPdicOprResp.builder().build(), HttpStatus.NOT_FOUND);
        }
    }
}
