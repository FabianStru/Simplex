import React from "react";
import Dropdown from "./Dropdown";

{/* Die Navigationsbar, welche das Dropdown menü enthältt */}


function Navbar(){
    return(
        <ul>
            <Dropdown/>
            <h1> Test</h1>
            <h2> ich hab 2 Dunst was ich mach</h2>
        </ul>
    )
}

export default Navbar
