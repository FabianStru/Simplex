import React from "react";


function TabelleToJson(arrayOfMatrix) {

    const finalData = [];
    let currentMatrix = [[], []];

    let tempMatrix = [[],[]]
    //tempMatrix ist ein temoräres objekt was am ende der Loop in finalData geschoben wird
    let rowHeader = []


    //zuerst gehe ich durch jede Matrix:
    for (let i = 0; i < arrayOfMatrix.length; i++) {

        //current Matrix ist die Matrix, welche aktuell bearbeitet wird
        currentMatrix = arrayOfMatrix[i];

        //tempMatrix ist die gekürzte Matrix mit nur zahlen
        tempMatrix = createTempMatrix(i)


        rowHeader = new Array(currentMatrix.length - 1);

        //initialisiere rowHeader und füllen mit dem inhalt der obersten zeile der Matrix:
        let columnHeader = fillRowheader(i);

        //jetzt gehen wir Zeile für Zeile durch die Matrix i
        for (let j = 0; j < currentMatrix.length; j++) {

            fillColumnHeader(j, rowHeader)

            fillMatrix(j, tempMatrix)

        }
        // TempMatrix, RowHeader und columnheader zu einem Objekt machen und zu finalData hinzufügen:
        const foo = {'matrix': tempMatrix, 'rowHeader': rowHeader, 'columnHeader': columnHeader}
        finalData.push(foo)
    }
    console.log(finalData)
    return finalData;


    function fillRowheader() {
        let rowHeader = new Array(currentMatrix[0].length - 1);

        for (let j = 0; j < currentMatrix[0].length - 1; j++) {
            rowHeader[j] = currentMatrix[0][j + 1];
        }
        return rowHeader
    }

    function createTempMatrix(i) {
        let matrix = new Array(arrayOfMatrix[i].length - 1)
        for (let j = 0; j < matrix.length; j++) {
            matrix[j] = new Array(arrayOfMatrix[i][j].length - 1)
        }
        return matrix;
    }

    function fillColumnHeader(j) {
        //ersten index auslassen und columHeader updaten
        if (!(j === 0)) {
            rowHeader[j - 1] = currentMatrix[j][0]
        }
    }

    function fillMatrix(j) {
        for (let k = 0; k < currentMatrix[j].length; k++) {
            if (!(j === 0 || k === 0)) {
                tempMatrix[j - 1][k - 1] = (currentMatrix[j][k])
            }
        }
    }
}

export default TabelleToJson;