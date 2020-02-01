package com.psi.subjectcard.model;

import com.psi.converter.StringListConverter;
import com.psi.learningoutcome.model.SubjectLearningOutcomeAchievement;
import com.psi.programcontent.model.ProgramContent;
import com.psi.subject.model.Subject;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "subject_card")
public class SubjectCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "objectives")
    @Convert(converter = StringListConverter.class)
    private List<String> objectives;

    @Column(name = "entry_requirements")
    @Convert(converter = StringListConverter.class)
    private List<String> entryRequirements;

    @Column(name = "teaching_tools")
    @Convert(converter = StringListConverter.class)
    private List<String> teachingTools;

    @Column(name = "basic_literature")
    @Convert(converter = StringListConverter.class)
    private List<String> basicLiterature;

    @Column(name = "supplementary_literature")
    @Convert(converter = StringListConverter.class)
    private List<String> supplementaryLiterature;

    @OneToMany(mappedBy = "subjectCard", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProgramContent> programContents;

    @OneToMany(mappedBy = "subjectCard", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubjectLearningOutcomeAchievement> subjectLearningOutcomeAchievements;
}
