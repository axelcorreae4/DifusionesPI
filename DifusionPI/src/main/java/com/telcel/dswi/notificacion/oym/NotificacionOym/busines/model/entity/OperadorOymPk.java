package com.telcel.dswi.notificacion.oym.NotificacionOym.busines.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Embeddable
public class OperadorOymPk implements Serializable {

    @Column(name = "IDOPERADOR", nullable = false)
    private Integer idOperador;
    @Column(name = "IDPDIC", nullable = false)
    private Integer idPdic;
}
