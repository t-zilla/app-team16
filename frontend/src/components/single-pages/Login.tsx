import React, { Component, FormEvent } from 'react';
import InputContainer from '../ui/InputContainer';
import { FunctionalButton } from '../ui/Button';
import AuthenticationService from '../../services/AuthenticationService';
import Configuration from '../../configuration/Configuration';
import './Login.css'
import { Redirect } from 'react-router-dom';

type LoginProps = {

};

type LoginState = {
    username: string;
    password: string;
    authenticated: boolean;
    authenticationChecked: boolean;
};

class Login extends Component<LoginProps, LoginState> {
    private authenticationService: AuthenticationService;
    constructor(
        props: LoginProps,
        
    ) {
        super(props);
        this.state = {
            username: '',
            password: '',
            authenticated: false,
            authenticationChecked: false
        };

        this.authenticationService = new AuthenticationService(new Configuration());
        this.handlePasswordChange = this.handlePasswordChange.bind(this);
        this.handleUsernameChange = this.handleUsernameChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.authenticationService.isAuthenticated()
            .then(response => {
                this.setState({
                    authenticated: response.data.success,
                    authenticationChecked: true
                })
            }).catch(error => {
                
            });
    }

    handleUsernameChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({username: e.currentTarget.value});
    handlePasswordChange = (e: React.FormEvent<HTMLInputElement>) => this.setState({password: e.currentTarget.value});

    handleSubmit(event: FormEvent) {
        this.authenticationService
            .login(this.state.username, this.state.password)
            .then(response => {
                this.authenticationService.setAccessToken(response.data);
                this.setState({
                    authenticationChecked: true,
                    authenticated: this.authenticationService.getAccessToken() !== ''
                });
            }).catch(error => {
                console.log(error);
            })
        event.preventDefault();
    }

    render() {
        if (this.state.authenticationChecked && this.state.authenticated) {
            return <Redirect to="/"/>
        }

        return (
            <div className="login-page column">
                <h2 className="section-header">Witaj w systemie zarządzania planami kształcenia</h2>
                <h2 className="section-header"><b>Politechniki Wrocławskiej!</b></h2>
                <form className="input-form" onSubmit={this.handleSubmit}>
                <InputContainer
                    label="Nazwa użytkownika"
                    type="text"
                    name="username"
                    value={this.state.username}
                    onChangeValue={this.handleUsernameChange}
                />
                <InputContainer
                    label="Hasło"
                    type="password"
                    name="password"
                    value={this.state.password}
                    onChangeValue={this.handlePasswordChange}
                />
                <FunctionalButton name="Zaloguj" buttonClass="main-btn" type="submit"/>
                </form>
            </div>
        );
    }
}

export default Login;