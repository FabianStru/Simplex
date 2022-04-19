package de.fhws.simplex;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * documentation
 */
public class GreatestChangeCalculator extends SteepestUnitAscentCalculator implements Calculator {

    /**
     * documentation
     */
    @Override
    public int[] getPivotelement(BigDecimal[][] matrix) {
        int pivotcolumn = getIndexOfBiggestNumberInRow(0,allProducts(matrix)); //
        int pivotrow = calculateQuotientAndReturnIndex(pivotcolumn, matrix);
        return new int[]{pivotrow, pivotcolumn};
    }

    /**
     * documentation
     */
    public int getIndexOfBiggestNumberInRow(int row, BigDecimal[][] matrix) {
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
     * documentation
     */
    public BigDecimal[][] allProducts(BigDecimal[][] matrix) // Gibt eine einzeilige Matrix mit den Produkten von dem Wert aus der Zeile G und und dem kleinsten quotienten zurück
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
