package de.fhws.simplex;

import java.math.BigDecimal;

/**
 * documentation
 */
public class BigDecimalFractionImpl implements BigDecimalWrapper {
    BigDecimal zaehler, nenner;

    /**
     * documentation
     */
    public BigDecimalFractionImpl(BigDecimal zaehler, BigDecimal nenner) {
        this.zaehler = zaehler;
        this.nenner = nenner;
    }

    /**
     * documentation
     */
    public BigDecimalWrapperImpl divide(BigDecimalWrapper divisor){
        return null;
    }




}
