package testCasesJUNIT;

import com.google.gson.Gson;
import currencyconverter.JSONParser;
import org.junit.Test;

public class testJSONParser {

    /*checks that JSONParser class works as intended. 
      i.e upon supplying custom String as a JSON response, 
      it has to parse date, base and HashMap <<rates>> 
     */
    @Test
    public void JSONParserTest() {

        //Given
        String JSONresponse = "{\"base\":\"RandomBase\",\"date\":\"2222-1111-0000\",\"rates\":{\"AUD\":0.019595,\"BGN\":0.025457,\"BRL\":0.048834,\"CAD\":0.019218}}";

        //Execute
        Gson gson = new Gson();
        JSONParser json = gson.fromJson(JSONresponse, JSONParser.class);

        //Verify
        assert (json.getDate().equals("2222-1111-0000")
                && json.getBase().equals("RandomBase")
                && json.getRates().size() == 4);
    }
}
