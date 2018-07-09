import models.Stock;
import models.StockType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StockTest {

    public Stock TEAstock;
    public Stock GINstock;

    @Before
    public void setUp(){
        TEAstock = new Stock("TEA", StockType.Common, 0, 100);
//        GINstock = new Stock("GIN", StockType.Prefered, 0, 2, 100);
    }

    @Test
    public void getStockSymbol() {
        assertEquals("TEA", TEAstock.getSymbol());
    }

    @Test
    public void getStockType() {
        assertEquals(StockType.Common, TEAstock.getStockType());
    }

    @Test
    public void getLastDividend() {
        assertEquals(0, TEAstock.getLastDividend());
    }

    @Test
    public void getFixedDividend() {
        assertEquals(2, TEAstock.getFixedDividend());
    }

    @Test
    public void getParValue() {
        assertEquals(100, TEAstock.getParValue());
    }
}
