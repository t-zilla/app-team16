import { SubjectLearningArea } from "./EnumerationTypes";
import { Course } from "./Course";
import { SubjectCard } from "./SubjectCard";

export default class Subject {
    constructor (
        code: string, 
        polishName: string, 
        englishName: string, 
        learningArea: SubjectLearningArea,
        ectsSum: number,
        cnpsSum: number,
        zzuSum: number
    ) {
        this.code = code;
        this.polishName = polishName;
        this.englishName = englishName;
        this.learningArea = learningArea;
        this.ectsSum = ectsSum;
        this.cnpsSum = cnpsSum;
        this.zzuSum = zzuSum;
    }

    code: string;
    polishName: string;
    englishName: string; 
    learningArea: SubjectLearningArea;
    ectsSum: number;
    cnpsSum: number;
    zzuSum: number;
    subjectCard?: SubjectCard;
    courses?: Course[];
};