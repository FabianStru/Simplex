package de.fhws.simplex;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum SimplexRankedTablesEnum {

    Beispiel1(SimplexRankedTables.beRottisBeispiel()), Beispiel2(SimplexRankedTables.beRottisBeispiel2()), Beispiel3(SimplexRankedTables.beRottisBeispiel3()),
    Beispiel4(SimplexRankedTables.beRottisBeispiel4()), Beispiel5(SimplexRankedTables.beRottisBeispiel5()), Beispiel6(SimplexRankedTables.beRottisBeispiel6());

    public Matrix getMatrix() {
        return matrix;
    }

    private final Matrix matrix;

    SimplexRankedTablesEnum(Matrix matrix) {
        this.matrix = matrix;
    }

    private static final List<SimplexRankedTablesEnum> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();


    public static SimplexRankedTablesEnum randomSimplexRankedTablesEnum() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
