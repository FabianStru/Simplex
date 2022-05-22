package de.fhws.simplex.Calculator;

import de.fhws.simplex.Simplex.Matrix;
import de.fhws.simplex.Simplex.SimplexRankedTables;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * This class tests the {@link GreatestChangeCalculator}'s pivot element calculation
 * for multiple pre-setup matrices examples from {@link SimplexRankedTables}.
 */
public class GreatestChangeCalculatorTest {
    Matrix m = new Matrix();
    GreatestChangeCalculator c = new GreatestChangeCalculator();

    /**
     * Tests the matrix SimplexRankedTables.beRottisBeispiel and whether it
     * finds the correct pivot elements according to the Greatest change procedure.
     * Also tests if it throws an IndexOutOfBoundsException
     * in case it's called again after the solution is found since no -1 is then returned as "index".
     */
    @Test
    public void test_RottisBeispiel() {
        m = SimplexRankedTables.beRottisBeispiel();
        m.printMatrix();
        Assert.assertArrayEquals(new int[]{2, 0}, c.getPivotelement(m.getMatrix()));
        m = m.nextStep(new int[]{2, 0});
        m.printMatrix();
        Assert.assertArrayEquals(new int[]{1, 1}, c.getPivotelement(m.getMatrix()));
        m = m.nextStep(new int[]{1, 1});
        m.printMatrix();
        assertException();

    }

    /**
     * Tests the matrix SimplexRankedTables.beRottisBeispiel2 and whether it
     * finds the correct pivot elements according to the Greatest change procedure.
     * Also tests if it throws an IndexOutOfBoundsException
     * in case it's called again after the solution is found since no -1 is then returned as "index".
     */
    @Test
    public void test_RottisBeispiel2() {
        m = SimplexRankedTables.beRottisBeispiel2();
        m.printMatrix();
        Assert.assertArrayEquals(new int[]{3, 1}, c.getPivotelement(m.getMatrix()));
        m = m.nextStep(new int[]{3, 1});
        m.printMatrix();
        assertException();

    }

    /**
     * Tests the matrix SimplexRankedTables.beRottisBeispiel3 and whether it
     * finds the correct pivot elements according to the Greatest change procedure.
     * Also tests if it throws an IndexOutOfBoundsException
     * in case it's called again after the solution is found since no -1 is then returned as "index".
     */
    @Test
    public void test_RottisBeispiel3() {
        m = SimplexRankedTables.beRottisBeispiel3();
        m.printMatrix();
        Assert.assertArrayEquals(new int[]{1, 1}, c.getPivotelement(m.getMatrix()));
        m = m.nextStep(new int[]{1, 1});
        m.printMatrix();
        assertException();

    }

    /**
     * Check if ArrayIndexOutOfBoundsException is thrown and
     * the included error message includes -1.
     */
    public void assertException() {
        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            c.getPivotelement(m.getMatrix());
        });
        String expectedMessage = "Index -1 out of bounds";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
