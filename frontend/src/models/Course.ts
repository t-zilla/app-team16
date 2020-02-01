import { CreditForm, FormOfCourse, LanguageLevel } from "./EnumerationTypes";

export class Course {
    
    constructor (
        code: string,
        zzu: number,
        cnps: number,
        ects: number,
        creditForm: CreditForm,
        finalCourse: boolean,
        form: FormOfCourse,
        hoursWeekly: number
    ) {
        this.code = code,
        this.zzu = zzu,
        this.cnps = cnps,
        this.ects = ects,
        this.creditForm = creditForm,
        this.finalCourse = finalCourse,
        this.form = form,
        this.hoursWeekly = hoursWeekly
    }

    code: string;
    zzu: number;
    cnps: number;
    ects: number;
    creditForm: CreditForm;
    finalCourse: boolean;
    form: FormOfCourse;
    hoursWeekly: number;
    languageLevel?: LanguageLevel;
    leadingCourse?: Course;
};