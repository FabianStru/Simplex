import React, {useState} from "react";
import './Tabellenfeld.css';

function Tabellenfeld  ({editable, content, onChange, placeholder, onClick}){

    if (editable) {
        return (
            <input className='TabellenfeldE'
                   type="text"
                   onChange={onChange}
                   placeholder={placeholder}
                   onClick={onClick}
            />
        )
    } else {
        return (
            <div className='Tabellenfeld'>{content}</div>
        )
    }
}

export default Tabellenfeld