package de.fhws.simplex.Calculator;

import org.apache.commons.math3.fraction.BigFraction;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * GreatestChangeCalculator is a {@link Calculator} using the Greatest Change procedure, determining the pivotelement.
 * <p>
 * @author Fabian Struensee
 */
public class GreatestChangeCalculator extends SteepestUnitAscentCalculator implements Calculator {

    /**
     * This method uses getIndexOfLargestNumberInRow of allProducts to get the pivotcolumn,
     * and calculateQuotientAndReturnIndex of that column to get the pivotelement.
     * <p>
     * @return int[0] is pivotrow and int[1] is pivotcolumn
     * @author Fabian Struensee
     */
    @Override
    public int[] getPivotelement(BigFraction[][] matrix) {
        int pivotcolumn = getIndexOfLargestNumberInRow(0,allProducts(matrix));
        int pivotrow = calculateQuotientAndReturnIndexOfSmallestQuotient(pivotcolumn, matrix);
        return new int[]{pivotrow, pivotcolumn};
    }

    /**
     *  This method returns the index of the largest number in the given row.
     *  <p>
     * @param row
     * @param matrix
     * @return the largest number in the given row
     * @author Fabian Struensee
     */
    public int getIndexOfLargestNumberInRow(int row, BigFraction[][] matrix) { // was, wenn mehrere gleich groß sind
        int index = -1; //Exception, falls -1 zurückgegeben wird
        BigFraction biggest = BigFraction.ZERO;
        for (int column = 0; column < matrix[0].length; column++) { //Iterieren über jedes Element der Spalten in der Zeile row
            if (matrix[0][column].compareTo(biggest) > 0 ){
                biggest = matrix[0][column]; // größtes Element
                index = column;
            }
        }
        return index;
    }

    /**
     * Calculates the smallest quotient of the cell divided by the value of "Rechte Seite" in its row for each column,
     * and multiples it with the value of "G" in its column. The produkt of that multiplikation is put into the return array.
     * <p>
     * @param matrix
     * @return a 2D array with one row containing the product of value G times the smallest quotient of "Rechte Seite" divided by value of cells.
     * @author Fabian Struensee
     */
    public BigFraction[][] allProducts(BigFraction[][] matrix) // Gibt eine einzeilige Matrix mit den Produkten von dem Wert aus der Zeile G und dem kleinsten quotienten zurück
    {
        BigFraction[][] result = new BigFraction[1][matrix[0].length];
        for(int column = 0; column<matrix[0].length; column++) //iteriert über jede Zeile aus einer Spalte
        {
            int index = calculateQuotientAndReturnIndexOfSmallestQuotient(column,matrix); // sucht dort den kleinsten Quotienten aus "Rechte Seite" durch den Wert aus der Zelle[index][column] und gibt den index an
            result[0][column] = matrix[0][column].negate().multiply(matrix[index][matrix[0].length-1].divide(matrix[index][column])); //multipliziert den wert aus der Gewinnzeile mit dem kleinsten Quotienten und setzt ihn in das Array
        }
        for(BigFraction b : result[0])
        {
            System.out.println(b);
        }
        return result;
    }


}
