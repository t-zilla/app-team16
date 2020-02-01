import React from 'react';
import Lecturer from '../../models/Lecturer';
import './LecturerList.css'

type LecturerListProps = {
    lecturerList: Lecturer[];
};

export const LecturerList = ({lecturerList}: LecturerListProps) => {
    return (
        <div className="lecturers">
            <div className="row">
                <h1 className="section-header">Prowadzący</h1>    
            </div>
        </div>
    );
};