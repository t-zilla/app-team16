import React, { Component } from 'react';
import './InputContainer.css';

type SelectionInputContainerProps = {
    label: string;
    name: string;
    options: JSX.Element[];
    onChangeValue: any;
};

class SelectionInputContainer extends Component<SelectionInputContainerProps>{
    render() {
        return (
            <div className="selection-input-container">
                <label>{this.props.label}</label>
                <select 
                    name={this.props.name}
                    onChange={this.props.onChangeValue}>
                        {this.props.options}
                </select>
            </div>
        );
    };
}

export default SelectionInputContainer;