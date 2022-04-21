import React from "react";

const Dropdown = ({color, ausgeklappt,}) => {
    return (
        <div
            className={`DropdownHeader ${ausgeklappt && 'DropdownMenu'}`}
        >

        </div>,
            <DropdownHeader>
                style = {{backgroundColor: color}}
            </DropdownHeader>
    )
}

export default Dropdown

function DropdownHeader(text) {
    return (
        <header className='DropdownHeader'>
        </header>
    )
}

function DropdownMenu() {

}