package com.psi.learningoutcome.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class AbstractLearningOutcome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;
    @Column(name = "symbol")
    protected String symbol;
    @Column(name = "description")
    protected String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "learning_outcome_type")
    protected LearningOutcomeType learningOutcomeType;
}
