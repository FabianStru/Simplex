import React,{useState} from "react";


function toArray(){
    const [Zeilen, setZeilen] = useState('');
    const [Spalten, setSpalten] = useState('');
    const [Tabelle,setTabelle] = useState([['']['']])



    createNewTabelle(Zeilen, Spalten);
    fillTabelleWithJsonObj();



    return (Tabelle)

    function createNewTabelle(Zeilen, Spalten) {

    }
    function fillTabelleWithJsonObj() {

    }


}

export default toArray();


