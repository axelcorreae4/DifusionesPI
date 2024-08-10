package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.service.negocio.Impl;

import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.controller.payload.Request.AltaPdicOprReq;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dao.OperadorDao;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dao.PdicDao;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dto.OperadorDto;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.Operador;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.Pdic;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.service.negocio.IAltaPdicOpService;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.service.persistence.IOperadorService;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.service.persistence.IPdicService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AltaPdicOpImplService implements IAltaPdicOpService {



    private @Setter @Getter List<OperadorDto> listaOperadoresExistentes;

    private IOperadorService iOperadorService;
    private IPdicService iPdicService;

    public AltaPdicOpImplService(IOperadorService iOperadorService, IPdicService iPdicService) {
        this.iOperadorService = iOperadorService;
        this.iPdicService = iPdicService;
    }

    @Override
    public List<OperadorDto> operadoresExistentes(List<OperadorDto> listaOperadores) {

        List<OperadorDto> listaOp = new ArrayList<>();
        //validamos si existe un operador, en caso de existir, los guardamos en una lista y los retornamos
        for (int i=0;i<listaOperadores.size();i++){
            if (iOperadorService.existsOperador(listaOperadores.get(i).getIdOperador())){
                listaOp.add(listaOperadores.get(i));
            }
        }
        //En caso de que la lista este vacia se retornara en el servicio [], de lo contraria indicara los operadores existentes
        setListaOperadoresExistentes(listaOp);

        return listaOp;
    }

    @Override
    public List<OperadorDto> listaOperadoresExistentes() {
        return getListaOperadoresExistentes();
    }


    @Override
    public Integer altaPdicOperador(AltaPdicOprReq altaPdicOprReq) {
        Integer registroExitoso = 0;
        //Validamos que el punto de interconexion no exista
        if (!iPdicService.existsPdic(altaPdicOprReq.getPuntoInterconexion().getIdPuntoInterconexion())){
            if (operadoresExistentes(altaPdicOprReq.getOperadores()).isEmpty()){
                //Si no existe el punto de interconexion y ningun id de operador, procedemos a registrar la informacion
                try{
                    //Guardamos en la base el punto de interconexion
                    Pdic pdic = iPdicService.save(altaPdicOprReq.getPuntoInterconexion());
                    if (pdic != null){

                        if (operadoresExistentes(altaPdicOprReq.getOperadores()).isEmpty()){
                            //Si no existe ningun operador, se procede a registrar los operadores.
                            iOperadorService.saveAllOperadores(altaPdicOprReq.getOperadores(),pdic);
                            registroExitoso = 0;
                        }
                        else {
                            //Guardamos en un método los operadores que no se pudieron almacenar
                            registroExitoso = 2;
                        }
                    }
                    else {
                        registroExitoso = 1;
                    }
                }catch (DataAccessException ex){
                    registroExitoso = 3;
                    System.out.println(ex.getMessage());
                }
            }
        }
        return registroExitoso;
    }


    @Override
    public Integer ultimoIdPdic() {
        return 0;
    }

    @Override
    public Integer ultimoIdOperador() {
        return 0;
    }

}
