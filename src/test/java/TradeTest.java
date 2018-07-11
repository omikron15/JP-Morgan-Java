import models.Stock;
import models.Trade;
import models.TradeType;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import static junit.framework.Assert.assertEquals;

public class TradeTest {

    public Trade trade;
    public Stock stock;
    public LocalDateTime date;

    @Before
    public void setUp(){
        date = LocalDateTime.parse("2018-01-01T11:00:00");
        stock = new Stock("TEA", 0, 100);
        trade =  new Trade(stock, date, 100, TradeType.Buy, 500.50);
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
    public void calculateGeometricMean() {

        Stock TEAstock = new Stock("TEA", 0, 100);

        LocalDateTime date1 = LocalDateTime.parse("2018-01-01T11:00:00");
        LocalDateTime date2 = LocalDateTime.parse("2018-01-01T11:05:00");
        LocalDateTime date3 = LocalDateTime.parse("2018-01-01T11:10:00");

        Trade trade1 = new Trade(TEAstock, date1, 150, TradeType.Buy, 500.50);
        Trade trade2 = new Trade(TEAstock, date2, 100, TradeType.Sell, 300.79);
        Trade trade3 = new Trade(TEAstock, date3, 2400, TradeType.Buy, 700.10);

        ArrayList<Trade> trades = new ArrayList();
        trades.add(trade1);
        trades.add(trade2);
        trades.add(trade3);

        assertEquals(472.36, Trade.calculateGeometricMean(trades), 0.2);
    }
}
