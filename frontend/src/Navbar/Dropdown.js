import React from "react";
import Button from "../Buttong/Buttong";
import './Dropdown.css';
import Mainpage from "../Mainpage/Mainpage";

const Dropdown = ({ausgeklappt}) => {
    ausgeklappt = false

    return (
        <div>
        <div
            className={`DropdownHeader ${ausgeklappt && 'DropdownMenu'}`}
        >

        </div>
            {/* er meckert hier mit dem komma, da return normalerweise nur ein element zurückgeben sollte. Wir geben hier 2 Zurück */}
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
        </div>

    )
}


const DropdownHeader = ({text, color, onClick, float}) => {
    return (
        <Button text={text} color={color} onClick={onClick} float={float}>
        </Button>
    )
}

function DropdownMenu() {
    return (
        <div>
            <h1>'du wicher'</h1>
            <Button color={'red'} text={'butong 1'}>
            </Button>
        </div>
    )
}

export default Dropdown