export enum LearningProfile {
    Practical,
    General,
    Undefined
};

export const StrToLearningProfileMap = (): Map<string, LearningProfile> => {
    return new Map<string, LearningProfile>()
        .set("PRACTICAL", LearningProfile.Practical)
        .set("GENERAL", LearningProfile.General)
};

export const LearningProfileToStrMap = (): Map<LearningProfile, string> => {
    return new Map<LearningProfile, string>()
        .set(LearningProfile.Practical, "Praktyczne")
        .set(LearningProfile.General, "Ogólnoakademickie")
};

export const LearningProfileTypeToString = (type: LearningProfile): string | undefined => LearningProfileToStrMap().get(type);
export const StringToLearningProfile = (name: string): LearningProfile | undefined => StrToLearningProfileMap().get(name);
