export default class Configuration {
    readonly SERVER_PORT: number = 8080;
    readonly API_URI: string = '/api';
    readonly SUBJECT_URI: string = this.API_URI + '/subjects';
    readonly SYLLABUS_URI: string = this.API_URI + '/syllabuses';
    readonly LECTURER_URI: string = this.API_URI + '/lecturers';
    readonly FACULTY_URI: string = this.API_URI + '/faculties';
};