import { AchievementRatingType } from "./EnumerationTypes";
import { SubjectCard } from "./SubjectCard";

export class PEKAchievementRating {

    constructor(
        description: string,
        type: AchievementRatingType,
        subjectCard: SubjectCard
    ) {
        this.description = description;
        this.type = type;
        this.subjectCard = subjectCard;
    }

    description: string;
    type: AchievementRatingType;
    subjectCard: SubjectCard;
};