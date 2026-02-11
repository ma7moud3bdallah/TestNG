package testNG.dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogIn1
{

    @Test (dataProvider = "logInDataCSV")
    public void logIn (String email, String password, boolean success)
    {
        System.out.println("Log In Credentials: " + "\n" +
                "  Email = " + email + "\n" +
                "  Password = " + password + "\n" +
                "  Successful Log In = " + success + "\n" );
    }

    @DataProvider
    public Object [] [] logInData ()
    {
        Object [] [] data = new Object [3] [3];

        data [0] [0] = "TestNG@Framework.com";		data [0] [1] = "TestNG1234";		data [0] [2] = true;
        data [1] [0] = "Joe@Doe.com";				data [1] [1] = "DoeDoe34";			data [1] [2] = false;
        data [2] [0] = "Test@Test.com";		        data [2] [1] = "Test1234";			data [2] [2] = false;

        return data;
    }
    @DataProvider
    public Object[][] logInDataCSV(){
        String filePath = "resources/DP.csv";
        List<Object[]> dataList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                String email = values[0];
                String password = values[1];
                boolean expectedResult = Boolean.parseBoolean(values[2]);
                dataList.add(new Object[]{email, password, expectedResult});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList.toArray(new Object[0][0]);
    }
}
