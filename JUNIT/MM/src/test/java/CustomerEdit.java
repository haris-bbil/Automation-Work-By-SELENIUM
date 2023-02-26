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

public class CustomerEdit {

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
        List<WebElement> Editbtn = driver.findElements(By.className("fa-pencil"));
        Editbtn.get(0).click();

        WebElement firstName= driver.findElement(By.id("first_name"));
        firstName.clear();
        firstName.sendKeys("Dev"+ nameSuffix);
        sleep(2000);

        WebElement lastName= driver.findElement(By.id("last_name"));
        lastName.clear();
        int nameSuffix2 = (int) (Math.random() * (100 - 1) + 1);
        lastName.sendKeys("Hasan"+nameSuffix2);
        sleep(2000);

        WebElement btnSaveCustomer = driver.findElement(By.id("save-customer"));

        WebElement primaryEmail= driver.findElement(By.name("primary_email"));
        primaryEmail.clear();
        primaryEmail.sendKeys("harismifta92@gmail.com");
        btnSaveCustomer.click();
        sleep(2000);
        driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']")).click();
        primaryEmail.clear();
        primaryEmail.sendKeys("devhasan" +emailSuffix+"@gmail.com");
        String primaryEmailValue= primaryEmail.getText();
        sleep(2000);

        WebElement secondaryEmail1= driver.findElement(By.id("secondary_email_one"));
        secondaryEmail1.clear();
        int emailSuffix2= (int)(Math.random()*(1000-1)+1);
        secondaryEmail1.sendKeys("devhasan" +emailSuffix2+"@gmail.com");
        sleep(2000);

        WebElement secondaryEmail2=  driver.findElement(By.id("secondary_email_two"));
        secondaryEmail2.clear();
        int emailSuffix3= (int)(Math.random()*(1000-1)+1);
        secondaryEmail2.sendKeys("devhasan" +emailSuffix3+"@gmail.com");

        long cellPhone= 9876534678L;
        WebElement cellPhoneField = driver.findElement(By.name("cell_phone"));
        cellPhoneField.clear();
        cellPhoneField.click();
        Thread.sleep(1000);
        cellPhoneField.sendKeys(""+cellPhone);
        btnSaveCustomer.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']")).click();
        Thread.sleep(2000);
        cellPhoneField.clear();
        cellPhoneField.click();
        cellPhoneField.sendKeys(id+""+phoneNumber);
        Thread.sleep(2000);
        String cellPhoneNumber = cellPhoneField.getText();
        System.out.println(cellPhoneNumber);
        Thread.sleep(1000);

        int phonenumber2= (int)(Math.random()*(999999999-777777777)+99000000);
        WebElement homePhone= driver.findElement(By.name("home_phone"));
        homePhone.click();
        homePhone.clear();
        homePhone.click();
        homePhone.sendKeys(id+""+phonenumber2);
        sleep(1000);

        WebElement workPhone= driver.findElement(By.name("work_phone"));
        workPhone.click();
        workPhone.clear();
        workPhone.click();
        int phonenumber3= (int)(Math.random()*(999999999-777777777)+99000000);
        workPhone.sendKeys(id+""+phonenumber3);
        sleep(1000);

        WebElement cellPhone2= driver.findElement(By.name("cell_phone_two"));
        cellPhone2.clear();
        cellPhone2.click();
        int phonenumber4= (int)(Math.random()*(999999999-777777777)+99000000);
        cellPhone2.sendKeys(id+""+phonenumber4);

        btnSaveCustomer.click();
        Thread.sleep(7000);

        driver.navigate().to("https://mm-dev.blubirdinteractive.org/customers");
        Thread.sleep(4000);

//        WebElement tableValue= driver.findElement(By.xpath("//td[contains(text(),'devhasan447@gmail.com')]"));
//        String tableValueContain= tableValue.getText();
        List <WebElement> tableEmailname= driver.findElements(By.tagName("td"));
        String tableEmailContains = tableEmailname.get(3).getText();
        String tableCellphone= tableEmailname.get(4).getText();
        System.out.println(tableEmailContains);

        WebElement searchfield=  driver.findElement(By.cssSelector("[type=search]"));
        searchfield.click();
        searchfield.sendKeys(""+tableEmailContains);
        Thread.sleep(4000);
        searchfield.clear();
        searchfield.sendKeys(""+tableCellphone);
        Thread.sleep(4000);

    }
}