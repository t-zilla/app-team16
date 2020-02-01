import React, { Component } from 'react';
import Menu from '../ui/Menu';
import { 
    GetMockedSubjects, 
    GetMockedDegreeCourseLearningOutcomes, 
    GetMockedMinisterialLearningOutcomes, 
    GetMockedSubjectLearningOutcomes,
    GetMockedFaculties,
    GetMockedLecturers,
    GetMockedSyllabuses
  } from '../../mocks/MockedObjects';
import './Dashboard.css';
import { SubjectList } from '../lists/SubjectList';
import {
    BrowserRouter as Router,
    Switch,
    Route
  } from "react-router-dom";
import SidePanel from '../ui/SidePanel';
import LearningOutcomeList from '../lists/LearningOutcomeList';
import { SyllabusList } from '../lists/SyllabusList';
import { FacultyList } from '../lists/FacultyList';
import { LecturerList } from '../lists/LecturerList';

class Dashboard extends Component {
    render() {
        return (
            <Router>
                <div className="dashboard row">
                    <Menu/>
                    <Switch>
                        <Route path="/subjects">
                            <SubjectList subjectList={GetMockedSubjects()}/>
                        </Route>
                        <Route path="/ministerial-outcomes">
                            <LearningOutcomeList 
                                outcomes={GetMockedMinisterialLearningOutcomes()}
                                outcomesName="Ministerialne efekty kształcenia"
                                outcomesPath="/ministerial-outcomes"
                            />
                        </Route>
                        <Route path="/degree-course-outcomes">
                            <LearningOutcomeList 
                                outcomes={GetMockedDegreeCourseLearningOutcomes()}
                                outcomesName="Kierunkowe efekty kształcenia"
                                outcomesPath="/degree-course-outcomes"
                            />
                        </Route>
                        <Route path="/subject-outcomes">
                            <LearningOutcomeList 
                                outcomes={GetMockedSubjectLearningOutcomes()}
                                outcomesName="Przedmiotowe efekty kształcenia"
                                outcomesPath="/subject-outcomes"
                            />
                        </Route>
                        <Route path="/syllabuses">
                            <SyllabusList syllabusList={GetMockedSyllabuses()}/>
                        </Route>
                        <Route path="/faculties">
                            <FacultyList facultyList={GetMockedFaculties()}></FacultyList>
                        </Route>
                        <Route path="/lecturers">
                            <LecturerList lecturerList={GetMockedLecturers()}></LecturerList>
                        </Route>
                    </Switch>
                    <SidePanel/>
                </div>
            </Router>
        )
    }
};

export default Dashboard;