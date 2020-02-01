package com.psi.programcontent.model;

import com.psi.course.model.CourseForm;
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
@Table(name = "program_content")
public class ProgramContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "lp")
    private Integer lp;
    @Enumerated(EnumType.STRING)
    @Column(name = "course_form")
    private CourseForm courseForm;
    @Column(name = "content")
    private String content;
    @Column(name = "hours_amount")
    private Integer hoursAmount;
    @ManyToOne
    @JoinColumn(name = "subject_card_id")
    private SubjectCard subjectCard;

}
