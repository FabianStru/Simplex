//package de.fhws.simplex.Calculator;
//
//import de.fhws.simplex.Simplex.Matrix;
//import de.fhws.simplex.Simplex.SimplexRankedTables;
//import de.fhws.simplex.Calculator.SteepestUnitAscentCalculator;
//import org.junit.Assert;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import static de.fhws.simplex.Simplex.SimplexRankedTablesEnum.*;
//
///**
// * This class tests the {@link SteepestUnitAscentCalculator}'s pivot element calculation
// * for multiple pre-setup matrices examples from {@link SimplexRankedTables}.
// */
//public class SteepestUnitAscendCalculatorTest {
//
//    Matrix m = new Matrix();
//    SteepestUnitAscentCalculator c = new SteepestUnitAscentCalculator();
//
//    /**
//     * Tests the matrix Beispiel1 and whether it
//     * finds the correct pivot elements according to the Steepest Unit Ascent procedure.
//     * Also tests if it throws an IndexOutOfBoundsException
//     * in case it's called again after the solution is found since no -1 is then returned as "index".
//     */
//    @Test
//    public void test_SteepestUnitAscent_RottisBeispiel1() {
//        m = Beispiel1.getMatrix();
//        Assertions.assertArrayEquals(new int[]{3, 1}, c.getPivotelement(m.getMatrix()));
//        m = m.nextStep(new int[]{3, 1});
//        Assertions.assertArrayEquals(new int[]{1, 0}, c.getPivotelement(m.getMatrix()));
//        m = m.nextStep(new int[]{1, 0});
//        Assertions.assertArrayEquals(new int[]{2, 1}, c.getPivotelement(m.getMatrix()));
//        m = m.nextStep(new int[]{2, 1});
//        GreatestChangeCalculatorTest.assertException(c, m);
//    }
//
//    /**
//     * Tests the matrix Beispiel2 and whether it
//     * finds the correct pivot elements according to the Steepest Unit Ascent procedure.
//     * Also tests if it throws an IndexOutOfBoundsException
//     * in case it's called again after the solution is found since no -1 is then returned as "index".
//     */
//    @Test
//    public void test_SteepestUnitAscent_RottisBeispiel2() {
//        m = Beispiel2.getMatrix();
//        Assertions.assertArrayEquals(new int[]{2, 0}, c.getPivotelement(m.getMatrix()));
//        m = m.nextStep(new int[]{2, 0});
//        Assertions.assertArrayEquals(new int[]{4, 1}, c.getPivotelement(m.getMatrix()));
//        m = m.nextStep(new int[]{4, 1});
//        Assertions.assertArrayEquals(new int[]{1, 0}, c.getPivotelement(m.getMatrix()));
//        m = m.nextStep(new int[]{1, 0});
//        Assertions.assertArrayEquals(new int[]{3, 1}, c.getPivotelement(m.getMatrix()));
//        m = m.nextStep(new int[]{3, 1});
//        Assertions.assertArrayEquals(new int[]{2, 0}, c.getPivotelement(m.getMatrix()));
//        m = m.nextStep(new int[]{2, 0});
//        GreatestChangeCalculatorTest.assertException(c, m);
//    }
//
//    /**
//     * Tests the matrix Beispiel3 and whether it
//     * finds the correct pivot elements according to the Steepest Unit Ascent procedure.
//     * Also tests if it throws an IndexOutOfBoundsException
//     * in case it's called again after the solution is found since no -1 is then returned as "index".
//     */
//    @Test
//    public void test_SteepestUnitAscent_RottisBeispiel3() {
//        m = Beispiel3.getMatrix();
//        Assertions.assertArrayEquals(new int[]{2, 2}, c.getPivotelement(m.getMatrix()));
//        m = m.nextStep(new int[]{2, 2});
//        Assertions.assertArrayEquals(new int[]{3, 0}, c.getPivotelement(m.getMatrix()));
//        m = m.nextStep(new int[]{3, 0});
//        Assertions.assertArrayEquals(new int[]{3, 1}, c.getPivotelement(m.getMatrix()));
//        m = m.nextStep(new int[]{3, 1});
//        Assertions.assertArrayEquals(new int[]{1, 2}, c.getPivotelement(m.getMatrix()));
//        m = m.nextStep(new int[]{1, 2});
//        Assertions.assertArrayEquals(new int[]{2, 0}, c.getPivotelement(m.getMatrix()));
//        m = m.nextStep(new int[]{2, 0});
//        GreatestChangeCalculatorTest.assertException(c, m);
//    }
//
//}
