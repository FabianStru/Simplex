import React from "react";
import Button from "../Buttong/Buttong";
import './Dropdown.css';

const Dropdown = ({  ausgeklappt  }) => {
    ausgeklappt=false

    return (
        <div
            className={`DropdownHeader ${ausgeklappt && 'DropdownMenu'}`}
            >

        </div>,
            <div>
                <DropdownHeader
                    className='headerRight'
                    text={'Page 2'}
                    color={'yellow'}
                    float={'right'}
                    onClick={weiterLeitung}
                >

                </DropdownHeader>
                <DropdownHeader
                    className='headerLeft'
                    text={'Page 1'}
                    color={'purple'}
                    float={'left'}
                    onClick={weiterLeitung}
                >
                </DropdownHeader>
            </div>

    )
}

export default Dropdown

const DropdownHeader = ({text , color, onClick, float })=>
{
    return (
        <Button text={text} color={color} onClick={onClick} float={float}>

        </Button>
    )
}
function DropdownMenu() {
    return (
        <h1>'du wicher'</h1>,
        <Button color={'red'} text={'butong 1'}>
        </Button>
    )
 }
 const weiterLeitung = (DropdownHeader) => {
    console.log('click')

 }