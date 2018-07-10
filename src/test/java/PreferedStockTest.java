import models.PreferedStock;
import models.StockType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PreferedStockTest {

    public PreferedStock GINStock;

    @Before
    public void setUp(){
        GINStock = new PreferedStock("GIN", 8, 2, 100);
    }

    @Test
    public void getStockSymbol() {
        assertEquals("GIN", GINStock.getSymbol());
    }

    @Test
    public void getStockType() {
        assertEquals(StockType.Prefered, GINStock.getStockType());
    }

    @Test
    public void getLastDividend() {
        assertEquals(8, GINStock.getLastDividend());
    }

    @Test
    public void getFixedDividend() {
        assertEquals(2, GINStock.getFixedDividend());
    }

    @Test
    public void getParValue() {
        assertEquals(100, GINStock.getParValue());
    }


}
