import React, {useState} from "react";
import Tabelle from "./Tabelle/Tabelle";
import './Casual.css';
import Button from "../Button/Button.js";
import jsonToTabelle from "./Tabelle/JsonToTabelle";

/* Hier soll der user das Simplex Problem lösen können */

function Casual(onClick) {
    const [Zeilen, setZeilen] = useState('');
    const [outZeilen, setOutZeilen] = useState(0)
    const [Spalten, setSpalten] = useState('');
    const [outSpalten, setOutSpalten] = useState(0);
    const [aktiv, setAktiv] = useState(false);


    const onSubmit = (e) => {
        e.preventDefault()
    }

    function addTabelle() {
        setAktiv(true)
        setOutSpalten(Spalten)
        setOutZeilen(Zeilen)
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
                    onClick={addTabelle}/>
            </div>
            {aktiv && <Tabelle editable={true} Zeileninput={outZeilen} Spalteninput={outSpalten}/>}
            <div>
                <h2>Hier entsteht dann das Trainingsprogramm für den Simplex Trainer</h2>
            </div>
        </form>

    )
}

export default Casual
