import React from "react";
import Tabellenfeld from "./Tabellenfeld";
import './Tabelle.css';

const Tabelle = ({Zeileninput, Spalteninput, editable}) => {


    const ZeilenAnzahl = Zeileninput
    const SpaltenAnzahl = Spalteninput


    function generateZeile() {
        const Zeile = []
        for (let i = 0; i < SpaltenAnzahl; i++) {
            Zeile.push(<td key={i}><Tabellenfeld editable={editable} title="test"/></td>)
        }
        return (
            Zeile
        )
    }

    function generateTable() {
        const Tabelle = []
        for (let i = 0; i < ZeilenAnzahl; i++) {
            const Zeile = generateZeile()
            Tabelle.push(<tr key={i}>{Zeile}</tr>)
        }
        return Tabelle;
    }

    return (
        <table>
            <thead>
            </thead>
            <tbody>
            {generateTable()}
            </tbody>
        </table>
    )
}

export default Tabelle