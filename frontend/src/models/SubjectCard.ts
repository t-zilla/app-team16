import { ProgramContent } from "./ProgramContent";
import Subject from "./Subject";
import { PEKAchievementRating } from "./PEKAchievementRating";

export class SubjectCard {

    constructor (
        objectives: string[],
        entryRequirements: string[],
        teachingTools: string[],
        basicLiterature: string[],
        supplementaryLiterature: string[],
        programContent: ProgramContent[],
        subject: Subject
    ) {
        this.objectives = objectives;
        this.entryRequirements = entryRequirements;
        this.teachingTools = teachingTools;
        this.basicLiterature = basicLiterature;
        this.supplementaryLiterature = supplementaryLiterature;
        this.programContent = programContent;
        this.subject = subject;
    }

    objectives: string[];
    entryRequirements: string[];
    teachingTools: string[];
    basicLiterature: string[];
    supplementaryLiterature: string[];
    programContent: ProgramContent[];
    subject: Subject;
    pekAchievementRatings?: PEKAchievementRating[];
};