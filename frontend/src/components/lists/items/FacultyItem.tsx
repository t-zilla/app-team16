import React from 'react';
import './FacultyItem.css';
import Faculty from '../../../models/Faculty';
import { LanguageOfStudyTypeToString } from '../../../models/enum-types/LanguageOfStudy'

type FacultyItemProps = {
    faculty: Faculty;
}

export const FacultyItem = ({faculty}: FacultyItemProps) => {
    return (
        <li className="faculties__faculty-item">
            <h4>{faculty.name} <span className="label">{LanguageOfStudyTypeToString(faculty.languageOfStudy)}</span></h4>
        </li>
    );
};