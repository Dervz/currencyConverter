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

public class CurrencyConverter {

    private static final String API_HOST = "https://api.fixer.io";

    public static void main(String[] args) throws Exception {

        String latest = CurrencyConverter.getJSON(API_HOST + "/latest");

        //get latest rates,base & date to print them out in the console
        Gson gson = new Gson();
        JSONParser json = gson.fromJson(latest, JSONParser.class);
        System.out.println("date = " + json.getDate() + " , base = " + json.getBase());

        //create HashMap to store rates after parsing
        HashMap<String, String> hm = new HashMap<>();
        hm = json.getRates();
        printMap(hm);

        //load GUI, passing the map to fullfil comboboxes with its keys
        GUI gui = new GUI(hm);
        gui.setVisible(true);

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

        if (currencyFrom != null && currencyTo != null) {
            String response = getJSON(API_HOST + "/latest?base=" + currencyFrom);
                
            //get the rates from JSON format
            Gson gson = new Gson();
            JSONParser json = gson.fromJson(response, JSONParser.class);
     
            //rate of the currency against base
            String rate = json.getRates().get(currencyTo);
            double conversionRate= Double.valueOf((rate != null)?rate:"0.0");
            
            //calculate final answer and round up to 4 decimal places
            DecimalFormat df = new DecimalFormat("#.####");
            df.setRoundingMode(RoundingMode.CEILING);
            double answer = amount * conversionRate;
             
            return amount + " " + currencyFrom + " = "  + df.format(answer) + " " + currencyTo  ;
            
        }

        return "You did not select any currency";
    }

    public static void printMap(HashMap<String, String> map) {
        for (String name : map.keySet()) {
            String value = map.get(name);
            System.out.println(name + " " + value);
        }

    }
}
