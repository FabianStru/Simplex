import React from "react";
import Button from "../Buttong/Buttong";
import './Dropdown.css';
import Mainpage from "../Mainpage/Mainpage";

const Dropdown = ({}) => {
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


const DropdownHeader = ({text , onClick, }) => {
    return (
        <Button text={text}  onClick={onClick} >
        </Button>
    )
}


export default Dropdown