package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.service.persistence.Impl;

import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dao.OperadorDao;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.dto.OperadorDto;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.Operador;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.OperadorOymPk;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity.Pdic;
import com.telcel.dswi.notificacion.oym.NotificacionOym.busines.service.persistence.IOperadorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OperadorImplService implements IOperadorService {

    private OperadorDao operadorDao;
    private ModelMapper modelMapper;

    public OperadorImplService (OperadorDao operadorDao, ModelMapper modelMapper){
        this.modelMapper = modelMapper;
        this.operadorDao = operadorDao;
    }

    @Transactional
    @Override
    public Operador save(OperadorDto operadorDto) {
        Operador operador = Operador.builder()
                .idPk(new OperadorOymPk(1,2))
                .nombre(operadorDto.getNombreOperador())
                .descripcion(operadorDto.getDescripcionOperador())
                .idServicio(operadorDto.getIdServicioOperador())

                .build();

        return operadorDao.save(operador);
    }

    @Override
    public OperadorDto findById(Integer id) {
        OperadorDto operadorDto = null;

        //Buscamos si existe el operador
        Operador operador = operadorDao.findById(id).orElse(null);

        if(operador != null){
            operadorDto = OperadorDto.builder()
                    
        }
        return operadorDto;
    }

    @Override
    public List<Operador> listaOperadores() {
        return operadorDao.findAll();
    }

    @Override
    public Boolean existsOperador(Integer id) {
        return operadorDao.existsById(id);
    }


    @Override
    public List<Operador> saveAllOperadores(List<OperadorDto> listaOperadores, Pdic pdic) {

        //Convertirmos los DTO a al modelo base
        /*
        List<Operador> listaOp = listaOperadores.stream()
                .map(this::operadorDtoToOperador)
                .collect(Collectors.toList());*/

        System.out.println("Lista OperadoresDTO: " + listaOperadores.toString() + "\n Pdic: " + pdic.toString());
        List<Operador> listaOp = new ArrayList<>();

        for (int i=0;i<listaOperadores.size();i++){
            Operador operador = new Operador();
            operador.setIdOperador(listaOperadores.get(i).getIdOperador());
            operador.setNombre(listaOperadores.get(i).getNombreOperador());
            operador.setDescripcion(listaOperadores.get(i).getDescripcionOperador());
            operador.setIdServicio(listaOperadores.get(i).getIdServicioOperador());
            operador.setIdPdic(pdic.getIdPdic());

            listaOp.add(operador);
        }

        return operadorDao.saveAll(listaOp);
    }

    public Operador operadorDtoToOperador(OperadorDto operadorDto) {
        return modelMapper.map(operadorDto, Operador.class);
    }
}
