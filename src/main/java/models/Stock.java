package models;

public class Stock {

    private String symbol;
    private StockType stockType;
    private int lastDividend;
    private int parValue;

    public Stock(String symbol, int lastDividend, int parValue) {
        this.symbol = symbol;
        this.stockType = StockType.Common;
        this.lastDividend = lastDividend;
        this.parValue = parValue;
    }

    public String getSymbol() {
        return symbol;
    }

    public StockType getStockType() {
        return stockType;
    }

    public int getLastDividend() {
        return lastDividend;
    }

    public int getParValue() {
        return parValue;
    }
}
