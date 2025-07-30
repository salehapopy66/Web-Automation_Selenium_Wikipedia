package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {

    @DataProvider(name = "invalidUserCredentials")
    public static Object[][] invalidCredentials(){

        Object[][] data = {
                {"username","automation@321","Incorrect username or password entered. Please try again."},
                {"Automation123456","password","Incorrect username or password entered. Please try again."},
                {"username","password","Incorrect username or password entered. Please try again."}
        };
        return data;

    }
}
