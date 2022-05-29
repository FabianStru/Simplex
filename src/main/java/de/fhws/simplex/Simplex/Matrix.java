package de.fhws.simplex.Simplex;

import de.fhws.simplex.Calculator.Calculator;
import de.fhws.simplex.Calculator.GreatestChangeCalculator;
import de.fhws.simplex.Calculator.SteepestUnitAscentCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

/**
 * This class represents the matrix of the Simplex algorithm and saves the values and table and offers all the
 * functions required to optimize it according to the Simplex tableau.
 *
 * @author Anton Kaiser, Fabian Struensee
 */
public class Matrix {

    BigDecimal[][] matrix;
    String[] columnHeader, rowHeader; //columnHeader = Spaltenbezeichner, rowHeader = Zeilenbezeichner
    int numberOfColumns, numberOfRows;
    int[] pivotelement; //pivotelement[0]: row, pivotelement[1]: column

    /**
     * Main function, currently for testing purposes to see and compare the different functions of Matrix.
     *
     * @param args not used arguments
     */
    public static void main(String[] args) {
        Matrix m;

        System.out.println("Manuelle Auswertung Simplex:");
        m = SimplexRankedTables.beRottisBeispiel();
        System.out.println(m.continueCalculate());

        m.nextStep(new int[]{3, 1}); //Manuell ausgewähltes Pivotelement für das Beispiel:
        // 3. Zeile, 1. Spalte (ausgehend von einer Nummerierung, die bei 0 beginnt)
        System.out.println(m.continueCalculate());

        m.nextStep(new int[]{1, 0});
        System.out.println(m.continueCalculate());

        m.nextStep(new int[]{2, 1});
        System.out.println(m.continueCalculate());
        m.printMatrix();

        System.out.println("Automatische Auswertung Simplex nach Steepest Unit:");
        m = SimplexRankedTables.beRottisBeispiel3();
        m.calculateSimplex();

        System.out.println("Automatische Auswertung Simplex nach Greatest Change:");
        m = SimplexRankedTables.beRottisBeispiel3();
        m.calculateSimplex(true);
    }

    /**
     * Public constructor for matrix, only giving rows and columns and thus offering an empty matrix.
     *
     * @param numberOfRows    amount of rows that your matrix should have
     * @param numberOfColumns amount of columns that your matrix should have
     */
    public Matrix(int numberOfRows, int numberOfColumns) {
        this.matrix = new BigDecimal[numberOfRows][numberOfColumns];
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.setTableHeaders();
    }

    /**
     * Public constructor for matrix, given an input of a BigDecimal matrix
     *
     * @param matrix the BigDecimal matrix with the desired values
     */
    public Matrix(BigDecimal[][] matrix) {
        this.matrix = matrix;
        this.numberOfColumns = this.matrix[0].length;
        this.numberOfRows = this.matrix.length;
        this.setTableHeaders();
    }

    /**
     * Constructor with no input that is needed for Spring Boot to work and transform a JSON into Matrix object
     */
    public Matrix() {
    }

    Matrix(BigDecimal[][] matrix, String[] columnHeader, String[] rowHeader) {
        this.matrix = matrix;
        this.columnHeader = columnHeader;
        this.rowHeader = rowHeader;
        this.numberOfColumns = this.matrix[0].length;
        this.numberOfRows = this.matrix.length;
    }

    private Matrix(BigDecimal[][] matrix, String[] columnHeader, String[] rowHeader, int[] pivotelement) {
        this(matrix, columnHeader, rowHeader);
        this.pivotelement = pivotelement;

    }

    /**
     * This method adds the String headers for the given matrix according to the Simplex schema.
     *
     * @author Anton Kaiser, Fabian Struensee
     */
    public void setTableHeaders() {
        this.columnHeader = new String[this.matrix[0].length];
        this.rowHeader = new String[this.matrix.length];
        for (int i = 0; i < this.matrix[0].length - 1; i++) {
            columnHeader[i] = "X" + (i + 1);
        }
        columnHeader[this.matrix[0].length - 1] = "Rechte Seite";
        rowHeader[0] = "G";
        for (int i = 1; i < this.matrix.length; i++) {
            char index = (char) ('A' + (i - 1));
            rowHeader[i] = "S" + index;
        }
    }

