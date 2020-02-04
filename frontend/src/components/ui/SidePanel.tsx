import React, { Component } from 'react';
import './SidePanel.css';
import UserTile from './UserTile';
import { CustomButton } from './Button';
import AuthenticationService from '../../services/AuthenticationService';
import Configuration from '../../configuration/Configuration';
import { Redirect } from 'react-router-dom';

const randomAvatarUrl: string = "https://i.pravatar.cc/50";

type SidePanelState = {
    loggingOut: boolean;
};

export default class SidePanel extends Component<{}, SidePanelState> {
    private authenticationService: AuthenticationService;
    constructor(props: {}) {
        super(props);
        this.state = {
            loggingOut: false  
        };
        this.loggingOut = this.loggingOut.bind(this);
        this.authenticationService = new AuthenticationService(new Configuration);
    } 

    loggingOut() {
        this.setState({
            loggingOut: true
        });
        this.authenticationService.logout();
    }

    render() {
        if (this.state.loggingOut) {
            return <Redirect to="/login"/>;
        }

        return (
            <div className="side-panel">
                <CustomButton
                    buttonClass="main-btn logout-btn"
                    name="Wyloguj"
                    onClickFunc={this.loggingOut}
                />
                <UserTile 
                    avatarImgUrl={randomAvatarUrl}
                />
            </div>
        );
    }
};