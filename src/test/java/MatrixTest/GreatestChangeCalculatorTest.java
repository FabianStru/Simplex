package MatrixTest;

import de.fhws.simplex.Matrix;
import de.fhws.simplex.GreatestChangeCalculator;
import de.fhws.simplex.SimplexRankedTables;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class GreatestChangeCalculatorTest {
    Matrix m = new Matrix();
    GreatestChangeCalculator c = new GreatestChangeCalculator();

    @Test
    public void RottisBeispielStepOne()
    {
        m = SimplexRankedTables.beRottisBeispiel();
        Assert.assertArrayEquals(new int[]{2, 0}, c.getPivotelement(m.getMatrix()));

    }
    @Test
    public void RottisBeispielStepTwo()
    {
        m = SimplexRankedTables.beRottisBeispiel();
        m = m.nextStep(new int[]{2, 0});
        Assert.assertArrayEquals(new int[]{1, 1}, c.getPivotelement(m.getMatrix()));

    }
}
