package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.controller;

import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dto.DifusionOYMDto;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.DifusionOYM;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.controller.payload.Response.MensajeResponse;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.service.persistence.IDifusionOYMService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/identidad")
public class OperacionDifusionController {

    private IDifusionOYMService iDifusionOYMService;

    public OperacionDifusionController(IDifusionOYMService iDifusionOYMService){
        this.iDifusionOYMService = iDifusionOYMService;
    }

    @PostMapping("/nuevaDifusion")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createDif (@RequestBody DifusionOYMDto difDto){
        System.out.println("Datos que llegan: " + difDto.toString());
        DifusionOYM difusionSave = null;

        try{
            difusionSave = iDifusionOYMService.save(difDto);
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Registro almacenado")
                    .status(1)
                    .build(),HttpStatus.OK);

        }catch(DataAccessException ex){
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Registro no almacenado")
                    .status(2)
                    .build(),HttpStatus.OK);
        }
    }

    @GetMapping("/consulta")
    @ResponseStatus(HttpStatus.OK)
    public List<DifusionOYM> listaDifusiones(){
        return iDifusionOYMService.listaDifusionOym();
    }

    @GetMapping("/buscarDif/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> buscarPorFolio(@PathVariable String id){
        DifusionOYMDto difusionOYMDto = iDifusionOYMService.findById(id);

        if (difusionOYMDto == null){
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("No existe la difusión")
                    .status(2)
                    .build(), HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Busqueda exitosa")
                    .objectc(difusionOYMDto)
                    .status(1)
                    .build(),HttpStatus.OK);
        }
    }

    @PutMapping("/actualizaDif/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> actualizaDifusion(@RequestBody DifusionOYMDto difusionOYMDto, @PathVariable String id){
        DifusionOYM difusionOYM = null;

        try{
            //Buscamos si existe el folio o difusion
            if (iDifusionOYMService.existsDif(id)){
                //Seteamos el id en el modelo para asegurar que no mande otro por el body
                difusionOYMDto.setIdMensaje(id);
                //Guardamos los cambios
                iDifusionOYMService.save(difusionOYMDto);

                return new ResponseEntity<>(MensajeResponse.builder()
                        .mensaje("Registro actualizado de manera correcta")
                        .objectc(difusionOYMDto)
                        .status(1).build(),HttpStatus.CREATED);
            }
            else {
                return new ResponseEntity<>(MensajeResponse.builder()
                        .mensaje("No se pudo actualizar el registro")
                        .objectc(null)
                        .status(2).build(),HttpStatus.NOT_FOUND);
            }
        }catch (DataAccessException exData){
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje(exData.getMessage())
                    .objectc(null)
                    .status(2),HttpStatus.METHOD_NOT_ALLOWED);
        }
    }
}
