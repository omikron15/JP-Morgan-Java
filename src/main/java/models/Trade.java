package models;

import java.util.Date;

public class Trade {

    private Stock stock;
    private Date timestamp;
    private int quantity;
    private TradeType type;
    private double price;

    public Trade(Stock stock, Date timestamp, int quantity, TradeType type, double price) {
        this.stock = stock;
        this.timestamp = timestamp;
        this.quantity = quantity;
        this.type = type;
        this.price = price;
    }

    public Stock getStock() {
        return stock;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getQuantity() {
        return quantity;
    }

    public TradeType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
