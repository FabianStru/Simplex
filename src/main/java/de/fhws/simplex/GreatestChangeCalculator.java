package de.fhws.simplex;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * GreatestChangeCalculator is a Calculator using the Greatest Change procedure, determining the pivotelement.
 *
 * @author Fabian Struensee
 * @version 1.1
 * @since 2022-04-07
 */
public class GreatestChangeCalculator extends SteepestUnitAscentCalculator implements Calculator {

    /**
     * This method uses getIndexOfBiggestNumberInRow of allProducts to get the pivotcolumn,
     * and calculateQuotientAndReturnIndex of that column to get the pivotelement.
     *
     * @return int[0] is pivotrow and int[1] is pivotcolumn
     * @author Fabian Struensee
     */
    @Override
    public int[] getPivotelement(BigDecimal[][] matrix) {
        int pivotcolumn = getIndexOfLargestNumberInRow(0,allProducts(matrix));
        int pivotrow = calculateQuotientAndReturnIndex(pivotcolumn, matrix);
        return new int[]{pivotrow, pivotcolumn};
    }

    /**
     *This method returns the largest number in the given row.
     * @return the largest number in the given row
     * @author Fabian Struensee
     */
    public int getIndexOfLargestNumberInRow(int row, BigDecimal[][] matrix) { // was, wenn mehrere gleich groß sind
        int index = -1; //Exception, falls -1 zurückgegeben wird
        BigDecimal biggest = BigDecimal.ZERO;
        for (int column = 0; column < matrix[0].length; column++) { //Iterieren über jedes Element der Spalten in der Zeile row
            if (matrix[0][column].compareTo(biggest) > 0 ){
                biggest = matrix[0][column]; // größtes Element
                index = column;
            }
        }
        return index;
    }

    /**
     * @return a 2D array with one row containing the product of value G times the smallest quotient of "Rechte Seite" divided by value of cells.
     * @author Fabian Struensee
     */
    public BigDecimal[][] allProducts(BigDecimal[][] matrix) // Gibt eine einzeilige Matrix mit den Produkten von dem Wert aus der Zeile G und dem kleinsten quotienten zurück
    {
        BigDecimal[][] result = new BigDecimal[1][matrix[0].length];
        for(int column = 0; column<matrix[0].length; column++) //iteriert über jede Zeile aus einer Spalte
        {
            int index = calculateQuotientAndReturnIndex(column,matrix); // sucht dort den kleinsten Quotienten aus "Rechte Seite" durch den Wert aus der Zelle[index][column] und gibt den index an
            result[0][column] = matrix[0][column].negate().multiply(matrix[index][matrix[0].length-1].divide(matrix[index][column], 15, RoundingMode.HALF_UP)); //multipliziert den wert aus der Gewinnzeile mit dem kleinsten Quotienten und setzt ihn in das Array
        }
        for(BigDecimal b : result[0])
        {
            System.out.println(b);
        }
        return result;
    }


}
