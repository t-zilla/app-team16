import axios from 'axios';
import Configuration from '../configuration/Configuration';
import Token from '../models/authentication/Token';

export default class AuthenticationService {
    private readonly ACCESS_TOKEN_KEY = 'accessToken';
    private readonly ACCESS_TOKEN_TYPE_KEY = 'accessTokenType';

    constructor(private conf: Configuration) { 
        this.login = this.login.bind(this);
    }

    setAccessToken(token: Token) {
        localStorage.setItem(this.ACCESS_TOKEN_KEY, token.accessToken);
        localStorage.setItem(this.ACCESS_TOKEN_TYPE_KEY, token.accessToken);
    }

    getAccessToken = () => localStorage.getItem(this.ACCESS_TOKEN_TYPE_KEY);

    getAccessTokenType = () => localStorage.getItem(this.ACCESS_TOKEN_TYPE_KEY);

    isAuthenticated = () => this.getAccessToken() && this.getAccessTokenType();

    login(username: string, password: string) {
        return axios.request<Token>({
            url: this.conf.LOGIN_URI,
            method: 'post',
            headers: {
                'Access-Control-Allow-Origin': '*'
            },
            transformResponse: [function(data, headers) {
                return new Token(
                    JSON.parse(data).accessToken,
                    JSON.parse(data).tokenType,
                );
            }],
            data: {
                username: username,
                password: password
            },
        });
    }
};