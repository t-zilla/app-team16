import React from 'react';
import './FacultyItem.css';
import Faculty from '../../../models/Faculty';
import { LanguageOfStudyTypeToString } from '../../../models/enum-types/LanguageOfStudy'
import { NavLink } from 'react-router-dom';

type FacultyItemProps = {
    faculty: Faculty;
}

export const FacultyItem = ({faculty}: FacultyItemProps) => {
    return (
        <NavLink to={"/faculty/" + faculty.id}>
            <li className="faculties__faculty-item">
                <h5>{faculty.name} <span className="label">{LanguageOfStudyTypeToString(faculty.languageOfStudy)}</span></h5>
            </li>
        </NavLink>
    );
};