import { SubjectLearningArea } from "./enum-types/SubjectLearningArea";
import { Course } from "./Course";
import { SubjectCard } from "./SubjectCard";

export default class Subject {
    constructor (
        id: number,
        code: string, 
        polishName: string, 
        englishName: string, 
        learningArea: SubjectLearningArea,
        ectsSum: number,
        cnpsSum: number,
        zzuSum: number
    ) {
        this.id = id;
        this.code = code;
        this.polishName = polishName;
        this.englishName = englishName;
        this.learningArea = learningArea;
        this.ectsSum = ectsSum;
        this.cnpsSum = cnpsSum;
        this.zzuSum = zzuSum;
    }

    id: number;
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