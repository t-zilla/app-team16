import { DegreeCourse } from "./DegreeCourse";

export class Speciality {

    constructor(
        name: string,
        degreeCourse: DegreeCourse
    ) {
        this.name = name;
        this.degreeCourse = degreeCourse;
    }

    name: string;
    degreeCourse: DegreeCourse;
};