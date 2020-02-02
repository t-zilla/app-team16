import React from 'react';
import Lecturer from '../../models/Lecturer';
import './LecturerList.css'
import { LecturerItem } from './items/LecturerItem';

type LecturerListProps = {
    lecturers: Lecturer[];
};

export const LecturerList = ({lecturers}: LecturerListProps) => {
    const lecturerItemList = lecturers.map((lecturer) => <LecturerItem lecturer={lecturer}/>)
    return (
        <div className="lecturers">
            <div className="row">
                <h1 className="section-header">Prowadzący</h1>
            </div>
            <ul className="lecturers__list">{lecturerItemList}</ul>    
        </div>
    );
};