import React, {useEffect, useState} from "react";
import Tabelle from "./Tabelle/Tabelle";
import jsonToTabelle from "./Tabelle/JsonToTabelle";
import Button from "../Button/Button";

function Ranked() {

    const [aktiv, setAktiv] = useState(false);
    const [componentstate, setcomponentstate] = useState(null)
    const [tabelleRanked, setTabelleRanked] = useState('')


    function startRankedMode() {
        setTabelleRanked(jsonToTabelle(componentstate))
        console.log(componentstate)
        setAktiv(true)

        //start Timer in backend
        //pull Json from backend
    }

    useEffect(() => {
        const requestOptions = {
            method: 'GET',
            headers: { 'Content-Type': 'application/json' },
        }
        // GET request using fetch inside useEffect React hook
        fetch('/api/getRanked',requestOptions)
            .then(response => response.json())
            .then(data => setcomponentstate(data));
// empty dependency array means this effect will only run once (like componentDidMount in classes)
    }, []);



    return (
        <div>
            <Button
                className='StartKnopf'
                text="Start Ranked"
                onClick={startRankedMode}
            />
            <div className="Tabellen">
               {aktiv&& componentstate && <Tabelle classname='givenTable' editable={false} Zeileninput={tabelleRanked.length}
                                                   Spalteninput={tabelleRanked[0].length} TableData={tabelleRanked}/>}
                {aktiv && <Tabelle classname='inputTable' editable={true} Zeileninput={tabelleRanked.length}
                                   Spalteninput={tabelleRanked[0].length}/>}
            </div>
        </div>
    )
}

export default Ranked
