import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class LocalValuationProcess {

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

// Navigating to the Create jobs Menu
        List<WebElement> JobsMenudrop = driver.findElements(By.className("title"));
        JobsMenudrop.get(2).click();
        sleep(2000);
        WebElement CreateJobMenu = driver.findElement(By.xpath("//a[contains(text(),'Create Job')]"));
        CreateJobMenu.click();
        Thread.sleep(5000);

//Selecting Customer from Modal
        driver.findElement(By.id("select2-customer_id-container")).click();
        Thread.sleep(2000);
        List<WebElement> searchCustomer= driver.findElements(By.className("select2-search__field"));
        searchCustomer.get(1).click();
        searchCustomer.get(1).sendKeys("Akash");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[contains(text(),'Akash Client')]")).click();
        Thread.sleep(2000);

// Select Job Type & Branch Type from Modal
        List<WebElement> selectJobType = driver.findElements(By.className("select2-selection__arrow"));
        selectJobType.get(14).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[contains(text(),'Local Move')]")).click();
        Thread.sleep(2000);
        selectJobType.get(15).click();
        driver.findElement(By.xpath("//li[contains(text(),'FL')]")).click();

// Creating Jobs
        driver.findElement(By.xpath("//button[contains(text(),'Create')]")).click();
        Thread.sleep(8000);

//  Adding Move date, Weight and Distances
        WebElement moveDate = driver.findElement(By.id("move_date"));
        moveDate.sendKeys("11/03/2022");
        driver.findElement(By.id("weight")).sendKeys("1000");
        driver.findElement(By.id("distance")).sendKeys("2000");

// Navigating To the Flat Fees tab and Adding data
        driver.findElement(By.cssSelector("[data-tab-key=flat_fees]")).click();
        Thread.sleep(5000);

        Select optionsFlatFees = new Select(driver.findElement(By.name("flat_fee_id")));
        optionsFlatFees.selectByValue("64");
        driver.findElement(By.name("flat_fee_quantity")).sendKeys("10");
        Thread.sleep(2000);

// Navigating To the Pack Hourly tab and Adding data
        driver.findElement(By.cssSelector("[data-tab-key=pack_hourly]")).click();
        Thread.sleep(5000);
        Select optionPackBoxes = new Select(driver.findElement(By.name("pack_hourly_id")));
        optionPackBoxes.selectByValue("18");
        driver.findElement(By.name("packhourly_travel_time")).sendKeys("10");
        driver.findElement(By.name("packhourly_travel_time")).sendKeys("10");
        Select travelTime = new Select(driver.findElement(By.name("packhourly_travel_time")));
        travelTime.selectByValue("0.5");
        Thread.sleep(3000);

// Navigating To the Valuation tab, Adding data and check functionalities
        driver.findElement(By.cssSelector("[data-tab-key=valuations]")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("calculateLocalValuation")).click();
        Thread.sleep(2000);

        WebElement replacementValueField =   driver.findElement(By.name("local_replacement_value"));
        replacementValueField.click();
        replacementValueField.clear();
        replacementValueField.sendKeys("60000");
        Thread.sleep(2000);
        driver.findElement(By.id("calculate-coverage-table-local"));
        Thread.sleep(4000);
        List  <WebElement> radiobtnD = driver.findElements(By.name("local_deductible_value"));
        radiobtnD.get(3).click();
        Thread.sleep(4000);
        radiobtnD.get(3).click();
        Thread.sleep(4000);
        radiobtnD.get(1).click();
        Thread.sleep(4000);
        radiobtnD.get(1).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("[data-tab-key=payments]")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("[data-tab-key=valuations]")).click();
        Thread.sleep(5000);

        driver.findElement(By.id("summary-adjustment-percent")).clear();
        Thread.sleep(2000);
        driver.findElement(By.id("summary-adjustment-percent")).sendKeys("10");
        Thread.sleep(3000);

//Saving job & Checking the Payment according to the Summary
        driver.findElement(By.id("save-job")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[data-tab-key=payments]")).click();
        Thread.sleep(1000);


// Sending Quote
        driver.findElement(By.cssSelector("[data-tab-key=basic_form]")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("//button[contains(text(),'Quote')]")).click();
        WebElement ldQuote = driver.findElement(By.id("ld_item"));

// MouseHovering over the Send Quote Options
        Actions action= new Actions(driver);
        action.moveToElement(ldQuote).perform();
        driver.findElement(By.cssSelector("[data-quote-type=LOCAL_HOURLY]")).click();
        //driver.findElement(By.cssSelector("[data-quote-type=LD]")).click();
        Thread.sleep(5000);

//  Navigating to the Recently Created Job for Further actions
        driver.findElement(By.xpath("//span[contains(text(),'Jobs')]")).click();
        sleep(2000);
        WebElement AllJobMenu = driver.findElement(By.xpath("//a[contains(text(),'All Jobs')]"));
        AllJobMenu.click();
        Thread.sleep(5000);
        WebElement firstJobs= driver.findElement(By.className("sorting_1"));
        firstJobs.click();
        Thread.sleep(1000);
//  Navigating to the new tab of the browser
        ArrayList<String> jobsTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(jobsTab.get(1));
        Thread.sleep(5000);
    }
}
