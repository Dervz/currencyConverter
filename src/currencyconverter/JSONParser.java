/**
 *
 * @author Pavel Nevmovenko
 */
package currencyconverter;

import java.util.HashMap;

public class JSONParser {

    String base;
    String date;

    //HashMap with key = currency name, value = exchange rate
    private HashMap<String, String> rates = new HashMap<>();

    public HashMap<String, String> getRates() {
        return rates;
    }

    public void setRates(HashMap<String, String> rates) {
        this.rates = rates;
    }

    public String getBase() {
        return base;
    }

    public String getDate() {
        return date;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
