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

    //private static final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {

        CurrencyConverter http = new CurrencyConverter();

        String latestUrl = "https://api.fixer.io/latest";
        String latest = CurrencyConverter.getJSON(latestUrl);
        
        Gson gson = new Gson();
        JSONParser json = gson.fromJson(latest, JSONParser.class);

        GUI.loadGUI();
        
        
        
//        HashMap<String, String> hm = new HashMap<>();
//        System.out.println(json.getDate());
//        System.out.println(json.getBase());
//        hm = json.getRates();
//
//        for (String name : hm.keySet()) {
//            String value = hm.get(name);
//            System.out.println(name + " " + value);
//        }

    }

    public static String getJSON(String uri) throws MalformedURLException, IOException {

        //Create instance of the URL, MalformedURLException is caught
        URL url = new URL(uri);

        //establish connection, IOException thrown
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");
        //con.setRequestProperty("User-Agent", USER_AGENT);

        System.out.println("\nGET request to : " + uri + "\nResponse code : " + con.getResponseCode());

        Scanner scan = new Scanner(con.getInputStream());
        String response = scan.next();

        return response;
    }

}
