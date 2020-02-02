import React from 'react';
import './FacultyItem.css';
import Faculty from '../../../models/Faculty';
import { LanguageOfStudyTypeToString } from '../../../models/enum-types/LanguageOfStudy'
import { NavLink, Route } from 'react-router-dom';
import FacultyPage from '../../single-pages/FacultyPage';

type FacultyItemProps = {
    faculty: Faculty;
}

export const FacultyItem = ({faculty}: FacultyItemProps) => {
    return (
        <NavLink to={"/faculty/" + faculty.id}>
            <li className="faculties__faculty-item">
                <h4>{faculty.name} <span className="label">{LanguageOfStudyTypeToString(faculty.languageOfStudy)}</span></h4>
            </li>
        </NavLink>
    );
};