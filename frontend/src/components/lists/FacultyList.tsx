import React from 'react';
import { Faculty } from '../../models/Faculty';
import './FacultyList.css'
import { NavLink, Route } from 'react-router-dom';
import { FunctionalButton } from '../ui/Button';

type FacultyListProps = {
    facultyList: Faculty[];
};

export const FacultyList = ({facultyList}: FacultyListProps) => {
    return (
        <div className="faculties">
            <div className="row">
                <h1 className="section-header">Kierunki</h1>    
                <NavLink to="/faculties/create">
                    <FunctionalButton 
                        name="Dodaj" 
                        type="submit"
                        buttonClass="main-btn"/>  
                </NavLink>
                <Route path="/faculties/create">                
                    
                </Route>
            </div>
        </div>
    );
};