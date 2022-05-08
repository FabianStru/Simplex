import jsonToTabelle from "./Tabelle/JsonToTabelle";
import React from 'react';

function Ranked(){
    return(
        <div>
            <h1>
                {jsonToTabelle()[0]}
                {jsonToTabelle()[1]}
                {jsonToTabelle()[2]}
                {jsonToTabelle()[3]}
            </h1>
        </div>
    )
}
export default Ranked