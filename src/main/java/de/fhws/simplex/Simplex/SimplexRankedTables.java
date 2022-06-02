package de.fhws.simplex.Simplex;

import org.apache.commons.math3.fraction.BigFraction;

/**
 * This class is used to create matrices with specific content.
 * <p>
 * @author Fabian Struensee
 */
public class SimplexRankedTables {

    /**
     * This method changes the matrix to be one example of a Simplex tableau with correct values.
     * <p>
     * @author Fabian Struensee
     */
    public static Matrix beRottisBeispiel() {
        Matrix m = new Matrix(4, 3);
        m.matrix[0][0] = new BigFraction(-300);
        m.matrix[0][1] = new BigFraction(-500);
        m.matrix[0][2] = new BigFraction(-36000);
        m.matrix[1][0] = new BigFraction(1);
        m.matrix[1][1] = new BigFraction(2);
        m.matrix[1][2] = new BigFraction(170);
        m.matrix[2][0] = new BigFraction(1);
        m.matrix[2][1] = new BigFraction(1);
        m.matrix[2][2] = new BigFraction(150);
        m.matrix[3][0] = new BigFraction(0);
        m.matrix[3][1] = new BigFraction(3);
        m.matrix[3][2] = new BigFraction(180);

        return m;
    }

    /**
     * This method changes the matrix to be one example of a Simplex tableau with correct values.
     * <p>
     * @author Fabian Struensee
     */
    public static Matrix beRottisBeispiel2() {
        Matrix m = new Matrix(5, 3);

        m.matrix[0][0] = new BigFraction(-210);
        m.matrix[0][1] = new BigFraction(-160);
        m.matrix[0][2] = new BigFraction(-640);
        m.matrix[1][0] = new BigFraction(4);
        m.matrix[1][1] = new BigFraction(2);
        m.matrix[1][2] = new BigFraction(17);
        m.matrix[2][0] = new BigFraction(2);
        m.matrix[2][1] = new BigFraction(-1);
        m.matrix[2][2] = new BigFraction(4);
        m.matrix[3][0] = new BigFraction(7);
        m.matrix[3][1] = new BigFraction(5);
        m.matrix[3][2] = new BigFraction(35);
        m.matrix[4][0] = new BigFraction(1);
        m.matrix[4][1] = new BigFraction(0);
        m.matrix[4][2] = new BigFraction(3);

        return m;
    }

    /**
     * This method changes the matrix to be one example of a Simplex tableau with correct values.
     * <p>
     * @author Fabian Struensee
     */
    public static Matrix beRottisBeispiel3() {
        Matrix m = new Matrix(5,4);
        m.matrix[0][0] = new BigFraction(-6);
        m.matrix[0][1] = new BigFraction(-4);
        m.matrix[0][2] = new BigFraction(-7);
        m.matrix[0][3] = new BigFraction(0);
        m.matrix[1][0] = new BigFraction(15);
        m.matrix[1][1] = new BigFraction(4);
        m.matrix[1][2] = new BigFraction(8);
        m.matrix[1][3] = new BigFraction(120);
        m.matrix[2][0] = new BigFraction(1);
        m.matrix[2][1] = new BigFraction(0);
        m.matrix[2][2] = new BigFraction(4);
        m.matrix[2][3] = new BigFraction(32);
        m.matrix[3][0] = new BigFraction(7);
        m.matrix[3][1] = new BigFraction(2);
        m.matrix[3][2] = new BigFraction(6);
        m.matrix[3][3] = new BigFraction(70);
        m.matrix[4][0] = new BigFraction(13);
        m.matrix[4][1] = new BigFraction(3);
        m.matrix[4][2] = new BigFraction(7);
        m.matrix[4][3] = new BigFraction(105);

        return m;
    }
    /**
     * This method changes the matrix to be one example of a Simplex tableau with correct values.
     * <p>
     * @author Fabian Struensee
     */
    public static Matrix beRottisBeispiel4() {
        Matrix m = new Matrix(4, 3);
        m.matrix[0][0] = new BigFraction(-1);
        m.matrix[0][1] = new BigFraction(-1);
        m.matrix[0][2] = new BigFraction(0);
        m.matrix[1][0] = new BigFraction(1);
        m.matrix[1][1] = new BigFraction(6);
        m.matrix[1][2] = new BigFraction(12);
        m.matrix[2][0] = new BigFraction(1);
        m.matrix[2][1] = new BigFraction(2);
        m.matrix[2][2] = new BigFraction(6);
        m.matrix[3][0] = new BigFraction(2);
        m.matrix[3][1] = new BigFraction(1);
        m.matrix[3][2] = new BigFraction(9);

        return m;
    }
    /**
     * This method changes the matrix to be one example of a Simplex tableau with correct values.
     * <p>
     * @author Fabian Struensee
     */
    public static Matrix beRottisBeispiel5() {
        Matrix m = new Matrix(4,5);
        m.matrix[0][0] = new BigFraction(-0.75);
        m.matrix[0][1] = new BigFraction(20);
        m.matrix[0][2] = new BigFraction(-0.5);
        m.matrix[0][3] = new BigFraction(6);
        m.matrix[0][4] = new BigFraction(0);
        m.matrix[1][0] = new BigFraction(0.25);
        m.matrix[1][1] = new BigFraction(-8);
        m.matrix[1][2] = new BigFraction(-1);
        m.matrix[1][3] = new BigFraction(9);
        m.matrix[1][4] = new BigFraction(0);
        m.matrix[2][0] = new BigFraction(0.5);
        m.matrix[2][1] = new BigFraction(-12);
        m.matrix[2][2] = new BigFraction(-0.5);
        m.matrix[2][3] = new BigFraction(3);
        m.matrix[2][4] = new BigFraction(0);
        m.matrix[3][0] = new BigFraction(0);
        m.matrix[3][1] = new BigFraction(0);
        m.matrix[3][2] = new BigFraction(1);
        m.matrix[3][3] = new BigFraction(0);
        m.matrix[3][4] = new BigFraction(1);

        return m;
    }
    /**
     * This method changes the matrix to be one example of a Simplex tableau with correct values.
     * <p>
     * @author Fabian Struensee
     */
    public static Matrix beRottisBeispiel6() {
        Matrix m = new Matrix(4, 3);
        m.matrix[0][0] = new BigFraction(-50);
        m.matrix[0][1] = new BigFraction(-80);
        m.matrix[0][2] = new BigFraction(0);
        m.matrix[1][0] = new BigFraction(-3);
        m.matrix[1][1] = new BigFraction(1);
        m.matrix[1][2] = new BigFraction(20);
        m.matrix[2][0] = new BigFraction(1);
        m.matrix[2][1] = new BigFraction(-2);
        m.matrix[2][2] = new BigFraction(20);
        m.matrix[3][0] = new BigFraction(3);
        m.matrix[3][1] = new BigFraction(-1);
        m.matrix[3][2] = new BigFraction(120);

        return m;
    }
}
