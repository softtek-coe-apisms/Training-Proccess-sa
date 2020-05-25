package com.selfassessment.trainingProcess.repository;

import com.selfassessment.trainingProcess.model.TrainingProcess;
import com.selfassessment.trainingProcess.model.TrainingProcessId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingProcessRepository extends CrudRepository<TrainingProcess,Integer> {
    List<TrainingProcess> findByTrainingProcessId(TrainingProcessId trainingProcessId);
    void  deleteByTrainingProcessId(TrainingProcessId trainingProcessId);
}
