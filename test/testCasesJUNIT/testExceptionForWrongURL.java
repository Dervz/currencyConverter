package testCasesJUNIT;

import org.junit.Test;
import currencyconverter.*;
import java.io.IOException;
import java.net.MalformedURLException;

public class testExceptionForWrongURL {

    /*checks if invalid link is provided (invalid link) such as 
    "badURL" then getJSON method will throw
    MalformedURLException
     */
    @Test(expected = MalformedURLException.class)
    public void badURLthowsException() throws IOException {

        //Given
        String badURL = "badURL";

        //Execute
        CurrencyConverter.getJSON(badURL);

    }
}
