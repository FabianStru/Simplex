import React from "react";
import Tabellenfeld from "./Tabellenfeld";
import './Tabelle.css';

const Tabelle = ({Zeileninput, Spalteninput}) => {
    const Zeilen = [Zeileninput]
    const Spalten = [Spalteninput]

    return (
        <div>
            <h1>Das ist eine Tabelle</h1>
            <h1>  {Spalten}  {Zeilen} </h1>
            <h1> </h1>
        </div>
    )
}

export default Tabelle