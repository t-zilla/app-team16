import React, { Component } from 'react';
import './DynamicMultiLineContainer.css';

type DynamicMultiLineContainerProps = {
    label: string;
    type: string;
    name: string;
    value: string;
    onChangeValue: any;
};

class DynamicMultiLineContainer extends Component<DynamicMultiLineContainerProps> {
    constructor(props: DynamicMultiLineContainerProps) {
        super(props);
    }
    
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

export default DynamicMultiLineContainer;