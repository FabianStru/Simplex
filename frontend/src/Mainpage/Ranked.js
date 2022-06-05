import React, {useState} from "react";
import Tabelle from "./Tabelle/Tabelle";
import jsonToTabelle from "../HelperMethods/JsonToTabelle";
import Button from "../Button/Button";
import TabelleToJson from "../HelperMethods/TabelleToJson";

function Ranked() {

    const [aktiv, setAktiv] = useState(false);
    const [tabelleRanked, setTabelleRanked] = useState('')
    const [Tabellen, setTabellen] = useState([])
    const [arrayOfMatrix, setArrayOfMatrix] = useState([0])
    const [counter, setCounter] = useState(2)
    const [response, setResponse] = useState();


    function startRankedMode() {
        getTabelle()
        //start Timer in backend
        //pull Json from backend
    }

    //toDo: check if number or string (first row and first column only string, rest only number)

    function addTabelle() {
        setCounter(counter + 1)

        function changeTabellchen(userTable, ekey) {
            //console.log('a: ' + userTable)
            //console.log('SSJGEA : ' + ekey)
            let copy = arrayOfMatrix
            copy[ekey - 1] = userTable
            setArrayOfMatrix(copy)
        }

        const Tabellchen = <Tabelle key={counter} ekey={counter} classname='inputTable' editable={true}
                                    Zeileninput={tabelleRanked.length}
                                    Spalteninput={tabelleRanked[0].length} onChange={changeTabellchen}/>
        setTabellen([...Tabellen, Tabellchen])
    }

    function removeTabelle() {
        //Wir entfernen die neuste Tabelle und zählen den Counter um eins herunter. Der Counter muss mindestens den Anfangswert behalten
        setTabellen((products) => Tabellen.filter((_, index) => index !== (Tabellen.length - 1)));
        if (counter > 2) {
            setCounter(counter - 1)
        }
        console.log(counter)
    }

    function send() {

        //Das erste Array von ArrayOfMatrix wird zum vom Server übergebenen Array gemacht
        const temp = arrayOfMatrix;
        temp[0] = tabelleRanked;
        setArrayOfMatrix(temp)
        //console.log(arrayOfMatrix)



        let xhr = new XMLHttpRequest()
        let url = "/api/postRanked"
        xhr.open("POST", url, true)
        xhr.setRequestHeader('Content-Type', 'application/json')
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                setResponse(JSON.parse(xhr.responseText))

            } else {
                console.log("Fehler: " + xhr.status)
            }
        }

        //hier noch ändern kumble:
        const readyToJson = TabelleToJson(arrayOfMatrix)
        const help = JSON.stringify(readyToJson)
        xhr.send(help)
        console.log(response)
    }

    function getTabelle() {
        let xhr = new XMLHttpRequest()
        let url = "/api/getRanked"
        xhr.open("GET", url, true)
        xhr.setRequestHeader("Content-Type", "application/json")
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                console.log('antwort : ' + xhr.responseText)
                const HALLLAHBANHNJ = JSON.parse(xhr.responseText)
                console.log('MAULHALTEN : ' + HALLLAHBANHNJ)
                setTabelleRanked(jsonToTabelle(HALLLAHBANHNJ))
                setAktiv(true)
            } else {
                console.log("Fehler: " + xhr.status)
            }
        }
        xhr.send(null)

    }


    return (
        <div>
            <Button
                className='StartKnopf'
                text="Start Ranked"
                onClick={startRankedMode}
            />
            {aktiv && <Button
                className='SendKnopf'
                text="Send"
                onClick={send}
            />}


            <div className="Tabellen">
                {aktiv &&
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
