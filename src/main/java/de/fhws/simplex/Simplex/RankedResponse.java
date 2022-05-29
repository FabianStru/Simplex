package de.fhws.simplex.Simplex;

public class RankedResponse {
    private boolean result;
    private RankedResponseMiscalculation[] miscalculations;

    public RankedResponse(RankedResponseMiscalculation[] miscalculations) {
        if (miscalculations.length == 0)
            result = true;
        else {
            this.miscalculations = miscalculations;
            result = false;
        }
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public RankedResponseMiscalculation[] getMiscalculations() {
        return miscalculations;
    }

    public void setMiscalculations(RankedResponseMiscalculation[] miscalculations) {
        this.miscalculations = miscalculations;
    }
}
