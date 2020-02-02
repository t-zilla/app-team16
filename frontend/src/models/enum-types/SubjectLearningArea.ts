export enum SubjectLearningArea {
    ForeignLanguage,
    PhysicalEducation,
    Math,
    PhysicsAndChemistry,
    InformationTechnology
};

export const StrToSubjectLearningAreaMap = (): Map<string, SubjectLearningArea> => {
    return new Map<string, SubjectLearningArea>()
        .set("Język obcy", SubjectLearningArea.ForeignLanguage)
        .set("Wychowanie fizyczne", SubjectLearningArea.PhysicalEducation)
        .set("Matematyka", SubjectLearningArea.Math)
        .set("Fizyka i chemia", SubjectLearningArea.PhysicsAndChemistry)
        .set("Technologia informacyjne", SubjectLearningArea.InformationTechnology);
};

export const SubjectLearningAreaToStrMap = (): Map<SubjectLearningArea, string> => {
    return new Map<SubjectLearningArea, string>()
        .set(SubjectLearningArea.ForeignLanguage, "Język obcy")
        .set(SubjectLearningArea.PhysicalEducation, "Wychowanie fizyczne")
        .set(SubjectLearningArea.Math, "Matematyka")
        .set(SubjectLearningArea.PhysicsAndChemistry, "Fizyka i chemia")
        .set(SubjectLearningArea.InformationTechnology, "Technologia informacyjne");
};

export const SubjectLearningAreaTypeToString = (type: SubjectLearningArea): string | undefined => SubjectLearningAreaToStrMap().get(type);
export const StringToSubjectLearningArea = (name: string): SubjectLearningArea | undefined => StrToSubjectLearningAreaMap().get(name);
