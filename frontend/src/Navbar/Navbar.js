import React from "react";
import Dropdown from "./Dropdown";
import './Navbar.css';
import './Dropdown.css';
import NavItem from "./NavItem";

{/* Die Navigationsbar, welche das Dropdown menü enthältt */}


function Navbar(props){
    return(
        <nav className= 'navbar'>
            <ul className='navbar-nav'>
                <NavItem icon='MENU'>
                   <Dropdown/>
                </NavItem>
            </ul>
        </nav>
    )
}

export default Navbar