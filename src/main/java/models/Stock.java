package models;

import java.util.ArrayList;

public class Stock {

    protected String symbol;
    protected StockType stockType;
    protected int lastDividend;
    protected int parValue;

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

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setLastDividend(int lastDividend) {
        this.lastDividend = lastDividend;
    }

    public void setParValue(int parValue) {
        this.parValue = parValue;
    }

    public double calculateDividendYield(double marketPrice){
        return (this.lastDividend/marketPrice);
    }

    public double calculatePERatio(double marketPrice){
        double dy = calculateDividendYield(marketPrice);
        return (marketPrice/(dy));
    }

    public static double calculateVWSP(ArrayList<Trade> trades){

        double tradeTimeQuantitySum = 0;
        double quantitySum = 0;

        for(Trade trade : trades){
            tradeTimeQuantitySum += (trade.getPrice() * trade.getQuantity());
            quantitySum += trade.getQuantity();
        }

        return (tradeTimeQuantitySum / quantitySum);


    }
}
