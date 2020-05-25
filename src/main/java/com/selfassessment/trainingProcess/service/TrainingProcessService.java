package com.selfassessment.trainingProcess.service;

import com.selfassessment.trainingProcess.model.TrainingProcess;
import com.selfassessment.trainingProcess.model.TrainingProcessId;
import com.selfassessment.trainingProcess.model.TrainingProcessResult;
import com.selfassessment.trainingProcess.repository.TrainingProcessRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Log
@Service
public class TrainingProcessService implements  ITrainingProcessService {


    @Autowired
    TrainingProcessRepository trainingProcessRepository;
    @Override
    public void saveTrainingProcess(TrainingProcess trainingProcess) {
        log.info("Save training process");
        trainingProcessRepository.save(trainingProcess);
    }

    @Override
    public List<TrainingProcessResult> getAll() {
        log.info("Getting all TrainingProcess");
        List result = new ArrayList<TrainingProcessResult>();
        trainingProcessRepository.findAll()
                                 .iterator()
                                 .forEachRemaining(trainingProcess -> {
                                    result.add(new TrainingProcessResult(trainingProcess));
                                 });
        return  result;
    }

    @Override
    public List<TrainingProcessResult> getById(TrainingProcessId idTrainingProcess) {
        List<TrainingProcessResult> result = new ArrayList();
        trainingProcessRepository.findByTrainingProcessId(idTrainingProcess)
                                 .forEach(training -> {
                                     result.add(new TrainingProcessResult(training));
                                 });
        return  result;
    }

    @Override
    public void deleteTrainingProcess(TrainingProcessId trainingProcessId) {
        log.info("Deleting trainingProcess by "+trainingProcessId.getIdUser()+ " User id" +
                "and "+ trainingProcessId.getIdTraining()+" Training Id");
        trainingProcessRepository.deleteByTrainingProcessId(trainingProcessId);
    }

    @Override
    public void updateTrainingProcess(TrainingProcess trainingProcess) {
        log.info("Updating trainigProcess with id: "+trainingProcess.toString());
        trainingProcessRepository.save(trainingProcess);
    }
}
