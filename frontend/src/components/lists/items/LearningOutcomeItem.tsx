import React from 'react';
import LearningOutcome from '../../../models/LearningOutcome';
import { LearningOutcomeTypeToString } from '../../../models/enum-types/LearningOutcomeType';
import './LearningOutcomeItem.css';
import { NavLink, Route } from 'react-router-dom';
import { LearningOutcomePage } from '../../single-pages/LearningOutcomePage';

type LearningOutcomeItemProps = {
    learningOutcome: LearningOutcome;
    outcomesPath: string;
}

export const LearningOutcomeItem = ({learningOutcome, outcomesPath}: LearningOutcomeItemProps) => {
    return (
        <NavLink to={outcomesPath + "/" + learningOutcome.id}>
        <li className="learning-outcomes__item row">
            <div className="learning-outcomes__item__detail"><h4>{learningOutcome.symbol}</h4></div>
            <div className="learning-outcomes__item__detail"><h4 className="label">{LearningOutcomeTypeToString(learningOutcome.type)}</h4></div>
            <div className="learning-outcomes__item__detail"><p><i>{learningOutcome.description}...</i></p></div>
        </li>
        <Route path={outcomesPath + "/:id"}>
            <LearningOutcomePage/>
        </Route>
        </NavLink>
    );
};