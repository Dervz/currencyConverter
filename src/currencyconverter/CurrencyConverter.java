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

public class CurrencyConverter {

    

    public static void main(String[] args) throws Exception {

        String API_PROVIDER = "https://api.fixer.io";
        String latest = CurrencyConverter.getJSON(API_PROVIDER + "/latest");
        
        Gson gson = new Gson();
        JSONParser json = gson.fromJson(latest, JSONParser.class);
        System.out.println("date = " + json.getDate() + " , base = " + json.getBase());

        HashMap<String, String> hm = new HashMap<>();
        hm = json.getRates();
        printMap(hm);
   
        //load GUI, passing the map to fullfil comboboxes
        new GUI(hm).setVisible(true);

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

    
    public static void printMap(HashMap<String, String> map){
     for (String name : map.keySet()) {
            String value = map.get(name);
            System.out.println(name + " " + value);
        }
    
    }
}
