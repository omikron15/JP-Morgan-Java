import models.Stock;
import models.Trade;
import models.TradeType;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
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

}
