package com.selfassessment.trainingProcess.controller;


import com.selfassessment.trainingProcess.model.TrainingProcessId;
import com.selfassessment.trainingProcess.model.TrainingProcessResult;
import com.selfassessment.trainingProcess.service.TrainingProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/trainingProcesses")
public class TrainingProcessController {

    @Autowired
    TrainingProcessService trainingProcessService;

    @GetMapping()
    public @ResponseBody List<TrainingProcessResult> getTrainingProcesses(){
        return  trainingProcessService.getAll();
    }

    @PostMapping()
    public ResponseEntity<TrainingProcessResult> setTrainingProcess(@RequestBody TrainingProcessResult trainingProcessResult){

        trainingProcessService.saveTrainingProcess(trainingProcessResult.toTrainingProcess());
        return new ResponseEntity(trainingProcessResult, HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<TrainingProcessResult> updateTrainingProcess(@RequestBody TrainingProcessResult trainingProcessResult){

        trainingProcessService.updateTrainingProcess(trainingProcessResult.toTrainingProcess());

        return new ResponseEntity(trainingProcessResult, HttpStatus.OK);
    }

    @DeleteMapping()
    public void deleteTrainingPRocess(@RequestBody TrainingProcessId trainingProcessId){
        trainingProcessService.deleteTrainingProcess(trainingProcessId);
    }
    @GetMapping(path = "/trainingProcess")
    public List<TrainingProcessResult> getTrainingProcessById(@RequestParam(name = "idUsuario") Integer idUser,
                                                                  @RequestParam(name = "idTraining") Integer idTraining){

        return trainingProcessService.getById(new TrainingProcessId(idUser,idTraining));
    }

}
