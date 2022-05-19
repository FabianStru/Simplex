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

    // hier wird die X zeile generiert:
    let oben = [[], []];
    for (let a = 0; a < outSpalten; a++) {
        oben[0].push('X' + (a + 1))
    }

    //hier wird die linke zeile generiert:
    let links = new Array(outZeilen)
    for (let b = 0; b < outZeilen; b++) {
        console.log(links)
        links[b]=new Array('A')

    }
    oben[0][outSpalten - 1] = 'rechte Seite'

    const onSubmit = (e) => {
        e.preventDefault()
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
    function onChange(e){
        setSpalten(e.target.value)
        Tabellenfeld.editable=false
        Tabellenfeld.content=Zeilen
    }
    function forward(){

        setCounter(counter+1)
        //toDo: testen ob am ende der map ist
    }
    function backwards(){
            setCounter(counter-1)

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
                    onChange={(e)=>setZeilen(e.target.value)}/>
                <Button
                    className='StartKnopf'
                    text="Start"
                    onClick={addTabelle}/>
                {counter > 0 && aktiv && <Button
                    className='Rückwärts'
                    text='Rückwärts'
                    onClick={backwards}/>}
                {counter > 0 && aktiv && <Button
                    className='Forwärts'
                    text='Fortwärts'
                    onClick={forward}/>}
            </div>
            {aktiv && <div className='GANZGROßERDIV'> <Tabelle className='TabelleLinks' editable={false} Zeileninput={outZeilen} Spalteninput={1} TableData={links}/>
                <div className='CasualTabellenFelder'>
                    <Tabelle className='TabelleOben' editable={false} Zeileninput={1} Spalteninput={outSpalten} TableData={oben}/>
                    <Tabelle className='TabelleMain' editable={true} Zeileninput={outZeilen} Spalteninput={outSpalten}/></div></div>}
            {counter > 0 && displayGiveTable()}
            <div>
                <h2>Hier entsteht dann das Trainingsprogramm für den Simplex Trainer</h2>
            </div>
        </form>

    )

    function displayGiveTable() {
        /*
        const Tabelle = jsonToTabelle(0)
        return( <Tabelle classname='givenTable' editable={false} Zeileninput={Tabelle.length}
                           Spalteninput={Tabelle[0].length} TableData={Tabelle}/>)
        //toDO: display the Table equal to the counter
        */

    }
}


export default Casual
/*
                   onChange={(e) => setZeilen(e.target.value)}/>

                    */