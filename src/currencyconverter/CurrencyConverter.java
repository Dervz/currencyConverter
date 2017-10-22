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

    private static final String API_FIXER = "https://api.fixer.io";

    public static void main(String[] args) throws Exception {

        String latest = CurrencyConverter.getJSON(API_FIXER + "/latest");

        //get latest rates,base & date and print them out in the console
        Gson gson = new Gson();
        JSONParser json = gson.fromJson(latest, JSONParser.class);
        System.out.println("date = " + json.getDate() + " , base = " + json.getBase());

        //store rates returned by Fixer.io/latest 
        HashMap<String, String> codes = json.getRates(); 
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

        if (currencyFrom != null && currencyTo != null && !currencyTo.equals(currencyFrom)) {
            String response = getJSON(API_FIXER + "/latest?base=" + currencyFrom);
                
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
             
            return amount + " " + currencyFrom + " = "  + df.format(answer) + " " + currencyTo;
            
        }
        
        else if(currencyTo.equals(currencyFrom)) return amount + " " + currencyFrom + " = "  + amount + " " + currencyTo;

        return "You did not select any currency";
    }
    
    //Loads up the GUI and performs some installation
    public static void GUILoader (HashMap<String, String> codes){
     GUI gui = new GUI();
        gui.setVisible(true);
        gui.fillBoxes(codes);
    }

    public static void printMap(HashMap<String, String> map) {
        for (String name : map.keySet()) {
            String value = map.get(name);
            System.out.println(name + " " + value);
        }

    }
}
