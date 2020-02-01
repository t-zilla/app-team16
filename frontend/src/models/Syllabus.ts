import { StudyDegree, FormOfStudy, LearningProfile, ProfessionalTitle } from "./EnumerationTypes";
import { Term } from "./Term";

export class Syllabus {

    readonly MaxTermAmount = 7;
    readonly MaxExtendedTermAmount = 8;

    constructor (
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
    ) {
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
    }

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
    examIssues?: string[];
    terms?: Term[]
};