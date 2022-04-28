import React, {useState} from "react";
import Tabelle from "./Tabelle/Tabelle";
import './Play.css';
import Button from "../Button/Button.js";



/* Hier soll der user das Simplex Problem lösen können */


function Play () {
    const [Zeilen] = useState('');
    const [Spalten] = useState('');

    return (
        <main className='Play'>
            <h1>Spalten:</h1>
            <input name="Spalten"  type="text" value={Spalten}/>
            <h1>Zeilen:</h1>
            <input name="Zeilen" type="text"  value={Zeilen}/>

            <h2>Hier entsteht dann das Trainingsprogramm für den Simplex Trainer</h2>
        </main>
    )
}
export default Play
