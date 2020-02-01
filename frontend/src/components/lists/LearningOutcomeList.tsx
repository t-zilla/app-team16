import React from 'react';
import LearningOutcome from '../../models/LearningOutcome';
import { LearningOutcomeTypeToString } from '../../models/LearningOutcome';
import './LearningOutcomeList.css';
import './LearningOutcomeItem.css';
import { FunctionalButton } from '../ui/Button';
import { NavLink, Route} from 'react-router-dom';

type LearningOutcomesProps = {
    outcomesName: string;
    outcomes: LearningOutcome[];
    outcomesPath: string;
};

type LearningOutcomeItemProps = {
    learningOutcome: LearningOutcome;
}

const LearningOutcomeItem = ({learningOutcome}: LearningOutcomeItemProps) => {
    return (
        <li className="learning-outcomes__item row">
            <div className="learning-outcomes__item__detail"><h5 className="label">{learningOutcome.symbol}</h5></div>
            <div className="learning-outcomes__item__detail"><h4>{LearningOutcomeTypeToString(learningOutcome.type)}</h4></div>
            <div className="learning-outcomes__item__detail"><h4>{learningOutcome.description}</h4></div>
        </li>
    );
};

const LearningOutcomeList = ({outcomes, outcomesName, outcomesPath} : LearningOutcomesProps) => {
    const outcomesItemList = outcomes.map((outcome) => <LearningOutcomeItem learningOutcome={outcome}/>)
    return (
        <div className="learning-outcomes">
            <div className="row">
                <h1 className="section-header">{outcomesName}</h1>    
                <NavLink to={outcomesPath + "/create"}>
                    <FunctionalButton 
                        name="Dodaj" 
                        type="submit"
                        buttonClass="main-btn"/>  
                </NavLink>
                <Route path={outcomesPath + "/create"}>                
                    
                </Route>
            </div>
            <ul className="learning-outcomes__list">{outcomesItemList}</ul>
        </div>
    );
};

export default LearningOutcomeList;