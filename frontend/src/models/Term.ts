import { Syllabus } from "./Syllabus";
import Subject from "./Subject";

export class Term {

    constructor (
        id: number,
        allowedDeficit: number,
        ectsSum: number,
        zzuSum: number,
        cnps: number,
        syllabus: Syllabus,
        order: number
    ) {
        this.id = id;
        this.allowedDeficit = allowedDeficit;
        this.ectsSum = ectsSum;
        this.zzuSum = zzuSum;
        this.cnps = cnps;
        this.syllabus = syllabus;
        this.order = order;
    }

    id: number;
    allowedDeficit: number;
    ectsSum: number;
    zzuSum: number;
    cnps: number;
    syllabus: Syllabus;
    order: number;
    subjects?: Subject[];
};