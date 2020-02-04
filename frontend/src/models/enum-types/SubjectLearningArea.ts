export enum SubjectLearningArea {
    ForeignLanguage,
    PhysicalEducation,
    Math,
    PhysicsAndChemistry,
    InformationTechnology
};

export const StrToSubjectLearningAreaMap = (): Map<string, SubjectLearningArea> => {
    return new Map<string, SubjectLearningArea>()
        .set("FOREIGN_LANGUAGE", SubjectLearningArea.ForeignLanguage)
        .set("PHYSICAL_EDUCATION", SubjectLearningArea.PhysicalEducation)
        .set("MATH", SubjectLearningArea.Math)
        .set("PHYSICS_AND_CHEMISTRY", SubjectLearningArea.PhysicsAndChemistry)
        .set("INFORMATION_TECHNOLOGY", SubjectLearningArea.InformationTechnology);
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
