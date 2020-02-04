import React, { Component, FormEvent } from 'react';
import './SyllabusCreator.css';
import { FunctionalButton, CustomButton } from '../ui/Button';
import { NavLink, Redirect } from "react-router-dom";
import { LearningOutcomeTypeToStrMap } from '../../models/enum-types/LearningOutcomeType';
import SelectionInputContainer from '../ui/SelectionInputContainer';
import InputContainer from '../ui/InputContainer';
import { ProfessionalTitle, StringToProfessionalTitle, ProfessionalTitleToStrMap } from '../../models/enum-types/ProfessionalTitle';
import { LearningProfile, StringToLearningProfile } from '../../models/enum-types/LearningProfile';
import { FormOfStudy, StringToFormOfStudy, FormOfStudyToStrMap } from '../../models/enum-types/FormOfStudy';
import { StudyDegree, StringToStudyDegree, StudyDegreeToStrMap } from '../../models/enum-types/StudyDegree';
import { Term } from '../../models/Term';
import DynamicMultiLineContainer from '../ui/DynamicMultiLineContainer';

type SyllabusCreatorProps = {};

type SyllabusCreatorState = {
    name: string;
    modificationDate: Date | undefined;
    studyDegree: StudyDegree | undefined;
    studyForm: FormOfStudy | undefined;
    learningProfile: LearningProfile | undefined;
    termAmount: number;
    entryRequirements: string;
    professionalTitle: ProfessionalTitle | undefined;
    formOfGradution: string;
    graduateSihouette: string;
    cnpsSum: number | undefined;
    ectsSum: number | undefined;
    zzuSum: number | undefined;
    cnpsMultiplier: number | undefined;
    extendedTermAmount: boolean;
    examIssues: string[];
    terms?: Term[];
    degreeCourseLearningOutcomeCodes?: string[];
    degreeCourseLearningOutcomeCodesStr: string,
    currentStep: number;
    toSyllabuses: boolean;
};

class SyllabusCreator extends Component<SyllabusCreatorProps, SyllabusCreatorState> { 
    private readonly FirstStep: number = 1;
    private readonly LastStep: number = 3;
    private readonly StringArrayDelimeter: string = '\n';

    constructor(props: SyllabusCreatorProps) {
        super(props);
        this.state = {
            name: '',
            modificationDate: undefined,
            studyDegree: StudyDegree.Undefined,
            studyForm: FormOfStudy.Undefined,
            learningProfile: LearningProfile.Undefined,
            termAmount: 7,
            entryRequirements: '',
            professionalTitle: ProfessionalTitle.Undefined,
            formOfGradution: '',
            graduateSihouette: '',
            cnpsSum: undefined,
            ectsSum: undefined,
            zzuSum: undefined,
            cnpsMultiplier: undefined,
            extendedTermAmount: false,
            examIssues: [],
            terms: [],
            degreeCourseLearningOutcomeCodes: [],
            degreeCourseLearningOutcomeCodesStr: '',
            currentStep: this.FirstStep,
            toSyllabuses: false
        };

        this.handleNameChange = this.handleNameChange.bind(this);
        this.handleStudyDegreeChange = this.handleStudyDegreeChange.bind(this);
        this.handleStudyFormChange = this.handleStudyFormChange.bind(this);
        this.handleLearningProfileChange = this.handleLearningProfileChange.bind(this);
        this.handleTermAmountChange = this.handleTermAmountChange.bind(this);
        this.handleEntryRequirementsChange = this.handleEntryRequirementsChange.bind(this);
        this.handleProfessionalTitleChange = this.handleProfessionalTitleChange.bind(this);
        this.handleFormOfGradudationChange = this.handleFormOfGradudationChange.bind(this);
        this.handleGraduateSihouetteChange = this.handleGraduateSihouetteChange.bind(this);
        this.handleCnpsSumChange = this.handleCnpsSumChange.bind(this);
        this.handleEctsSumChange = this.handleEctsSumChange.bind(this);
        this.handleZzuSumChange = this.handleZzuSumChange.bind(this);
        this.handleExtendedTermAmountChange = this.handleExtendedTermAmountChange.bind(this);
        this.handleExamIssuesChange = this.handleExamIssuesChange.bind(this);
        this.moveStepForward = this.moveStepForward.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }   

    handleNameChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({name: e.currentTarget.value});
    handleStudyDegreeChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({studyDegree: StringToStudyDegree(e.currentTarget.value)});
    handleStudyFormChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({studyForm: StringToFormOfStudy(e.currentTarget.value)});
    handleLearningProfileChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({learningProfile: StringToLearningProfile(e.currentTarget.value)});
    handleTermAmountChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({termAmount: Number.parseInt(e.currentTarget.value)});
    handleEntryRequirementsChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({entryRequirements: e.currentTarget.value});
    handleProfessionalTitleChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({professionalTitle: StringToProfessionalTitle(e.currentTarget.value)});
    handleFormOfGradudationChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({formOfGradution: e.currentTarget.value});
    handleGraduateSihouetteChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({graduateSihouette: e.currentTarget.value});
    handleCnpsSumChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({cnpsSum: Number.parseInt(e.currentTarget.value)});
    handleEctsSumChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({ectsSum: Number.parseInt(e.currentTarget.value)});
    handleZzuSumChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({zzuSum: Number.parseInt(e.currentTarget.value)});
    handleExtendedTermAmountChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({extendedTermAmount: e.currentTarget.value ? true : false});
    handleExamIssuesChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({examIssues: e.currentTarget.value.split("\n")});
    handleDegreeCourseLearningOutcomeCodesStrChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({degreeCourseLearningOutcomeCodesStr: e.currentTarget.value});

