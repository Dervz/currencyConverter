package testCasesJUNIT;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class testResponseCodeForInvalidURL {

    /*checks that establishing HttpURLConnection to the INVALID link 
      returns response code of 404
     */
    @Test
    public void checkResponseCode404() throws IOException {

        String fixerAPI_URL = "https://api.fixer.io/notLatest";

        //Given
        URL url = new URL(fixerAPI_URL);

        //Execute
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        int responseCode = con.getResponseCode();

        //Verify
        assertEquals(404, responseCode);

    }
}
