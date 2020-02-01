import React from 'react';
import './SubjectList.css';
import './SubjectItem.css';
import { FunctionalButton } from '../ui/Button';
import { Route, NavLink } from "react-router-dom";
import SubjectCreator from '../inputs/SubjectCreator';
import { SubjectItem } from './SubjectItem';
import Subject from '../../models/Subject';

type SubjectsProps = {
    subjectList: Subject[]
};

export const SubjectList = ({subjectList}: SubjectsProps) => {
    const subjects = subjectList.map((subject, index) => <SubjectItem key={index} subject={subject}/> );
    return (
        <div className="subjects">
            <div className="row">
                <h1 className="section-header">Przedmioty</h1>    
                <NavLink to="/subjects/create">
                    <FunctionalButton 
                        name="Dodaj" 
                        type="submit"
                        buttonClass="main-btn"/>  
                </NavLink>
                <Route path="/subjects/create">                
                    <SubjectCreator/>
                </Route>
            </div>
            <ul className="row subjects-list">{subjects}</ul>
        </div>
    );
};