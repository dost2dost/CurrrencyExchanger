package currencyexhange;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterWrapperTest {
    ConverterWrapper converterWrapper=new ConverterWrapper();

    /**
     * base currency is USD and exchange fee is deducted from converted ammount
     */
    @Test
    public void eurotoUSD(){
        assertEquals("6.0 EURO = 5.69 USD",converterWrapper.convert(6.0,0.31,"USD"));
    }
    @Test
    public void usdtoEuro(){
        assertEquals("6.0 USD = 4.9904 EUR",converterWrapper.convert(6.0,0.31,"EUR"),"ok");


    }
    @Test
    public void anyCurrency(){
        assertEquals("6.0 USD = 1058.5430000000001PKR",converterWrapper.convert(6.0,0.31,"PKR"),"ok");

    }

}