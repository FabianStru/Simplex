import React, {useState} from "react";
import Tabellenfeld from "./Tabellenfeld";
import './Tabelle.css';
import createUserTable from "./createUserTable";
import Button from "../../Button/Button";

const Tabelle = ({Zeileninput, Spalteninput, editable, TableData}) => {

    const ZeilenAnzahl = Zeileninput
    const SpaltenAnzahl = Spalteninput
    let userTable= new Array(ZeilenAnzahl);
    for(let a=0;a<ZeilenAnzahl;a++){
        userTable[a]=new Array(Spalteninput)
    }

    const handleChange = (row, column, event) => {
        let copy = [...userTable];
        copy[row][column] = +event.target.value;
        userTable=copy

        console.log(userTable);
    }
    function sendTabelle() {
/*
        let xhr = new XMLHttpRequest()
        let url = "http://localhost:8080/api/postMatrix"
        xhr.open("POST",url,true)
        xhr.setRequestHeader()
        xhr.onreadystatechange = function () {
            if(xhr.readyState === 4 && xhr.status === 200) {
                let json = JSON.parse(xhr.responseText)
                console.log(json.matrix)
            }
        }
        xhr.send(JSON.stringify(userTable))

 */
        console.log(JSON.stringify(userTable))
    }



    function generateZeile(Zeilennummer) {

        const Zeile = []
        for (let i = 0; i < SpaltenAnzahl; i++) {
            const key = i+Zeilennummer
            if (editable) {
                Zeile.push(<td key={key}><Tabellenfeld editable={editable} onChange={(e)=>handleChange(Zeilennummer,i, e)}/></td>)
            } else {
                Zeile.push(<td key={key}><Tabellenfeld content={TableData[Zeilennummer][i]} editable={editable}/></td>)
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
    if(editable){
        return (
            <div>
                <table>
                    <thead>
                    </thead>
                    <tbody>
                    {generateTable()}
                    </tbody>
                </table>
                <Button
                    className='absenden'
                    text='Abfahrt'
                    onClick={sendTabelle}/>
            </div>
        )
    }
    else{
        return (
            <div>
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
}

export default Tabelle