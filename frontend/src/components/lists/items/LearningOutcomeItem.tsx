import React from 'react';
import LearningOutcome from '../../../models/LearningOutcome';
import { LearningOutcomeTypeToString } from '../../../models/enum-types/LearningOutcomeType';
import './LearningOutcomeItem.css';
import { NavLink, Route } from 'react-router-dom';
import LearningOutcomePage from '../../single-pages/LearningOutcomePage';

type LearningOutcomeItemProps = {
    learningOutcome: LearningOutcome;
    outcomesSinglePath: string;
}

export const LearningOutcomeItem = ({learningOutcome, outcomesSinglePath}: LearningOutcomeItemProps) => {
    return (
        <NavLink to={outcomesSinglePath + "/" + learningOutcome.id}>
        <li className="learning-outcomes__item row">
            <div className="learning-outcomes__item__detail"><h5>{learningOutcome.symbol}</h5></div>
            <div className="learning-outcomes__item__detail"><h5 className="label">{LearningOutcomeTypeToString(learningOutcome.type)}</h5></div>
            <div className="learning-outcomes__item__detail"><h5><i>{learningOutcome.description}...</i></h5></div>
        </li>
        </NavLink>
    );
};