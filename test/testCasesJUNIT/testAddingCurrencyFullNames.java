package testCasesJUNIT;

import currencyconverter.CurrencyConverter;
import java.util.HashMap;
import java.util.TreeMap;
import org.junit.Test;

public class testAddingCurrencyFullNames {

    /*checks workability of method "addCurrencyNames" which
      appends full name of the currency depending on its
      currency code
 E.g: RUB ---> Russian Ruble (RUB) 
      AUD ---> Australian Dollar (AUD)
     */
    @Test
    public void addingFullName() {

        //Given
        HashMap<String, String> codes = new HashMap();
        codes.put("RUB", "123");
        codes.put("USD", "6543");
        codes.put("INR", "999");
        codes.put("AUD", "777");

        //Execute 
        TreeMap<String, String> fullNames = CurrencyConverter.addCurrencyNames(codes);

        //Verify
        assert (fullNames.containsKey("Australian Dollar (AUD)")
                && fullNames.containsKey("Indian Rupee (INR)")
                && fullNames.containsKey("Russian Ruble (RUB)")
                && fullNames.containsKey("US Dollar (USD)"));

    }
}
