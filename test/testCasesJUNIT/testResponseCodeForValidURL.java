package testCasesJUNIT;

import currencyconverter.CurrencyConverter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class testResponseCodeForValidURL {

    /*checks that establishing HttpURLConnection to the appropriate link 
      returns response code of 200
     */
    @Test
    public void checkResponseCode200() throws IOException {
        String fixerAPI_URL = "https://api.fixer.io/latest";
        CurrencyConverter.getJSON(fixerAPI_URL);

        //Given
        URL url = new URL(fixerAPI_URL);

        //Excute
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        int responseCode = con.getResponseCode();

        //Verify
        assertEquals(200, responseCode);

    }
}
