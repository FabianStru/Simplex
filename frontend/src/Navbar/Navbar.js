import React from "react";
import Dropdown from "./Dropdown";
import './Navbar.css';
import './Dropdown.css';

{/* Die Navigationsbar, welche das Dropdown menü enthältt */}


function Navbar(){
    return(
        <nav className= 'Navigationsbar'>
            <Dropdown/>

        </nav>
    )
}

export default Navbar