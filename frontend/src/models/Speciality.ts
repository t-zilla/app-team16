import Faculty from "./Faculty";

export class Speciality {

    constructor(
        id: number,
        name: string,
        degreeCourse: Faculty
    ) {
        this.id = id;
        this.name = name;
        this.degreeCourse = degreeCourse;
    }

    id: number;
    name: string;
    degreeCourse: Faculty;
};