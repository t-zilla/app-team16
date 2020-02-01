import React from 'react';
import './SyllabusItem.css';
import Syllabus from '../../../models/Syllabus';
import { ProfessionalTitleTypeToString } from '../../../models/enum-types/ProfessionalTitle';
import { NavLink, Route } from 'react-router-dom';
import { SyllabusPage } from '../../single-pages/SyllabusPage';

type SyllabusItemProps = {
    syllabus: Syllabus;
}

export const SyllabusItem = ({syllabus}: SyllabusItemProps) => {
    return (
        <NavLink to={"/syllabus/" + syllabus.name}>
        <li className="syllabuses__syllabus-item">
            <h4>{syllabus.name} <span className="label">{ProfessionalTitleTypeToString(syllabus.professionalTitle)}</span></h4>
            <ul className="syllabuses__syllabus-item__stats">
                <li>Suma ECTS <span className="label">{syllabus.ectsSum}</span> </li>
                <li>Suma CNPS <span className="label">{syllabus.cnpsSum}</span></li>
                <li>Suma ZZU <span className="label">{syllabus.zzuSum}</span></li>
                <li>Semestrów <span className="label">{syllabus.termAmount}</span></li>
            </ul>
            <p><i>{syllabus.graduateSihouette}...</i></p>
        </li>
        <Route path="/syllabus/:id">
            <SyllabusPage/>
        </Route>
        </NavLink>
    );
};