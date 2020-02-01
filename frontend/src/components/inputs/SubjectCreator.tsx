import React, { Component, FormEvent } from 'react';
import './SubjectCreator.css';
import { FunctionalButton } from '../ui/Button';
import { NavLink, Redirect } from "react-router-dom";
import { LearningOutcomeType, LearningOutcomeTypeToStrMap, StringToLearningOutcomeType } from '../../models/enum-types/LearningOutcomeType';
import SelectionInputContainer from '../ui/SelectionInputContainer';
import InputContainer from '../ui/InputContainer';

type SubjectCreatorProps = {};

type SubjectCreatorState = {
    code: string;
    polishName: string;
    englishName: string;
    learningArea: LearningOutcomeType | undefined;
    toSubjects: boolean;
};

class SubjectCreator extends Component<SubjectCreatorProps, SubjectCreatorState> { 
    constructor(props: SubjectCreatorProps) {
        super(props);
        this.state = {
            code: '',
            polishName: '',
            englishName: '',
            learningArea: LearningOutcomeType.Undefined,
            toSubjects: false
        };

        this.handleCodeChange = this.handleCodeChange.bind(this);
        this.handlePolishNameChange = this.handlePolishNameChange.bind(this);
        this.handleEnglishNameChange = this.handleEnglishNameChange.bind(this);
        this.handleLearningAreaChange = this.handleLearningAreaChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }   

    handleCodeChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({code: e.currentTarget.value});
    handlePolishNameChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({polishName: e.currentTarget.value});
    handleEnglishNameChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({englishName: e.currentTarget.value});
    handleLearningAreaChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({learningArea: StringToLearningOutcomeType(e.currentTarget.value)});

    handleSubmit(event: FormEvent) {
        alert(this.state.code + ", " + this.state.englishName + ", " + this.state.polishName + ", " + this.state.learningArea);
        this.setState({toSubjects: true});
    }

    render() {
        const learningOutcomeOptionList = () => {
            const options = [];
            for (let [type, outcome] of Array.from(LearningOutcomeTypeToStrMap().entries())) {
                options.push(<option key={type} value={type}>{outcome}</option>)
            }
            return options;
        }

        if (this.state.toSubjects) {
            return <Redirect to="/subjects"/>;
        }

        return (
            <div className="subject-creator">
                <NavLink to="/subjects">
                    <div className="subject-creator__background"></div>
                </NavLink>
                <form className="input-form" onSubmit={this.handleSubmit}>
                    <div className="row">
                        <InputContainer 
                            label="Kod przedmiotu" 
                            type="text" 
                            name="code" 
                            value={this.state.code}
                            onChangeValue={this.handleCodeChange}
                        />
                        <SelectionInputContainer 
                            label="Obszar kształcenia" 
                            name="learningArea" 
                            options={learningOutcomeOptionList()}
                            onChangeValue={this.handleLearningAreaChange}
                        />
                    </div>
                    <InputContainer 
                        label="Nazwa w j. polskim" 
                        type="text"
                        name="polishName" 
                        value={this.state.polishName}
                        onChangeValue={this.handlePolishNameChange}
                    />
                    <InputContainer 
                        label="Nazwa w j. angielskim" 
                        type="text" 
                        name="englishName" 
                        value={this.state.englishName}
                        onChangeValue={this.handleEnglishNameChange}
                    />
                    <FunctionalButton name="Zatwierdź" buttonClass="main-btn" type="submit"/>
                </form>
            </div>
        );
    };
};

export default SubjectCreator;