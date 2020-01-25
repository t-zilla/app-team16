package com.psi.learningoutcome.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ministerial_learning_outcome")
public class MinisterialLearningOutcome extends AbstractLearningOutcome {

    @Enumerated(EnumType.STRING)
    @Column(name = "krk_level")
    private KrkLevel krkLevel;
    @Enumerated(EnumType.STRING)
    @Column(name = "learning_outcome_area")
    private LearningOutcomeArea learningOutcomeArea;
}
