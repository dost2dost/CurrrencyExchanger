package currencyexhange;

public class ConverterWrapper {

    private Double amount;
    private Double exchangeFee;
    private String symbol;
    private Converter converter;

    public ConverterWrapper() {
    }

    /**
     *
     * @param ammount
     * @param exchangeFee
     * @param symbol
     */
    public ConverterWrapper(double ammount, double exchangeFee, String symbol) {
        this.amount = ammount;
        this.exchangeFee = exchangeFee;
        this.symbol = symbol;
    }

    /**
     *
     * @param ammount
     * @param exchangeFee
     * @param symbol
     * @return
     */
    public String convert(Double ammount,Double exchangeFee,String symbol){
        converter=new Converter();

        if(symbol.equalsIgnoreCase("USD")){
            return converter.euroToUSD(ammount,exchangeFee,symbol);
        }else if(symbol.equalsIgnoreCase("EUR")){
            return converter.usdToEuro(ammount,exchangeFee,symbol);
        }else {
            return converter.convert(ammount,exchangeFee,symbol);
        }
    }
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getExchangeFee() {
        return exchangeFee;
    }

    public void setExchangeFee(Double exchangeFee) {
        this.exchangeFee = exchangeFee;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
