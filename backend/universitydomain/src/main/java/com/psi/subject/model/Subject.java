package com.psi.subject.model;

import com.psi.researcher.model.Researcher;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Data
@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "polish_name")
    private String polishName;
    @Column(name = "english_name")
    private String englishName;
    @Enumerated(EnumType.STRING)
    @Column(name = "subject_learning_area")
    private SubjectLearningArea subjectLearningArea;
    @OneToOne(mappedBy = "subject")
    private SubjectCard subjectCard;
    @ManyToOne
    @JoinColumn(name = "researcher_id")
    private Researcher researcher;
    @Transient
    private int ectsSum;
    @Transient
    private int cnpsSum;
    @Transient
    private int zzuSum;
}
