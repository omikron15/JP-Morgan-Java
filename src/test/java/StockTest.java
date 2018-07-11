
import models.Stock;
import models.StockType;
import models.Trade;
import models.TradeType;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class StockTest {

    public Stock TEAstock;
    public Stock POPstock;

    public Trade trade1;
    public Trade trade2;
    public Trade trade3;

    public Date date1;
    public Date date2;
    public Date date3;
    public ArrayList<Trade> trades;

    @Before
    public void setUp(){
        TEAstock = new Stock("TEA", 0, 100);

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

        trade1 = new Trade(TEAstock, date1, 150, TradeType.Buy, 500.50);
        trade2 = new Trade(TEAstock, date2, 100, TradeType.Sell, 300.79);
        trade3 = new Trade(TEAstock, date3, 2400, TradeType.Buy, 7000.10);

        trades = new ArrayList();
        trades.add(trade1);
        trades.add(trade2);
        trades.add(trade3);
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
        POPstock = new Stock("POP", 8, 100);
        assertEquals(0.08, POPstock.calculateDividendYield(100), 0.1);
        assertEquals(0.0102, POPstock.calculateDividendYield(777), 0.1);
        assertEquals(0.7272, POPstock.calculateDividendYield(11), 0.1);
    }

    @Test
    public void calculatePERatioPOPstock() {
        POPstock = new Stock("POP", 8, 100);
        assertEquals(1250, POPstock.calculatePERatio(100), 0.1);
        assertEquals(75466.200, POPstock.calculatePERatio(777), 0.1);
        assertEquals(15.1265, POPstock.calculatePERatio(11), 0.1);
    }

    @Test
    public void calculateVWSP() {
        assertEquals(6379.39, Stock.calculateVWSP(trades), 0.01);
    }

}
