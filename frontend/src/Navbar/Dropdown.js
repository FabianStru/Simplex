import React from "react";
import Button from "../Button/Button";
import './Dropdown.css';
import {menuItems} from "./MenuItems/menuItems";

/*const Dropdown = ({}) => {
    return (

            <div className='Dropdown'>


                <DropdownHeader
                    className='homeButton'
                    text={'Home'}
                    onClick={event => window.location.href = '/'}
                >
                </DropdownHeader>
                <DropdownHeader
                    className='playButton'
                    text={'Play'}
                    onClick={event => window.location.href = '/play'}
                >
                </DropdownHeader>

            </div>

    )
}

 */
const Dropdown = ({}) => {
    return (
        <ul className='menus'>
            {menuItems.map((menu, index)=>{
                return (
                    <li className='menu-items' key={index}>
                        <a href='/#'>{menu.title}</a>
                    </li>
                )
            })}
        </ul>
    )
}


const DropdownHeader = ({text , onClick, }) => {
    return (
        <Button text={text}  onClick={onClick} >
        </Button>
    )
}


export default Dropdown