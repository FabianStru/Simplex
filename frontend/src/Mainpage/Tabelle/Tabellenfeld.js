import React from "react";
import './Tabellenfeld.css';

function Tabellenfeld(editable){
    if (editable) {
        return (
            <input className='Tabellenfeld'
                   type="text"
            />
        )
    } else {

    }

}
export default Tabellenfeld