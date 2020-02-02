export enum StudyDegree {
    FirstDegree,
    SecondDegree,
    ThirdDegree,
    UniformMasterDegree,
    Undefined
};

export const StrToStudyDegreeMap = (): Map<string, StudyDegree> => {
    return new Map<string, StudyDegree>()
        .set("Pierwszy stopień", StudyDegree.FirstDegree)
        .set("Drugi stopień", StudyDegree.SecondDegree)
        .set("Trzeci stopień", StudyDegree.ThirdDegree)
        .set("Jednolite magisterskie", StudyDegree.UniformMasterDegree);
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
