import React, {useState} from "react";
import './Tabellenfeld.css';

function Tabellenfeld  ({editable, content, onChange, placeholder}){

    if (editable) {
        return (
            <input className='TabellenfeldE'
                   type="text"
                   onChange={onChange}
                   placeholder={placeholder}
            />
        )
    } else {
        return (
            <div className='Tabellenfeld'>{content}</div>
        )
    }
}

export default Tabellenfeld