import React, { Component } from 'react';
import Faculty from '../../models/Faculty';
import { GetMockedFaculties } from '../../mocks/MockedObjects';
import { FunctionalButton } from '../ui/Button';
import { NavLink } from 'react-router-dom';
import { LanguageOfStudyTypeToString } from '../../models/enum-types/LanguageOfStudy';
import './FacultyPage.css';

type FacultyPageProps = {
    facultyId: number;
};

type FacultyPageState = {
    error: boolean;
    isLoaded: boolean;
    faculty?: Faculty;
};

export default class FacultyPage extends Component<FacultyPageProps, FacultyPageState> {
    constructor(props: FacultyPageProps) {
        super(props);
        this.state = {
            error: false,
            isLoaded: false,
            faculty: undefined
        };
    }

    componentDidMount() {
        this.setState({
            faculty: GetMockedFaculties().find(faculty => faculty.id === this.props.facultyId)
        });
    }

    render() {
        return (
            <div className="faculty-page">
                <div className="row">
                    <h1 className="section-header">
                        {this.state.faculty ? this.state.faculty.name : ''}
                    </h1>    
                    <NavLink to="/faculties">
                    <FunctionalButton 
                        name="Kierunek" 
                        type={undefined}
                        buttonClass="main-btn"/>  
                    </NavLink>
                </div>
                <div className="row">
                    <h4 className="syllabus-page__detail">Język studiów <span className="label">{this.state.faculty ? LanguageOfStudyTypeToString(this.state.faculty.languageOfStudy) : ''}</span></h4>
                </div>
                <div className="column">
                    <h2 className="section-sub-header">Specjalizacje</h2>
                    <p>Brak...</p>
                </div>
            </div>
        );
    };
};