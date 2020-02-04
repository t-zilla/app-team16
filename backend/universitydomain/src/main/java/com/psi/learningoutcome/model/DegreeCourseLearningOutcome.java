package com.psi.learningoutcome.model;

import com.psi.syllabus.model.Syllabus;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "degree_course_learning_outcome")
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DegreeCourseLearningOutcome extends AbstractLearningOutcome {

    @ManyToMany
    @JoinTable(name = "degree_course_lo_to_ministerial_lo",
            joinColumns = @JoinColumn(name = "degree_course_learning_outcome_id"),
            inverseJoinColumns = @JoinColumn(name = "ministerial_learning_outcome_id"))
    private List<MinisterialLearningOutcome> ministerialLearningOutcomes;

    @ManyToMany
    @JoinTable(name = "degree_course_lo_to_subject_lo",
            joinColumns = @JoinColumn(name = "degree_course_learning_outcome_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_learning_outcome_id"))
    private List<SubjectLearningOutcome> subjectLearningOutcomes;

    @ManyToOne
    @JoinColumn(name = "syllabus_id")
    private Syllabus syllabus;

    @Override
    public String toString() {
        return "DegreeCourseLearningOutcome{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", description='" + description + '\'' +
                ", learningOutcomeType=" + learningOutcomeType +
                '}';
    }
}
