import React, { Component } from 'react';
import './InputContainer.css';

type InputContainerProps = {
    label: string;
    type: string;
    name: string;
    value: string;
    onChangeValue: any;
};

class InputContainer extends Component<InputContainerProps> {
    render() {
        return (
            <div className="input-container">
                <label>{this.props.label}</label>
                <input 
                    type={this.props.type} 
                    name={this.props.name} 
                    value={this.props.value}
                    onChange={this.props.onChangeValue}
                />
            </div>
        )
    };
}

export default InputContainer;