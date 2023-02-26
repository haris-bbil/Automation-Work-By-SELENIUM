import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class Login {
    @FindBy(id = "email")
    WebElement emailfld;
    @FindBy(id="password")
    WebElement passwordfld;
    @FindBy(css="[type= submit]")
    WebElement submitbtn;

    @FindBy(className = "page-breadcrumb")
    WebElement dashboardtxt;


    int emailSuffix= (int)(Math.random()*(1000-1)+1);
    int nameSuffix = (int)(Math.random()*(100-1)+1);
    int phonenumber= (int)(Math.random()*(999999999-777777777)+99000000);
    int id= 9;
    WebDriver driver;

    public Login (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public String dologin (){
        emailfld.sendKeys("admin@movingwithclass.com");
        passwordfld.sendKeys("Florida$#2023");
        submitbtn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return dashboardtxt.getText();
    }
}
