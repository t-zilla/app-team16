package com.psi.degreecourse.model;

import com.psi.speciality.model.Speciality;
import com.psi.syllabus.model.Syllabus;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "degree_course")
public class DegreeCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "study_language")
    private StudyLanguage studyLanguage;

    @OneToMany(mappedBy = "degreeCourse", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Speciality> specialities;

    @OneToMany(mappedBy = "degreeCourse", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Syllabus> syllabuses;

    @Override
    public String toString() {
        return "DegreeCourse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studyLanguage=" + studyLanguage +
                '}';
    }
}
