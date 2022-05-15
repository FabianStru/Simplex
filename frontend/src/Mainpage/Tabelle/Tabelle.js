import React, {useState} from "react";
import Tabellenfeld from "./Tabellenfeld";
import './Tabelle.css';

const Tabelle = ({Zeileninput, Spalteninput, editable, TableData}) => {

    const ZeilenAnzahl = Zeileninput
    const SpaltenAnzahl = Spalteninput
    let userTable= new Array(ZeilenAnzahl);
    for(let a=0;a<ZeilenAnzahl;a++){
        userTable[a]=new Array(3)
    }

    const handleChange = (row, column, event) => {
        let copy = [...userTable];
        copy[row][column] = +event.target.value;
        userTable=copy

        console.log(userTable);
    };


    function generateZeile(Zeilennummer) {

        const Zeile = []
        for (let i = 0; i < SpaltenAnzahl; i++) {
            const key = i+Zeilennummer
            if (editable) {
                Zeile.push(<td key={key}><Tabellenfeld editable={editable} onChange={(e)=>handleChange(Zeilennummer,i,e)}/></td>)
            } else {
                Zeile.push(<td key={key}><Tabellenfeld content={TableData[Zeilennummer][i]} editable={editable}
                                                     title="test"/></td>)
            }
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