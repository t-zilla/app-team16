import React from 'react';
import LearningOutcome from '../../models/LearningOutcome';
import './LearningOutcomeList.css';
import { FunctionalButton } from '../ui/Button';
import { NavLink, Route} from 'react-router-dom';
import { LearningOutcomeItem } from './items/LearningOutcomeItem';

type LearningOutcomesProps = {
    outcomesName: string;
    outcomes: LearningOutcome[];
    outcomesPath: string;
    outcomesSinglePath: string;
};

const LearningOutcomeList = ({outcomes, outcomesName, outcomesPath, outcomesSinglePath} : LearningOutcomesProps) => {
    const outcomesItemList = outcomes.map((outcome) => <LearningOutcomeItem learningOutcome={outcome} outcomesSinglePath={outcomesSinglePath}/>)
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