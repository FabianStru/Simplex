import React,{useState} from "react";
import * as data from './Tabelle.json';


function toArray(){
    const ServerTabelle = data.matrix;
    const [Zeilen, setZeilen] = useState('');
    const [Spalten, setSpalten] = useState('');
    let Tabelle = new Array();


    createNewTabelle();
    fillTabelleWithJsonObj();


    return (Tabelle)
    /*
    Erstellt ein mehrdimensionales Array in der Größe der Tabelle
     */
    function createNewTabelle() {
        let ServerArray = new Array(ServerTabelle.length);
        for(let i = 0; i<ServerArray.length;i++) {
            ServerArray[i]=new Array(ServerTabelle[i].length)
        }
        Tabelle=ServerArray
    }
    /*
    Füllt das Array mit Werten
     */
    function fillTabelleWithJsonObj() {

    }


}
toArray.defaultProps={Zeilen: 4, Spalten: 3, Tabelle: [[3],[4]],}

export default toArray;


