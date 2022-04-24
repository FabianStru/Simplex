import React from "react";
import Tabellenfeld from "./Tabellenfeld";
import './Tabelle.css';

function Tabelle() {
    return (
        <div className='Tabellenrahmen'>
            <div className={'Reihe'}>
                <Tabellenfeld/>
                <Tabellenfeld/>
                <Tabellenfeld/>
            </div>
            <div className={'Reihe'}>
                <Tabellenfeld/>
                <Tabellenfeld/>
                <Tabellenfeld/>
            </div>
            <div className={'Reihe'}>
                <Tabellenfeld/>
                <Tabellenfeld/>
                <Tabellenfeld/>
            </div>
        </div>
    )
}

export default Tabelle