package com.psi.term.model;

import com.psi.subjecttoterm.model.SubjectToTerm;
import com.psi.syllabus.model.Syllabus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "term")
public class Term {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "allowed_deficit")
    private Integer allowedDeficit;

    @ManyToOne
    @JoinColumn(name = "syllabus_id")
    private Syllabus syllabus;

    @OneToMany(mappedBy = "term", orphanRemoval = true)
    private List<SubjectToTerm> subjectToTerms;

    @Transient
    private int ectsSum;

    @Transient
    private int zzuSum;

    @Transient
    private int cnpsSum;

    @PostLoad
    private void computeDerived() {
        int ectsSum = 0, cnpsSum = 0, zzuSum = 0;
        for (SubjectToTerm subjectToTerm : subjectToTerms) {
            ectsSum += subjectToTerm.getSubject().getEctsSum();
            cnpsSum += subjectToTerm.getSubject().getCnpsSum();
            zzuSum += subjectToTerm.getSubject().getZzuSum();
        }
        setCnpsSum(cnpsSum);
        setEctsSum(ectsSum);
        setZzuSum(zzuSum);
    }

}
