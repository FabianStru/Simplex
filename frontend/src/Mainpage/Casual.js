import React, {useState} from "react";
import Tabelle from "./Tabelle/Tabelle";
import './Casual.css';
import Button from "../Button/Button.js";
import jsonToTabelle from "./Tabelle/JsonToTabelle";
import Tabellenfeld from "./Tabelle/Tabellenfeld";

/* Hier soll der user das Simplex Problem lösen können */

function Casual() {
    const [Zeilen, setZeilen] = useState('');
    const [outZeilen, setOutZeilen] = useState(0)
    const [Spalten, setSpalten] = useState('');
    const [outSpalten, setOutSpalten] = useState(0);
    const [aktiv, setAktiv] = useState(false);

    const [counter, setCounter] = useState(0);
    /*Counter ist so:
    0 = User hat nichts eingegeben
    1= User hat Spalten und Zeilen eingegeben
    2= User hat eine Tabelle an Server geschickt
    2-X = verschiedene Steps anzeigen der gelösten Tabelle
    */
    const [matrix, setMatrix] = useState([[], []])
    let serverData;


    // hier wird die X zeile generiert:

    let oben = [[], []];
    for (let a = 0; a < outSpalten; a++) {
        oben[0].push('X' + (a + 1))
    }

    //hier wird die linke zeile generiert:
    let links = new Array(outZeilen)
    for (let b = 0; b < outZeilen; b++) {

        links[b] = new Array('A')
    }

    oben[0][outSpalten - 1] = 'rechte Seite'

    const onSubmit = (e) => {
        e.preventDefault()
    }

    function sendTabelle() {


        //an Server die matrix schicken und die json mit verschiedenen matrix erhalten
        let xhr = new XMLHttpRequest()
        let url = "/api/postMatrix"
        xhr.open("POST", url, true)
        xhr.setRequestHeader('Content-Type', 'application/json')
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                serverData = JSON.parse(xhr.responseText)

                //setzt Counter auf 2 damit die Tabelle angezeigt wird
                setCounter(2);
                console.log('serverData:' + serverData[0].matrix)
            } else {
                console.log("Fehler: " + xhr.status)
            }
        }
        const readyToJson = {"matrix:" : matrix};
        xhr.send(JSON.stringify(readyToJson))
        console.log('unsre Daten' + readyToJson)

        //console.log(JSON.stringify(readyToJson))
    }

    function addTabelle() {
        if (Spalten > 0 && Zeilen > 0) {
            setAktiv(true)
            setOutSpalten(Spalten)
            setOutZeilen(Zeilen)
            setCounter(1);
        } else {
            setAktiv(false)
        }
    }


    function forward() {
        setCounter(counter + 1)
        //toDo: testen ob am ende der map ist
    }

    function backwards() {
        setCounter(counter - 1)
        //toDo: testen ob auf 1 ist
    }


    return (
        <form className='Casual' onSubmit={onSubmit}>
            <div className='Eingabefeld'>
                <label>Spalten:</label>
                <Tabellenfeld
                    className='ja'
                    editable={true}
                    placeholder='Spalten angeben'
                    required
                    type="text"
                    value={Spalten}
                    onChange={(e) => setSpalten(e.target.value)}/>
                <label>Zeilen:</label>
                <Tabellenfeld
                    editable={true}
                    placeholder='Zeilen angeben'
                    type="text"
                    required
                    value={Zeilen}
                    onChange={(e) => setZeilen(e.target.value)}/>
                <Button
                    className='StartKnopf'
                    text="Start"
                    onClick={addTabelle}/>

            </div>
            {aktiv && <div className='GANZGROßERDIV'>
                <Tabelle className='TabelleLinks' editable={false} Zeileninput={outZeilen} Spalteninput={1}
                         TableData={links}/>
                <div className='CasualTabellenFelder'>
                    <Tabelle className='TabelleOben' editable={false} Zeileninput={1} Spalteninput={outSpalten}
                             TableData={oben}/>
                    <Tabelle className='TabelleMain' editable={true} Zeileninput={outZeilen} Spalteninput={outSpalten}
                             onChange={setMatrix}/>
                </div>
                <Button
                    className='absenden'
                    text='Abfahrt'
                    onClick={sendTabelle}/>
            </div>}

            <div>
                {counter > 1 && displayGiveTable()}
                <div>
                    {counter > 1 && aktiv && <Button
                        className='Rückwärts'
                        text='Rückwärts'
                        onClick={backwards}/>}
                    {counter > 1 && aktiv && <Button
                        className='Forwärts'
                        text='Fortwärts'
                        onClick={forward}/>}
                </div>
            </div>
        </form>
    )

    function displayGiveTable() {
        const fertigMatrix = jsonToTabelle(serverData[counter - 2])
        console.log('fertigMatrix: ' + fertigMatrix)
        return (<Tabelle classname='givenTable' editable={false} Zeileninput={fertigMatrix.length}
                         Spalteninput={fertigMatrix[0].length} TableData={fertigMatrix}/>)
        //toDO: display the Table equal to the counter

    }
}


export default Casual
