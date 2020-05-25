package com.selfassessment.trainingProcess.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class TrainingProcessId implements Serializable {

    private Integer idUser;
    private Integer idTraining;

    public TrainingProcessId(Integer idUser,Integer idTraining){
        this.idTraining = idTraining;
        this.idUser = idUser;
    }

}
