import { AchievementRatingType } from "./enum-types/EnumerationTypes";
import { SubjectCard } from "./SubjectCard";

export class PEKAchievementRating {

    constructor(
        id: number,
        description: string,
        type: AchievementRatingType,
        subjectCard: SubjectCard
    ) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.subjectCard = subjectCard;
    }

    id: number;
    description: string;
    type: AchievementRatingType;
    subjectCard: SubjectCard;
};