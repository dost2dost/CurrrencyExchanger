import currencyexhange.Converter;
import currencyexhange.ConverterWrapper;

import java.util.Scanner;

public class CurrencyMan {
    public static void main(String[] args) {

         Double amount;
         Double exchangeFee;
         String symbol = "";

        ConverterWrapper converterWrapper=new ConverterWrapper();
        Scanner sc=new Scanner(System.in);
        System.out.println(" Enter amount ");
        amount=sc.nextDouble();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Enter Exchange fee ");
        exchangeFee=sc.nextDouble();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Enter Convert able Currency 1=USD or 2=EUR");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int symbno=sc.nextInt();
        if(symbno==1){
            symbol="USD";
        }else if(symbno==2){
            symbol="EUR";
        }

        try {
            if(amount!=null && exchangeFee!=null && !symbol.equalsIgnoreCase(""))
                System.out.println(converterWrapper.convert(Double.valueOf(amount),Double.valueOf(exchangeFee),symbol));
        }catch (Exception ex){
            ex.printStackTrace();
        }





    }
}
