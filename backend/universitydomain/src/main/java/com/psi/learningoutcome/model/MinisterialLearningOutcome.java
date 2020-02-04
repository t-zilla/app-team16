package com.psi.learningoutcome.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "ministerial_learning_outcome")
public class MinisterialLearningOutcome extends AbstractLearningOutcome {

    @Enumerated(EnumType.STRING)
    @Column(name = "krk_level")
    private KrkLevel krkLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "learning_outcome_area")
    private LearningOutcomeArea learningOutcomeArea;

    @Override
    public String toString() {
        return "MinisterialLearningOutcome{" +
                "krkLevel=" + krkLevel +
                ", learningOutcomeArea=" + learningOutcomeArea +
                ", id=" + id +
                ", symbol='" + symbol + '\'' +
                ", description='" + description + '\'' +
                ", learningOutcomeType=" + learningOutcomeType +
                '}';
    }
}
