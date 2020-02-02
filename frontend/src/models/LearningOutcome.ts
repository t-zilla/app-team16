import { LearningOutcomeType } from './enum-types/LearningOutcomeType';

export default abstract class LearningOutcome {
    
    constructor (
        id: number,
        symbol: string,
        type: LearningOutcomeType,
        description: string
    ) {
        this.id = id;
        this.symbol = symbol;
        this.type = type;
        this.description = description;
    }

    id: number;
    symbol: string;
    type: LearningOutcomeType;
    description: string;
};