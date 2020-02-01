package com.psi.learningoutcome.model;

import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "subject_learning_outcome")
@SuperBuilder
public class SubjectLearningOutcome extends AbstractLearningOutcome {
}
