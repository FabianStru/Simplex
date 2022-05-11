import React from "react";
import Tabelle from "./Tabelle/Tabelle";
import jsonToTabelle from "./Tabelle/JsonToTabelle";

function Ranked(){

    const Tabelleranked = jsonToTabelle();

    return(
        <div>
            <div>
                <Tabelle editable={false} Spalteninput={Tabelleranked.length} Zeileninput={Tabelleranked[0].length} TableData={Tabelleranked}/>
            </div>
        </div>
    )
}
export default Ranked
