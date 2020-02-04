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

import com.psi.subjectcard.model.SubjectCard;
import com.psi.subject.model.Subject;
import com.psi.subject.model.SubjectLearningArea;
import com.psi.researcher.model.*;
import com.psi.learningoutcome.model.*;
import com.psi.programcontent.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

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

            table.addCell("Kod przedmiotu");
            table.addCell(subject.getCode());
                
            document.add(table);

            int i = 1;
            document.add(new Paragraph(new Text("CELE PRZEDMIOTU").setFontSize(14)));
            for (String s : subjectCard.getObjectives()) {
                document.add(new Paragraph("C" + i + ". " + s));
                i++;
            }

            // document.add(new Paragraph("PRZEDMIOTOWE EFEKTY UCZENIA SIĘ").setFontSize(14));
            // for (SubjectLearningOutcomeAchievement outcome : subjectCard.getSubjectLearningOutcomeAchievements()) {
            //     document.add(new Paragraph(outcome.getSymbol() + " " + outcome.getDescription()));
            // }

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