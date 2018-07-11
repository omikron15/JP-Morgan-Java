package models;

public class PreferredStock extends Stock {

    protected int fixedDividend;

    public PreferredStock(String symbol, int lastDividend, int fixedDividend , int parValue) {
        super(symbol, lastDividend, parValue);
        this.stockType = StockType.Prefered;
        this.fixedDividend = fixedDividend;
    }

    public int getFixedDividend() {
        return fixedDividend;
    }

    public void setFixedDividend(int fixedDividend) {
        this.fixedDividend = fixedDividend;
    }

    public double calculateDividendYield(double marketPrice){
        return (this.fixedDividend*this.parValue)/marketPrice;
    }

    public double calculatePERatio(double marketPrice){
        return (marketPrice/(calculateDividendYield(marketPrice)));
    }
}
