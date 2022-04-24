import React from "react";
import Dropdown from "./Dropdown";
import './Navbar.css';

{/* Die Navigationsbar, welche das Dropdown menü enthältt */}


function Navbar(){
    return(
        <ul className= 'Navbar-test'>
            <Dropdown/>

        </ul>
    )
}

export default Navbar
