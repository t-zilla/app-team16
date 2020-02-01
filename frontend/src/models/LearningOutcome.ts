import { LearningOutcomeType } from './EnumerationTypes';

export default abstract class LearningOutcome {
    
    constructor (
        symbol: string,
        type: LearningOutcomeType,
        description: string
    ) {
        this.symbol = symbol;
        this.type = type;
        this.description = description;
    }

    symbol: string;
    type: LearningOutcomeType;
    description: string;
};

export const StrToLearningOutcomeTypeMap = (): Map<string, LearningOutcomeType> => {
    return new Map<string, LearningOutcomeType>()
        .set("Wiedza", LearningOutcomeType.Knowledge)
        .set("Kompetencje społeczne", LearningOutcomeType.SocialCompetences)
        .set("Umiejetności", LearningOutcomeType.Skills);
};

export const LearningOutcomeTypeToStrMap = (): Map<LearningOutcomeType, string> => {
    return new Map<LearningOutcomeType, string>()
        .set(LearningOutcomeType.Knowledge, "Wiedza")
        .set(LearningOutcomeType.SocialCompetences, "Kompetencje społeczne")
        .set(LearningOutcomeType.Skills, "Umiejetności");
};

export const LearningOutcomeTypeToString = (type: LearningOutcomeType): string | undefined => LearningOutcomeTypeToStrMap().get(type);
export const StringToLearningOutcomeType = (name: string): LearningOutcomeType | undefined => StrToLearningOutcomeTypeMap().get(name);