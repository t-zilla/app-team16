import React from 'react';
import LearningOutcome from '../../../models/LearningOutcome';
import { LearningOutcomeTypeToString } from '../../../models/enum-types/LearningOutcomeType';
import './LearningOutcomeItem.css';

type LearningOutcomeItemProps = {
    learningOutcome: LearningOutcome;
}

export const LearningOutcomeItem = ({learningOutcome}: LearningOutcomeItemProps) => {
    return (
        <li className="learning-outcomes__item row">
            <div className="learning-outcomes__item__detail"><h5 className="label">{learningOutcome.symbol}</h5></div>
            <div className="learning-outcomes__item__detail"><h4>{LearningOutcomeTypeToString(learningOutcome.type)}</h4></div>
            <div className="learning-outcomes__item__detail"><h4>{learningOutcome.description}</h4></div>
        </li>
    );
};