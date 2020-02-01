import Subject from '../models/Subject';
import { SubjectLearningArea, LearningOutcomeType } from '../models/EnumerationTypes';
import SubjectLearningOutcome from '../models/SubjectLearningOutcome';
import MinisterialLearningOutcome from '../models/MinisterialLearningOutcome';
import DegreeCourseLearningOutcome from '../models/DegreeCourseLearningOutcome';

export function GetMockedSubjects(): Subject[] {
    return [
        new Subject("0xswe2", "Informatyka", "Computer science", SubjectLearningArea.InformationTechnology, 5, 10, 10),
        new Subject("1awed4", "Analiza matematyczna", "Methematical analysis", SubjectLearningArea.Math, 6, 10, 10),
        new Subject("1wae21", "Analiza matematyczna", "Methematical analysis", SubjectLearningArea.Math, 6, 10, 10),
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