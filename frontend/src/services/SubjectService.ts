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
        axios.interceptors.request.use(config => {
            const token = this.authenticationService.getAccessToken();
            if (token) {
                config.headers['Authorization'] = `Bearer ${token}`;
            }
            return config;
        }, error => {
            Promise.reject(error);
        });
        
        return axios.request({
            url: this.conf.SUBJECT_URI,
            method: 'get',
            headers: {
                'Authorization': 'Bearer ' + this.authenticationService.getAccessToken(),
                'Access-Control-Allow-Origin': '*'
            },
        })
        //return axios.get(this.conf.SYLLABUS_URI);
    }
};