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
import SyllabusService from '../../services/SyllabusService';
import Syllabus from '../../models/Syllabus';

type SyllabusCreatorProps = {};

type SyllabusCreatorState = {
    name: string;
    studyDegree: StudyDegree | undefined;
    studyForm: FormOfStudy | undefined;
    learningProfile: LearningProfile | undefined;
    termAmount: number;
    entryRequirements: string;
    professionalTitle: ProfessionalTitle | undefined;
    graduationForm: string;
    graduateSilhouette: string;
    cnpsSum: number | undefined;
    ectsSum: number | undefined;
    zzuSum: number | undefined;
    cnpsMultiplier: number | undefined;
    extendedTermAmount: boolean;
    examIssues: string[];
    examIssuesStr: string;
    terms?: Term[];
    degreeCourseLearningOutcomeCodes?: string[];
    degreeCourseLearningOutcomeCodesStr: string,
    currentStep: number;
    toSyllabuses: boolean;
};

class SyllabusCreator extends Component<SyllabusCreatorProps, SyllabusCreatorState> { 
    private readonly FirstStep: number = 1;
    private readonly LastStep: number = 2;
    private readonly StringArrayDelimeter: string = '\n';
    private syllabusService: SyllabusService;
    constructor(props: SyllabusCreatorProps) {
        super(props);
        this.state = {
            name: '',
            studyDegree: StudyDegree.Undefined,
            studyForm: FormOfStudy.Undefined,
            learningProfile: LearningProfile.Undefined,
            termAmount: 7,
            entryRequirements: '',
            professionalTitle: ProfessionalTitle.Undefined,
            graduationForm: '',
            graduateSilhouette: '',
            cnpsSum: undefined,
            ectsSum: undefined,
            zzuSum: undefined,
            cnpsMultiplier: undefined,
            extendedTermAmount: false,
            examIssues: [],
            examIssuesStr: '',
            terms: [],
            degreeCourseLearningOutcomeCodes: [],
            degreeCourseLearningOutcomeCodesStr: '',
            currentStep: this.FirstStep,
            toSyllabuses: false
        };
        this.syllabusService = new SyllabusService();
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
        this.handleDegreeCourseLearningOutcomeCodesStrChange = this.handleDegreeCourseLearningOutcomeCodesStrChange.bind(this);
        this.handleExamIssuesStrChange = this.handleExamIssuesStrChange.bind(this);
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
    handleFormOfGradudationChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({graduationForm: e.currentTarget.value});
    handleGraduateSihouetteChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({graduateSilhouette: e.currentTarget.value});
    handleCnpsSumChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({cnpsSum: Number.parseInt(e.currentTarget.value)});
    handleEctsSumChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({ectsSum: Number.parseInt(e.currentTarget.value)});
    handleZzuSumChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({zzuSum: Number.parseInt(e.currentTarget.value)});
    handleExtendedTermAmountChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({extendedTermAmount: e.currentTarget.value ? true : false});
    handleExamIssuesChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({examIssues: e.currentTarget.value.split("\n")});
    handleDegreeCourseLearningOutcomeCodesStrChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({degreeCourseLearningOutcomeCodesStr: e.currentTarget.value});
    handleExamIssuesStrChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({examIssuesStr: e.currentTarget.value});

    handleSubmit(event: FormEvent) {
        event.preventDefault();
        if (this.state.currentStep === this.LastStep) {
            const toCreate: Syllabus = new Syllabus(
                0, this.state.name, this.state.studyDegree, this.state.studyForm, this.state.learningProfile, this.state.termAmount,
                this.state.entryRequirements, this.state.professionalTitle, this.state.graduationForm, this.state.graduateSilhouette,
                this.state.cnpsSum, this.state.ectsSum, this.state.zzuSum, this.state.cnpsMultiplier, this.state.extendedTermAmount,
                this.state.examIssues
            );
            
            this.syllabusService.create(toCreate)
                .then(response => {

                }).catch(error => {

                });
            this.setState({toSyllabuses: true});
        }
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
                    name="graduateSilhouette" 
                    value={this.state.graduateSilhouette}
                    onChangeValue={this.handleGraduateSihouetteChange}
                />
                <InputContainer 
                    label="Forma zakończenia studiów" 
                    type="text" 
                    name="graduationForm" 
                    value={this.state.graduationForm}
                    onChangeValue={this.handleFormOfGradudationChange}
                />
            </div>;
    };
    
    loadSecondStepForm() {
        return <div className="input-step-form">
            <DynamicMultiLineContainer 
                label="Zagadnienia egzaminacyjne" 
                type="textarea" 
                name="examIssuesStr" 
                value={this.state.examIssuesStr}
                onChangeValue={this.handleExamIssuesStrChange}
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
            name={"Dalej (krok " + this.state.currentStep + " z " + this.LastStep +")"} 
            buttonClass="main-btn" onClickFunc={this.moveStepForward}
        />;

         if (this.state.currentStep === this.FirstStep) {
            currentStepForm = this.loadFirstStepForm()
        } else if (this.state.currentStep === this.LastStep) {
            currentStepForm = this.loadSecondStepForm()
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