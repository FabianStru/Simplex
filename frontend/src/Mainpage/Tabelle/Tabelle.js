import React, {useState} from "react";
import Tabellenfeld from "./Tabellenfeld";
import './Tabelle.css';
import createUserTable from "./createUserTable";
import Button from "../../Button/Button";

const Tabelle = ({Zeileninput, Spalteninput, editable, TableData, onChange, ekey}) => {

    const ZeilenAnzahl = Zeileninput
    const SpaltenAnzahl = Spalteninput
    let userTable = new Array(ZeilenAnzahl);
    for (let a = 0; a < ZeilenAnzahl; a++) {
        userTable[a] = new Array(Spalteninput)
    }

    const handleChange = (row, column, event) => {
        let copy = [...userTable];
        copy[row][column] = +event.target.value;
        userTable = copy
        console.log('ekey TAbelle : '+ekey)
        //console.log(userTable);
        onChange(userTable,ekey);
    }

    function generateZeile(Zeilennummer) {

        const Zeile = []
        for (let i = 0; i < SpaltenAnzahl; i++) {
            const key = i + Zeilennummer
            if (editable) {
                Zeile.push(<td key={key}><Tabellenfeld className='Tabellenfeld' editable={editable}
                                                       onChange={(e) => handleChange(Zeilennummer, i, e)}/></td>)
            } else {
                Zeile.push(<td key={key}><Tabellenfeld className='Tabellenfeld' content={TableData[Zeilennummer][i]} editable={editable}/></td>)
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

                <div className='Tabellejs'>

                    <table>
                        <thead>
                        </thead>
                        <tbody>
                        {generateTable()}
                        </tbody>
                    </table>
                </div>

        )
}

export default Tabelle