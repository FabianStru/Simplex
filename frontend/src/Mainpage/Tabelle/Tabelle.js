import React from "react";
import Tabellenfeld from "./Tabellenfeld";
import './Tabelle.css';

const Tabelle = ({Zeileninput, Spalteninput, editable, TableData}) => {


    const ZeilenAnzahl = Zeileninput
    const SpaltenAnzahl = Spalteninput

    function generateZeile(Zeilennummer) {
        const Zeile = []
        for (let i = 0; i < SpaltenAnzahl; i++) {
            Zeile.push(<td key={i}><Tabellenfeld input={TableData[i][Zeilennummer]} editable={editable} title="test"/></td>)
        }
        return (
            Zeile
        )
    }

    function generateTable() {
        const Tabelle = []
        for (let Zeilennummer = 0; Zeilennummer < ZeilenAnzahl; Zeilennummer++) {
            const Zeile = generateZeile(Zeilennummer)
            Tabelle.push(<tr key={Zeilennummer}>{Zeile}</tr>)
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