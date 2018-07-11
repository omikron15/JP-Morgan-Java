import models.PreferredStock;
import models.StockType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PreferredStockTest {

    public PreferredStock GINStock;

    @Before
    public void setUp(){
        GINStock = new PreferredStock("GIN", 8, 2, 100);
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

    @Test
    public void setFixedDividend() {
        GINStock.setFixedDividend(5);
        assertEquals(5, GINStock.getFixedDividend());
    }

    @Test
    public void calculateDividendYieldPOPstock() {
        assertEquals(2, GINStock.calculateDividendYield(100), 0.01);
        assertEquals(0.2574, GINStock.calculateDividendYield(777), 0.01);
        assertEquals(18.1818, GINStock.calculateDividendYield(11), 0.01);
    }

    @Test
    public void calculatePERatioTEAstock() {
        assertEquals(50 , GINStock.calculatePERatio(100), 0.01);
        assertEquals(3018.64, GINStock.calculatePERatio(777), 0.01);
        assertEquals(0.6050, GINStock.calculatePERatio(11), 0.01);
    }

}
