import React, { Component } from 'react';
import Faculty from '../../models/Faculty';
import { GetMockedFaculties } from '../../mocks/MockedObjects';

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
                {this.state.faculty ? this.state.faculty.name : ''}
            </div>
        );
    };
};