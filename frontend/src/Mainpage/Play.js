import React, {useState} from "react";
import Tabelle from "./Tabelle/Tabelle";
import './Play.css';
import Button from "../Button/Button.js";
import Tabellenfeld from "./Tabelle/Tabellenfeld";



/* Hier soll der user das Simplex Problem lösen können */




function Play (onClick) {
    const [Zeilen,setZeilen] = useState('');
    const [Spalten,setSpalten] = useState('');

    const onSubmit=(e)=>{
       e.preventDefault()

    }

    return (
        <form className='Play' onSubmit={onSubmit}>
            <div className='Eingabefeld'>
                <label>Spalten:</label>
                <input
                    placeholder='Spalten angeben'
                    name="Spalten"
                    required
                    type="text"
                    value={Spalten}
                    onChange={(e) => setSpalten(e.target.value)}/>
                <label>Zeilen:</label>
                <input
                    placeholder='Zeilen angeben'
                    className="Zeilen"
                    type="text"
                    required
                    value={Zeilen}
                    onChange={(e) => setZeilen(e.target.value)}/>
                <Button
                    className='StartKnopf'
                    text="Start"
                    onClick={onClick}/>
            </div>
            <div>

                <h2>Hier entsteht dann das Trainingsprogramm für den Simplex Trainer</h2>
            </div>

            <Tabelle Zeileninput={Zeilen} Spalteninput={Spalten}/>
        </form>

    )
}
export default Play
