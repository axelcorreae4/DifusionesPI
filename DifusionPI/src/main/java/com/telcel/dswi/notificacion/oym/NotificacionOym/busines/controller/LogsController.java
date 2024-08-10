package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.controller;

import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.controller.payload.Response.MensajeResponse;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dto.log.LogOperadorDto;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.log.LogOperador;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.service.persistence.ILogsService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/identidad")
public class LogsController {

    private ILogsService iLogsService;

    public LogsController(ILogsService iLogsService) {
        this.iLogsService = iLogsService;
    }

    @PostMapping("/nuevoLogOperador")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> altaLogOperador(@RequestBody LogOperadorDto logOperadorDto){
        LogOperador logOperador = null;

        try{
            logOperador = iLogsService.saveLogOperador(logOperadorDto);
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Se registro con exito en el Log del operador")
                    .status(1)
                    .objectc(logOperador)
                    .build(), HttpStatus.OK);
        }catch (DataAccessException ex){
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("No se pudo registrar en el log del operador")
                    .status(2)
                    .objectc(null)
                    .build(), HttpStatus.OK);
        }
    }
}
