import React, {useEffect, useState} from "react";
import Tabelle from "./Tabelle/Tabelle";
import jsonToTabelle from "./Tabelle/JsonToTabelle";
import Button from "../Button/Button";

function Ranked() {

    const [aktiv, setAktiv] = useState(false);
    const [componentstate, setcomponentstate] = useState(null)
    const [tabelleRanked, setTabelleRanked] = useState('')
    const [counter, setCounter] = useState(0)
    const [Tabellen, setTabellen] = useState([])


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
            headers: {'Content-Type': 'application/json'},
        }
        // GET request using fetch inside useEffect React hook
        fetch('/api/getRanked', requestOptions)
            .then(response => response.json())
            .then(data => setcomponentstate(data));
// empty dependency array means this effect will only run once (like componentDidMount in classes)
    }, []);

    //toDo: check if number or string (first row and first column only string, rest only number)


    function addTabelle() {
        const Tabellchen = <Tabelle classname='inputTable' editable={true} Zeileninput={tabelleRanked.length}
                                    Spalteninput={tabelleRanked[0].length}/>
        setTabellen([...Tabellen, Tabellchen])
    }

    function removeTabelle() {
        setTabellen((products) => Tabellen.filter((_, index) => index !== (Tabellen.length - 1)));
    }

    return (
        <div>
            <Button
                className='StartKnopf'
                text="Start Ranked"
                onClick={startRankedMode}
            />

            <div className="Tabellen">
                {aktiv && componentstate &&
                    <Tabelle classname='givenTable' editable={false} Zeileninput={tabelleRanked.length}
                             Spalteninput={tabelleRanked[0].length} TableData={tabelleRanked}/>}
                {aktiv && Tabellen}
                {aktiv && <div>
                    <Button
                        className='NextKnopf'
                        text='Neue Tabelle'
                        onClick={addTabelle}>
                    </Button>
                    <Button
                        className='EntfernKnopf'
                        text='Entferne Tabelle'
                        onClick={removeTabelle}>
                    </Button>
                </div>}
            </div>
        </div>
    )
}

export default Ranked

/*
            <div>

                    <Tabelle classname='inputTable' editable={true} Zeileninput={tabelleRanked.length}
                             Spalteninput={tabelleRanked[0].length}/>
                </div>
 */