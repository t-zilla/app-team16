import Subject from '../models/Subject';
import { LearningProfile } from '../models/enum-types/LearningProfile';
import { StudyDegree } from '../models/enum-types/StudyDegree';
import { SubjectLearningArea } from '../models/enum-types/SubjectLearningArea';
import { FormOfStudy } from '../models/enum-types/FormOfStudy';
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
        new Subject(0, "0xswe2", "Informatyka", "Computer science", SubjectLearningArea.InformationTechnology, 5, 10, 10),
        new Subject(1, "1awed4", "Analiza matematyczna", "Methematical analysis", SubjectLearningArea.Math, 6, 10, 10),
        new Subject(2, "1wae21", "Analiza matematyczna", "Methematical analysis", SubjectLearningArea.Math, 6, 10, 10),
        new Subject(3, "221wwe", "Analiza matematyczna", "Methematical analysis", SubjectLearningArea.Math, 6, 10, 10),
        new Subject(4, "221wwe", "Analiza matematyczna", "Methematical analysis", SubjectLearningArea.Math, 6, 10, 10),
        new Subject(6, "221wwe", "Analiza matematyczna", "Methematical analysis", SubjectLearningArea.Math, 6, 10, 10)
    ];
};

export function GetMockedSubjectLearningOutcomes(): SubjectLearningOutcome[] {
    return [
        new SubjectLearningOutcome(0, "PEK0", LearningOutcomeType.Knowledge, "PEK0 - opis"),
        new SubjectLearningOutcome(1, "PEK1", LearningOutcomeType.Knowledge, "PEK1 - opis"),
        new SubjectLearningOutcome(2, "PEK2", LearningOutcomeType.Knowledge, "PEK2 - opis")
    ];
};

export function GetMockedMinisterialLearningOutcomes(): MinisterialLearningOutcome[] {
    return [
        new MinisterialLearningOutcome(0, "MEK0", LearningOutcomeType.Skills, "MEK0 - opis"),
        new MinisterialLearningOutcome(1, "MEK1", LearningOutcomeType.Skills, "MEK1 - opis"),
        new MinisterialLearningOutcome(2, "MEK2", LearningOutcomeType.Skills, "MEK2 - opis")
    ];
};

export function GetMockedDegreeCourseLearningOutcomes(): DegreeCourseLearningOutcome[] {
    return [
        new DegreeCourseLearningOutcome(0, "DEK0", LearningOutcomeType.SocialCompetences, "DEK0 - opis"),
        new DegreeCourseLearningOutcome(1, "DEK2", LearningOutcomeType.SocialCompetences, "DEK1 - opis"),
        new DegreeCourseLearningOutcome(2, "DEK1", LearningOutcomeType.SocialCompetences, "DEK2 - opis")
    ];
};

export function GetMockedFaculties(): Faculty[] {
    return [
        new Faculty(0, "Informatyka", LanguageOfStudy.Polish),
        new Faculty(1, "Computer Science", LanguageOfStudy.English),
        new Faculty(2, "Architecture", LanguageOfStudy.English)
    ];
};

export function GetMockedLecturers(): Lecturer[] {
    return [
        new Lecturer(0, "Jan", "Kowalski"),
        new Lecturer(1, "Stefan", "Kowalski"),
        new Lecturer(2, "Jarosław", "Malina"),
        new Lecturer(3, "Agnieszka", "Sęp")
    ];
};


const exampleSyllabusExamIssues: string[] = [
    "Paradygmaty programowania obiektowego",
    "Arytmetyka stało- i zmiennoprzecinkowa",
    "Normalizacja schematu bazy danych",
    "Model warstwowy TCP/IP",
    "Ocena złożoności algorytmów",
    "Język UML w projektowaniu oprogramowania",
    "Generowanie realistycznych obrazów scen 3-D za pomocą metody śledzenia promieni",
    "Mechanizmy systemu operacyjnego wspomagające synchronizację procesów",
    "9. Programowalne scalone układy cyfrowe PLD, CPLD oraz FPGA",
    "Optyczne nośniki informacji"
];

const exampleSyllabusGraduateSihouette: string = `Absolwent specjalności posiada wiedzę i umiejętności
z zakresu ogólnych zagadnień informatyki. Posiada
umiejętności obejmujące: zasady budowy współczesnych
komputerów i urządzeń z nimi współpracujących,
systemów operacyjnych, sieci komputerowych, baz
danych, programowania komputerów, inżynierii
oprogramowania, sztucznej inteligencji, grafiki
komputerowej, komunikacji człowiek-komputer oraz
konstruowania urządzeń cyfrowych. Absolwent jest
przygotowany do samodzielnego rozwiązywania
problemów informatycznych oraz do pracy w zespołach
programistycznych. Ponadto absolwent tej specjalności
wyróżnia się znajomością zagadnień projektowania
lokalnych i rozległych sieci komputerowych ze
szczególnym uwzględnieniem technik światłowodowych
i zagadnień bezpieczeństwa, zagadnień projektowania
systemów informatycznych i mobilnych oraz zagadnień
związanych z zarządzaniem projektem informatycznym.
Absolwent może znaleźć zatrudnienie jako projektant
oprogramowania, administrator systemów
informatycznych, projektant i administrator sieci
komputerowych oraz specjalista w dziedzinie
bezpieczeństwa systemów.`

const exampleSyllabusEntryRequirements: string = `Konkurs ocen ze świadectwa dojrzałości i ze świadectwa ukończenia szkoły średniej.`;

export function GetMockedSyllabuses(): Syllabus[] {
    return [
        new Syllabus(0, "W8 - Informatyka", new Date(), StudyDegree.FirstDegree, FormOfStudy.Stationary, LearningProfile.Practical, 
            7, exampleSyllabusEntryRequirements, ProfessionalTitle.BachelorOfEngineering, "praca dyplomowa, egzamin dyplomowy", 
            exampleSyllabusGraduateSihouette, 210, 210, 210, 1, false, exampleSyllabusExamIssues),
        new Syllabus(1, "W4 - Informatyka", new Date(), StudyDegree.FirstDegree, FormOfStudy.Stationary, LearningProfile.Practical, 
            7, exampleSyllabusEntryRequirements, ProfessionalTitle.BachelorOfEngineering, "praca dyplomowa, egzamin dyplomowy", 
            exampleSyllabusGraduateSihouette, 420, 210, 210, 2, false, exampleSyllabusExamIssues)
    ];
};

export function GetMockedProgram(): ProgramContent[] {
    return [
        
    ];
};