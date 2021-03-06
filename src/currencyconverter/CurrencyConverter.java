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
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.TreeMap;

public class CurrencyConverter {

    private static final String API_FIXER = "https://api.fixer.io";

    public static void main(String[] args) throws Exception {

        String latest = CurrencyConverter.getJSON(API_FIXER + "/latest");

        //get latest rates,base & date and print them out in the console
        Gson gson = new Gson();
        JSONParser json = gson.fromJson(latest, JSONParser.class);
        System.out.println("date = " + json.getDate() + " , base = " + json.getBase());

        //store rates returned by Fixer.io/latest and add full Currency Names
        TreeMap<String, String> codes = addCurrencyNames(json.getRates());
        printMap(codes);

        //load GUI, passing the map to fullfil comboboxes with its keys
        GUILoader(codes);

    }
    

    //gets JSON message from the API endpoint provided as String in args
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
    

    //Converts between 2 currencies and returns the answer.
    public static String convert(String currencyFrom, String currencyTo, Double amount) throws Exception {

        //if Strings provided are null 
        if (currencyFrom.equals("") || currencyTo.equals("")) {
            return "You did not select any currency";
        }

        //if selected currencies are not the same
        if (!currencyTo.equals(currencyFrom)) {

            //record time for API respond (should be implimented inside this method , cant isolate)
            long startTime = System.nanoTime();
            String response = getJSON(API_FIXER + "/latest?base=" + currencyFrom);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000;
            System.out.println("API responded in " + duration + " ms ");

            //get the rates from API in JSON format
            Gson gson = new Gson();
            JSONParser json = gson.fromJson(response, JSONParser.class);

            //rate of the currencyTo against currencyFrom
            String rate = json.getRates().get(currencyTo);
            double conversionRate = Double.valueOf((rate != null) ? rate : "0.0");

            //calculate final answer and round up to 4 decimal places
            DecimalFormat df = new DecimalFormat("#.####");
            df.setRoundingMode(RoundingMode.CEILING);
            double answer = amount * conversionRate;

            return amount + " " + currencyFrom + " = " + df.format(answer) + " " + currencyTo + "*1 " + currencyFrom + " = " + df.format(conversionRate) + " " + currencyTo;

        } //if currencies selected are the same
        else if (currencyTo.equals(currencyFrom)) {
            return amount + " " + currencyFrom + " = " + amount + " " + currencyTo + "*1 " + currencyFrom + " = " + "1" + " " + currencyTo;
        }
        return "You did not select any currency";
    }
    

    //Loads up the GUI 
    public static void GUILoader(TreeMap<String, String> codes) {
        GUI gui = new GUI();
        gui.setVisible(true);
        gui.fillBoxes(codes);
    }

    
    //Adds full currency name to TreeMap's keys and returns it
    public static TreeMap addCurrencyNames(HashMap<String, String> codes) {
        TreeMap<String, String> modified = new TreeMap();
        Locale.setDefault(Locale.ROOT);

        /*E.g: RUB ---> Russian Ruble (RUB) 
                AUD ---> Australian Dollar (AUD)
         */
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
    

    public static void printMap(TreeMap<String, String> map) {

        for (String name : map.keySet()) {
            String value = map.get(name);
            System.out.println(name + " " + value);

        }

    }

}
