package de.fhws.simplex;

import java.math.BigDecimal;

/**
 * documentation
 */
public interface Calculator {

    /**
     * documentation
     */
    int[] getPivotelement(BigDecimal[][] matrix);

    /**
     * documentation
     */
    int getIndexOfSmallestNumberInRow(int row, BigDecimal[][] matrix);

    /**
     * documentation
     */
    int calculateQuotientAndReturnIndex(int column, BigDecimal[][] matrix);

}
