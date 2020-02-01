import { Syllabus } from "./Syllabus";

export class Term {

    constructor (
        allowedDeficit: number,
        ectsSum: number,
        zzuSum: number,
        cnps: number,
        syllabus: Syllabus
    ) {
        this.allowedDeficit = allowedDeficit;
        this.ectsSum = ectsSum;
        this.zzuSum = zzuSum;
        this.cnps = cnps;
        this.syllabus = syllabus;
    }

    allowedDeficit: number;
    ectsSum: number;
    zzuSum: number;
    cnps: number;
    syllabus: Syllabus;
};