package de.fhws.simplex;

import java.math.BigDecimal;

/**
 * The Calculator interface is used to build other specialised Calculators for determining the pivotelement.
 *
 * @author Anton Kaiser
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
