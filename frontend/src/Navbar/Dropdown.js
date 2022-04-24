import React from "react";
import Button from "../Buttong/Buttong";
import './Dropdown.css';
import {useNavigate} from "react-router-dom";
import Mainpage from "../Mainpage/Mainpage";

const Dropdown = ({ausgeklappt}) => {
    ausgeklappt = false

    return (
        <div
            className={`DropdownHeader ${ausgeklappt && 'DropdownMenu'}`}
        >

        </div>,
            /* er meckert hier mit dem komma, da return normalerweise nur ein element zurückgeben sollte. Wir geben hier 2 Zurück */
            <div>
                <DropdownHeader
                    className='headerRight'
                    text={'Page 2'}
                    float={'right'}
                    onClick={event => window.location.href = '/play'}
                >

                </DropdownHeader>
                <DropdownHeader
                    className='headerLeft'
                    text={'Page 1'}
                    float={'right'}
                    onClick={event => window.location.href = '/'}
                >

                </DropdownHeader>
            </div>

    )
}


const DropdownHeader = ({text, onClick, float}) => {
    return (
        <Button text={text}  onClick={onClick} float={float}>
        </Button>
    )
}

function DropdownMenu() {
    return (
        <div>
            <h1>'Guten Morgen'</h1>
            <Button color={'red'} text={'butong 1'}>
            </Button>
        </div>
    )
}

export default Dropdown