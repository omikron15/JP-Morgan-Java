
import models.Stock;
import models.StockType;
import models.Trade;
import models.TradeType;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class StockTest {

    public Stock TEAstock;
    public Stock POPstock;

    public Trade trade1;
    public Trade trade2;
    public Trade trade3;
    public Trade trade4;
    public Trade trade5;

    public LocalDateTime date1;
    public LocalDateTime date2;
    public LocalDateTime date3;
    public LocalDateTime date4;
    public ArrayList<Trade> trades;

    @Before
    public void setUp(){
        TEAstock = new Stock("TEA", 0, 100);
        POPstock = new Stock("POP", 8, 100);

        date1 = LocalDateTime.parse("2018-01-01T11:00:00");
        date2 = LocalDateTime.parse("2018-01-01T11:05:00");
        date3 = LocalDateTime.parse("2018-01-01T11:10:00");
        date4 = LocalDateTime.parse("2018-01-01T11:30:00");


        trade1 = new Trade(TEAstock, date1, 150, TradeType.Buy, 500.50);
        trade2 = new Trade(TEAstock, date2, 100, TradeType.Sell, 300.79);
        trade3 = new Trade(TEAstock, date3, 2400, TradeType.Buy, 7000.10);
        trade4 = new Trade(TEAstock, date4, 1400, TradeType.Buy, 3000.10);
        trade5 = new Trade(POPstock, date2, 756, TradeType.Buy, 3175.85);

        trades = new ArrayList();
        trades.add(trade1);
        trades.add(trade2);
        trades.add(trade3);
        trades.add(trade4);
        trades.add(trade5);
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

    @Test
    public void calculateDividendYieldTEAstock() {
        assertEquals(0.0, TEAstock.calculateDividendYield(100), 0.1);
        assertEquals(0.0, TEAstock.calculateDividendYield(777), 0.1);
        assertEquals(0.0, TEAstock.calculateDividendYield(11), 0.1);
    }

    @Test
    public void calculateDividendYieldPOPstock() {
        assertEquals(0.08, POPstock.calculateDividendYield(100), 0.1);
        assertEquals(0.0102, POPstock.calculateDividendYield(777), 0.1);
        assertEquals(0.7272, POPstock.calculateDividendYield(11), 0.1);
    }

    @Test
    public void calculatePERatioPOPstock() {
        assertEquals(1250, POPstock.calculatePERatio(100), 0.1);
        assertEquals(75466.200, POPstock.calculatePERatio(777), 0.1);
        assertEquals(15.1265, POPstock.calculatePERatio(11), 0.1);
    }

    @Test
    public void calculateVWSP() {
        LocalDateTime testDate = LocalDateTime.parse("2018-01-01T11:10:00");
        assertEquals(6379.39, Stock.calculateVWSP(TEAstock, trades, testDate), 0.01);
    }

}
