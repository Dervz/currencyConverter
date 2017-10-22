package testCasesJUNIT;

import currencyconverter.CurrencyConverter;
import org.junit.Test;

public class testResponseMessageJSON {

    /*checks that JSON message returned from API contains several 
      randomly selected currency codes.
     */
    @Test
    public void hello() throws Exception {

        //Given
        String fixerAPI_URL_default = "https://api.fixer.io/latest";

        //Execute
        String responseDefault = CurrencyConverter.getJSON(fixerAPI_URL_default);

        //Verify
        assert (responseDefault.contains("AUD")
                && responseDefault.contains("CNY")
                && responseDefault.contains("IDR")
                && responseDefault.contains("PHP")
                && responseDefault.contains("THB")
                && responseDefault.contains("ZAR")
                && responseDefault.contains("HKD"));

    }
}
