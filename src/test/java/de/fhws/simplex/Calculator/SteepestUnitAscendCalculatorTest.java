package de.fhws.simplex.Calculator;

import de.fhws.simplex.Simplex.Matrix;
import de.fhws.simplex.Simplex.SimplexRankedTables;
import de.fhws.simplex.Calculator.SteepestUnitAscentCalculator;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class SteepestUnitAscendCalculatorTest {

    Matrix m = new Matrix();
    SteepestUnitAscentCalculator c = new SteepestUnitAscentCalculator();

    @Test
    public void Test_RottisBeispielSU()
    {
        m = SimplexRankedTables.beRottisBeispiel();
        Assert.assertArrayEquals(new int[]{3, 1}, c.getPivotelement(m.getMatrix()));
        m = m.nextStep(new int[]{3, 1});
        Assert.assertArrayEquals(new int[]{1, 0}, c.getPivotelement(m.getMatrix()));
        m = m.nextStep(new int[]{1, 0});
        Assert.assertArrayEquals(new int[]{2, 1}, c.getPivotelement(m.getMatrix()));
    }
    @Test
    public void Test_RottisBeispiel2SU()
    {
        m = SimplexRankedTables.beRottisBeispiel2();
        Assert.assertArrayEquals(new int[]{2, 0}, c.getPivotelement(m.getMatrix()));
        m = m.nextStep(new int[]{2, 0});
        Assert.assertArrayEquals(new int[]{4, 1}, c.getPivotelement(m.getMatrix()));
        m = m.nextStep(new int[]{4, 1});
        Assert.assertArrayEquals(new int[]{1, 0}, c.getPivotelement(m.getMatrix()));
        m = m.nextStep(new int[]{1, 0});
        Assert.assertArrayEquals(new int[]{3, 1}, c.getPivotelement(m.getMatrix()));
        m = m.nextStep(new int[]{3, 1});
        Assert.assertArrayEquals(new int[]{2, 0}, c.getPivotelement(m.getMatrix()));

    }
    @Test
    public void Test_RottisBeispiel3SU()
    {
        m = SimplexRankedTables.beRottisBeispiel3();
        Assert.assertArrayEquals(new int[]{2, 2}, c.getPivotelement(m.getMatrix()));
        m = m.nextStep(new int[]{2, 2});
        Assert.assertArrayEquals(new int[]{3, 0}, c.getPivotelement(m.getMatrix()));
        m = m.nextStep(new int[]{3, 0});
        Assert.assertArrayEquals(new int[]{3, 1}, c.getPivotelement(m.getMatrix()));
        m = m.nextStep(new int[]{3, 1});
        Assert.assertArrayEquals(new int[]{1, 2}, c.getPivotelement(m.getMatrix()));
        m = m.nextStep(new int[]{1, 2});
        Assert.assertArrayEquals(new int[]{2, 0}, c.getPivotelement(m.getMatrix()));

    }

}
