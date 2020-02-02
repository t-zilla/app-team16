import React from 'react';
import Lecturer from '../../../models/Lecturer';
import './LecturerItem.css';
import { NavLink } from 'react-router-dom';

type LecturerItemProps = {
    lecturer: Lecturer;
}

export const LecturerItem = ({lecturer}: LecturerItemProps) => {
    return (
        <li className="lecturers__lecturer-item row">
            <div className="lecturers__lecturer-item__detail"><h5 className="label">{lecturer.name} {lecturer.surname}</h5></div>
        </li>
    );
};