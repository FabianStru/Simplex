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
    public void Test_RottisBeispielS(){
        m = SimplexRankedTables.beRottisBeispiel();
        m.nextStep(new int[] {3,1});
        double[][] compare = {{-300.000000000000000,166.666666666666667,-6000.000000000000000},{1.000000000000000,-0.666666666666667,50.000000000000000},{1.000000000000000,-0.333333333333333,90.000000000000000},{0.000000000000000,0.333333333333333,60.000000000000000}};
        BigDecimal[][] bcom = new BigDecimal[compare.length][compare[0].length];
        for(int i = 0; i < compare.length; i++)
        {
            for(int j = 0; j<compare[i].length;j++)
            {
                bcom[i][j] = new BigDecimal(compare[i][j]);
            }
        }
        for(int i = 0; i < compare.length; i++)
        {
            for(int j = 0; j<compare[i].length;j++)
            {
                Assert.assertTrue(bcom[i][j].setScale(10, RoundingMode.HALF_UP).compareTo(m.getMatrix()[i][j].setScale(10, RoundingMode.HALF_UP)) == 0);
            }
        }

    }
}
