import React from 'react';
import './SyllabusList.css';
import { NavLink, Route } from 'react-router-dom';
import { FunctionalButton } from '../ui/Button';

export const SyllabusList = () => {
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
        </div>
    );
};