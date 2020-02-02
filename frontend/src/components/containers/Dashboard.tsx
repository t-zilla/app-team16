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
import SyllabusPage from '../single-pages/SyllabusPage';
import SubjectCreator from '../inputs/SubjectCreator';
import SubjectPage from '../single-pages/SubjectPage';
import FacultyPage from '../single-pages/FacultyPage';
import { LearningOutcomePage } from '../single-pages/LearningOutcomePage';
import SyllabusCreator from '../inputs/SyllabusCreator';

class Dashboard extends Component {
    render() {
        return (
            <Router>
                <div className="dashboard row">
                    <Menu/>
                    <Switch>
                        <Route path={"/subjects"}>
                            <SubjectList subjectList={GetMockedSubjects()}/>
                        </Route>
                        <Route exact path="/ministerial-outcomes">
                            <LearningOutcomeList 
                                outcomes={GetMockedMinisterialLearningOutcomes()}
                                outcomesName="Ministerialne efekty kształcenia"
                                outcomesPath="/ministerial-outcomes"
                            />
                        </Route>
                        <Route exact path="/degree-course-outcomes">
                            <LearningOutcomeList 
                                outcomes={GetMockedDegreeCourseLearningOutcomes()}
                                outcomesName="Kierunkowe efekty kształcenia"
                                outcomesPath="/degree-course-outcomes"
                            />
                        </Route>
                        <Route exact path="/subject-outcomes">
                            <LearningOutcomeList 
                                outcomes={GetMockedSubjectLearningOutcomes()}
                                outcomesName="Przedmiotowe efekty kształcenia"
                                outcomesPath="/subject-outcomes"
                            />
                        </Route>
                        <Route exact path="/syllabuses">
                            <SyllabusList syllabusList={GetMockedSyllabuses()}/>
                        </Route>
                        <Route exact path="/faculties">
                            <FacultyList facultyList={GetMockedFaculties()}></FacultyList>
                        </Route>
                        <Route exact path="/lecturers">
                            <LecturerList lecturers={GetMockedLecturers()}></LecturerList>
                        </Route>
                        <Route path="/subject/:id">
                            <SubjectPage subjectId={0}/>
                        </Route>
                        <Route path="/syllabus/:id">
                            <SyllabusPage syllabusId={0}/>
                        </Route>
                        <Route path="/faculty/:id">
                            <FacultyPage facultyId={0}/>
                        </Route>
                        <Route path="/ministerial-outcome/:id">
                            <LearningOutcomePage/>
                        </Route>
                        <Route path="/degree-course-outcome/:id">
                            <LearningOutcomePage/>
                        </Route>
                        <Route path="/subject-outcome/:id">
                            <LearningOutcomePage/>
                        </Route>
                        <Route exact path="/syllabuses/create">                
                            <SyllabusCreator/>
                        </Route>
                    </Switch>
                    <SidePanel/>
                </div>
            </Router>
        )
    }
};

export default Dashboard;