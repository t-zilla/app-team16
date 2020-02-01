import { LearningOutcomeType } from './enum-types/LearningOutcomeType';

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