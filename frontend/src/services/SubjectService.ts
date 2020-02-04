import axios from 'axios';
import Configuration from '../configuration/Configuration';
import AuthenticationService from './AuthenticationService';

export default class SubjectService {
    private conf: Configuration;
    private authenticationService: AuthenticationService;
    
    constructor() {
        this.conf = new Configuration();
        this.authenticationService = new AuthenticationService(this.conf);
        //this.authenticationService.setupInterceptor(axios);
    }

    getAll() {
        return axios.request({
            url: this.conf.SUBJECT_URI,
            method: 'get',
            headers: {
                'Authorization': 'Bearer ' + this.authenticationService.getAccessToken(),
                'Access-Control-Allow-Origin': '*'
            },
        })
    }

    get(id: number) {
        return axios.request({
            url: `${this.conf.SUBJECT_URI}/${id}`,
            method: 'get',
            headers: {
                'Authorization': 'Bearer ' + this.authenticationService.getAccessToken(),
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/json'
            },
        })
    }
};