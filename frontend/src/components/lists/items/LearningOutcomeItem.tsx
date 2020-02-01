import React from 'react';
import LearningOutcome from '../../../models/LearningOutcome';
import { LearningOutcomeTypeToString } from '../../../models/enum-types/LearningOutcomeType';
import './LearningOutcomeItem.css';
import { NavLink, Route } from 'react-router-dom';
import { LearningOutcomePage } from '../../single-pages/LearningOutcomePage';

type LearningOutcomeItemProps = {
    learningOutcome: LearningOutcome;
}

export const LearningOutcomeItem = ({learningOutcome}: LearningOutcomeItemProps) => {
    return (
        <NavLink to={"/outcomes/" + learningOutcome.symbol}>
        <li className="learning-outcomes__item row">
            <div className="learning-outcomes__item__detail"><h5 className="label">{learningOutcome.symbol}</h5></div>
            <div className="learning-outcomes__item__detail"><h4>{LearningOutcomeTypeToString(learningOutcome.type)}</h4></div>
            <div className="learning-outcomes__item__detail"><h4>{learningOutcome.description}</h4></div>
        </li>
        <Route path="/outcomes/:id"></Route>
        </NavLink>
    );
};