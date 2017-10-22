package testCasesJUNIT;

import com.google.gson.Gson;
import currencyconverter.CurrencyConverter;
import static currencyconverter.CurrencyConverter.getJSON;
import currencyconverter.JSONParser;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.Test;

public class testConvertMethodValidity {

    //variables used to generate random amount for convertion
    int rangeMin = 1;
    int rangeMax = 255;
    int amount = ThreadLocalRandom.current().nextInt(rangeMin, rangeMax + 1);
    DecimalFormat df = new DecimalFormat("#.####");

    /*checks THREE custom conversions performed by the convert method.
      Also checks that answer is given to precisely 4 decimal places.
      Finally, checks that if both provided currencies are same, result 
      returned is the AMOUNT entered to convert.   
     */
    @Test
    public void validArgumentsProvidedToConvert() throws IOException, Exception {
        df.setRoundingMode(RoundingMode.CEILING);

        //Given
        String fromUSD = getJSON("https://api.fixer.io/latest?base=" + "USD");
        String fromNOK = getJSON("https://api.fixer.io/latest?base=" + "NOK");
        Gson gson = new Gson();

        //get JSON response for USD base, parse it
        JSONParser jsonUSD = gson.fromJson(fromUSD, JSONParser.class);
        HashMap<String, String> codesFromUSD = jsonUSD.getRates();

        String rateUSD = codesFromUSD.get("CZK");
        double conversionRateUSD = Double.valueOf((rateUSD != null) ? rateUSD : "0.0");

        //get JSON response for NOK base, parse it
        JSONParser jsonNOK = gson.fromJson(fromNOK, JSONParser.class);
        HashMap<String, String> codesFromNOK = jsonNOK.getRates();

        String rateNOK = codesFromNOK.get("PLN");
        double conversionRateNOK = Double.valueOf((rateNOK != null) ? rateNOK : "0.0");

        //calculate expected answers
        double answerUSDtoCZK = amount * conversionRateUSD;
        double answerNOKtoPLN = amount * conversionRateNOK;

        //Execute
        String convertUSDtoCZK = CurrencyConverter.convert("USD", "CZK", (double) amount);
        String convertUSDtoUSD = CurrencyConverter.convert("USD", "USD", (double) amount);
        String convertNOKtoPLN = CurrencyConverter.convert("NOK", "PLN", (double) amount);

        //Verify
        assert (convertUSDtoCZK.contains("" + amount)
                && convertUSDtoCZK.contains("USD")
                && convertUSDtoCZK.contains("CZK")
                && convertUSDtoUSD.contains("" + amount)
                && convertNOKtoPLN.contains("" + amount)
                && convertNOKtoPLN.contains("" + df.format(answerNOKtoPLN))
                && convertUSDtoCZK.contains("" + df.format(answerUSDtoCZK))
                && convertNOKtoPLN.contains("NOK")
                && convertNOKtoPLN.contains("PLN"));

    }

}
