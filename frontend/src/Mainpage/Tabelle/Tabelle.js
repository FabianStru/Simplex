import React from "react";
import Tabellenfeld from "./Tabellenfeld";
import './Tabelle.css';

const Tabelle = ({Zeileninput, Spalteninput, editable, TableData}) => {


    const ZeilenAnzahl = Zeileninput
    const SpaltenAnzahl = Spalteninput

    function generateZeile(j) {
        const Zeile = []
        for (let i = 0; i < SpaltenAnzahl; i++) {
            const fu = TableData[i][j]
            Zeile.push(<td key={i}><Tabellenfeld input={fu} editable={editable} title="test"/></td>)
        }
        return (
            Zeile
        )
    }

    function generateTable() {
        const Tabelle = []
        for (let i = 0; i < ZeilenAnzahl; i++) {
            const Zeile = generateZeile(i)
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