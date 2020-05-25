package com.selfassessment.trainingProcess.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "trainingProcess")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TrainingProcess {

    @EmbeddedId
    private TrainingProcessId trainingProcessId;

    @Column
    private Byte isCompleted;


}
