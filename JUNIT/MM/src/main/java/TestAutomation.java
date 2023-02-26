import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;

public class TestAutomation {

    // Declaring ANSI_RESET so that we can reset the color
    public static final String ANSI_RESET = "\u001B[0m";
    // Declaring the color
    public static final String ANSI_Red = "\u001B[31m";
    public static final String ANSI_Green = "\u001B[32m";

    WebDriver driver;

    @Before

    public void setup() {
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");
        FirefoxOptions ops = new FirefoxOptions();
        ops.addArguments("--headed");
        driver = new FirefoxDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void EditCustomer() throws InterruptedException {
        driver.get("https://mm-dev.blubirdinteractive.org/login");
        driver.findElement(By.id("email")).sendKeys("harismashuk92@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.cssSelector("[type=submit]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        int emailSuffix = (int) (Math.random() * (1000 - 1) + 1);
        int nameSuffix = (int) (Math.random() * (100 - 1) + 1);
        int phoneNumber = (int) (Math.random() * (999999999 - 777777777) + 99000000);
        int id = 9;

        //Navigating to the ALL Customer menu
        List<WebElement> CreteCustomerMenudrop = driver.findElements(By.className("title"));
        CreteCustomerMenudrop.get(1).click();
        sleep(2000);
        WebElement AllCustomerMenu = driver.findElement(By.xpath("//a[contains(text(),'All Customers')]"));
        AllCustomerMenu.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(By.cssSelector("[type=search]")).sendKeys("devhasan447@gmailcom");
        Thread.sleep(4000);
        WebElement tableValue=  driver.findElement(By.xpath("//td[contains(text(),'devhasan447@gmailcom')]"));
        System.out.println(tableValue.getText());
    }

}