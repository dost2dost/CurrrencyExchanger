package utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class ExchangeRateFinder {
    private static String exUrl;

    /**
     *
     * @param baseCurrency
     * @param toExchange
     * @return  the exchange rate against us doller
     */
    public static Map<String, Double> findExchangeRate(String baseCurrency, String toExchange) {
        Map<String, Double> ratesMap = null;
        exUrl="https://v6.exchangerate-api.com/v6/837d1d3b8539b0c4a140a424/latest/"+baseCurrency.toUpperCase();
        try {
            URL url = new URL(exUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            int connectionResponse = httpURLConnection.getResponseCode();
            if (connectionResponse == HttpURLConnection.HTTP_OK) {

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                String lineReader;
                StringBuffer buffer = new StringBuffer();
                while ((lineReader = bufferedReader.readLine()) != null) {
                    buffer.append(lineReader);
                }
                bufferedReader.close();

                JSONObject jsonObject = new JSONObject(buffer.toString());
                ObjectMapper objectMapper = new ObjectMapper();
                ratesMap = objectMapper.readValue(jsonObject.get("conversion_rates").toString(), Map.class);

                //System.out.println(ratesMap.get("USD"));

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ratesMap;
    }
}
