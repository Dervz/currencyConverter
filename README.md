# Currency Converter 
<b>NOTE: when you run project, IF YOU GET THE ERROR please add jar path by</b>
Rght click on project name --> properties ---> Libraries ---> Add jar/folder ---> Choose gson-2.6.2.jar located in the project repo. 
This is the reported bug https://netbeans.org/bugzilla/show_bug.cgi?id=54450 which happens rarely.

## 🔵 Overview
- "Currency Converter" is a Java program designed to perform convertions between two currencies. 
- It uses API from http://fixer.io to retrieve currency rates. 
    - fixer.io updates rates daily around 4 PM.
    - returns JSON messages as response.


## 🔵 Aims

<b>1) Develop correctly functioning currency converter:</b>
  - Gives correct answer which is based on the retrieved rates.
  - Must be **similar to _Gooogle currency converter_ as much as possible**.
  - Retrieves rates from the provided API http://fixer.io.

<b>2) Demonstrate the ability of writing "clean code":</b>
  - By using encapsulation and methods isolation. I.e methods should perform **one distinct** task each.
  - By commenting when appropriate in order to make code easy to read.
  - By structuring methods and classes in the most logical way.
  
<b>3) Demonstrate the ability of developing JUNIT tests:</b>
  - Each test is unique and checks one particular feature or method functionality.
  - Several tests must be developed in order to achieve high code test coverge.
  - All the tests must be run at once by grouping them together in the test suite.
  
<b>4) Demonstrate the ability of using Git:</b>
  - Commits should be performed regularly so code never gets lost.
  - Commits are aided with comments when appropriate.
  
  
### 🔵 I/O

- Inputs provided by the user:
    - Amount to convert.
    - Base currency which is being converted **from**.
    - Targeted currency to convert **to**.
  
- Outputs provided by the app:
    - Answer based on present rates provided by the API.
    - Equation in the form of **" 1 currencyFrom = n currencyTo "**.

### 🔵 Implementation
- <b> Library used </b>
  - GSON library https://github.com/google/gson
  - GSON jar https://repo1.maven.org/maven2/com/google/code/gson/gson/2.6.2/
  - **In this project GSON is used to convert a JSON string to an equivalent Java object.**

_Classes of the project:_

<b>1) CurrencyConverter.java</b>
  - Performs all the logic of the program.
  - Connects to the API.
  - Retrieves JSON messages fro the API.
  - Calls JSONparser.java to parse JSON message.
  - Instantiates GUI.
  - Converts between two selected currencies based on the amount entered.

<b>2) JSONParser.java</b>
  - Defines the structure of JSON message returned by the API.
  - Allows to convert _JSON message to the Java objects:_
    - _String date_ which represents the date of the currency rates.
    - _String base_ which represents the base against which currencies are rated.
    - _HashMap<String, String> rates_ which contains key/value pairs which represent currency name and currency rate respectively.
  
<b>3) GUI.java</b>
  - Defines the structure and design of the GUI.
  - Contains auto-generated code by the _swing framework_.
  - Gets the input from the user, passes it to the CurrencyConverter.java to perform calculations
  - Gets output from the CurrencyConverter.java, prints it to the user


### 🔵 Testing
JUNIT4 testing is implemented in this project. All of the tests can be run at once by running JUNIT4TestSuite.java suite.
In total there are 8 tests which aim to test the functionality of the methods in CurrencyConverter.java and JSONParser.java. GUI class is not tested in this project since 80% of the code is auto generated and the rest 20% are used to perform trivial operations. 

<b> Tests developed: </b>
  1) _testResponseCodeForValidURL_ checks that establishing HttpURLConnection to the _CORRECT link 
      returns response code of 200._
  2) _testResponseCodeForInvalidURL_ checks that establishing HttpURLConnection to the _INVALID link 
      returns response code of 404._
  3) _testExceptionForWrongURL_ checks if invalid link is provided such as 
    "badURL" then CurrencyConverter.getJSON(String uri) _will throw MalformedURLException._
  4) _testResponseMessageJSON_ checks that JSON message returned from API _contains correct currency codes._
  5) _testReturnOfConvertMethod_ checks if invalid arguments are provided to CurrencyConverter.convert(String cur1, String cur2, Double amount) method, _then it returns "You did not select any currency" message._
  6) _testAddingCurrencyFullNames_ checks workability of method "addCurrencyNames" which
      _appends full name of the currency depending on its
      currency code
      - RUB ---> Russian Ruble (RUB) 
      - AUD ---> Australian Dollar (AUD)
  7) _testConvertMethodValidity_ checks THREE custom conversions performed by the convert method.
      Also checks that answer is given to precisely 4 decimal places.
      Finally, checks that if both provided currencies are same, result 
      returned is the AMOUNT entered to convert.
  8) _JSONParserTest_ checks that JSONParser class works as intended. 
      i.e upon supplying String as a JSON response, 
      _it has to parse date, base and HashMap <String, Stirng> rates._


### 🔵 Conclusion and problems
The only problem which might be faced when running the project is poor response time from the API.
After testing at 3 different periods during the day it was found that average response time from the API is 60 ms (CurrencyConveter.convert(str, str, double) method outputs the reponse time from the API each time it is called). However, in the ONE testing showed that API's host had some connection problems and response times raised up to 2000ms. It lasted for 15 minutes and then stabilized back. 



