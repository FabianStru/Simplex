import React,{useState} from "react";
import * as data from './Servertabelle.json';


function toArray(){
    const ServerTabelle = data.matrix;
    const oben = data.oben;
    const links = data.links;
    let Tabelle = new Array();


    createNewTabelle();
    fillTabelleWithJsonObj();


    console.log(Tabelle)

    return (Tabelle)
    /*
        Erstellt ein mehrdimensionales Array in der Größe der Tabelle +1
         */
    function createNewTabelle() {
        let ServerArray = new Array(ServerTabelle.length+1);
        for(let i = 0; i<ServerArray.length;i++) {
            ServerArray[i]=new Array(ServerTabelle[0].length+1)
        }
        Tabelle=ServerArray
    }


    function fillTabelleWithJsonObj() {
        //füllen der oberen Zeile:
        for (let i = 0; i < oben.length; i++) {
        Tabelle[0][i+1] = oben[i];
        }
        //füllen der linken Spalte:
        for (let i = 0; i < links.length; i++) {
        Tabelle[i+1][0] = links[i];
        }

        //füllen des restes:
        for (var Zeile = 0; Zeile < ServerTabelle.length; Zeile++) {
            for (var Spalte = 0; Spalte < ServerTabelle[Zeile].length; Spalte++) {
                Tabelle[Zeile+1][Spalte+1] = ServerTabelle[Zeile][Spalte];
            }
        Tabelle[0][0] = ""
        }
    }
}

toArray.defaultProps={Zeilen: 4, Spalten: 3, Tabelle: [[3],[4]],}

export default toArray;


