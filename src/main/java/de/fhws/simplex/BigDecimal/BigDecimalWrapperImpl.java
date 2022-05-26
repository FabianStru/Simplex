package de.fhws.simplex.BigDecimal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/**
 * documentation
 */
public class BigDecimalWrapperImpl extends BigDecimal implements BigNumberWrapper {
    public BigDecimalWrapperImpl(char[] in, int offset, int len) {
        super(in, offset, len);
    }

    public BigDecimalWrapperImpl(char[] in, int offset, int len, MathContext mc) {
        super(in, offset, len, mc);
    }

    public BigDecimalWrapperImpl(char[] in) {
        super(in);
    }

    public BigDecimalWrapperImpl(char[] in, MathContext mc) {
        super(in, mc);
    }

    public BigDecimalWrapperImpl(String val) {
        super(val);
    }

    public BigDecimalWrapperImpl(String val, MathContext mc) {
        super(val, mc);
    }

    public BigDecimalWrapperImpl(double val) {
        super(val);
    }

    public BigDecimalWrapperImpl(double val, MathContext mc) {
        super(val, mc);
    }

    public BigDecimalWrapperImpl(BigInteger val) {
        super(val);
    }

    public BigDecimalWrapperImpl(BigInteger val, MathContext mc) {
        super(val, mc);
    }

    public BigDecimalWrapperImpl(BigInteger unscaledVal, int scale) {
        super(unscaledVal, scale);
    }

    public BigDecimalWrapperImpl(BigInteger unscaledVal, int scale, MathContext mc) {
        super(unscaledVal, scale, mc);
    }

    public BigDecimalWrapperImpl(int val) {
        super(val);
    }

    public BigDecimalWrapperImpl(int val, MathContext mc) {
        super(val, mc);
    }

    public BigDecimalWrapperImpl(long val) {
        super(val);
    }

    public BigDecimalWrapperImpl(long val, MathContext mc) {
        super(val, mc);
    }
}
