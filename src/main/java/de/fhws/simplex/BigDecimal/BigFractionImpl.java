package de.fhws.simplex.BigDecimal;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.fraction.BigFraction;
import org.apache.commons.math3.fraction.FractionConversionException;

import java.math.BigInteger;

/**
 * documentation
 */
public class BigFractionImpl extends BigFraction implements BigDecimalWrapper {

    public BigFractionImpl(BigInteger num) {
        super(num);
    }

    public BigFractionImpl(BigInteger num, BigInteger den) {
        super(num, den);
    }

    public BigFractionImpl(double value) throws MathIllegalArgumentException {
        super(value);
    }

    public BigFractionImpl(double value, double epsilon, int maxIterations) throws FractionConversionException {
        super(value, epsilon, maxIterations);
    }

    public BigFractionImpl(double value, int maxDenominator) throws FractionConversionException {
        super(value, maxDenominator);
    }

    public BigFractionImpl(int num) {
        super(num);
    }

    public BigFractionImpl(int num, int den) {
        super(num, den);
    }

    public BigFractionImpl(long num) {
        super(num);
    }

    public BigFractionImpl(long num, long den) {
        super(num, den);
    }

}
