import React from 'react';
import './SyllabusItem.css';
import Syllabus from '../../../models/Syllabus';
import { ProfessionalTitleTypeToString, ProfessionalTitle } from '../../../models/enum-types/ProfessionalTitle';
import { NavLink } from 'react-router-dom';

type SyllabusItemProps = {
    syllabus: Syllabus;
}

export const SyllabusItem = ({syllabus}: SyllabusItemProps) => {
    return (
        <NavLink to={"/syllabus/" + syllabus.id}>
        <li className="syllabuses__syllabus-item">
            <h5>{syllabus.name} <span className="label">{ProfessionalTitleTypeToString(syllabus.professionalTitle)}</span></h5>
            <ul className="syllabuses__syllabus-item__stats">
                <li>Suma ECTS <span className="label">{syllabus.ectsSum}</span> </li>
                <li>Suma CNPS <span className="label">{syllabus.cnpsSum}</span></li>
                <li>Suma ZZU <span className="label">{syllabus.zzuSum}</span></li>
                <li>Semestrów <span className="label">{syllabus.termAmount}</span></li>
            </ul>
        </li>
        </NavLink>
    );
};