    public Matrix deepCopy() {
        BigDecimal[][] matrixCopy = java.util.Arrays.stream(matrix).map(BigDecimal[]::clone).toArray($ -> matrix.clone());
        String[] columnHeaderCopy = columnHeader.clone();
        String[] rowHeaderCopy = rowHeader.clone();
        int[] pivotelementCopy = pivotelement.clone();
        return new Matrix(matrixCopy, columnHeaderCopy, rowHeaderCopy, pivotelementCopy);
    }

    /**
     * This method is the setter for the numberOfColumns.
     *
     * @param numberOfColumns the number of columns to be set
     */
    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }

    /**
     * This method is the setter for the numberOfRows.
     *
     * @param numberOfRows the number of rows to be set
     */
    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    /**
     * This method is the setter for the matrix.
     *
     * @param matrix the matrix to be set
     */
    public void setMatrix(BigDecimal[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * This method is the setter for the column header.
     *
     * @param columnHeader the column header to be set
     */
    public void setColumnHeader(String[] columnHeader) {
        this.columnHeader = columnHeader;
    }

    /**
     * This method is the setter for the row header.
     *
     * @param rowHeader the row header to be set
     */
    public void setRowHeader(String[] rowHeader) {
        this.rowHeader = rowHeader;
    }

    /**
     * This method is the setter for pivotelement.
     *
     * @param pivotelement the pivotelement to be set
     */
    public void setPivotelement(int[] pivotelement) {
        this.pivotelement = pivotelement;
    }

    /**
     * This method is the getter for the pivotelement.
     *
     * @return an int array with two elements:
     * <li>[0] -> index of pivot element in pivot row
     * <li>[1] -> index of pivot element in pivot column
     */
    public int[] getPivotelement() {
        return pivotelement;
    }

    /**
     * This method is the getter for the number of columns.
     *
     * @return the number of columns of the matrix
     */
    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    /**
     * This method is the getter for the number of rows.
     *
     * @return the number of rows of the matrix
     */
    public int getNumberOfRows() {
        return numberOfRows;
    }

    /**
     * This method is the getter for the matrix.
     *
     * @return the matrix with all the values (BigDecimal[][] array)
     */
    public BigDecimal[][] getMatrix() {
        return matrix;
    }

    /**
     * This method is the getter for the column header.
     *
     * @return the column header String array
     */
    public String[] getColumnHeader() {
        return columnHeader;
    }

    /**
     * This method is the getter for the row header
     *
     * @return the row header String array
     */
    public String[] getRowHeader() {
        return rowHeader;
    }

    /**
     * This method overrides the toString method to properly display a matrix when printing it without the printMatrix method.
     *
     * @return a properly formatted String with the given values in matrix and their headers
     */
    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        for (BigDecimal[] row : matrix) {
            StringJoiner stringJoinerRow = new StringJoiner(",", "[", "]");
            for (BigDecimal number : row) {
                stringJoinerRow.add(number.toPlainString());

            }
            stringJoiner.add(stringJoinerRow.toString());
        }
        return "Matrix{" + "matrix=" + stringJoiner + ", oben=" + Arrays.toString(columnHeader) + ", links=" + Arrays.toString(rowHeader) + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix1 = (Matrix) o;
        //check if matrices are the same
        return this.compareAndCheck(matrix1).length == 0 &&
                Arrays.equals(getColumnHeader(), matrix1.getColumnHeader()) &&
                Arrays.equals(getRowHeader(), matrix1.getRowHeader());
    }


    @Override
    public int hashCode() {
        int result = Arrays.deepHashCode(getMatrix());
        result = 31 * result + Arrays.hashCode(getColumnHeader());
        result = 31 * result + Arrays.hashCode(getRowHeader());
        return result;
    }

    /**
     * Formatted output of the matrix with column and row headers and the corresponding values of the matrix.
     *
     * @author Anton Kaiser
     */
    public void printMatrix() {
        System.out.printf("%15.4s" + " ", ""); // Damit links oben Abstand ist (bspw. in Tabelle die Zelle links oben leer) und X1 über matrix[0][0] steht
        for (String s : columnHeader) {
            System.out.printf("%15s" + " ", s);
        }
        System.out.println(); //neue Zeile
        for (int row = 0; row < matrix.length; row++) {
            System.out.printf("%15.4s" + " ", rowHeader[row]);
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%15.4f" + " ", matrix[row][col]);
            }
            System.out.println();
        }
    }

    /**
     * This method calculates the Simplex tableau with the standard steepest unit ascent procedure.
     */
    public Matrix[] calculateSimplex() { // Standard mit Steepest Unit Ascent
        return calculateSimplex(false);
    }

    /**
     * This method calculates the Simplex tableau.
     *
     * @param greatestChange whether to use the greatest change procedure, otherwise steepest unit ascent
     * @return the matrix which was calculated
     * @author Anton Kaiser
     */
    public Matrix[] calculateSimplex(boolean greatestChange) { //bei true: Greatest Change Verfahren, sonst Steepest Unit Ascent
        Calculator pivotCalculator;
        if (greatestChange) {
            pivotCalculator = new GreatestChangeCalculator();
        } else {
            pivotCalculator = new SteepestUnitAscentCalculator();
        }
        int counter = 0;
        ArrayList<Matrix> iterations = new ArrayList<>();
        this.pivotelement = getPivotelement(pivotCalculator); //need to call it here otherwise pivotelement is null
        iterations.add(this.deepCopy());
        while (continueCalculate()) {
            counter++;
            if (counter > 1)
                this.pivotelement = getPivotelement(pivotCalculator); //first pivotelement already calculated before doing the first deepcopy
            nextStep(pivotelement); //Muss dann später noch auf BigDecimalWrapper geändert werden, sobald wir das mit dem Bruch geändert haben
            iterations.add(this.deepCopy());
        }
        printMatrix();
        System.out.println("Nach " + counter + " Iterationsschritten hat der Simplex-Algorithmus die optimale Loesung gefunden.");

        return iterations.toArray(Matrix[]::new);
    }

    /**
     * This method gets the pivotelement depending on the given pivotCalculator and returns its value.
     *
     * @param pivotCalculator the pivotCalculator which should be used to determine the pivotelement
     */
    private int[] getPivotelement(Calculator pivotCalculator) {
        return pivotCalculator.getPivotelement(this.matrix);
    }

    /**
     * This methods determines whether the Simplex algorithm already terminated or if it should keep on going to optimize the tableau results.
     *
     * @return true if it should continue, otherwise false
     * @author Anton Kaiser, Fabian Struensee
     */
    private boolean continueCalculate() {
        int counter = 0;
        for (int column = 0; column < this.matrix[0].length - 1; column++) { //Iterieren über jedes Element (= die Spalten) in der "G"-Zeile, ausgenommen das Element von "Rechte Seite".
            if (this.matrix[0][column].compareTo(BigDecimal.ZERO) >= 0) counter++;
        }
        if (counter == this.matrix[0].length - 1)
            return false; // Falls jedes Element in der Zeile "G" außer das Element von "Rechte Seite" nichtnegativ ist, wird false zurückgegeben
        return true; //Solange mindestens ein Element (außer das von "Rechte Seite") in der "G"-Zeile ein negatives Vorzeichen hat, wird true zurückgegeben
    }

    /**
     * This method calculates the new simplex tableau iteration based on the given pivotelement.
     *
     * @param pivot the pivot element which should be used for the simplex method calculation
     * @return the changed matrix with the new values of the next simplex iteration
     * @author Anton Kaiser, Fabian Struensee
     */
    public Matrix nextStep(int[] pivot) { //pivot[0] ist die Zeile pivot[1] ist die Spalte
        BigDecimal pivotElement = this.matrix[pivot[0]][pivot[1]];

//        printMatrix(); //Für Debugging

        String temp = this.rowHeader[pivot[0]];
        this.rowHeader[pivot[0]] = this.columnHeader[pivot[1]]; //Nicht-Basis-Variablen
        this.columnHeader[pivot[1]] = temp;

//        try {
//            this.matrix[pivot[0]][pivot[1]] = tempB.divide(pivotElement); // Pivotelement
//        } catch (ArithmeticException e) {
//            this.matrix[pivot[0]][pivot[1]] = ; // Pivotelement
//        }

        calculatePivotElement(pivot, pivotElement);
        calculateRemainingElements(pivot, pivotElement);
        calculatePivotRow(pivot, pivotElement);
        calculatePivotColumn(pivot, pivotElement);

        return this;
    }

    /**
     * This method calculates the changes of the simplex tableau for everything in the table except for the pivot element, -row and -column.
     *
     * @param pivot        an int array with two elements:
     *                     <li>[0] -> index of pivot element in pivot row
     *                     <li>[1] -> index of pivot element in pivot column
     * @param pivotElement the BigDecimal variable of the pivot element
     * @author Anton Kaiser, Fabian Struensee
     */
    private void calculateRemainingElements(int[] pivot, BigDecimal pivotElement) {
        BigDecimal subtrahend;
        for (int column = 0; column < this.matrix[0].length; column++) { //Restliche Felder
            if (column != pivot[1]) for (int row = 0; row < this.matrix.length; row++) {
                if (row != pivot[0]) {
                    subtrahend = this.matrix[row][pivot[1]].multiply(this.matrix[pivot[0]][column]).divide(pivotElement, 15, RoundingMode.HALF_UP);
//                        System.out.println("Zeile: " + row + " | Spalte: " + column + " | Feld (alt): " + this.matrix[row][column]); //Debugging Print
//                        System.out.println("Subtrahend: " + subtrahend + " setzt sich zusammen aus: " +
//                                "\n - Faktor 1: " + this.matrix[row][pivot[1]] + " \n - Faktor 2: " + this.matrix[pivot[0]][column] + "\n - Dividend (Pivotelement): " + pivotElement);
                    this.matrix[row][column] = this.matrix[row][column].subtract(subtrahend);
                }
            }
        }
    }

    /**
     * This method calculates the changes of the simplex tableau for the pivot row.
     *
     * @param pivot        an int array with two elements:
     *                     <li>[0] -> index of pivot element in pivot row
     *                     <li>[1] -> index of pivot element in pivot column
     * @param pivotElement the BigDecimal variable of the pivot element
     * @author Anton Kaiser, Fabian Struensee
     */
    private void calculatePivotRow(int[] pivot, BigDecimal pivotElement) {
        for (int column = 0; column < this.matrix[0].length; column++) { //Pivotzeile
            if (column != pivot[1]) //Pivotelement selbst ausschließen, da die Operationen nur für alle anderen Elemente in der Zeile gilt.
                this.matrix[pivot[0]][column] = this.matrix[pivot[0]][column].divide(pivotElement, 15, RoundingMode.HALF_UP);
            // auf 15 Nachkommastellen "kaufmännisch" runden wie aus der Schule bekannt
        }
    }

    /**
     * This method calculates the changes of the simplex tableau for the pivot column.
     *
     * @param pivot        an int array with two elements:
     *                     <li>[0] -> index of pivot element in pivot row
     *                     <li>[1] -> index of pivot element in pivot column
     * @param pivotElement the BigDecimal variable of the pivot element
     * @author Anton Kaiser, Fabian Struensee
     */
    private void calculatePivotColumn(int[] pivot, BigDecimal pivotElement) {
        for (int row = 0; row < this.matrix.length; row++) { //Pivotspalte
            if (row != pivot[0])
                this.matrix[row][pivot[1]] = this.matrix[row][pivot[1]].divide(pivotElement, 15, RoundingMode.HALF_UP).negate();
            // auf 15 Nachkommastellen "kaufmännisch" runden wie aus der Schule bekannt
        }
    }

    /**
     * This method calculates the changes of the simplex tableau for the pivot element itself.
     *
     * @param pivot        an int array with two elements:
     *                     <li>[0] -> index of pivot element in pivot row
     *                     <li>[1] -> index of pivot element in pivot column
     * @param pivotElement the BigDecimal variable of the pivot element
     * @author Anton Kaiser, Fabian Struensee
     */
    private void calculatePivotElement(int[] pivot, BigDecimal pivotElement) {
        this.matrix[pivot[0]][pivot[1]] = BigDecimal.ONE.divide(pivotElement, 15, RoundingMode.HALF_UP); // Pivotelement,
        // auf 15 Nachkommastellen "kaufmännisch" runden wie aus der Schule bekannt
    }

    public Integer[][] compareAndCheck(Matrix matrixToCheck) {
        List<Integer[]> coordinates = new ArrayList<>();
        for (int i = 0; i < matrixToCheck.getMatrix().length; i++) {
            for (int j = 0; j < matrixToCheck.getMatrix()[i].length; j++) {
                if ((matrixToCheck.getMatrix()[i][j].setScale(10, RoundingMode.HALF_UP).compareTo(this.getMatrix()[i][j].setScale(10, RoundingMode.HALF_UP)) != 0))
                        coordinates.add(new Integer[]{i,j});
            }
        }
        return coordinates.toArray(new Integer[0][0]);
    }
}
