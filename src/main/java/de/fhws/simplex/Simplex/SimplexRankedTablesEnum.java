package de.fhws.simplex.Simplex;

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

    //https://stackoverflow.com/questions/1972392/pick-a-random-value-from-an-enum#:~:text=private%20static%20final%20List%3CLetter%3E%20VALUES%20%3D%0A%20%20%20%20Collections.unmodifiableList(Arrays.asList(values()))%3B%0A%20%20private%20static%20final%20int%20SIZE%20%3D%20VALUES.size()%3B%0A%20%20private%20static%20final%20Random%20RANDOM%20%3D%20new%20Random()%3B
    private static final List<SimplexRankedTablesEnum> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();


    public static SimplexRankedTablesEnum randomSimplexRankedTablesEnum() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
