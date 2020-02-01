import { LanguageOfStudy } from "./enum-types/LanguageOfStudy";
import { Speciality } from "./Speciality";

export default class Faculty {

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