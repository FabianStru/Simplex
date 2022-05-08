import React,{useState} from "react";
import * as data from './Servertabelle.json';


function toArray(){
    const ServerTabelle = data.matrix;
    const [Tabelle,setTabelle] = useState([''][''])


    createNewTabelle(Zeilen, Spalten);
    fillTabelleWithJsonObj();



    return (Tabelle)

    function createNewTabelle(Zeilen, Spalten) {

    }

    function fillTabelleWithJsonObj() {
        //füllen der oberen Zeile:
        for (let i = 1; i < ServerTabelle.matrix[0].length; i++) {
        Tabelle[0][i] = ServerTabelle.oben[i-1];
        }
        //füllen der linken Spalte:
        for (let i = 1; i < ServerTabelle.matrix.length; i++) {
        Tabelle[i][0] = ServerTabelle.links[i-1];
        }
        //füllen des restes:
        for (var i = 0; i < ServerTabelle.matrix.length; i++) {
            for (var j = 0; j < ServerTabelle.matrix[i].length; j++) {
                Tabelle[i+1][j+1] = ServerTabelle[i][j];
            }

        }
    }
}

export default toArray;


