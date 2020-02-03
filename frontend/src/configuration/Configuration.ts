export default class Configuration {
    readonly SERVER_PORT: number = 8080;
    readonly API_URI: string = `http://localhost:${this.SERVER_PORT}/api`;
    readonly LOGIN_URI: string = this.API_URI + '/auth/generate-token';
    readonly SUBJECT_URI: string = this.API_URI + '/subjects';
    readonly SYLLABUS_URI: string = this.API_URI + '/syllabuses';
    readonly LECTURER_URI: string = this.API_URI + '/lecturers';
    readonly FACULTY_URI: string = this.API_URI + '/faculties';
};