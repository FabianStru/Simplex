package de.fhws.simplex;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

/**
 * documentation
 */
public class Matrix {

    BigDecimal[][] matrix;
    String[] oben, links; //oben = Spaltenbezeichner, links = Zeilenbezeichner

    public static void main(String[] args) {
        Matrix m = new Matrix(2, 4);

        System.out.println("Manuelle Auswertung Simplex:");
        m.beRottisBeispiel();
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
        m.beRottisBeispiel();
        m.calculateSimplex();

        System.out.println("Automatische Auswertung Simplex nach Greatest Change:");
        m.beRottisBeispiel();
        m.calculateSimplex(true);
    }

    /**
     * documentation
     */
    public Matrix(int zeilen, int spalten) {
        this.matrix = new BigDecimal[zeilen][spalten];
        this.oben = new String[spalten];
        this.links = new String[zeilen];
        this.setObenAndLinks();
    }

    /**
     * documentation
     */
    private void setObenAndLinks() {
        this.oben = new String[this.matrix[0].length];
        this.links = new String[this.matrix.length];
        for (int i = 0; i < this.matrix[0].length - 1; i++) {
            oben[i] = "X" + (i + 1);
        }
        oben[this.matrix[0].length - 1] = "Rechte Seite";
        links[0] = "G";
        for (int i = 1; i < this.matrix.length; i++) {
            char index = (char) ('A' + (i - 1));
            links[i] = "S" + index;
        }
    }

    /**
     * documentation
     */
    void beRottisBeispiel() {
        matrix = new BigDecimal[4][3];
        matrix[0][0] = new BigDecimal("-300");
        matrix[0][1] = new BigDecimal("-500");
        matrix[0][2] = new BigDecimal("-36000");
        matrix[1][0] = new BigDecimal("1");
        matrix[1][1] = new BigDecimal("2");
        matrix[1][2] = new BigDecimal("170");
        matrix[2][0] = new BigDecimal("1");
        matrix[2][1] = new BigDecimal("1");
        matrix[2][2] = new BigDecimal("150");
        matrix[3][0] = new BigDecimal("0");
        matrix[3][1] = new BigDecimal("3");
        matrix[3][2] = new BigDecimal("180");
        this.setObenAndLinks();
    }


    // https://stackoverflow.com/questions/3395825/how-to-print-formatted-bigdecimal-values
    // https://stackoverflow.com/questions/5061912/printing-out-a-2d-array-in-matrix-format
    // https://www.baeldung.com/java-printstream-printf#:~:text=System.out.printf(%22%27-,%255.2f,-%27%25n%22%2C%205.1473)%3B

    public void setMatrix(BigDecimal[][] matrix) {
        this.matrix = matrix;
    }

    public void setOben(String[] oben) {
        this.oben = oben;
    }

    public void setLinks(String[] links) {
        this.links = links;
    }

    public BigDecimal[][] getMatrix() {
        return matrix;
    }

    public String[] getOben() {
        return oben;
    }

    public String[] getLinks() {
        return links;
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "matrix=" + Arrays.toString(matrix) +
                ", oben=" + Arrays.toString(oben) +
                ", links=" + Arrays.toString(links) +
                '}';
    }

