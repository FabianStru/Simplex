import React, {useEffect, useState} from "react";
import Tabelle from "./Tabelle/Tabelle";
import jsonToTabelle from "./Tabelle/JsonToTabelle";
import Button from "../Button/Button";

function Ranked() {

    const Tabelleranked = jsonToTabelle(0);
    const [aktiv, setAktiv] = useState(false);
    const [componentstate, setcomponentstate] = useState(null)


    function startRankedMode() {
        setAktiv(true)
        //start Timer in backend
        //pull Json from backend
    }

    useEffect(() => {
        const requestOptions = {
            method: 'GET',
            headers: { 'Content-Type': 'application/json' }
            ,
        }
        // GET request using fetch inside useEffect React hook
        fetch('/api/getRanked',requestOptions)
            .then(response => response.json())
            .then(data => setcomponentstate(data));

// empty dependency array means this effect will only run once (like componentDidMount in classes)
    }, []);







    /*
    // Simple POST request with a JSON body using fetch
    const requestOptions = {
        method: 'GET',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ title: 'React POST Request Example' })
    };
    fetch('http://localhost:8080/api/getRanked', requestOptions)
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
                {aktiv&& componentstate && <Tabelle classname='givenTable' editable={false} Zeileninput={componentstate.matrix.length}
                                   Spalteninput={componentstate.matrix[0].length} TableData={componentstate.matrix}/>}
                {aktiv && <Tabelle classname='inputTable' editable={true} Zeileninput={Tabelleranked.length - 1}
                                   Spalteninput={Tabelleranked[0].length - 1}/>}
            </div>
        </div>
    )
}

export default Ranked
