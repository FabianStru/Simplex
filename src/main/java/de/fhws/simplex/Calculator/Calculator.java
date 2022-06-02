package de.fhws.simplex.Calculator;

import de.fhws.simplex.Exception.ArrayLengthIsZeroException;
import org.apache.commons.math3.fraction.BigFraction;

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
    int[] getPivotelement(BigFraction[][] matrix);

    /**
     * documentation
     */
    int getIndexOfSmallestNumberInRow(int row, BigFraction[][] matrix) throws ArrayLengthIsZeroException;

    /**
     * documentation
     */
    int calculateQuotientAndReturnIndexOfSmallestQuotient(int column, BigFraction[][] matrix);

}
