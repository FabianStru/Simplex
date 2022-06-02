import React, {useState} from "react";
import Tabelle from "./Tabelle/Tabelle";
import './Casual.css';
import Button from "../Button/Button.js";
import jsonToTabelle from "../HelperMethods/JsonToTabelle";
import Tabellenfeld from "./Tabelle/Tabellenfeld";
import Dropdowngenerix from "../Navbar/Dropdowngenerix";

/* Hier soll der user das Simplex Problem lösen können */

function Casual() {
    const [Zeilen, setZeilen] = useState('');
    const [outZeilen, setOutZeilen] = useState(0)
    const [Spalten, setSpalten] = useState('');
    const [outSpalten, setOutSpalten] = useState(0);
    const [aktiv, setAktiv] = useState(false);
    const [serverData, setServerData] = useState({})
    const [dropdownSpalten, setDropdownSpalten]=useState(false)
    const [dropdownZeilen, setDropdownZeilen]=useState(false)
    const [a,setA]=useState(null)
    const [counter, setCounter] = useState(0);

    /*Counter ist so:
    0 = User hat nichts eingegeben
    1= User hat Spalten und Zeilen eingegeben
    2= User hat eine Tabelle an Server geschickt
    2-X = verschiedene Steps anzeigen der gelösten Tabelle
    */

    let matrix = new Array(outZeilen);
    for (let a = 0; a < outZeilen; a++) {
        matrix[a] = new Array(outSpalten)
    }
    function setMatrix(a){
        matrix=a;
    }



    // hier wird die X zeile generiert:

    let oben = [[], []];
    for (let a = 0; a < outSpalten; a++) {
        oben[0].push('X' + (a + 1))
    }
    oben[0][outSpalten - 1] = 'rechte Seite'
    //hier wird die linke zeile generiert:
    let links = new Array(outZeilen)
    for (let b = 0; b < outZeilen; b++) {
            links[b]= new Array('G')
        if(b>=1) {

            links[b] = new Array('S'+ String.fromCharCode('A'.charCodeAt() + b-1))
        }
    }



    const onSubmit = (e) => {
        e.preventDefault()
    }

    function sendTabelle() {

        //an Server die matrix schicken und die json mit verschiedenen matrix erhalten
        let xhr = new XMLHttpRequest()
        let url = "/api/postMatrix"
        xhr.open("POST", url, true)
        xhr.setRequestHeader('Content-Type', 'application/json')
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                setServerData(JSON.parse(xhr.responseText))

                //setzt Counter auf 2 damit die Tabelle angezeigt wird
                setCounter(2);
                //console.log('serverData:' + serverData[0].matrix)
            } else {
                console.log("Fehler: " + xhr.status)
            }
        }
        const readyToJson = {"matrix" : matrix};
        const help = JSON.stringify(readyToJson)
        xhr.send(help)
        console.log('matrix:' + matrix)
        console.log('unsre Daten' + help)

        //console.log(JSON.stringify(readyToJson))
    }

    function addTabelle() {
        if (Spalten > 0 && Zeilen > 0) {
            setAktiv(true)
            setOutSpalten(Spalten)
            setOutZeilen(Zeilen)
            setCounter(1);
        } else {
            setAktiv(false)
        }
    }


    function forward() {
            setCounter(counter + 1)

        //toDo: testen ob am ende der map ist
    }

    function backwards() {
        if(counter>2){
            setCounter(counter - 1)
        }

        //toDo: testen ob auf 1 ist
    }



    return (
        <form className='Casual' onSubmit={onSubmit}>
            <div className='VorAbsenden'>
                <div className='Eingabefeld'>
                    <div className='Spalteneingabe'>
                        <label className='SpaltenLabel'>Spalten:</label>
                        <div
                            className='AnzahlSpalten'
                            onClick={()=>setDropdownSpalten(!dropdownSpalten)}>
                            {!Spalten && "Spalten angeben"}
                            {Spalten && Spalten}
                        </div>
                        {dropdownSpalten &&
                            <Dropdowngenerix
                            Dropdownlist={[1,2,3,4,5,6]}
                            A={setSpalten}
                            dropdownBoolean={setDropdownSpalten}/>}
                    </div>
                    <div className='Zeileneingabe'>
                        <label className='ZeilenLabel'>Zeilen:</label>
                        <div
                            className='AnzahlZeilen'
                            onClick={()=>setDropdownZeilen(!dropdownZeilen)}>
                            {!Zeilen && "Zeilen angeben"}
                            {Zeilen && Zeilen}
                        </div>
                        {dropdownZeilen && <Dropdowngenerix Dropdownlist={[1,2,3,4,5,6]} A={setZeilen} dropdownBoolean={setDropdownZeilen}/>}
                    </div>

                </div>
                <Button
                    className='StartKnopf'
                    text="Start"
                    onClick={addTabelle}/>
            </div>



            {aktiv && <div className='nochGrößererDiv'><div className='GANZGROßERDIV'>

                <Tabelle className='TabelleOben' editable={false} Zeileninput={1} Spalteninput={outSpalten}
                         TableData={oben}/><div className='LinksUndMain'>
                <Tabelle className='TabelleLinks' editable={false} Zeileninput={outZeilen} Spalteninput={1}
                                                    TableData={links}/>
                <Tabelle className='TabelleMain' editable={true} Zeileninput={outZeilen} Spalteninput={outSpalten}
                         onChange={setMatrix}/></div></div>
                <Button
                    className='absenden'
                    text='Abfahrt'
                    onClick={sendTabelle}/>
            </div>
            }

            <div>
                {counter > 1 && displayGiveTable()}
                <div className='NavButtons'>
                    {counter > 1 && aktiv && <Button
                        className='Rückwärts'
                        text='Rückwärts'
                        onClick={backwards}/>}
                    {counter > 1 && aktiv && <Button
                        className='Forwärts'
                        text='Fortwärts'
                        onClick={forward}/>}
                </div>
            </div>
        </form>
    )

    function displayGiveTable() {
        console.log('foo' +serverData[0])
        const fertigMatrix = jsonToTabelle(serverData[counter-2])
        console.log('fertigMatrix: ' + fertigMatrix)
        return (<Tabelle classname='givenTable' editable={false} Zeileninput={fertigMatrix.length}
                         Spalteninput={fertigMatrix[0].length} TableData={fertigMatrix}/>)
        //toDO: display the Table equal to the counter

    }
}


export default Casual
/*
<Tabellenfeld
                    className='ja'
                    editable={true}
                    placeholder='Spalten angeben'
                    required
                    type="text"
                    value={Spalten}
                    onChange={(e) => setSpalten(e.target.value)}/>
 */