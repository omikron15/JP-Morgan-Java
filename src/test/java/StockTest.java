import models.Stock;
import models.StockType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StockTest {

    public Stock TEAstock;

    @Before
    public void setUp(){
        TEAstock = new Stock("TEA", 0, 100);
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
    public void getParValue() {
        assertEquals(100, TEAstock.getParValue());
    }

    @Test
    public void setStockSymbol() {
        TEAstock.setSymbol("POP");
        assertEquals("POP", TEAstock.getSymbol());
    }

    @Test
    public void setLastDividend() {
        TEAstock.setLastDividend(5);
        assertEquals(5, TEAstock.getLastDividend());
    }

    @Test
    public void setParValue() {
        TEAstock.setParValue(50);
        assertEquals(50, TEAstock.getParValue());
    }
}
