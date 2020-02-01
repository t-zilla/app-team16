package com.psi.learningoutcome.model;

import com.psi.subjectcard.model.SubjectCard;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "subject_learning_outcome_achievement")
public class SubjectLearningOutcomeAchievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "achievement_type")
    private AchievementType achievementType;

    @ManyToOne
    @JoinColumn(name = "subject_card_id")
    private SubjectCard subjectCard;

    @ManyToOne
    @JoinColumn(name = "subject_learning_outcome_id")
    private SubjectLearningOutcome subjectLearningOutcome;

}
