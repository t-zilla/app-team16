import React from 'react';
import './SyllabusList.css';
import { NavLink, Route } from 'react-router-dom';
import { FunctionalButton } from '../ui/Button';
import Syllabus from '../../models/Syllabus';
import { SyllabusItem } from './items/SyllabusItem';

type SyllabusListProps = {
    syllabusList: Syllabus[];
};

export const SyllabusList = ({syllabusList}: SyllabusListProps) => {
    const syllabuses = syllabusList.map((syllabus, index) => <SyllabusItem key={index} syllabus={syllabus}/> );
    return (
        <div className="syllabuses">
            <div className="row">
                <h1 className="section-header">Plany kształcenia</h1>    
                <NavLink to="/syllabuses/create">
                    <FunctionalButton 
                        name="Dodaj" 
                        type="submit"
                        buttonClass="main-btn"/>  
                </NavLink>
                <Route path="/syllabuses/create">                
                    
                </Route>
            </div>
            <ul className="row syllabuses-list">{syllabuses}</ul>
        </div>
    );
};