import React from 'react';
import './SubjectItem.css';
import Subject from '../../../models/Subject';
import { NavLink } from 'react-router-dom';

type SubjectItemProps = {
    subject: Subject;
}

export const SubjectItem = ({subject}: SubjectItemProps) => {
    return (
        <NavLink to={"/subject/" + subject.id}>
        <li className="subjects__subject-item">
            <h5>{subject.code}</h5>
            <h4>{subject.polishName}</h4>
            <ul className="subjects__subject-item__stats">
                <li>ECTS <span className="label">{subject.ectsSum}</span> </li>
                <li>CNPS <span className="label">{subject.cnpsSum}</span></li>
                <li>ZZU <span className="label">{subject.zzuSum}</span></li>
                <li>{subject.courses ? subject.courses.length : "Brak kursów"}</li>
            </ul>
        </li>
        </NavLink>
    );
};
