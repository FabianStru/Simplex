import React, {useState} from "react";
import Tabelle from "./Tabelle/Tabelle";
import './Play.css';
import Button from "../Button/Button.js";



/* Hier soll der user das Simplex Problem lösen können */


function Play () {
    const [Zeilen,setZeilen] = useState('');
    const [Spalten,setSpalten] = useState('');

    return (
        <main className='Play'>
            <h1>Spalten:</h1>
            <input
                name="Spalten"
                required
                type="text"
                value={Spalten}
                onChange={(e) => setSpalten(e.target.value)}/>
            <h1>Zeilen:</h1>
            <input
                name="Zeilen"
                type="text"
                required
                value={Zeilen}
                onChange={(e) => setZeilen(e.target.value)}/>
            <Button text="Start" ></Button>
            <h2>Hier entsteht dann das Trainingsprogramm für den Simplex Trainer</h2>
            <h2>{Zeilen}</h2>


        </main>
    )
}
export default Play
