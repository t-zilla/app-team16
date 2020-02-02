export enum LearningProfile {
    Practical,
    General
};

export const StrToLearningProfileMap = (): Map<string, LearningProfile> => {
    return new Map<string, LearningProfile>()
        .set("Praktyczne", LearningProfile.Practical)
        .set("Ogólnoakademickie", LearningProfile.General)
};

export const LearningProfileToStrMap = (): Map<LearningProfile, string> => {
    return new Map<LearningProfile, string>()
        .set(LearningProfile.Practical, "Praktyczne")
        .set(LearningProfile.General, "Ogólnoakademickie")
};

export const LearningProfileTypeToString = (type: LearningProfile): string | undefined => LearningProfileToStrMap().get(type);
export const StringToLearningProfile = (name: string): LearningProfile | undefined => StrToLearningProfileMap().get(name);
