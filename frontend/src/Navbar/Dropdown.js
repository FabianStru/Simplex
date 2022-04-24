import React from "react";
import Button from "../Buttong/Buttong";
import './Dropdown.css';
import Mainpage from "../Mainpage/Mainpage";

const Dropdown = ({ausgeklappt}) => {
    return (

            <div>
                <DropdownHeader
                    className='headerRight'
                    text={'Play'}
                    color={'yellow'}
                    onClick={event => window.location.href = '/play'}
                >

                </DropdownHeader>
                <DropdownHeader
                    className='headerLeft'
                    text={'Home'}
                    color={'purple'}
                    onClick={event => window.location.href = '/'}
                >

                </DropdownHeader>
        </div>

    )
}


const DropdownHeader = ({text, color, onClick, float}) => {
    return (
        <Button text={text} color={color} onClick={onClick} float={float}>
        </Button>
    )
}


export default Dropdown