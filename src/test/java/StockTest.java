import models.Stock;
import org.junit.Before;
import org.junit.Test;

public class StockTest {

    public Stock TEAstock;
    public Stock GINstock;

    @Before
    public void setUp(){
        TEAstock = new Stock("TEA", StockType.Common, 0, 100);
        GINstock = new Stock("GIN", StockType.Prefered, 0, 2, 100);
    }

    @Test
    public void getStockSymbol() {
        assertEquals("TEA", TEAstock.getSymbol());
    }
}
