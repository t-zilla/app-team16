package com.psi.pdf;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;

import com.psi.subjectcard.model.*;
import com.psi.subject.model.*;
import com.psi.researcher.model.*;
import com.psi.learningoutcome.model.*;
import com.psi.programcontent.model.*;
import com.psi.course.model.*;
import com.psi.subjecttoterm.model.*;
import com.psi.term.model.*;
import com.psi.syllabus.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;

public class SubjectCardPdfGenerator {

    private static final Logger logger = LoggerFactory.getLogger(SubjectCardPdfGenerator.class);

    public static ByteArrayInputStream generate(SubjectCard subjectCard) {

        ByteArrayOutputStream dest = new ByteArrayOutputStream();

        try {
            PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
            Document document = new Document(pdf);

            PdfFont helvetica = PdfFontFactory.createFont(FontConstants.HELVETICA, "CP1250", true);
            document.setFont(helvetica);

            document.add(new Paragraph(new Text("KARTA PRZEDMIOTU").setFontSize(18)));
            
            Table table = new Table(2).useAllAvailableWidth();
 
            Subject subject = subjectCard.getSubject();
            table.addCell("Nazwa w języku polskim");
            table.addCell(subject.getPolishName());

            table.addCell("Nazwa w języku angielskim");
            table.addCell(subject.getEnglishName());

            HashSet<String> studyDegrees = new HashSet();
            HashSet<String> specialities = new HashSet();
            String form = "";
            String degree = "";
            String mandatory = "";
    
            for (SubjectToTerm stt : subject.getSubjectToTerms()) {
                if (stt.getObligatory()) {
                    mandatory = "obowiązkowy";
                } else {
                    mandatory = "nieobowiązkowy";
                }
                if (stt.getTerm() != null) {
                    Syllabus syllabus = stt.getTerm().getSyllabus();
                    if (syllabus.getDegreeCourse() != null) {
                        studyDegrees.add(syllabus.getDegreeCourse().getName());
                    }
                    if (syllabus.getSpeciality() != null) {
                        studyDegrees.add(syllabus.getSpeciality().getName());
                    }
                    if (syllabus.getStudyForm() == StudyForm.STATIONARY) {
                        form = "stacjonarna";
                    } else if  (syllabus.getStudyForm() == StudyForm.EXTRAMURAL) {
                        form = "niestacjonarna";
                    }
                    if (syllabus.getStudyDegree() == StudyDegree.FIRST_DEGREE) {
                        form = "1";
                    } else if  (syllabus.getStudyDegree() == StudyDegree.SECOND_DEGREE) {
                        form = "2";
                    } else if  (syllabus.getStudyDegree() == StudyDegree.THIRD_DEGREE) {
                        form = "3";
                    } else if  (syllabus.getStudyDegree() == StudyDegree.UNIFORM_MASTER_DEGREE) {
                        form = "jednolite magisterskie";
                    }
                }
            }
            
            table.addCell("Kierunek studiów (jeśli dotyczy)");
            table.addCell(String.join(", ", studyDegrees));

            table.addCell("Specjalność (jeśli dotyczy)");
            table.addCell(String.join(", ", specialities));

            table.addCell("Stopień i forma studiów");
            table.addCell(degree + " " + form);

            table.addCell("Rodzaj przedmiotu");
            table.addCell(mandatory);
                
            table.addCell("Kod przedmiotu");
            table.addCell(subject.getCode());

            document.add(table);

            ArrayList<String> lecture = new ArrayList();
            ArrayList<String> excercise = new ArrayList();
            ArrayList<String> lab = new ArrayList();
            ArrayList<String> project = new ArrayList();
            ArrayList<String> seminar = new ArrayList();

            for (Course course : subject.getCourses()) {
                ArrayList list;
                if (course.getCourseForm() == CourseForm.LECTURE) {
                    list = lecture;
                } else if (course.getCourseForm() == CourseForm.EXCERCISE) {
                    list = excercise;
                } else if (course.getCourseForm() == CourseForm.LABORATORY) {
                    list = lab;
                } else if (course.getCourseForm() == CourseForm.PROJECT) {
                    list = project;
                } else if (course.getCourseForm() == CourseForm.SEMINAR) {
                    list = seminar;
                } else {
                    continue;
                }

                list.add(course.getZzu().toString());
                list.add(course.getCnps().toString());

                if (course.getCreditForm() == CreditForm.EXAM) {
                    list.add("egzamin");
                } else if (course.getCreditForm() == CreditForm.CREDIT) {
                    list.add("zaliczenie na ocenę");
                } else {
                    list.add("");
                }

                if (course.getFinalCourse()) {
                    list.add("X");
                } else {
                    list.add("");
                }

                list.add(course.getEcts().toString());
            }

            table = new Table(6).useAllAvailableWidth();
            table.addCell("");
            table.addCell("Wykład");
            table.addCell("Ćwiczenia");
            table.addCell("Laboratorium");
            table.addCell("Projekt");
            table.addCell("Seminarium");

            ArrayList<String> legend = new ArrayList(Arrays.asList(
                "Liczba godzin zajęć zorganizowanych w uczelni (ZZU)",
                "Liczba godzin całkowitego nakładu pracy na studenta (CNPS)",
                "Forma zaliczenia",
                "Dla grupy kursów zaznaczyć kurs końcowy (X)",
                "Liczba punktów ECTS"
            ));

            for (int row = 0; row < legend.size(); row++) {
                table.addCell(legend.get(row));
                table.addCell(lecture.size() > row ? lecture.get(row) : "");
                table.addCell(excercise.size() > row ? excercise.get(row) : "");
                table.addCell(lab.size() > row ? lab.get(row) : "");
                table.addCell(project.size() > row ? project.get(row) : "");
                table.addCell(seminar.size() > row ? seminar.get(row) : "");
            }

            document.add(table);

            int i = 1;
            document.add(new Paragraph(new Text("WYMAGANIA WSTĘPNE").setFontSize(14)));
            for (String s : subjectCard.getEntryRequirements()) {
                document.add(new Paragraph("" + i + ". " + s));
                i++;
            }
        
            i = 1;
            document.add(new Paragraph(new Text("CELE PRZEDMIOTU").setFontSize(14)));
            for (String s : subjectCard.getObjectives()) {
                document.add(new Paragraph("C" + i + ". " + s));
                i++;
            }

            document.add(new Paragraph("PRZEDMIOTOWE EFEKTY UCZENIA SIĘ").setFontSize(14));
            for (SubjectLearningOutcomeAchievement achievement : subjectCard.getSubjectLearningOutcomeAchievements()) {
                SubjectLearningOutcome outcome = achievement.getSubjectLearningOutcome();
                document.add(new Paragraph(outcome.getSymbol() + " " + outcome.getDescription()));
            }

            i = 1;
            document.add(new Paragraph(new Text("STOSOWANE NARZĘDZIA DYDAKTYCZNE").setFontSize(14)));
            for (String s : subjectCard.getTeachingTools()) {
                document.add(new Paragraph("N" + i + ". " + s));
                i++;
            }

            i = 1;
            document.add(new Paragraph("LITERATURA PODSTAWOWA"));
            for (String s : subjectCard.getBasicLiterature()) {
                document.add(new Paragraph("" + i + ". " + s));
                i++;
            }

            i = 1;
            document.add(new Paragraph("LITERATURA UZUPEŁNIAJĄCA"));
            for (String s : subjectCard.getSupplementaryLiterature()) {
                document.add(new Paragraph("" + i + ". " + s));
                i++;
            }

            document.add(new Paragraph(new Text("OPIEKUN PRZEDMIOTU").setFontSize(14)));
            Researcher researcher = subject.getResearcher();

            if (researcher != null) {
                String prefix = "";

                if (researcher.getAcademicDegree() == AcademicDegree.DOCTOR) {
                    prefix = "Dr ";
                }

                document.add(new Paragraph(prefix + researcher.getFirstName() + ' ' + researcher.getLastName()));
            } else {
                document.add(new Paragraph("brak"));
            }

            document.close();
        } catch (Exception ex) {

            logger.error("Error occurred: {0}", ex);
        }
        
        return new ByteArrayInputStream(dest.toByteArray());
    }
}