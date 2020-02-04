import React, { Component } from 'react';
import './SubjectPage.css';
import Subject from '../../models/Subject';
import { GetMockedSubjects } from '../../mocks/MockedObjects';
import { SubjectLearningAreaTypeToString } from '../../models/enum-types/SubjectLearningArea';
import { FunctionalButton } from '../ui/Button';
import { NavLink } from 'react-router-dom';
import SubjectService from '../../services/SubjectService';

type SubjectPageProps = {
    subjectId: number;
};

type SubjectPageState = {
    error: boolean;
    isLoaded: boolean;
    subject?: Subject;
};

export default class SubjectPage extends Component<SubjectPageProps, SubjectPageState> {
    private subjectService: SubjectService;
    constructor(props: SubjectPageProps) {
        super(props);
        this.state = {
            error: false,
            isLoaded: false,
            subject: undefined
        };
        this.subjectService = new SubjectService();
    }

    componentDidMount() {
        this.subjectService.get(this.props.match.params.id)
            .then(response => {
                console.log(response.data)
                this.setState({
                    subject: Subject.fromJson(response.data)
                });
            }).catch(error => {

            });
    }

    render() {
        return (
            <div className="subject-page">
                <div className="row">
                    <h1 className="section-header">
                        {this.state.subject ? this.state.subject.polishName : ''} | {this.state.subject ? this.state.subject.englishName : ''}
                    </h1>    
                    <NavLink to="/syllabuses">
                    <FunctionalButton 
                        name="Przedmiot" 
                        type={undefined}
                        buttonClass="main-btn"/>  
                    </NavLink>
                </div>
                <div className="row">
                    <h4 className="syllabus-page__detail">Kod <span className="label">{this.state.subject ? this.state.subject.code : ''}</span></h4>
                    <h4 className="syllabus-page__detail">Punkty ZZU <span className="label">{this.state.subject ? this.state.subject.zzuSum : ''}</span></h4>
                    <h4 className="syllabus-page__detail">Punkty ECTS <span className="label">{this.state.subject ? this.state.subject.ectsSum : ''}</span></h4>
                    <h4 className="syllabus-page__detail">Punkty CNPS <span className="label">{this.state.subject ? this.state.subject.cnpsSum : ''}</span></h4>
                </div>
                <div className="row">
                    <h4 className="syllabus-page__detail">Obszar kształcenia <span className="label">{this.state.subject ? SubjectLearningAreaTypeToString(this.state.subject.learningArea) : ''}</span></h4>
                    <h4 className="syllabus-page__detail">Prowadzący <span className="label">Brak...</span></h4>
                    
                </div>
                <div className="column">
                    <h2 className="section-sub-header">Kursy</h2>
                    <p>Brak...</p>
                </div>
                <div className="column">
                    <h2 className="section-sub-header">Karta przedmiotu</h2>
                    <p>Brak...</p>
                </div>
                
            </div>
        );
    };
};