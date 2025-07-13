package testNG.dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrangeHRM
{
    WebDriver driver;

    @Test (dataProviderClass = SignInDP.class, dataProvider = "signin-provider")
    public void signIn (String usename, String password, boolean success)
    {
        driver = new ChromeDriver ();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        driver.findElement(By.name("username")).sendKeys(usename);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        System.out.println("Sign In Credentials: " + "\n" +
                "  Username = " + usename + "\n" +
                "  Password = " + password + "\n" +
                "  Successful Sign In = " + success + "\n" );
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
        String actualResult = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
        String expectedResult = "Dashboard";
        Assert.assertEquals(actualResult, expectedResult, "The Actual & Expected Results Do Not Match");

        driver.quit();
    }
}
