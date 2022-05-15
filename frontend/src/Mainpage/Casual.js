import React, {useState} from "react";
import Tabelle from "./Tabelle/Tabelle";
import './Casual.css';
import Button from "../Button/Button.js";
import Tabellenfeld from "./Tabelle/Tabellenfeld";


/* Hier soll der user das Simplex Problem lösen können */

function Casual() {
    const [Zeilen, setZeilen] = useState('');
    const [outZeilen, setOutZeilen] = useState(0)
    const [Spalten, setSpalten] = useState('');
    const [outSpalten, setOutSpalten] = useState(0);
    const [aktiv, setAktiv] = useState(false);
    let oben = [[],[]];
    let oben1 = [];
    let links = new Array(Zeilen);
    for(let a = 0;a<Spalten;a++){
        oben[0].push('X')
    }
    const onSubmit = (e) => {
        e.preventDefault()
    }


    function addTabelle() {
        setAktiv(true)
        setOutSpalten(Spalten)
        setOutZeilen(Zeilen)


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

            </div>
            {aktiv && <div><Tabelle editable={false} Zeileninput={1} Spalteninput={oben[0].length} TableData={oben} />
                <Tabelle editable={true} Zeileninput={outZeilen} Spalteninput={outSpalten}/></div>}
            <div>
                <h2>Hier entsteht dann das Trainingsprogramm für den Simplex Trainer</h2>
            </div>
        </form>

    )

}
export default Casual
