import React, { Component } from 'react';
import './SyllabusList.css';
import { NavLink } from 'react-router-dom';
import { FunctionalButton } from '../ui/Button';
import Syllabus from '../../models/Syllabus';
import { SyllabusItem } from './items/SyllabusItem';
import SyllabusService from '../../services/SyllabusService';
import { GetMockedSyllabuses } from '../../mocks/MockedObjects';

type SyllabusListProps = {
    syllabusList: Syllabus[];
};

type SyllabusListState = {
    syllabuses: Syllabus[];
};

export class SyllabusList extends Component<SyllabusListProps, SyllabusListState> {
    private syllabusService: SyllabusService;
    constructor(props: SyllabusListProps) {
        super(props);
        this.state = {
            syllabuses: GetMockedSyllabuses()
        };
        this.syllabusService = new SyllabusService();
    };

    componentDidMount() {
        this.syllabusService.getAll()
            .then(response => {
                console.log(response);
            }).catch(error => {
                console.log(error);
            });
    }
    
    render() {
        const syllabuses = this.state.syllabuses.map((syllabus, index) => <SyllabusItem key={index} syllabus={syllabus}/> );
        return (
            <div className="syllabuses">
                <div className="row">
                    <h1 className="section-header">Plany kształcenia</h1>    
                    <NavLink to="/syllabuses/create">
                        <FunctionalButton 
                            name="Dodaj" 
                            type="submit"
                            buttonClass="main-btn"/>  
                    </NavLink>
                </div>
                <ul className="row syllabuses-list">{syllabuses}</ul>
            </div>
        );
    }
};