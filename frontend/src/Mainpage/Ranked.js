import React from "react";
import Tabelle from "./Tabelle/Tabelle";
import jsonToTabelle from "./Tabelle/JsonToTabelle";

function Ranked(){

    const Tabelleranked = jsonToTabelle();
    let a = new Array(4)
    for(let b=0;b<a.length;b++){
        a[b]= new Array(3)
    }
    a[1][0]=1;

    return(
        <div>
            <div>
                <Tabelle editable={false} Spalteninput={a.length} Zeileninput={a[0].length} TableData={a}/>
            </div>
        </div>
    )
}
export default Ranked
