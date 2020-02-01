import Subject from '../models/Subject';
import { SubjectLearningArea, StudyDegree, FormOfStudy, LearningProfile } from '../models/enum-types/EnumerationTypes';
import { ProfessionalTitle } from '../models/enum-types/ProfessionalTitle';
import { LanguageOfStudy } from '../models/enum-types/LanguageOfStudy';
import { LearningOutcomeType } from '../models/enum-types/LearningOutcomeType';
import SubjectLearningOutcome from '../models/SubjectLearningOutcome';
import MinisterialLearningOutcome from '../models/MinisterialLearningOutcome';
import DegreeCourseLearningOutcome from '../models/DegreeCourseLearningOutcome';
import { ProgramContent } from '../models/ProgramContent';
import Faculty from '../models/Faculty';
import Lecturer from '../models/Lecturer';
import Syllabus from '../models/Syllabus';

export function GetMockedSubjects(): Subject[] {
    return [
        new Subject("0xswe2", "Informatyka", "Computer science", SubjectLearningArea.InformationTechnology, 5, 10, 10),
        new Subject("1awed4", "Analiza matematyczna", "Methematical analysis", SubjectLearningArea.Math, 6, 10, 10),
        new Subject("1wae21", "Analiza matematyczna", "Methematical analysis", SubjectLearningArea.Math, 6, 10, 10),
        new Subject("221wwe", "Analiza matematyczna", "Methematical analysis", SubjectLearningArea.Math, 6, 10, 10),
        new Subject("221wwe", "Analiza matematyczna", "Methematical analysis", SubjectLearningArea.Math, 6, 10, 10),
        new Subject("221wwe", "Analiza matematyczna", "Methematical analysis", SubjectLearningArea.Math, 6, 10, 10)
    ];
};

export function GetMockedSubjectLearningOutcomes(): SubjectLearningOutcome[] {
    return [
        new SubjectLearningOutcome("PEK0", LearningOutcomeType.Knowledge, "PEK0 - opis"),
        new SubjectLearningOutcome("PEK1", LearningOutcomeType.Knowledge, "PEK1 - opis"),
        new SubjectLearningOutcome("PEK2", LearningOutcomeType.Knowledge, "PEK2 - opis")
    ];
};

export function GetMockedMinisterialLearningOutcomes(): MinisterialLearningOutcome[] {
    return [
        new MinisterialLearningOutcome("MEK0", LearningOutcomeType.Skills, "MEK0 - opis"),
        new MinisterialLearningOutcome("MEK1", LearningOutcomeType.Skills, "MEK1 - opis"),
        new MinisterialLearningOutcome("MEK2", LearningOutcomeType.Skills, "MEK2 - opis")
    ];
};

export function GetMockedDegreeCourseLearningOutcomes(): DegreeCourseLearningOutcome[] {
    return [
        new DegreeCourseLearningOutcome("DEK0", LearningOutcomeType.SocialCompetences, "DEK0 - opis"),
        new DegreeCourseLearningOutcome("DEK2", LearningOutcomeType.SocialCompetences, "DEK1 - opis"),
        new DegreeCourseLearningOutcome("DEK1", LearningOutcomeType.SocialCompetences, "DEK2 - opis")
    ];
};

export function GetMockedFaculties(): Faculty[] {
    return [
        new Faculty("Informatyka", LanguageOfStudy.Polish),
        new Faculty("Computer Science", LanguageOfStudy.English),
        new Faculty("Architecture", LanguageOfStudy.English)
    ];
};

export function GetMockedLecturers(): Lecturer[] {
    return [
        new Lecturer("Jan", "Kowalski"),
        new Lecturer("Stefan", "Kowalski"),
        new Lecturer("Jarosław", "Malina"),
        new Lecturer("Agnieszka", "Sęp")
    ];
};

export function GetMockedSyllabuses(): Syllabus[] {
    return [
        new Syllabus("W8 - Informatyka", new Date(), StudyDegree.FirstDegree, FormOfStudy.Stationary, LearningProfile.Practical, 
            7, "Matura z informatyki", ProfessionalTitle.BachelorOfEngineering, "Egzamin", "Potrafi w komputery", 210, 210, 210, 1, false),
        new Syllabus("W4 - Informatyka", new Date(), StudyDegree.FirstDegree, FormOfStudy.Stationary, LearningProfile.Practical, 
            7, "Matura z informatyki", ProfessionalTitle.BachelorOfEngineering, "Egzamin", "Potrafi w komputery", 420, 210, 210, 2, false)
    ];
};

export function GetMockedProgram(): ProgramContent[] {
    return [
        
    ];
};