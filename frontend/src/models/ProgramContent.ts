import { FormOfCourse } from "./enum-types/EnumerationTypes";
import { SubjectCard } from "./SubjectCard";

export class ProgramContent {
    
    constructor (
        id: number,
        lp: number,
        form: FormOfCourse,
        content: string,
        hoursAmount: number,
        subjectCard: SubjectCard
    ) {
        this.id = id;
        this.lp = lp;
        this.form = form;
        this.content = content;
        this.hoursAmount = hoursAmount;
        this.subjectCard = subjectCard;
    }

    id: number;
    lp: number;
    form: FormOfCourse;
    content: string;
    hoursAmount: number;
    subjectCard: SubjectCard;
};