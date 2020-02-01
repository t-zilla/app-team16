package com.psi.course.model;

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
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "zzu")
    private Integer zzu;
    @Column(name = "cnps")
    private Integer cnps;
    @Column(name = "ects")
    private Integer ects;
    @Enumerated(EnumType.STRING)
    @Column(name = "credit_form")
    private CreditForm creditForm;
    @Column(name = "final_course")
    private Boolean finalCourse;
    @Enumerated(EnumType.STRING)
    @Column(name = "course_form")
    private CourseForm courseForm;
    @Column(name = "hours_weekly")
    private Integer hoursWeekly;
    @Enumerated(EnumType.STRING)
    @Column(name = "language_level")
    private LanguageLevel languageLevel;
    @ManyToOne
    @JoinColumn(name = "leading_course_id")
    private Course leadingCourse;
}
