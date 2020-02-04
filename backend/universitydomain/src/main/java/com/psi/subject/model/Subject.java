package com.psi.subject.model;

import com.psi.course.model.Course;
import com.psi.researcher.model.Researcher;
import com.psi.subjectcard.model.SubjectCard;
import com.psi.subjecttoterm.model.SubjectToTerm;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

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

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubjectToTerm> subjectToTerms;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Course> courses;

    @Transient
    private int ectsSum;

    @Transient
    private int cnpsSum;

    @Transient
    private int zzuSum;

    @PostLoad
    private void computeDerived() {
        int ectsSum = 0, cnpsSum = 0, zzuSum = 0;
        for (Course course : courses) {
            ectsSum += course.getEcts();
            cnpsSum += course.getCnps();
            zzuSum += course.getZzu();
        }
        setCnpsSum(cnpsSum);
        setEctsSum(ectsSum);
        setZzuSum(zzuSum);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", polishName='" + polishName + '\'' +
                ", englishName='" + englishName + '\'' +
                ", subjectLearningArea=" + subjectLearningArea +
                ", ectsSum=" + ectsSum +
                ", cnpsSum=" + cnpsSum +
                ", zzuSum=" + zzuSum +
                '}';
    }
}
