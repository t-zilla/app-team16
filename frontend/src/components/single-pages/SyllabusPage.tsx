import React, { Component } from 'react';
import Syllabus from '../../models/Syllabus';
import { GetMockedSyllabuses } from '../../mocks/MockedObjects';
import { LearningProfileTypeToString } from '../../models/enum-types/LearningProfile';
import { ProfessionalTitleTypeToString } from '../../models/enum-types/ProfessionalTitle';
import { StudyDegreeTypeToString } from '../../models/enum-types/StudyDegree';
import { FormOfStudyTypeToString } from '../../models/enum-types/FormOfStudy';
import './SyllabusPage.css';
import { FunctionalButton } from '../ui/Button';
import { NavLink, match } from 'react-router-dom';
import SyllabusService from '../../services/SyllabusService';

type SyllabusPageProps = {
    syllabusId: number;
    match: match;
};

type SyllabusPageState = {
    error: boolean;
    isLoaded: boolean;
    syllabus?: Syllabus;
};

export default class SyllabusPage extends Component<{}, SyllabusPageState> {
    private syllabusService: SyllabusService;
    constructor(props: SyllabusPageProps) {
        super(props);
        this.state = {
            error: false,
            isLoaded: false
        };
        this.syllabusService = new SyllabusService();
    }

    componentDidMount() {
        this.syllabusService.get(this.props.match.params.id)
            .then(response => {
                this.setState({
                    syllabus: Syllabus.fromJson(response.data)
                });
            }).catch(error => {

            });
    }

    render() {
        const examIssues = this.state.syllabus ? this.state.syllabus.examIssues.map((examIssue) =>
            <li className="syllabus-page__exam-issues__item">{examIssue}</li>
        ) : "";
        return (
            <div className="syllabus-page">
                <div className="row">
                    <h1 className="section-header">
                        {this.state.syllabus ? this.state.syllabus.name : ''}
                    </h1>    
                    <NavLink to="/syllabuses">
                    <FunctionalButton 
                        name="Plan kształcenia" 
                        type={undefined}
                        buttonClass="main-btn"/>  
                    </NavLink>
                </div>
                <div className="row">
                    <h4 className="syllabus-page__detail">Suma punktów CNPS <span className="label">{this.state.syllabus ? this.state.syllabus.cnpsSum : ''}</span></h4>
                    <h4 className="syllabus-page__detail">Suma punktów ZZU <span className="label">{this.state.syllabus ? this.state.syllabus.zzuSum : ''}</span></h4>
                    <h4 className="syllabus-page__detail">Suma punktów ECTS <span className="label">{this.state.syllabus ? this.state.syllabus.ectsSum : ''}</span></h4>
                    <h4 className="syllabus-page__detail">Liczba semestrów <span className="label">{this.state.syllabus ? this.state.syllabus.termAmount : ''}</span></h4>
                </div>
                <div className="row">
                    <h4 className="syllabus-page__detail">Profil nauczania <span className="label">{this.state.syllabus ? LearningProfileTypeToString(this.state.syllabus.learningProfile) : ''}</span></h4>
                    <h4 className="syllabus-page__detail">Tytuł zawodowy <span className="label">{this.state.syllabus ? ProfessionalTitleTypeToString(this.state.syllabus.professionalTitle) : ''}</span></h4>
                    <h4 className="syllabus-page__detail">Stopień studiów <span className="label">{this.state.syllabus ? StudyDegreeTypeToString(this.state.syllabus.studyDegree) : ''}</span></h4>
                    <h4 className="syllabus-page__detail">Forma studiów <span className="label">{this.state.syllabus ? FormOfStudyTypeToString(this.state.syllabus.studyForm) : ''}</span></h4>
                </div>
                <div className="row">
                    <h4 className="syllabus-page__detail">Forma zakończenia studiów <span className="label">{this.state.syllabus ? this.state.syllabus.graduationForm : ''}</span></h4>
                </div>
                <div className="column">
                    <h2 className="section-sub-header">Wymaganie wstępne</h2>
                    <p>{this.state.syllabus ? this.state.syllabus.entryRequirements : ''}</p>
                </div>
                <div className="column">
                    <h2 className="section-sub-header">Sylwetka absolwenta</h2>
                    {this.state.syllabus ? this.state.syllabus.graduateSilhouette : ''}
                </div>
                <div className="column">
                    <h2 className="section-sub-header">Zagadnienia egzaminacyjne</h2>
                    <ol className="syllabus-page__exam-issues">{examIssues}</ol>
                </div>
            </div>
        );
    };
};