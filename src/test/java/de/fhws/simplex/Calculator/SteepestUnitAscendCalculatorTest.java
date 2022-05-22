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
    public void RottisBeispielStepOne()
    {
        m = SimplexRankedTables.beRottisBeispiel();
        Assert.assertArrayEquals(new int[]{3, 1}, c.getPivotelement(m.getMatrix()));

    }
    @Test
    public void RottisBeispielStepTwo()
    {
        m = SimplexRankedTables.beRottisBeispiel();
        m = m.nextStep(new int[]{3, 1});
        Assert.assertArrayEquals(new int[]{1, 0}, c.getPivotelement(m.getMatrix()));

    }
}
