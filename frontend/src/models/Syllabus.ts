import { LearningProfile, StringToLearningProfile } from "./enum-types/LearningProfile";
import { FormOfStudy, StringToFormOfStudy } from './enum-types/FormOfStudy';
import { StudyDegree, StringToStudyDegree } from './enum-types/StudyDegree';
import { ProfessionalTitle, StringToProfessionalTitle } from './enum-types/ProfessionalTitle';
import { Term } from "./Term";

export default class Syllabus {

    readonly MaxTermAmount = 7;
    readonly MaxExtendedTermAmount = 8;

    constructor (
        id: number,
        name: string,
        studyDegree: StudyDegree,
        studyForm: FormOfStudy,
        learningProfile: LearningProfile,
        termAmount: number,
        entryRequirements: string,
        professionalTitle: ProfessionalTitle,
        formOfGradution: string,
        graduateSilhouette: string,
        cnpsSum: number,
        ectsSum: number,
        zzuSum: number,
        cnpsMultiplier: number,
        extendedTermAmount: boolean,
        examIssues: string[]
    ) {
        this.id = id;
        this.name = name;
        this.studyDegree = studyDegree;
        this.studyForm = studyForm;
        this.learningProfile = learningProfile;
        this.termAmount = termAmount;
        this.entryRequirements = entryRequirements;
        this.professionalTitle = professionalTitle;
        this.formOfGradution = formOfGradution;
        this.graduateSilhouette = graduateSilhouette;
        this.cnpsSum = cnpsSum;
        this.ectsSum = ectsSum;
        this.zzuSum = zzuSum;
        this.cnpsMultiplier = cnpsMultiplier;
        this.extendedTermAmount = extendedTermAmount;
        this.examIssues = examIssues;
    }
    
    id: number;
    name: string;
    studyDegree: StudyDegree;
    studyForm: FormOfStudy;
    learningProfile: LearningProfile;
    termAmount: number;
    entryRequirements: string;
    professionalTitle: ProfessionalTitle;
    formOfGradution: string;
    graduateSilhouette: string;
    cnpsSum: number;
    ectsSum: number;
    zzuSum: number;
    cnpsMultiplier: number;
    extendedTermAmount: boolean;
    examIssues: string[];
    terms?: Term[]

    static capitalize(s: string) {
        console.log(s.charAt(0).toUpperCase() + s.slice(1).toLowerCase());
        return s.charAt(0).toUpperCase() + s.slice(1).toLowerCase();
    };

    static fromJson(json: any): Syllabus {
        console.log(json)
        return new Syllabus(
            json.id,
            json.name,
            StringToStudyDegree(json.studyDegree),
            StringToFormOfStudy(json.studyForm),
            StringToLearningProfile(json.learningProfile),
            json.termAmount,
            json.entryRequirements,
            StringToProfessionalTitle(json.professionalTitle),
            json.formOfGradution,
            json.graduateSilhouette,
            json.cnpsSum,
            json.ectsSum,
            json.zzuSum,
            json.cnpsMultiplier,
            json.extendedTermAmount,
            json.examIssues
        );
    }
};


