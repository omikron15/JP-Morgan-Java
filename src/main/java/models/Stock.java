package models;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

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

    public static double calculateVWSP(Stock stock, ArrayList<Trade> trades, LocalDateTime date){

        double tradeTimeQuantitySum = 0;
        double quantitySum = 0;
        LocalDateTime adjustedDate = date.minusMinutes(15);

        for(Trade trade : trades){
            //get trade time for comparisons
            LocalDateTime tradeTime = trade.getTimestamp();

            //if trade time is within 15minute range
            if((tradeTime.isBefore(date)||tradeTime.isEqual(date))&&(tradeTime.isBefore(date)||tradeTime.isEqual(date))){

                //if stock is of the right type then use stock data for calculation
                if((trade.getStock() == stock)){
                    tradeTimeQuantitySum += (trade.getPrice() * trade.getQuantity());
                    quantitySum += trade.getQuantity();
                }
            }

        }
        return (tradeTimeQuantitySum / quantitySum);
    }
}
