package currencyexhange;

import utility.ExchangeRateFinder;

import java.math.BigDecimal;
import java.util.Map;

public class Converter {
    private Map<String,Double> ratesMap;

    public Converter() {
        this.ratesMap = ExchangeRateFinder.findExchangeRate("USD","EURO");
    }

    /**
     *
     * @param amount
     * @param exchangeFee
     * @param symbol
     * @return
     */
    public String euroToUSD(Double amount,Double exchangeFee,String symbol){
        Double tamount=amount*Double.valueOf(String.valueOf(ratesMap.get(symbol.toUpperCase())))-exchangeFee;
        return new StringBuffer().append(amount+" EURO").append(" = "+tamount).append(" USD").toString();
    }

    /**
     *
     * @param amount
     * @param exchangeFee
     * @param symbol
     * @return
     */
    public String usdToEuro(Double amount,Double exchangeFee,String symbol){
        Double tamount=amount*Double.valueOf(String.valueOf(ratesMap.get(symbol.toUpperCase())))-exchangeFee;
        return new StringBuffer().append(amount+" USD").append(" = "+tamount).append(" EUR").toString();
    }

    /**
     *
     * @param ammount
     * @param feeExchange
     * @param symbol
     * @return
     */
    public String convert(Double ammount, Double feeExchange, String symbol){
        Double tammount=ammount*ratesMap.get(symbol.toUpperCase())-feeExchange;

       return new StringBuffer().append(ammount+" USD").append(" = "+tammount).append(symbol).toString();
    }
}
