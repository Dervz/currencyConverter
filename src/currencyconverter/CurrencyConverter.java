/**
 * @author Pavel Nevmovenko
 */
package currencyconverter;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;
import com.google.gson.Gson;
import java.awt.event.KeyEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Locale;
import javax.swing.Action;

public class CurrencyConverter {

    private static final String API_FIXER = "https://api.fixer.io";

    public static void main(String[] args) throws Exception {

        String latest = CurrencyConverter.getJSON(API_FIXER + "/latest");

        //get latest rates,base & date and print them out in the console
        Gson gson = new Gson();
        JSONParser json = gson.fromJson(latest, JSONParser.class);
        System.out.println("date = " + json.getDate() + " , base = " + json.getBase());

        //store rates returned by Fixer.io/latest 
        HashMap<String, String> codes = json.getRates();
        codes = addCurrencyNames(codes);
        printMap(codes);

        //load GUI, passing the map to fullfil comboboxes with its keys
        GUILoader(codes);

    }

    public static String getJSON(String uri) throws MalformedURLException, IOException {

        //Create instance of the URL, MalformedURLException is caught
        URL url = new URL(uri);

        //establish connection, IOException thrown
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");
        System.out.println("\nGET request to : " + uri + "\nResponse code : " + con.getResponseCode());

        Scanner scan = new Scanner(con.getInputStream());
        String response = scan.next();

        return response;
    }

    public static String convert(String currencyFrom, String currencyTo, Double amount) throws Exception {

        
         //substitute both Strings with their substrings of currencyCodes contained between "(" and ")"
         currencyFrom = currencyFrom.substring(currencyFrom.indexOf("(") + 1, currencyFrom.indexOf(")"));
         currencyTo = currencyTo.substring(currencyTo.indexOf("(") + 1, currencyTo.indexOf(")"));
        
        if (currencyFrom != null && currencyTo != null && !currencyTo.equals(currencyFrom)) {
            String response = getJSON(API_FIXER + "/latest?base=" + currencyFrom);

            //get the rates from JSON format
            Gson gson = new Gson();
            JSONParser json = gson.fromJson(response, JSONParser.class);

            //rate of the currency against base
            String rate = json.getRates().get(currencyTo);
            double conversionRate = Double.valueOf((rate != null) ? rate : "0.0");

            //calculate final answer and round up to 4 decimal places
            DecimalFormat df = new DecimalFormat("#.####");
            df.setRoundingMode(RoundingMode.CEILING);
            double answer = amount * conversionRate;

            return amount + " " + currencyFrom + " = " + df.format(answer) + " " + currencyTo;

        } //if currencies selected are same
        else if (currencyTo.equals(currencyFrom)) {
            return amount + " " + currencyFrom + " = " + amount + " " + currencyTo;
        }

        return "You did not select any currency";
    }

    //Loads up the GUI and performs some installation
    public static void GUILoader(HashMap<String, String> codes) {
        //instantiate GUI
        GUI gui = new GUI();
        gui.setVisible(true);

        //fullfills ComboBoxes with currencies
        gui.fillBoxes(codes);
    }

    public static void printMap(HashMap<String, String> map) {

        for (String name : map.keySet()) {
            String value = map.get(name);
            System.out.println(name + " " + value);

        }

    }

    /*    adds full currency name to HashMap's keys and returns it
     E.g: RUB ---> Russian Ruble (RUB) 
          AUD ---> Australian Dollar (AUD)
    */
    public static HashMap addCurrencyNames(HashMap<String, String> codes) {
        
        HashMap<String, String> modified = new HashMap();
        
        //set locale to ROOT (as default and suitable for all contries)
        Locale.setDefault(Locale.ROOT);
        
        for (String name : codes.keySet()) {
            String value = codes.get(name);
            
            //create Currency object for each key (Currency Code)
            Currency c = Currency.getInstance(name);
            
            //get full name of each Currency object by its Currency Code
            String newName = c.getDisplayName() + " (" + name + ")";
            modified.put(newName, value);
        }

        return modified;
    }
}
