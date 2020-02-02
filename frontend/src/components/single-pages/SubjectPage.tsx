import React, { Component } from 'react';
import './SubjectPage.css';
import Subject from '../../models/Subject';
import { GetMockedSubjects } from '../../mocks/MockedObjects';
import { SubjectLearningAreaTypeToString } from '../../models/enum-types/SubjectLearningArea';
import { FunctionalButton } from '../ui/Button';
import { NavLink } from 'react-router-dom';

type SubjectPageProps = {
    subjectId: number;
};

type SubjectPageState = {
    error: boolean;
    isLoaded: boolean;
    subject?: Subject;
};

export default class SubjectPage extends Component<SubjectPageProps, SubjectPageState> {
    constructor(props: SubjectPageProps) {
        super(props);
        this.state = {
            error: false,
            isLoaded: false,
            subject: undefined
        };
    }

    componentDidMount() {
        this.setState({
            subject: GetMockedSubjects().find(subject => subject.id === this.props.subjectId)
        });
    }

    render() {
        return (
            <div className="subject-page">
                <div className="row">
                    <h1 className="section-header">
                        {this.state.subject ? this.state.subject.polishName : ''}
                    </h1>    
                    <NavLink to="/syllabuses">
                    <FunctionalButton 
                        name="Przedmiot" 
                        type={undefined}
                        buttonClass="main-btn"/>  
                    </NavLink>
                </div>
                {this.state.subject ? this.state.subject.code : ''}
                {this.state.subject ? this.state.subject.polishName : ''}
                {this.state.subject ? this.state.subject.englishName : ''}
                {this.state.subject ? this.state.subject.ectsSum : ''}
                {this.state.subject ? this.state.subject.zzuSum : ''}
                {this.state.subject ? this.state.subject.cnpsSum : ''}
                {this.state.subject ? SubjectLearningAreaTypeToString(this.state.subject.learningArea) : ''}
            </div>
        );
    };
};