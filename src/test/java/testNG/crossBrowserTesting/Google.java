package testNG.crossBrowserTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Google
{
    WebDriver driver;

    @Test
    @Parameters ( {"URL", "BrowserType"} )
    public void verifyTAU (String url, String browserType)
    {
        if (browserType.equalsIgnoreCase("Internet Explorer"))
        {
            driver = new InternetExplorerDriver ();
        }
        else if (browserType.equalsIgnoreCase("Edge"))
        {
            driver = new EdgeDriver();
        }
        else if (browserType.equalsIgnoreCase("Chrome"))
        {
            driver = new ChromeDriver ();
        }

        driver.manage().window().maximize();
        driver.get(url);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n" + "Open " + browserType);
        System.out.println("   " +  driver.getTitle());
        System.out.println("   " +  driver.findElement(By.xpath("//div[@class='k1zIA rSk4se']//*[name()='svg']")).getText());
        System.out.println("Close " + browserType + "\n");

        driver.quit();
    }



}









