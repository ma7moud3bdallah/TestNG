package testNG.assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testNG.Highlighter;

import java.time.Duration;


public class VerifySignIn_SA
{
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void setUp ()
    {
        driver = new ChromeDriver ();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/");
        System.out.println("1. Open Chrome & Application");
    }

    @Test
    public void signIn ()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        WebElement textUsername = driver.findElement(By.name("username"));
        Highlighter.highlightElement(driver, textUsername);
        textUsername.sendKeys("Admin");

        WebElement textPassword = driver.findElement(By.name("password"));
        Highlighter.highlightElement(driver, textPassword);
        textPassword.sendKeys("admin123");

        WebElement buttonLogin = driver.findElement(By.xpath("//button[@type='submit']"));
        Highlighter.highlightElement(driver, buttonLogin);
        buttonLogin.click();

        System.out.println("2. Sign In");
    }

    @Test
    public void testHomePageVerification ()
    {

        softAssert.assertEquals(true, false, "The Welcome Link Is Not Correct On The Home Page");
        System.out.println("3. Verify Welcome Link");

        softAssert.assertFalse(false, "The Admin Tab Is Not Displayed On The Home Page");
        System.out.println("4. Verify Admin Tab");
        softAssert.assertTrue(false, "The Dashboard Is Not Correct On The Home Page");
        System.out.println("5. Verify Dashboard");
        softAssert.assertAll();


    }

    @Test
    public void userSearch ()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='oxd-main-menu-item'])[1]")));
        WebElement menuAdmin = driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[1]"));
        Highlighter.highlightElement(driver, menuAdmin);
        menuAdmin.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")));
        WebElement textUserName = driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']"));
        Highlighter.highlightElement(driver, textUserName);
        textUserName.sendKeys("Admin");

        WebElement buttonSearch = driver.findElement(By.xpath("//button[normalize-space()='Search']"));
        Highlighter.highlightElement(driver, buttonSearch);
        buttonSearch.click();

        System.out.println("6. Search For User");
    }

    @Test
    public void userSignOut ()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='profile picture']")));

        WebElement linkWelcome = driver.findElement(By.xpath("//img[@alt='profile picture']"));
        Highlighter.highlightElement(driver, linkWelcome);
        linkWelcome.click();

        WebElement linkLogout = driver.findElement(By.xpath("//a[normalize-space()='Logout']"));
        Highlighter.highlightElement(driver, linkLogout);
        linkLogout.click();

        System.out.println("7. Sign Out");
    }

    @AfterClass
    public void tearDown ()
    {
        System.out.println("8. Close Chrome & Application");
        driver.quit();
    }
}
