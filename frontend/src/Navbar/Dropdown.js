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
                    onClick={event => window.location.href = '/play'}
                >

                </DropdownHeader>
                <DropdownHeader
                    className='headerLeft'
                    text={'Home'}
                    onClick={event => window.location.href = '/'}
                >

                </DropdownHeader>
            </div>

    )
}


const DropdownHeader = ({text , onClick, float}) => {
    return (
        <Button text={text}  onClick={onClick} float={float}>
        </Button>
    )
}


export default Dropdown