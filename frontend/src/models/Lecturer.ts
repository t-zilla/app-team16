export default class Lecturer {
    constructor (
        id: number,
        name: string,
        surname: string
    ) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    id: number;
    name: string;
    surname: string;
};