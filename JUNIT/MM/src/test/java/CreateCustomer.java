import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;

public class CreateCustomer {

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
    public void loginSys() throws InterruptedException {
        driver.get("https://mm-dev.blubirdinteractive.org/login");
        driver.findElement(By.id("email")).sendKeys("harismashuk92@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.cssSelector("[type=submit]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        int emailSuffix= (int)(Math.random()*(1000-1)+1);
        int nameSuffix = (int)(Math.random()*(100-1)+1);
        int phonenumber= (int)(Math.random()*(999999999-777777777)+99000000);
        int id= 9;

//Navigating to the Create Customer menu
        List<WebElement> CreteCustomerMenudrop = driver.findElements(By.className("title"));
        CreteCustomerMenudrop.get(1).click();
        sleep(2000);
        WebElement CreteCustomerMenu = driver.findElement(By.xpath("//a[contains(text(),'Create Customer')]"));
        CreteCustomerMenu.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//Test Case -1: Check Required field validations
        WebElement btnSaveCustomer = driver.findElement(By.id("save-customer"));
        btnSaveCustomer.click();
        WebElement branchValidation = driver.findElement(By.id("branch_id-error"));
        WebElement firstNameValidation = driver.findElement(By.id("first_name-error"));
        System.out.println(branchValidation.getText());
        System.out.println(firstNameValidation.getText());

        if (branchValidation.isDisplayed() && firstNameValidation.isDisplayed()) {
            System.out.println(ANSI_Green + "Test Case 1 is Passed" + ANSI_Green);
        } else {
            System.out.println(ANSI_Red + "Required Field validation is not available" + ANSI_RESET);
        }
        sleep(2000);

//Test Case 2: Check Duplicate Email & Phonenumber
        long cellPhone= 9876534678L;
        Select options = new Select(driver.findElement(By.id("branch_id")));
        options.selectByValue("1");
        //options.selectByIndex(2);
        //options.selectByVisibleText("MD");
        driver.findElement(By.id("first_name")).sendKeys("Dev");
        sleep(2000);
        driver.findElement(By.id("last_name")).sendKeys("Hasan"+nameSuffix);
        sleep(2000);
        driver.findElement(By.id("company")).sendKeys("Blubird");
        sleep(2000);
        WebElement zipCode = driver.findElement(By.id("zip_code"));
        zipCode.sendKeys("95108");
        sleep(4000);
        Select DwellingType = new Select(driver.findElement(By.id("dwelling")));
        DwellingType.selectByValue("4");
        sleep(2000);
        driver.findElement(By.id("address")).sendKeys("1781, De Marietta Avenue, Gardner, San Jose, Santa Clara County");
        WebElement cellPhoneField = driver.findElement(By.name("cell_phone"));
        cellPhoneField.click();
        Thread.sleep(1000);
        cellPhoneField.sendKeys(""+cellPhone);
        Thread.sleep(1000);
        WebElement primaryEmail= driver.findElement(By.name("primary_email"));
        primaryEmail.sendKeys("harismifta92@gmail.com");
        btnSaveCustomer.click();
        if(driver.findElement(By.className("swal-modal")).isEnabled()){
            sleep(3000);
            System.out.println(ANSI_Green + "Test Case 2 is Passed" + ANSI_Green);
        } else {
            System.out.println(ANSI_Red + "Required Field validation is not available" + ANSI_RESET);
        }
        sleep(1000);

 //Test Case-3: Create new Customer
        driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']")).click();
        primaryEmail.clear();
        sleep(2000);
        cellPhoneField.clear();
        sleep(2000);
        primaryEmail.sendKeys("devhasan"+emailSuffix+"@gmailcom");
        int emailSuffix2= (int)(Math.random()*(1000-1)+1);
        driver.findElement(By.id("secondary_email_one")).sendKeys("devhasan" +emailSuffix2+"@gmailcom");
        int emailSuffix3= (int)(Math.random()*(1000-1)+1);
        driver.findElement(By.id("secondary_email_two")).sendKeys("devhasan" +emailSuffix3+"@gmailcom");
        sleep(2000);
        cellPhoneField.click();
        cellPhoneField.sendKeys(id+""+phonenumber);
        int phonenumber2= (int)(Math.random()*(999999999-777777777)+99000000);
        WebElement homePhone= driver.findElement(By.name("home_phone"));
        homePhone.click();
        homePhone.sendKeys(id+""+phonenumber2);
        sleep(1000);
        int phonenumber3= (int)(Math.random()*(999999999-777777777)+99000000);
        WebElement workPhone= driver.findElement(By.name("work_phone"));
        workPhone.click();
        workPhone.sendKeys(id+""+phonenumber3);
        sleep(1000);
        int phonenumber4= (int)(Math.random()*(999999999-777777777)+99000000);
        WebElement cellPhone2= driver.findElement(By.name("cell_phone_two"));
        cellPhone2.click();
        cellPhone2.sendKeys(id+""+phonenumber4);
        sleep(2000);
        driver.findElement(By.id("notes")).sendKeys("This is a Test Customer");
        driver.findElement(By.id("email_list")).click();
        sleep(1000);
        driver.findElement(By.id("mail_list")).click();
        sleep(1000);
        driver.findElement(By.id("is_unsubscribed")).click();
        sleep(1000);
        driver.findElement(By.id("no_mailing_lists")).click();
        sleep(1000);
        driver.findElement(By.id("donot_send_review")).click();
        sleep(1000);
        driver.findElement(By.id("commercial_client")).click();
        sleep(1000);
        driver.findElement(By.id("claim")).click();
        sleep(1000);
        Select evaluation= new Select(driver.findElement(By.id("evaluation")));
        evaluation.selectByValue("3");
        sleep(1000);
        WebElement anniversary= driver.findElement(By.id("anniversary"));
        anniversary.clear();
        anniversary.sendKeys("10/25/2010");
        sleep(1000);
        btnSaveCustomer.click();
        WebElement successMessage= driver.findElement(By.xpath("//div[@class='swal-modal']"));
        if(successMessage.isEnabled()){
            System.out.println(ANSI_Green + "Test Case 3 is Passed" + ANSI_Green);
        }
        else {
            System.out.println(ANSI_Red + "Test Case 3 is Failed" + ANSI_RESET);
        }
    }

    @After
    public void closeDriver () {
        //driver.close();
        // driver.quit();
    }
}
