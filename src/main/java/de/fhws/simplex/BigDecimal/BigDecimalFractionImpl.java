package de.fhws.simplex.BigDecimal;

import java.math.BigDecimal;

/**
 * documentation
 */
public class BigDecimalFractionImpl implements BigDecimalWrapper {
     BigDecimal numerator, denominator;

    /**
     * This method is used to display a BigDecimalFraction.
     * <p>
     * @return numerator / denominator
     */
    @Override
    public String toString(){
        return numerator.toString() + "/" + denominator.toString();
    }

    /**
     * documentation
     */
    public BigDecimalFractionImpl(BigDecimal numerator, BigDecimal denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * documentation
     */
    public BigDecimalWrapperImpl divide(BigDecimalWrapper divisor){
        return null;
    }




}
