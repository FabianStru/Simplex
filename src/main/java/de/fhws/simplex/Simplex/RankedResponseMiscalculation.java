package de.fhws.simplex.Simplex;


public class RankedResponseMiscalculation {
    private int matrixIndex;
    private Integer[] coordinates; //those two numbers are the coordinates of the matrix array which show the wrong input number of the user

    public RankedResponseMiscalculation(int matrixIndex, Integer[] coordinates) {
        this.matrixIndex = matrixIndex;
        this.coordinates = coordinates;
    }

    public int getMatrixIndex() {
        return matrixIndex;
    }

    public void setMatrixIndex(int matrixIndex) {
        this.matrixIndex = matrixIndex;
    }

    public Integer[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Integer[] coordinates) {
        this.coordinates = coordinates;
    }
}
