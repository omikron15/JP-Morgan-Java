import models.Stock;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.assertEquals;

public class TradeTest {

    public Trade trade1;
    public Trade trade2;
    public Trade trade3;
    public Stock stock1;
    public Stock stock2;
    public Date currentDate;

    @Before
    public void setUp(){

        stock1 = new Stock("TEA", 0, 100);
        currentDate = new Date();
        trade1 =  new Trade(stock1, currentDate, 100, TradeType.Buy, 500.50);
    }

    @Test
    public void getStock() {
        assertEquals(stock1, trade1.getStock());
    }

    @Test
    public void getDate() {
        assertEquals(currentDate, trade1.getDate());
    }

    @Test
    public void getQuantity() {
        assertEquals(100, trade1.getQuantity());
    }

    @Test
    public void getType() {
        assertEquals(TradeType.Buy, trade1.getType());
    }

    @Test
    public void getPrice() {
        assertEquals(500.50, trade1.getPrice());
    }


}
