package de.fhws.simplex.Calculator;

import de.fhws.simplex.Exception.ArrayLengthIsZeroException;
import org.apache.commons.math3.fraction.BigFraction;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * SteepestUnitAscentCalculator is a {@link Calculator} using the steepest unit ascent procedure, determining the pivotelement.
 *
 * @author Anton Kaiser, Fabian Struensee
 */
public class SteepestUnitAscentCalculator implements Calculator {

    /**
     * This method returns the pivotelement for the given matrix.
     * <p>
     *
     * @param matrix the matrix whose pivotelement is to be determined
     * @return an int array with two elements:
     * <li>[0] -> pivotrow
     * <li>[1] -> pivotcolumn
     */
    @Override
    public int[] getPivotelement(BigFraction[][] matrix) {
        try {
            int pivotcolumn = getIndexOfSmallestNumberInRow(0, matrix);
            int pivotrow = calculateQuotientAndReturnIndexOfSmallestQuotient(pivotcolumn, matrix);
            return new int[]{pivotrow, pivotcolumn};
        }
        catch(ArrayLengthIsZeroException e){
            e.printStackTrace();
        }
        return null;
    }


    /**
     * This method returns the smallest number in the given row.
     * <p>
     *
     * @param row    the row in which the smallest number should be determined
     * @param matrix the matrix in which the smallest number should be determined
     * @return the index of the smallest number in the given row
     * @author Anton Kaiser
     */

    @Override
    public int getIndexOfSmallestNumberInRow(int row, BigFraction[][] matrix) throws ArrayLengthIsZeroException {
        int index = -1; //Exception, falls -1 zurückgegeben wird
        BigFraction smallest = BigFraction.ZERO; // Anfangswert von 0, um zu prüfen, ob in "G"-Zeile ein negativer Wert existiert
        for (int column = 0; column < matrix[0].length - 1; column++) { //Iterieren über jedes Element (= die Spalten) in der "G"-Zeile, ausgenommen das Element von "Rechte Seite"
            if (matrix[0][column].compareTo(smallest) < 0 /*&& matrix[0][column].compareTo(BigFraction.ZERO ) < 0*/) { // Dadurch dass smallest als 0 definiert ist, ist der zweite Fall immer richtig sobald der erste wahr ist.
                smallest = matrix[0][column]; //kleinste negative Zeile aus "G"-Zeile entnehmen, ausgenommen das Element von "Rechte Seite"
                index = column;
            }
        }
        if(index == -1)
            throw new ArrayLengthIsZeroException("Keine Einträge in der Zeile");
        return index;
    }

    /**
     * This method calculates all quotients of the elements of the given column divided by the elements of "Rechte Seite" and returns the index of the smallest one.
     * <p>
     *
     * @param column the column of which the smallest quotient should be determined for
     * @param matrix the matrix for which the smallest quotient should be determined for
     * @return the index of the smallest quotient in the column
     */
    @Override
    public int calculateQuotientAndReturnIndexOfSmallestQuotient(int column, BigFraction[][] matrix) {
        BigFraction smallest = new BigFraction(Integer.MAX_VALUE);
        int index = -1;
        for (int row = 1; row < matrix.length; row++) { //über Pivotspalte iterieren und Quotienten von Pivotspalte geteilt durch "Rechte Seite" ausrechnen und Minimum zurückgeben
            if (matrix[row][column].compareTo(BigFraction.ZERO) <= 0)
                continue; // Durch 0 teilen prüfen und überspringen falls der Fall
            BigFraction quotient = matrix[row][matrix[0].length - 1].divide(matrix[row][column]);
            if (quotient.compareTo(smallest) < 0) {
                smallest = quotient;
                index = row;
            }
        }
        return index;
    }
    // vielleicht alle Werte in ein Array packen und dann das in eine getSmallest Methode packen, sodass wir doppelten Code in getIndexOfSmallestNumberInRow und calculateQuotientAndReturnIndex vermeiden
}