    handleSubmit(event: FormEvent) {
        if (this.state.currentStep === this.LastStep) {
            this.setState({toSyllabuses: true});
        }
        event.preventDefault();
    }

    loadFirstStepForm() {
        const studyDegreeOptionList = () => {
            const options = [];
            for (let [type, studyDegree] of Array.from(StudyDegreeToStrMap().entries())) {
                options.push(<option key={type} value={type}>{studyDegree}</option>)
            }
            return options;
        }

        const studyFormOptionList = () => {
            const options = [];
            for (let [type, formOfStudy] of Array.from(FormOfStudyToStrMap().entries())) {
                options.push(<option key={type} value={type}>{formOfStudy}</option>)
            }
            return options;
        }

         const learningProfileOptionList = () => {
            const options = [];
            for (let [type, learningProfile] of Array.from(LearningOutcomeTypeToStrMap().entries())) {
                options.push(<option key={type} value={type}>{learningProfile}</option>)
            }
            return options;
        }

        const professionalTitleOptionList = () => {
            const options = [];
            for (let [type, professionalTitle] of Array.from(ProfessionalTitleToStrMap().entries())) {
                options.push(<option key={type} value={type}>{professionalTitle}</option>)
            }
            return options;
        }

        return <div className="input-form-step">
            <div className="row">
                <InputContainer 
                    label="Nazwa" 
                    type="text" 
                    name="name" 
                    value={this.state.name}
                    onChangeValue={this.handleNameChange}
                />
                <SelectionInputContainer 
                    label="Stopień studiów" 
                    name="studyDegree" 
                    options={studyDegreeOptionList()}
                    onChangeValue={this.handleStudyDegreeChange}
                />
                <SelectionInputContainer 
                    label="Forma studiów" 
                    name="studyForm" 
                    options={studyFormOptionList()}
                    onChangeValue={this.handleStudyFormChange}
                />
            </div>
            <div className="row">
                <SelectionInputContainer 
                    label="Obszar kształcenia" 
                    name="learningProfile" 
                    options={learningProfileOptionList()}
                    onChangeValue={this.handleLearningProfileChange}
                />
                <SelectionInputContainer 
                    label="Obszar kształcenia" 
                    name="learningProfile" 
                    options={professionalTitleOptionList()}
                    onChangeValue={this.handleLearningProfileChange}
                />
            </div>
                <InputContainer 
                    label="Wymagania wstępne" 
                    type="text"
                    name="entryRequirements" 
                    value={this.state.entryRequirements}
                    onChangeValue={this.handleEntryRequirementsChange}
                />
                <InputContainer 
                    label="Sylwetka absolwenta" 
                    type="text" 
                    name="graduateSihouette" 
                    value={this.state.graduateSihouette}
                    onChangeValue={this.handleGraduateSihouetteChange}
                />
                <InputContainer 
                    label="Forma zakończenia studiów" 
                    type="text" 
                    name="formOfGradution" 
                    value={this.state.formOfGradution}
                    onChangeValue={this.handleFormOfGradudationChange}
                />
            </div>;
    };

    loadFinalStepForm() {
        const termSubjectInputList = this.state.terms ? this.state.terms.map(term =>
            <InputContainer 
                label={"Semestr " + term.order} 
                type="text" 
                name="term" 
                value={this.state.degreeCourseLearningOutcomeCodesStr}
                onChangeValue={this.handleDegreeCourseLearningOutcomeCodesStrChange}
            />
        ) : '';
        return <div className="input-step-form">
            {termSubjectInputList}
        </div>
    }
    
    loadSecondStepForm() {
        return <div className="input-step-form">
            <DynamicMultiLineContainer 
                label="Zagadnienia egzaminacyjne" 
                type="text" 
                name="degreeCourseLearningOutcomeCodesStr" 
                value={this.state.degreeCourseLearningOutcomeCodesStr}
                onChangeValue={this.handleDegreeCourseLearningOutcomeCodesStrChange}
            />
            <InputContainer 
                label="Kierunkowe efekty kształcenia" 
                type="text" 
                name="degreeCourseLearningOutcomeCodesStr" 
                value={this.state.degreeCourseLearningOutcomeCodesStr}
                onChangeValue={this.handleDegreeCourseLearningOutcomeCodesStrChange}
            />
        </div>
    }

    moveStepForward() {
        this.setState({
            currentStep: this.state.currentStep + 1
        })
    }

    render() {
        if (this.state.toSyllabuses) {
            return <Redirect to="/syllabuses"/>;
        }

        let currentStepForm: JSX.Element = this.loadFirstStepForm();
        let currentBtn: JSX.Element = <CustomButton 
            name={"Dalej (krok " + this.state.currentStep + " z 3)"} 
            buttonClass="main-btn" onClickFunc={this.moveStepForward}
        />;

         if (this.state.currentStep === this.FirstStep) {
            currentStepForm = this.loadFirstStepForm()
        } else if (this.state.currentStep === 2) {
            currentStepForm = this.loadSecondStepForm()
        } else if (this.state.currentStep === this.LastStep) {
            currentStepForm = this.loadFinalStepForm()
            currentBtn = <FunctionalButton name="Wyślij" buttonClass="main-btn" type="submit"/>
        }

        return (
            <div className="syllabus-creator">
                <div className="row">
                    <h1 className="section-header">Tworzenie...</h1>    
                    <NavLink to="/syllabuses">
                        <FunctionalButton 
                            name="Plan kształcenia" 
                            type="submit"
                            buttonClass="main-btn"/>  
                    </NavLink>
                </div>
                <form className="input-form" onSubmit={this.handleSubmit}>
                    {currentStepForm}
                    {currentBtn}                    
                </form>
            </div>
        );
    };
};

export default SyllabusCreator;