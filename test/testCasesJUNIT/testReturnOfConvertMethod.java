package testCasesJUNIT;

import currencyconverter.CurrencyConverter;
import org.junit.Test;

public class testReturnOfConvertMethod {

    /*checks if invalid arguments are provided to "convert" method
      then it returns "You did not select any currency" message
     */
    @Test
    public void nullArgumentsProvidedToConvert() throws Exception {
       
            //Given
            String arg1 = "";
            String arg2 = "";
            Double arg3 = 0.0;
            
            //Execute
            String responseOfConvert = CurrencyConverter.convert(arg1, arg2, arg3);
            
            //Verify
            assert(responseOfConvert.equals("You did not select any currency"));

       
    }
}
