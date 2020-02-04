import React, { Component } from 'react';
import './SubjectList.css';
import { FunctionalButton } from '../ui/Button';
import { Route, NavLink } from "react-router-dom";
import SubjectCreator from '../inputs/SubjectCreator';
import { SubjectItem } from './items/SubjectItem';
import Subject from '../../models/Subject';
import { GetMockedSubjects } from '../../mocks/MockedObjects';
import SubjectService from '../../services/SubjectService';

type SubjectListProps = {
    subjectList: Subject[]
};

type SubjectListState = {
    subjects: Subject[];
};

export class SubjectList extends Component<SubjectListProps, SubjectListState> {
    private subjectService: SubjectService;
    constructor(props: SubjectListProps) {
        super(props);
        this.state = {
            subjects: []
        };
        this.subjectService = new SubjectService();
    }

    componentWillMount() {
        this.subjectService.getAll()
            .then(response => {
                this.setState({
                    subjects: response.data
                });
            })
            .catch(error => {
                console.log(error);
            });
    }

    render() {
        const subjects = this.state.subjects.map((subject, index) => <SubjectItem key={index} subject={subject}/> );
        return (
            <div className="subjects">
                <div className="row">
                    <h1 className="section-header">Przedmioty</h1>    
                    <NavLink to="/subjects/create">
                        <FunctionalButton 
                            name="Dodaj" 
                            type="submit"
                            buttonClass="main-btn"/>  
                    </NavLink>
                    <Route path="/subjects/create">                
                        <SubjectCreator/>
                    </Route>
                </div>
                <ul className="row subjects-list">{subjects}</ul>
            </div>
        );
    }
};