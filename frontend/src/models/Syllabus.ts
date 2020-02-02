import { LearningProfile } from "./enum-types/LearningProfile";
import { FormOfStudy } from './enum-types/FormOfStudy';
import { StudyDegree } from './enum-types/StudyDegree';
import { ProfessionalTitle } from './enum-types/ProfessionalTitle';
import { Term } from "./Term";

export default class Syllabus {

    readonly MaxTermAmount = 7;
    readonly MaxExtendedTermAmount = 8;

    constructor (
        id: number,
        name: string,
        modificationDate: Date,
        studyDegree: StudyDegree,
        studyForm: FormOfStudy,
        learningProfile: LearningProfile,
        termAmount: number,
        entryRequirements: string,
        professionalTitle: ProfessionalTitle,
        formOfGradution: string,
        graduateSihouette: string,
        cnpsSum: number,
        ectsSum: number,
        zzuSum: number,
        cnpsMultiplier: number,
        extendedTermAmount: boolean,
        examIssues: string[]
    ) {
        this.id = id;
        this.name = name;
        this.modificationDate = modificationDate;
        this.studyDegree = studyDegree;
        this.studyForm = studyForm;
        this.learningProfile = learningProfile;
        this.termAmount = termAmount;
        this.entryRequirements = entryRequirements;
        this.professionalTitle = professionalTitle;
        this.formOfGradution = formOfGradution;
        this.graduateSihouette = graduateSihouette;
        this.cnpsSum = cnpsSum;
        this.ectsSum = ectsSum;
        this.zzuSum = zzuSum;
        this.cnpsMultiplier = cnpsMultiplier;
        this.extendedTermAmount = extendedTermAmount;
        this.examIssues = examIssues;
    }
    
    id: number;
    name: string;
    modificationDate: Date;
    studyDegree: StudyDegree
    studyForm: FormOfStudy;
    learningProfile: LearningProfile;
    termAmount: number;
    entryRequirements: string;
    professionalTitle: ProfessionalTitle;
    formOfGradution: string;
    graduateSihouette: string;
    cnpsSum: number;
    ectsSum: number;
    zzuSum: number;
    cnpsMultiplier: number;
    extendedTermAmount: boolean;
    examIssues: string[];
    terms?: Term[]
};

