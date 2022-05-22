package de.fhws.simplex.Simplex;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.bind.SchemaOutputResolver;
import java.math.BigDecimal;

public class MatrixTest {
    Matrix m = new Matrix();

    @Test
    public void Test_RottisBeispielS(){
        m = SimplexRankedTables.beRottisBeispiel();
        m.nextStep(new int[] {3,1});
        System.out.println(m);

        Assertions.assertEquals(new BigDecimal[][]{{}},m.getMatrix());


    }
}
