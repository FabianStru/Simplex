import React from "react";
import Tabellenfeld from "./Tabellenfeld";
import './Tabelle.css';

const Tabelle = (Zeileninput, Spalteninput) => {
    const Zeilen = [Zeileninput]
    const Spalten = [Spalteninput]
    return (
        <Tabelle>
            <h1>Das ist eine Tabelle</h1>
            <h1 title={Zeilen}> Zeilen</h1>
            <h1 title={Spalten}> Spalten</h1>
        </Tabelle>
    )
}

export default Tabelle