import React from "react";
import Dropdown from "./Dropdown";

{/* Die Navigationsbar, welche das Dropdown menü enthältt */}


function Navbar(){
    return(
        <ul>
            <Dropdown/>
            <li> Test</li>
            <li> ich hab 2 Dunst was ich mach</li>
        </ul>
    )
}

export default Navbar
