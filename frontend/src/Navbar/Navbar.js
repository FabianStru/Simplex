import React from "react";
import Dropdown from "./Dropdown";
import './Navbar.css';
import './Dropdown.css';
import NavItem from "./NavItem";
import Button from "../Button/Button";
import {ReactComponent as Icon} from './Icons/Icon.svg';
import {ReactComponent as Icon2} from "./Icons/Icon2.svg";

{/* Die Navigationsbar, welche das Dropdown menü enthältt */}


function Navbar(props){
    return(
        <nav className= 'navbar'>
            <ul className='navbar-nav'>
                <NavItem className='navbar-icon' icon={ <Icon /> }>
                   <Dropdown/>
                </NavItem>
            </ul>
        </nav>
    )
}

export default Navbar
/*
<Button className='darkModeSwitch'/>
 */