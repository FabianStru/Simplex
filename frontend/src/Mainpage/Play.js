import React, {useState} from "react";
import Tabelle from "./Tabelle/Tabelle";
import './Play.css';
import Button from "../Button/Button.js";


/* Hier soll der user das Simplex Problem lösen können */

function Play(onClick) {
    let boolean = true;

    const [Zeilen, setZeilen] = useState('');
    const [Spalten, setSpalten] = useState('');
    const [components, setComponents] = useState([""])

    const onSubmit = (e) => {
        e.preventDefault()
    }

    function addTabelle() {
        setComponents([...components, "Sample Component"])
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
                {boolean ? components.map((item, i) =>
                    (<Tabelle Zeileninput={Zeilen} Spalteninput={Spalten} text={item}/>)): ''}
            </div>

            <div>
                <h2>Hier entsteht dann das Trainingsprogramm für den Simplex Trainer</h2>
            </div>
        </form>

    )
}

export default Play
