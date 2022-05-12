import React, {useState} from "react";
import Tabellenfeld from "./Tabellenfeld";
import './Tabelle.css';

const Tabelle = ({Zeileninput, Spalteninput, editable, TableData}) => {

    const ZeilenAnzahl = Zeileninput
    const SpaltenAnzahl = Spalteninput
    /*
    const [matrix, setMatrix] = useState(Array.from({length: ZeilenAnzahl},()=> Array.from({length: SpaltenAnzahl}, () => null)));

    const handleChange = (row, column, event) => {
        let copy = [...matrix];
        copy[row][column] = +event.target.value;
        setMatrix(copy);

        console.log(matrix);
    };
ab hier meins
    let userTable= new Array(ZeilenAnzahl);
    for(let a=0;a<ZeilenAnzahl;a++){
        userTable[a]=new Array(4)
    }

    const [userTable , setUserTable]= useState([ZeilenAnzahl][SpaltenAnzahl])
userTable[Zeilennummer][e.key]=e.target.value
     */


    function generateZeile(Zeilennummer) {
        /*
        function onChange(e){

            handleChange(Zeilennummer, e.target.key, e)

        }

         */

        const Zeile = []
        for (let i = 0; i < SpaltenAnzahl; i++) {
            if (editable) {
                Zeile.push(<td key={i}><Tabellenfeld editable={editable} title="test" /*onChange={onChange}*//></td>)
            } else {
                Zeile.push(<td key={i}><Tabellenfeld content={TableData[Zeilennummer][i]} editable={editable}
                                                     title="test"/></td>)
            }
        }

        return (
            Zeile
        )

    }

    function generateTable() {
        const Tabelle = []
        for (let Zeilennummer = 0; Zeilennummer < ZeilenAnzahl; Zeilennummer++) {
            const Zeile = generateZeile(Zeilennummer)
            Tabelle.push(<tr key={Zeilennummer}>{Zeile}</tr>)
        }
        return Tabelle;
    }
    return (
        <table>
            <thead>
            </thead>
            <tbody>
            {generateTable()}
            </tbody>
        </table>
    )
}

export default Tabelle