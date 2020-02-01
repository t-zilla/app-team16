import React, { Component } from 'react';
import { Button } from './Button';
import './Menu.css';
import { NavLink } from "react-router-dom";

class Menu extends Component {
    render() {
        return(
            <div className="menu">
                <h3 className="menu__header">Efekty kształcenia</h3>
                <ul className="menu__options-wrapper column">
                    <li><NavLink to="/ministerial-outcomes"><Button name="Ministerialne efekty kształcenia" buttonClass="list-btn"/></NavLink></li>
                    <li><NavLink to="/degree-course-outcomes"><Button name="Kierunkowe efekty kształcenia" buttonClass="list-btn"/></NavLink></li>
                    <li><NavLink to="/subject-outcomes"><Button name="Przedmiotowe efekty kształcenia" buttonClass="list-btn"/></NavLink></li>
                </ul>
                <h3 className="menu__header">Uczelnia</h3>
                <ul className="menu__options-wrapper column">
                    <li><NavLink to="/syllabuses"><Button name="Plany ksztacenia" buttonClass="list-btn"/></NavLink></li>
                    <li><NavLink to="/faculties"><Button name="Kierunki" buttonClass="list-btn"/></NavLink></li>
                    <li><NavLink to="/subjects"><Button name="Przedmioty" buttonClass="list-btn"/></NavLink></li>
                    <li><NavLink to="/lecturers"><Button name="Prowadzący" buttonClass="list-btn"/></NavLink></li>
                </ul>
            </div>
        );
    }
};

export default Menu;