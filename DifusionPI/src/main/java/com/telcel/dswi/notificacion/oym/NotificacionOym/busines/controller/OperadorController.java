package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.controller;

import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dto.OperadorDto;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.Operador;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.controller.payload.Response.MensajeResponse;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.service.persistence.IOperadorService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/identidad/operador")
public class OperadorController {

    private IOperadorService iOperadorService;

    public OperadorController(IOperadorService iOperadorService){
        this.iOperadorService = iOperadorService;
    }

    @PostMapping("/nuevoOperador")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createOperador(@RequestBody OperadorDto operadorDto){
        Operador operadorSave = null;

        try{
            operadorSave = iOperadorService.save(operadorDto);
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Registro exitoso")
                    .objectc(operadorSave)
                    .status(1).build(),HttpStatus.OK);
        }catch (DataAccessException ex){
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("No se pudo registrar el operador")
                    .objectc(null)
                    .status(2).build(), HttpStatus.OK);
        }
    }
}
