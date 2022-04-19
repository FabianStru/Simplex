package de.fhws.simplex;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * documentation
 */
public class SteepestUnitAscentCalculator implements Calculator {

    /**
     * documentation
     */
    @Override
    public int[] getPivotelement(BigDecimal[][] matrix) {
        int pivotcolumn = getIndexOfSmallestNumberInRow(0, matrix); //
        int pivotrow = calculateQuotientAndReturnIndex(pivotcolumn, matrix);
        return new int[]{pivotrow, pivotcolumn};
    }


    @Override
    public int getIndexOfSmallestNumberInRow(int row, BigDecimal[][] matrix) {
        int index = -1; //Exception, falls -1 zurückgegeben wird
        BigDecimal smallest = BigDecimal.ZERO; // Anfangswert von 0, um zu prüfen, ob in "G"-Zeile ein negativer Wert existiert
        for (int column = 0; column < matrix[0].length - 1; column++) { //Iterieren über jedes Element (= die Spalten) in der "G"-Zeile, ausgenommen das Element von "Rechte Seite"
            if (matrix[0][column].compareTo(smallest) < 0 /*&& matrix[0][column].compareTo(BigDecimal.ZERO ) < 0*/) { // Dadurch dass smallest als 0 definiert ist, ist der zweite Fall immer richtig sobald der erste wahr ist.
                smallest = matrix[0][column]; //kleinste negative Zeile aus "G"-Zeile entnehmen, ausgenommen das Element von "Rechte Seite"
                index = column;
            }
        }

        return index;
    }

    @Override
    public int calculateQuotientAndReturnIndex(int column, BigDecimal[][] matrix) {
        BigDecimal smallest = BigDecimal.valueOf(Integer.MAX_VALUE);
        int index = -1;
        for (int row = 1; row < matrix.length; row++) { //über Pivotspalte iterieren und Quotienten von Pivotspalte geteilt durch "Rechte Seite" ausrechnen und Minimum zurückgeben
            if (matrix[row][column].compareTo(BigDecimal.ZERO)<=0) continue; // Durch 0 teilen prüfen und überspringen falls der Fall
            BigDecimal quotient = matrix[row][matrix[0].length - 1].divide(matrix[row][column], 15, RoundingMode.HALF_UP);
            if (quotient.compareTo(smallest) < 0) {
                smallest = quotient;
                index = row;
            }
        }
        return index;
    }
    // vielleicht alle Werte in ein Array packen und dann das in eine getSmallest Methode packen, sodass wir doppelten Code in getIndexOfSmallestNumberInRow und calculateQuotientAndReturnIndex vermeiden
}