package testCasesJUNIT;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
            testCasesJUNIT.testResponseCodeForValidURL.class,
             testCasesJUNIT.testExceptionForWrongURL.class,
             testCasesJUNIT.testResponseCodeForInvalidURL.class,
             testCasesJUNIT.testResponseMessageJSON.class,
             testCasesJUNIT.testReturnOfConvertMethod.class,
             testCasesJUNIT.testConvertMethodValidity.class,
             testCasesJUNIT.testAddingCurrencyFullNames.class,
             testCasesJUNIT.testJSONParser.class
                     
        })
public class JUNIT4TestSuite {

}
