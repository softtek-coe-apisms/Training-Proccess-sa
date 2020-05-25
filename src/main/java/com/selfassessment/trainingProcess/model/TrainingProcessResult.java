package com.selfassessment.trainingProcess.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingProcessResult {

    private Integer idUser;
    private Integer idTraining;
    private boolean isCompleted;

    public TrainingProcessResult(TrainingProcess trainingProcess){
        idUser = trainingProcess.getTrainingProcessId().getIdUser();
        idTraining = trainingProcess.getTrainingProcessId().getIdTraining();
        isCompleted = trainingProcess.getIsCompleted() == 1 ?  true :  false;
    }

    public TrainingProcess toTrainingProcess(){
        return  new TrainingProcess(new TrainingProcessId(this.idUser,this.idTraining),this.isCompleted == true ? (byte)1: 0 );
    }


}
