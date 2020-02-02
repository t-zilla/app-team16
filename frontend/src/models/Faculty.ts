import { LanguageOfStudy } from "./enum-types/LanguageOfStudy";
import { Speciality } from "./Speciality";

export default class Faculty {

    constructor (
        id: number,
        name: string,
        languageOfStudy: LanguageOfStudy
    ) {
        this.id = id;
        this.name = name;
        this.languageOfStudy = languageOfStudy;
    }

    id: number;
    name: string;
    languageOfStudy: LanguageOfStudy;
    specialities?: Speciality[];
};