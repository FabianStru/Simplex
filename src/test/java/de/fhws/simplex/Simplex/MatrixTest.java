package de.fhws.simplex.Simplex;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;

import javax.xml.bind.SchemaOutputResolver;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MatrixTest {
    Matrix m = new Matrix();

    @Test
    public void Test_Matrix_RottisBeispiel() {
        m = SimplexRankedTables.beRottisBeispiel();
        m.nextStep(new int[]{3, 1});
        double[][] compare = {{-300.000000000000000, 166.666666666666667, -6000.000000000000000}, {1.000000000000000, -0.666666666666667, 50.000000000000000}, {1.000000000000000, -0.333333333333333, 90.000000000000000}, {0.000000000000000, 0.333333333333333, 60.000000000000000}};
        BigDecimal[][] bcompare = doubleToBigDecimalArray(compare);
        Matrix c = new Matrix(bcompare, new String[]{"X1", "SC", "Rechte Seite"}, new String[]{"G", "SA", "SB", "X2"});
        System.out.println(c);

        Assertions.assertEquals(c, m);
    }

    @Test
    public void Test_Matrix_RottisBeispiel2() {
        m = SimplexRankedTables.beRottisBeispiel2();
        m.nextStep(new int[]{2, 0});
        double[][] compare = {{105, -265, -220}, {-2, 4, 9}, {0.5, -0.5, 2}, {-3.5, 8.5, 21}, {-0.5, 0.5, 1}};
        BigDecimal[][] bcompare = doubleToBigDecimalArray(compare);
        Matrix c = new Matrix(bcompare, new String[]{"SB", "X2", "Rechte Seite"}, new String[]{"G", "SA", "X1", "SC", "SD"});
        System.out.println(c);

        Assertions.assertEquals(c, m);
    }

    @Test
    public void Test_Matrix_RottisBeispiel3() {
        m = SimplexRankedTables.beRottisBeispiel3();
        m.nextStep(new int[]{2, 0});
        System.out.println(m.toString());
        double[][] compare = {{6, -4, 17, 192}, {-15, 4, -52, -360}, {1, 0, 4, 32}, {-7, 2, -22, -154}, {-13, 3, -45, -311}};
        BigDecimal[][] bcompare = doubleToBigDecimalArray(compare);
        Matrix c = new Matrix(bcompare, new String[]{"SB", "X2", "X3", "Rechte Seite"}, new String[]{"G", "SA", "X1", "SC", "SD"});
        System.out.println(c);

        Assertions.assertEquals(c, m);
    }

    public BigDecimal[][] doubleToBigDecimalArray(double[][] doubleArray){
        BigDecimal[][] convertedBigDecimalArray = new BigDecimal[doubleArray.length][doubleArray[0].length];

        for (int i = 0; i < doubleArray.length; i++) {
            for (int j = 0; j < doubleArray[i].length; j++) {
                convertedBigDecimalArray[i][j] = new BigDecimal(doubleArray[i][j]);
            }
        }

        return convertedBigDecimalArray;
    }

}
