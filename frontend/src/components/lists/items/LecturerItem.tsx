import React from 'react';
import Lecturer from '../../../models/Lecturer';
import './LecturerItem.css';

type LecturerItemProps = {
    lecturer: Lecturer;
}

export const LecturerItem = ({lecturer}: LecturerItemProps) => {
    return (
        <li className="lecturers__lecturer-item row">
            <div className="lecturers__lecturer-item__detail">
                <h5>{lecturer.name} {lecturer.surname} <span className="label">0 przedmiotów</span></h5>
            </div>
        </li>
    );
};