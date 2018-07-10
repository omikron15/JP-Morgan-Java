import models.Stock;
import models.Trade;
import models.TradeType;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static junit.framework.Assert.assertEquals;

public class TradeTest {

    public Trade trade;
    public Trade trade1;
    public Trade trade2;
    public Trade trade3;
    public Stock stock;
    public Date date;
    public Date date1;
    public Date date2;
    public Date date3;
    public ArrayList<Trade> trades;



    @Before
    public void setUp(){

        date = new Date();
        stock = new Stock("TEA", 0, 100);
        trade =  new Trade(stock, date, 100, TradeType.Buy, 500.50);

        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

        String date1String = "01-01-2018 11:00:00";
        String date2String = "01-01-2018 11:05:00";
        String date3String = "01-01-2018 11:30:00";

        try{
            date1 = dateformat.parse(date1String);
            date2 = dateformat.parse(date2String);
            date3 = dateformat.parse(date3String);
        } catch (ParseException e) {
            System.out.println("Date format error");
        }

        trade1 = new Trade(stock, date1, 150, TradeType.Buy, 500.50);
        trade2 = new Trade(stock, date2, 100, TradeType.Sell, 300.79);
        trade3 = new Trade(stock, date3, 2400, TradeType.Buy, 7000.10);

        trades = new ArrayList();
        trades.add(trade1);
        trades.add(trade2);
        trades.add(trade3);

    }

    @Test
    public void getStock() {
        assertEquals(stock, trade.getStock());
    }

    @Test
    public void getTimestamp() {
        assertEquals(date, trade.getTimestamp());
    }

    @Test
    public void getQuantity() {
        assertEquals(100, trade.getQuantity());
    }

    @Test
    public void getType() {
        assertEquals(TradeType.Buy, trade.getType());
    }

    @Test
    public void getPrice() {
        assertEquals(500.50, trade.getPrice());
    }

    @Test
    public void calculateVWSP() {
        assertEquals(16830347.33, Stock.calculateVWSP(trades));
    }
}
