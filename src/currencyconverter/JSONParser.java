/**
 *
 * @author Nevmovenko
 */
package currencyconverter;

import java.util.HashMap;
import java.util.List;

public class JSONParser {

    String base;
    String date;
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
