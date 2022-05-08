import React from "react";
import './Tabellenfeld.css';

function Tabellenfeld(editable, input){
    if (editable) {
        return (
            <input className='Tabellenfeld'
                   type="text"
            />
        )
    } else {
        return (
            <div className='Tabellenfeld'>{input}</div>
        )
    }

}
export default Tabellenfeld