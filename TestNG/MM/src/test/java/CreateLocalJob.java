import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateLocalJob {
    @FindBy (className = "title")
    List <WebElement> jobMenuDropdown ;
    @FindBy (xpath = "//a[contains(text(),'Create Job')]")
    WebElement clickCreateJobMenu ;
    @FindBy (id = "select2-customer_id-container")
    WebElement clickCustomerDropdown ;
    @FindBy (className = "select2-search__field")
    List<WebElement> searchCustomer ;
    @FindBy (xpath = "//li[contains(text(),'Aabir Client')]")
    WebElement selectCustomer;
    @FindBy (className="select2-selection__arrow")
    List<WebElement> selectJob_BranchType;
    @FindBy (xpath = "//li[contains(text(),'Long Distance')]")
    WebElement selectLDJob ;
    @FindBy (xpath = "//li[contains(text(),'Local Move')]")
    WebElement selectLocalJob ;
    @FindBy (xpath = "//li[contains(text(),'FL')]")
    WebElement selectBranchFl;
    @FindBy (xpath = "//button[contains(text(),'Create')]")
    WebElement createbtn ;
    @FindBy (id="select2-estimator-container")
    WebElement estimatorDropdown;
    //@FindBy (className="select2-selection__arrow")
//    List<WebElement> estimatorDropdown;
    @FindBy (className = "select2-results__option")
    List<WebElement> selectOption;
    @FindBy (id="save-job")
    WebElement SaveJobBtn ;
    @FindBy (className = "swal-button--confirm")
    WebElement confirmModal;

    WebDriver driver ;
    public CreateLocalJob (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void _createLocalJob() throws InterruptedException {

        jobMenuDropdown.get(2).click();
            Thread.sleep(3000);
                clickCreateJobMenu.click();
                    Thread.sleep(3000);
                        clickCustomerDropdown.click();
                            Thread.sleep(2000);
                                searchCustomer.get(1).sendKeys("Aabir Client");
                                    Thread.sleep(3000);
                                        selectCustomer.click();
                                            Thread.sleep(1000);
                                                selectJob_BranchType.get(13).click();
                                                    Thread.sleep(2000);
                                                        selectLocalJob.click();
                                                            Thread.sleep(1000);
                                                                selectJob_BranchType.get(14).click();
                                                                    Thread.sleep(2000);
                                                                        selectBranchFl.click();
                                                                            Thread.sleep(1000);
                                                                        createbtn.click();
                                                                    Thread.sleep(5000);
                                                                estimatorDropdown.click();
                                                            Thread.sleep(3000);
                                                        selectOption.get(6).click();
                                                    Thread.sleep(2000);
                                                SaveJobBtn.click();
                                            Thread.sleep(2000);
                                        confirmModal.click();
                                    Thread.sleep(2000);
    }
}

