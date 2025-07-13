package testNG.dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogIn2
{
    WebDriver driver;

    @Test (dataProvider = "login-provider")
    public void logIn (String email, String password, boolean success)  {
        driver = new ChromeDriver ();
        driver.manage().window().maximize();

        driver.get("http://www.automationpractice.pl/index.php");
        driver.findElement(By.className("login")).click();

        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("SubmitLogin")).click();

        System.out.println("Log In Credentials: " + "\n" +
                "  Email = " + email + "\n" +
                "  Password = " + password + "\n" +
                "  Successful Log In = " + success + "\n" );


        String actualResult = driver.findElement(By.className("logout")).getText();
        String expectedResult = "Sign out";
        Assert.assertEquals(actualResult, expectedResult, "The Actual & Expected Results Do Not Match");

        driver.quit();
    }

    @DataProvider (name = "login-provider")
    public Object [] [] logInData ()
    {
        Object [] [] data = new Object [3] [3];

        data [0] [0] = "TestNG@Framework.com";		data [0] [1] = "TestNG1234";		data [0] [2] = true;
        data [1] [0] = "Joe@Doe.com";				data [1] [1] = "DoeDoe34";			data [1] [2] = false;
        data [2] [0] = "ABC@Automation.com";		data [2] [1] = "ABC1234";			data [2] [2] = false;

        return data;
    }
}
