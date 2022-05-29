package de.fhws.simplex.BigDecimal;

import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.fraction.BigFraction;
import org.apache.commons.math3.fraction.FractionConversionException;

import java.math.BigInteger;

/**
 * documentation
 */
public class BigFractionWrapperImpl extends BigFraction implements BigNumberWrapper {

    public BigFractionWrapperImpl(BigInteger num) {
        super(num);
    }

    public BigFractionWrapperImpl(BigInteger num, BigInteger den) {
        super(num, den);
    }

    public BigFractionWrapperImpl(double value) throws MathIllegalArgumentException {
        super(value);
    }

    public BigFractionWrapperImpl(double value, double epsilon, int maxIterations) throws FractionConversionException {
        super(value, epsilon, maxIterations);
    }

    public BigFractionWrapperImpl(double value, int maxDenominator) throws FractionConversionException {
        super(value, maxDenominator);
    }

    public BigFractionWrapperImpl(int num) {
        super(num);
    }

    public BigFractionWrapperImpl(int num, int den) {
        super(num, den);
    }

    public BigFractionWrapperImpl(long num) {
        super(num);
    }

    public BigFractionWrapperImpl(long num, long den) {
        super(num, den);
    }
}
