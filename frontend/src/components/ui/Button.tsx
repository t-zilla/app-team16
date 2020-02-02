import React from 'react';
import './Button.css';

type ButtonProps = {
    buttonClass: string;
    name: string;
};

export const Button = ({buttonClass, name}: ButtonProps) => <div className={buttonClass}>{name}</div>;

type FunctionalButtonProps = {
    buttonClass: string;
    type: 'submit' | 'reset' | 'button' | undefined;
    name: string;
};

export const FunctionalButton = ({buttonClass, type, name}: FunctionalButtonProps) => <button className={buttonClass} type={type}>{name}</button>

type CustomButtonProps = {
    buttonClass: string;
    onClickFunc: any;
    name: string;
};

export const CustomButton = ({buttonClass, onClickFunc, name}: CustomButtonProps) => <div className={buttonClass} onClick={onClickFunc}>{name}</div>
