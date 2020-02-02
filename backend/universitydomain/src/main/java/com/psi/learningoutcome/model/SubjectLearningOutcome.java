package com.psi.learningoutcome.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "subject_learning_outcome")
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SubjectLearningOutcome extends AbstractLearningOutcome {
}
