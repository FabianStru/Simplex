package de.fhws.simplex;

import java.math.BigDecimal;

/**
 * This class is used to create matrices with specific content.
 * <p>
 * @author Fabian Struensee
 */
public class SimplexRankedTables {
    public SimplexRankedTables() {
    }

    /**
     * This method changes the matrix to be one example of a Simplex tableau with correct values.
     * <p>
     * @author Fabian Struensee
     */
    public void beRottisBeispiel(Matrix m) {
        m.matrix = new BigDecimal[4][3];
        m.matrix[0][0] = new BigDecimal("-300");
        m.matrix[0][1] = new BigDecimal("-500");
        m.matrix[0][2] = new BigDecimal("-36000");
        m.matrix[1][0] = new BigDecimal("1");
        m.matrix[1][1] = new BigDecimal("2");
        m.matrix[1][2] = new BigDecimal("170");
        m.matrix[2][0] = new BigDecimal("1");
        m.matrix[2][1] = new BigDecimal("1");
        m.matrix[2][2] = new BigDecimal("150");
        m.matrix[3][0] = new BigDecimal("0");
        m.matrix[3][1] = new BigDecimal("3");
        m.matrix[3][2] = new BigDecimal("180");
        m.setTableHeaders();
    }
    /**
     * This method changes the matrix to be one example of a Simplex tableau with correct values.
     * <p>
     * @author Fabian Struensee
     */
    public void beRottisBeispiel2(Matrix m) {
        m.matrix = new BigDecimal[5][3];
        m.matrix[0][0] = new BigDecimal("-210");
        m.matrix[0][1] = new BigDecimal("-160");
        m.matrix[0][2] = new BigDecimal("-640");
        m.matrix[1][0] = new BigDecimal("4");
        m.matrix[1][1] = new BigDecimal("2");
        m.matrix[1][2] = new BigDecimal("17");
        m.matrix[2][0] = new BigDecimal("2");
        m.matrix[2][1] = new BigDecimal("-1");
        m.matrix[2][2] = new BigDecimal("4");
        m.matrix[3][0] = new BigDecimal("7");
        m.matrix[3][1] = new BigDecimal("5");
        m.matrix[3][2] = new BigDecimal("35");
        m.matrix[4][0] = new BigDecimal("1");
        m.matrix[4][1] = new BigDecimal("0");
        m.matrix[4][2] = new BigDecimal("3");
        m.setTableHeaders();
    }
    /**
     * This method changes the matrix to be one example of a Simplex tableau with correct values.
     * <p>
     * @author Fabian Struensee
     */
    public void beRottisBeispiel3(Matrix m) {
        m.matrix = new BigDecimal[5][4];
        m.matrix[0][0] = new BigDecimal("-6");
        m.matrix[0][1] = new BigDecimal("-4");
        m.matrix[0][2] = new BigDecimal("-7");
        m.matrix[0][3] = new BigDecimal("0");
        m.matrix[1][0] = new BigDecimal("15");
        m.matrix[1][1] = new BigDecimal("4");
        m.matrix[1][2] = new BigDecimal("8");
        m.matrix[1][3] = new BigDecimal("120");
        m.matrix[2][0] = new BigDecimal("1");
        m.matrix[2][1] = new BigDecimal("0");
        m.matrix[2][2] = new BigDecimal("4");
        m.matrix[2][3] = new BigDecimal("32");
        m.matrix[3][0] = new BigDecimal("7");
        m.matrix[3][1] = new BigDecimal("2");
        m.matrix[3][2] = new BigDecimal("6");
        m.matrix[3][3] = new BigDecimal("70");
        m.matrix[4][0] = new BigDecimal("13");
        m.matrix[4][1] = new BigDecimal("3");
        m.matrix[4][2] = new BigDecimal("7");
        m.matrix[4][3] = new BigDecimal("105");
        m.setTableHeaders();
    }
}
