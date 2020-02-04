package com.psi.term.model;

import com.psi.subjecttoterm.model.SubjectToTerm;
import com.psi.syllabus.model.Syllabus;
import com.psi.term.exception.ZzuLimitException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
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

import static java.text.MessageFormat.format;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "term")
public class Term {

    private static final int MAX_ZZU_AMOUNT = 360;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "allowed_deficit")
    private Integer allowedDeficit;

    @ManyToOne
    @JoinColumn(name = "syllabus_id")
    private Syllabus syllabus;

    @OneToMany(mappedBy = "term", cascade = CascadeType.ALL, orphanRemoval = true)
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

    public void addSubject(SubjectToTerm subjectToTerm) {
        if (subjectToTerm.getSubject().getZzuSum() + zzuSum > MAX_ZZU_AMOUNT) {
            throw new ZzuLimitException(format("Term cannot have more than {0} zzu.", MAX_ZZU_AMOUNT));
        } else {
            subjectToTerms.add(subjectToTerm);
        }
    }

}
