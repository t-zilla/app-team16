import { FormOfCourse } from "./EnumerationTypes";
import { SubjectCard } from "./SubjectCard";

export class ProgramContent {
    
    constructor (
        lp: number,
        form: FormOfCourse,
        content: string,
        hoursAmount: number,
        subjectCard: SubjectCard
    ) {
        this.lp = lp;
        this.form = form;
        this.content = content;
        this.hoursAmount = hoursAmount;
        this.subjectCard = subjectCard;
    }

    lp: number;
    form: FormOfCourse;
    content: string;
    hoursAmount: number;
    subjectCard: SubjectCard;
};