package com.selfassessment.trainingProcess.service;

import com.selfassessment.trainingProcess.model.TrainingProcess;
import com.selfassessment.trainingProcess.model.TrainingProcessId;
import com.selfassessment.trainingProcess.model.TrainingProcessResult;

import java.util.List;


public interface ITrainingProcessService {

    void saveTrainingProcess(TrainingProcess trainingProcess);
    List<TrainingProcessResult> getAll();
    List<TrainingProcessResult> getById(TrainingProcessId idTrainingProcess);
    void deleteTrainingProcess(TrainingProcessId idTrainingProcess);
    void updateTrainingProcess(TrainingProcess trainingProcess);
}
