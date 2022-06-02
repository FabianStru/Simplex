import React from "react";

function TabelleToJson(arrayOfMatrix) {

    const finalData = [{}];
    //tempMatrix ist ein temoräres objekt was am ende der Loop in finalData geschoben wird
    const tempObject = {}
    const tempMatrix = [[], []]

    //zuerst gehe ich durch jede Matrix:
    for (let i = 0; i < arrayOfMatrix.length; i++) {
        let columnHeader = [arrayOfMatrix[i].length - 1];

        //initialisiere rowHeader und füllen mit dem inhalt der obersten zeile der Matrix:
        let rowHeader = fillRowheader(i);

        //jetzt gehen wir durch jede Matrix, zeile für Zeile
        for (let j = 0; j < arrayOfMatrix[i]; j++) {

            if (i > 0) { //ersten index auslassen und columHeader updaten
                columnHeader.push(arrayOfMatrix[i][0])
            }
        }
    }
    return finalData;


    function fillRowheader(i) {
        let rowHeader = [arrayOfMatrix.length - 1];
        for (let j = 0; j < arrayOfMatrix[i][0]; j++) {
            if (j > 0) {
                rowHeader = arrayOfMatrix[i][j];
            }
        }
        return rowHeader
    }
}

export default TabelleToJson;