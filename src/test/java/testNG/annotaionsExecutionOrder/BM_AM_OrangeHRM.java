package testNG.annotaionsExecutionOrder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;


public class BM_AM_OrangeHRM
{
    WebDriver driver;

    @BeforeClass
    public void setUp ()
    {
        driver = new ChromeDriver ();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        System.out.println("1. Open Chrome & Application");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

    @Test
    public void signIn ()
    {
        WebElement textUsername = driver.findElement(By.name("username"));
        textUsername.sendKeys("Admin");

        WebElement textPassword = driver.findElement(By.name("password"));
        textPassword.sendKeys("admin123");

        WebElement buttonLogin = driver.findElement(By.xpath("//button[text()=' Login ']"));

        buttonLogin.click();

        System.out.println("2. Sign In");
    }

    @Test
    public void userSearch ()
    {
        WebElement menuAdmin = driver.findElement(By.xpath("//span[text()='Admin']"));
        menuAdmin.click();

        WebElement textUserName = driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
        textUserName.sendKeys("Admin");

        WebElement buttonSearch = driver.findElement(By.cssSelector("button[type='submit']"));
        buttonSearch.click();

        System.out.println("3. Search For User");
    }

    @Test
    public void userSignOut ()
    {
        WebElement linkWelcome = driver.findElement(By.xpath("//img[@alt='profile picture']"));

        linkWelcome.click();

        WebElement linkLogout = driver.findElement(By.xpath("//a[normalize-space()='Logout']"));

        linkLogout.click();

        System.out.println("4. Sign Out");
    }

    @AfterClass
    public void tearDown ()
    {
        System.out.println("5. Close Chrome & Application");
        driver.quit();
    }
}