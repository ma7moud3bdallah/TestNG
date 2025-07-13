package testNG.dependencyTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import testNG.Highlighter;

import java.time.Duration;

public class DependsOnMethods_FAIL
{
    WebDriver driver;

    @Test
    public void test1_SetUpChrome ()
    {
        driver = new ChromeDriver ();
        driver.manage().window().maximize();

        System.out.println("1. Set Up Chrome");
    }

    @Test(dependsOnMethods = "test1_SetUpChrome")
    public void test2_OpenOrangeHRM ()
    {
        driver.get("https://opensource-demo.orangehrmlive1234.com/");

        Assert.assertEquals(false, true, "Could Not Access OrangeHRM");
        System.out.println("2. Open OrangeHRM");
    }

    @Test(dependsOnMethods = "test2_OpenOrangeHRM")
    public void test3_SignIn ()
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

    @Test(dependsOnMethods = "test3_SignIn")
    public void test4_SearchUser ()
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

        System.out.println("3. Search For User");
    }

    @Test (dependsOnMethods = { "test2_OpenOrangeHRM", "test3_SignIn" } )
    public void test5_SearchEmployee ()
    {
        WebElement menuPIM = driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[2]"));
        Highlighter.highlightElement(driver, menuPIM);
        menuPIM.click();

        WebElement buttonSearch = driver.findElement(By.xpath("//div[@class='oxd-grid-4 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//input[1]"));
        Highlighter.highlightElement(driver, buttonSearch);
        buttonSearch.click();

        System.out.println("5. Search For Employee");
    }

    @Test (dependsOnMethods = { "test2_OpenOrangeHRM", "test3_SignIn" } )
    public void test6_SearchCandidate ()
    {
        WebElement menuRecruitment = driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[4]"));
        Highlighter.highlightElement(driver, menuRecruitment);
        menuRecruitment.click();

        WebElement buttonSearch = driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]"));
        Highlighter.highlightElement(driver, buttonSearch);
        buttonSearch.click();

        System.out.println("6. Search For Candidate");
    }

    @Test (dependsOnMethods = { "test2_OpenOrangeHRM", "test3_SignIn" } )
    public void test7_SignOut ()
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
}