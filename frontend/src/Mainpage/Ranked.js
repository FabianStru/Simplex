import React, {useState} from "react";
import Tabelle from "./Tabelle/Tabelle";
import jsonToTabelle from "./Tabelle/JsonToTabelle";
import Button from "../Button/Button";

function Ranked() {

    const [aktiv, setAktiv] = useState(false);
    const [tabelleRanked, setTabelleRanked] = useState('')


    async function fetchAsync () {
        let response = await fetch("/api/getRanked");
        return await response.json();
    }


    function getTabelle(){
        let xhr = new XMLHttpRequest()
        let url = "/api/getRanked"
        xhr.open("GET", url, true)
        xhr.setRequestHeader("Content-Type","application/json")
        xhr.onreadystatechange = function () {
            if(xhr.readyState === 4 && xhr.status === 200) {
                console.log('antwort : '+xhr.responseText)
                const HALLLAHBANHNJ = JSON.parse(xhr.responseText)
                console.log('MAULHALTEN : ' +HALLLAHBANHNJ)
                setTabelleRanked(jsonToTabelle(HALLLAHBANHNJ))
                setAktiv(true)
            }else {
                console.log("Fehler: " + xhr.status)
            }
        }
        xhr.send(null)

    }
    function startRankedMode() {
        getTabelle()


        //start Timer in backend
        //pull Json from backend
    }

/*
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

    //toDo: check if number or string (first row and first column only string, rest only number)
 */
    return (
        <div>
            <Button
                className='StartKnopf'
                text="Start Ranked"
                onClick={getTabelle}
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
