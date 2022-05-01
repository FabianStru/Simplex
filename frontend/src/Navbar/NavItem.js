import React from "react";
import './NavItem.css';
import { useState } from "react";

function NavItem(props){

    const [ausgeklappt, setAusgeklappt] = useState(false);

    return (
        <li className='nav-item'>
            <a href="#" className='icon-button' onClick={()=>setAusgeklappt(!ausgeklappt)}>
                {props.icon}
            </a>

            {ausgeklappt && props.children}

        </li>
    )
}

export default NavItem;