import React from "react";


function TabelleToJson(arrayOfMatrix) {

    const finalData = [{}];
    let currentMatrix = [[], []];
    //tempMatrix ist ein temoräres objekt was am ende der Loop in finalData geschoben wird



    //zuerst gehe ich durch jede Matrix:
    for (let i = 0; i < arrayOfMatrix.length; i++) {
        //tempMatrix ist die gekürzte Matrix mit nur zahlen
        const tempMatrix = createTempMatrix(i)

        currentMatrix = arrayOfMatrix[i];

        let columnHeader = new Array(currentMatrix.length - 1);

        //initialisiere rowHeader und füllen mit dem inhalt der obersten zeile der Matrix:
        let rowHeader = fillRowheader(i);

        //jetzt gehen wir Zeile für Zeile durch die Matrix i
        for (let j = 0; j < currentMatrix.length; j++) {
            console.log('counter 1: ' + j)

            if (i > 0) { //ersten index auslassen und columHeader updaten
                columnHeader.push(currentMatrix[j][0])
            }

            for (let k = 0; k < currentMatrix[j].length; k++) {
                if (!(j === 0 || k === 0)) {
                    tempMatrix[j - 1][k - 1] = (currentMatrix[j][k])
                }
            }
        }
        console.log(arrayOfMatrix[0])
        console.log(tempMatrix)
        console.log('columnHeader: ' + columnHeader)
        console.log('rowHeader: ' + rowHeader)
        // TempMatrix, RowHeader und columnheader zu einem Objekt machen und zu finalData hinzufügen:
        const foo = [{'matrix' : tempMatrix, 'columnheader' : columnHeader, 'Rowheader' : rowHeader}]
        finalData.push(foo)
    }
    console.log(finalData)
    return finalData;


    function fillRowheader() {
        let rowHeader = new Array(currentMatrix[0].length - 1);
        for (let j = 1; j < currentMatrix[0].length; j++) {
            rowHeader[j] = currentMatrix[0][j];
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
}

export default TabelleToJson;