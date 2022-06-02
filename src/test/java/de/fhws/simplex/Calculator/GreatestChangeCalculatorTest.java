//package de.fhws.simplex.Calculator;
//
//import de.fhws.simplex.Simplex.Matrix;
//import de.fhws.simplex.Simplex.SimplexRankedTables;
//import de.fhws.simplex.Simplex.SimplexRankedTablesEnum;
//import org.junit.Assert;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import static de.fhws.simplex.Simplex.SimplexRankedTablesEnum.*;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
///**
// * This class tests the {@link GreatestChangeCalculator}'s pivot element calculation
// * for multiple pre-setup matrices examples from {@link SimplexRankedTables}.
// */
//public class GreatestChangeCalculatorTest {
//    Matrix m = new Matrix();
//    GreatestChangeCalculator c = new GreatestChangeCalculator();
//
//    /**
//     * Tests the matrix Beispiel1 and whether it
//     * finds the correct pivot elements according to the Greatest change procedure.
//     * Also tests if it throws an IndexOutOfBoundsException
//     * in case it's called again after the solution is found since no -1 is then returned as "index".
//     */
//    @Test
//    public void test_GreatestChange_RottisBeispiel() {
//        m = Beispiel1.getMatrix();
//        Assertions.assertArrayEquals(new int[]{2, 0}, c.getPivotelement(m.getMatrix()));
//        m = m.nextStep(new int[]{2, 0});
//        Assertions.assertArrayEquals(new int[]{1, 1}, c.getPivotelement(m.getMatrix()));
//        m = m.nextStep(new int[]{1, 1});
//        assertException(c, m);
//
//    }
//
//    /**
//     * Tests the matrix Beispiel2 and whether it
//     * finds the correct pivot elements according to the Greatest change procedure.
//     * Also tests if it throws an IndexOutOfBoundsException
//     * in case it's called again after the solution is found since no -1 is then returned as "index".
//     */
//    @Test
//    public void test_GreatestChange_RottisBeispiel2() {
//        m = Beispiel2.getMatrix();
//        Assertions.assertArrayEquals(new int[]{3, 1}, c.getPivotelement(m.getMatrix()));
//        m = m.nextStep(new int[]{3, 1});
//        assertException(c, m);
//
//    }
//
//    /**
//     * Tests the matrix Beispiel3 and whether it
//     * finds the correct pivot elements according to the Greatest change procedure.
//     * Also tests if it throws an IndexOutOfBoundsException
//     * in case it's called again after the solution is found since no -1 is then returned as "index".
//     */
//    @Test
//    public void test_GreatestChange_RottisBeispiel3() {
//        m = Beispiel3.getMatrix();
//        Assertions.assertArrayEquals(new int[]{1, 1}, c.getPivotelement(m.getMatrix()));
//        m = m.nextStep(new int[]{1, 1});
//        assertException(c, m);
//
//    }
//
//    /**
//     * Check if ArrayIndexOutOfBoundsException is thrown and
//     * the included error message includes -1.
//     */
//    public static void assertException(Calculator c, Matrix m) {
//        Exception exception = assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
//            c.getPivotelement(m.getMatrix());
//        });
//        String expectedMessage = "Index -1 out of bounds";
//        String actualMessage = exception.getMessage();
//        assertTrue(actualMessage.contains(expectedMessage));
//    }
//}
