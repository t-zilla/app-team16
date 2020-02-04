export enum StudyDegree {
    FirstDegree,
    SecondDegree,
    ThirdDegree,
    UniformMasterDegree,
    Undefined
};

export const StrToStudyDegreeMap = (): Map<string, StudyDegree> => {
    return new Map<string, StudyDegree>()
        .set("FIRST_DEGREE", StudyDegree.FirstDegree)
        .set("SECOND_DEGREE", StudyDegree.SecondDegree)
        .set("THIRD DEGREE", StudyDegree.ThirdDegree)
        .set("UNIFORM_MASTER_DEGREE", StudyDegree.UniformMasterDegree);
};

export const StudyDegreeToStrMap = (): Map<StudyDegree, string> => {
    return new Map<StudyDegree, string>()
        .set(StudyDegree.FirstDegree, "Pierwszy stopień")
        .set(StudyDegree.SecondDegree, "Drugi stopień")
        .set(StudyDegree.ThirdDegree, "Trzeci stopień")
        .set(StudyDegree.UniformMasterDegree, "Jednolite magisterskie");
};

export const StudyDegreeTypeToString = (type: StudyDegree): string | undefined => StudyDegreeToStrMap().get(type);
export const StringToStudyDegree = (name: string): StudyDegree | undefined => StrToStudyDegreeMap().get(name);
