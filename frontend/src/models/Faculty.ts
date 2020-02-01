import { LanguageOfStudy } from "./EnumerationTypes";
import { Speciality } from "./Speciality";

export class Faculty {

    constructor (
        name: string,
        languageOfStudy: LanguageOfStudy
    ) {
        this.name = name;
        this.languageOfStudy = languageOfStudy;
    }

    name: string;
    languageOfStudy: LanguageOfStudy;
    specialities?: Speciality[];
};