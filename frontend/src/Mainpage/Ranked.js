import React, {useState} from "react";
import Tabelle from "./Tabelle/Tabelle";
import jsonToTabelle from "./Tabelle/JsonToTabelle";
import Button from "../Button/Button";

function Ranked() {

    const Tabelleranked = jsonToTabelle();
    const [aktiv, setAktiv] = useState(false);

    function startRankedMode() {
        setAktiv(true)
        //start Timer in backend
        //pull Json from backend
    }

    /*
    // Simple POST request with a JSON body using fetch
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ title: 'React POST Request Example' })
    };
    fetch('http://localhost:8080/home?zeilen=4&spalten=3&matrix=((-300,-500,-36000),(1,2,170),(1,1,150),(0,3,180))', requestOptions)
        .then(response => response.json())
        .then(data => this.setState({ postId: data.id }));
    console.log(requestOptions.matrix)
    */


    return (
        <div>
            <Button
                className='StartKnopf'
                text="Start Ranked"
                onClick={startRankedMode}
            />
            <div className="Tabellen">
                {aktiv && <Tabelle classname='givenTable' editable={false} Zeileninput={Tabelleranked.length}
                                   Spalteninput={Tabelleranked[0].length} TableData={Tabelleranked}/>}
                {aktiv && <Tabelle classname='inputTable' editable={true} Zeileninput={Tabelleranked.length - 1}
                                   Spalteninput={Tabelleranked[0].length - 1}/>}

            </div>
        </div>
    )
}

export default Ranked
