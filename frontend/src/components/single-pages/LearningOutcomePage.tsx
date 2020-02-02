import React, { Component } from 'react';
import LearningOutcome from '../../models/LearningOutcome';
import { GetMockedFaculties, GetMockedMinisterialLearningOutcomes, GetMockedDegreeCourseLearningOutcomes, GetMockedSubjectLearningOutcomes } from '../../mocks/MockedObjects';
import { FunctionalButton } from '../ui/Button';
import { NavLink } from 'react-router-dom';
import { LanguageOfStudyTypeToString } from '../../models/enum-types/LanguageOfStudy';
import './LearningOutcomePage.css';
import { LearningOutcomeTypeToString } from '../../models/enum-types/LearningOutcomeType';
import DegreeCourseLearningOutcome from '../../models/DegreeCourseLearningOutcome';

export enum LearningOutcomeSource {
    Ministerial,
    Subject,
    DegreeCourse
};

type LearningOutcomePageProps = {
    learningOutcomeId: number;
    source: LearningOutcomeSource;
};

type LearningOutcomePageState = {
    error: boolean;
    isLoaded: boolean;
    learningOutcome?: LearningOutcome;
};

export default class LearningOutcomePage extends Component<LearningOutcomePageProps, LearningOutcomePageState> {

    private fetchLearningOutcomeFunc = () => {
        if (this.props.source === LearningOutcomeSource.DegreeCourse)
            return GetMockedDegreeCourseLearningOutcomes();
        else if (this.props.source === LearningOutcomeSource.Subject)
            return GetMockedMinisterialLearningOutcomes();
        else
            return GetMockedSubjectLearningOutcomes();
    }

    constructor(props: LearningOutcomePageProps) {
        super(props);
        this.state = {
            error: false,
            isLoaded: false,
            learningOutcome: undefined
        };        
    }

    componentDidMount() {
        this.setState({
            learningOutcome: this.fetchLearningOutcomeFunc().find(learningOutcome => learningOutcome.id === this.props.learningOutcomeId)
        });
    }

    render() {
        return (
            <div className="faculty-page">
                <div className="row">
                    <h1 className="section-header">
                        {this.state.learningOutcome ? this.state.learningOutcome.symbol : ''}
                    </h1>    
                    <NavLink to="/faculties">
                    <FunctionalButton 
                        name="Efekt kształcenia" 
                        type={undefined}
                        buttonClass="main-btn"/>  
                    </NavLink>
                </div>
                <div className="row">
                    <h4 className="syllabus-page__detail">Obszar efektu kształcenia <span className="label">{this.state.learningOutcome ? LearningOutcomeTypeToString(this.state.learningOutcome.type) : ''}</span></h4>
                </div>
                <div className="column">
                    <h2 className="section-sub-header">Opis</h2>
                    <p>{this.state.learningOutcome ? this.state.learningOutcome.description : ''}</p>
                </div>
            </div>
        );
    };
};