import React from "react";

function TabelleToJson(arrayOfMatrix) {

    const finalData = [{}];
    //tempMatrix ist ein temoräres objekt was am ende der Loop in finalData geschoben wird
    const tempObject = {}
    const tempMatrix = []

    //zuerst gehe ich durch jede Matrix:
    for (let i = 0; i < arrayOfMatrix.length; i++) {
        let columnHeader = [arrayOfMatrix[i].length - 1];

        //initialisiere rowHeader und füllen mit dem inhalt der obersten zeile der Matrix:
        let rowHeader = fillRowheader(i);

        //jetzt gehen wir Zeile für Zeile durch die Matrix i
        for (let j = 0; j < arrayOfMatrix[i]; j++) {

            if (i > 0) { //ersten index auslassen und columHeader updaten
                columnHeader.push(arrayOfMatrix[i][0])
            }
            if (j > 0) {
                tempMatrix.push(arrayOfMatrix[i][j])
            }
        }
        console.log('matrix: ' + tempMatrix)
        console.log('columnHeader: ' + columnHeader)
        console.log('rowHeader: ' + rowHeader)
        // TempMatrix, RowHeader und columnheader zu einem Objekt machen und zu finalData hinzufügen:

    }
    return finalData;


    function fillRowheader(i) {
        let rowHeader = [arrayOfMatrix[0].length - 1];
        for (let j = 0; j < arrayOfMatrix[i][0]; j++) {
            if (j > 0) {
                rowHeader = arrayOfMatrix[i][j];
            }
        }
        return rowHeader
    }
}

export default TabelleToJson;