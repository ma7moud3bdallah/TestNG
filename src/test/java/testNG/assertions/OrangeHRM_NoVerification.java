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
import testNG.Highlighter;

import java.time.Duration;

public class OrangeHRM_NoVerification
{
    WebDriver driver;

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
        WebElement textUsername = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        Highlighter.highlightElement(driver, textUsername);
        textUsername.sendKeys("Admin");

        WebElement textPassword = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        Highlighter.highlightElement(driver, textPassword);
        textPassword.sendKeys("admin123");

        WebElement buttonLogin = driver.findElement(By.xpath("//button[@type='submit']"));
        Highlighter.highlightElement(driver, buttonLogin);
        buttonLogin.click();

        System.out.println("2. Sign In");
    }

    @Test
    public void userSearch ()
    {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='oxd-main-menu-item'])[1]")));
//        WebElement menuAdmin = driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[1]"));
//        Highlighter.highlightElement(driver, menuAdmin);
//        menuAdmin.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")));
//        WebElement textUserName = driver.findElement(By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']"));
//        Highlighter.highlightElement(driver, textUserName);
//        textUserName.sendKeys("Admin");
//
//        WebElement buttonSearch = driver.findElement(By.xpath("//button[normalize-space()='Search']"));
//        Highlighter.highlightElement(driver, buttonSearch);
//        buttonSearch.click();
//
//        System.out.println("3. Search For User");
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

        System.out.println("4. Sign Out");
    }

    @AfterClass
    public void tearDown ()
    {
        System.out.println("5. Close Chrome & Application");
        driver.quit();
    }
}
