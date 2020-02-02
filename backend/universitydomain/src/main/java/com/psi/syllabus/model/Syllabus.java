package com.psi.syllabus.model;

import com.psi.converter.StringListConverter;
import com.psi.degreecourse.model.DegreeCourse;
import com.psi.learningoutcome.model.DegreeCourseLearningOutcome;
import com.psi.speciality.model.Speciality;
import com.psi.term.model.Term;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "syllabus")
public class Syllabus {

    private static final int MAX_TERM_AMOUNT = 7;
    private static final int MAX_EXTENDED_TERM_AMOUNT = 8;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "study_degree")
    private StudyDegree studyDegree;

    @Enumerated(EnumType.STRING)
    @Column(name = "study_form")
    private StudyForm studyForm;

    @Column(name = "learning_profile")
    @Enumerated(EnumType.STRING)
    private LearningProfile learningProfile;

    @Column(name = "term_amount")
    private Integer termAmount;

    @Column(name = "entry_requirements")
    private String entryRequirements;

    @Enumerated(EnumType.STRING)
    @Column(name = "professional_title")
    private ProfessionalTitle professionalTitle;

    @Column(name = "graduation_form")
    private String graduationForm;

    @Column(name = "graduate_silhouette")
    private String graduateSilhouette;

    @Column(name = "cnps_multiplier")
    private Integer cnpsMultiplier;

    @Column(name = "extended_term_amount")
    private Boolean extendedTermAmount;

    @Column(name = "exam_issues")
    @Convert(converter = StringListConverter.class)
    private List<String> examIssues;

    @ManyToOne
    @JoinColumn(name = "degree_course_id")
    private DegreeCourse degreeCourse;

    @ManyToOne
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;

    @OneToMany(mappedBy = "syllabus", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Term> terms;

    @OneToMany(mappedBy = "syllabus", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DegreeCourseLearningOutcome> degreeCourseLearningOutcomes;

    @Transient
    private Integer cnpsSum;

    @Transient
    private Integer ectsSum;

    @Transient
    private Integer zzuSum;

    @PostLoad
    private void computeDerived() {
        int ectsSum = 0, cnpsSum = 0, zzuSum = 0;
        for (Term term : terms) {
            ectsSum += term.getEctsSum();
            cnpsSum += term.getCnpsSum();
            zzuSum += term.getZzuSum();
        }
        setCnpsSum(cnpsSum);
        setEctsSum(ectsSum);
        setZzuSum(zzuSum);
    }


}
