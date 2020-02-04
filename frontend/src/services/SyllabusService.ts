import axios from 'axios';
import Configuration from '../configuration/Configuration';
import AuthenticationService from './AuthenticationService';

export default class SyllabusService {
    private conf: Configuration;
    private authenticationService: AuthenticationService;
    
    constructor() {
        this.conf = new Configuration();
        this.authenticationService = new AuthenticationService(this.conf);
    }

    getAll() {
        return axios.request({
            url: this.conf.SYLLABUS_URI,
            method: 'get',
            headers: {
                'Authorization': 'Bearer ' + this.authenticationService.getAccessToken(),
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/json'
            },
        })
    }

    get(id: number) {
        return axios.request({
            url: `${this.conf.SYLLABUS_URI}/${id}`,
            method: 'get',
            headers: {
                'Authorization': 'Bearer ' + this.authenticationService.getAccessToken(),
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/json'
            },
        })
    }
};