    /**
     * Formatierte Ausgabe der Matrix mit Spalten- und Zeilenbezeichnungen sowie den entsprechenden Werten der Matrix.
     */
    public void printMatrix() {
        System.out.printf("%15.4s" + " ", ""); // Damit links oben Abstand ist (bspw. in Tabelle die Zelle links oben leer) und X1 über matrix[0][0] steht
        for (String s : oben) {
            System.out.printf("%15s" + " ", s);
        }
        System.out.println(); //neue Zeile
        for (int row = 0; row < matrix.length; row++) {
            System.out.printf("%15.4s" + " ", links[row]);
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%15.4f" + " ", matrix[row][col]);
            }
            System.out.println();
        }
    }

    /**
     * documentation
     */
    public Matrix calculateSimplex() { // Standard mit Steepest Unit Ascent
        return calculateSimplex(false);
    }

    /**
     * documentation
     */
    public Matrix calculateSimplex(boolean greatestChange) { //bei true: Greatest Change Verfahren, sonst Steepest Unit Ascent
        Calculator pivotCalculator;
        if (greatestChange) {
            pivotCalculator = new GreatestChangeCalculator();
        } else {
            pivotCalculator = new SteepestUnitAscentCalculator();
        }
        int counter = 0;
        while (continueCalculate()) {
            counter++;
            printPivotelement(pivotCalculator);
            nextStep(pivotCalculator.getPivotelement(this.matrix)); //Muss dann später noch auf BigDecimalWrapper geändert werden, sobald wir das mit dem Bruch geändert haben
        }
        printMatrix();
        System.out.println("Nach " + counter + " Iterationsschritten hat der Simplexalgorithmus die optimale Loesung gefunden.");

        return this;
    }

    /**
     * documentation
     */
    private void printPivotelement(Calculator pivotCalculator){
        int[] pivotelement = pivotCalculator.getPivotelement(this.matrix);
        System.out.println("Zeile: " + pivotelement[0]);
        System.out.println("Spalte: " + pivotelement[1]);
    }

    /**
     * documentation
     */
    private boolean continueCalculate() {
        int counter = 0;
        for (int column = 0; column < this.matrix[0].length - 1; column++) { //Iterieren über jedes Element (= die Spalten) in der "G"-Zeile, ausgenommen das Element von "Rechte Seite"
            if (this.matrix[0][column].compareTo(BigDecimal.ZERO) >= 0) counter++;
        }
        if (counter == this.matrix[0].length - 1)
            return false; // Falls jedes Element in der Zeile "G" außer das Element von "Rechte Seite" nichtnegativ ist, wird false zurückgegeben
        return true; //Solange mindestens ein Element (außer das von "Rechte Seite") in der "G"-Zeile ein negatives Vorzeichen hat, wird true zurückgegeben
    }


    /**
     * documentation
     */
    Matrix nextStep(int[] pivot) { //pivot[0] ist die Zeile pivot[1] ist die Spalte
        BigDecimal pivotElement = this.matrix[pivot[0]][pivot[1]];

        printMatrix(); //Für Debugging

        String temp = this.links[pivot[0]];
        this.links[pivot[0]] = this.oben[pivot[1]]; //Nicht-Basis-Variablen
        this.oben[pivot[1]] = temp;

/* Idee für das Vermeiden von Rundungsfehlern: Falls Non-terminating decimal expansion auftreten sollte,
nur als Bruch darstellen.
Aber Problem: BigDecimal unterstützt keine Bruchdarstellung so weit ich weiß, daher müsste man das dann ggf. als "String" speichern.
Dann kann man es aber nicht in matrix speichern, weil Elemente in dem Array vom Datentyp BigDecimal sein müssen.
*/
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
     * documentation
     */
    private void calculateRemainingElements(int[] pivot, BigDecimal pivotElement) {
        BigDecimal subtrahend;
        for (int column = 0; column < this.matrix[0].length; column++) { //Restliche Felder
            if (column != pivot[1])
                for (int row = 0; row < this.matrix.length; row++) {
                    if (row != pivot[0]) {
                        subtrahend = this.matrix[row][pivot[1]].multiply(this.matrix[pivot[0]][column]).divide(pivotElement, 15, RoundingMode.HALF_UP);
//                        System.out.println("Zeile: " + row + " | Spalte: " + column + " | Feld (alt): " + this.matrix[row][column]);
//                        System.out.println("Subtrahend: " + subtrahend + " setzt sich zusammen aus: " +
//                                "\n - Faktor 1: " + this.matrix[row][pivot[1]] + " \n - Faktor 2: " + this.matrix[pivot[0]][column] + "\n - Dividend (Pivotelement): " + pivotElement);
                        this.matrix[row][column] = this.matrix[row][column].subtract(subtrahend);
                    }
                }
        }
    }

    /**
     * documentation
     */
    private void calculatePivotRow(int[] pivot, BigDecimal pivotElement) {
        for (int column = 0; column < this.matrix[0].length; column++) { //Pivotzeile
            if (column != pivot[1]) //Pivotelement selbst ausschließen, da die Operationen nur für alle anderen Elemente in der Zeile gilt.
                this.matrix[pivot[0]][column] = this.matrix[pivot[0]][column].divide(pivotElement, 15, RoundingMode.HALF_UP);
            // auf 15 Nachkommastellen "kaufmännisch" runden wie aus der Schule bekannt
        }
    }

    /**
     * documentation
     */
    private void calculatePivotColumn(int[] pivot, BigDecimal pivotElement) {
        for (int row = 0; row < this.matrix.length; row++) { //Pivotspalte
            if (row != pivot[0])
                this.matrix[row][pivot[1]] = this.matrix[row][pivot[1]].divide(pivotElement, 15, RoundingMode.HALF_UP).negate();
            // auf 15 Nachkommastellen "kaufmännisch" runden wie aus der Schule bekannt
        }
    }

    /**
     * documentation
     */
    private void calculatePivotElement(int[] pivot, BigDecimal pivotElement) {
        this.matrix[pivot[0]][pivot[1]] = BigDecimal.ONE.divide(pivotElement, 15, RoundingMode.HALF_UP); // Pivotelement,
        // auf 15 Nachkommastellen "kaufmännisch" runden wie aus der Schule bekannt
    }

}
