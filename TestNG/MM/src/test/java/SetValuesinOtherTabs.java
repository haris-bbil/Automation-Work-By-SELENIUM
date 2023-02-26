import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SetValuesinOtherTabs {

@FindBy (className = "select2-results__option")
    List<WebElement> selectOption;
@FindBy (id="save-job")
    WebElement SaveJobBtn ;
@FindBy (className = "swal-button--confirm")
    WebElement confirmModal;

    @FindBy(css="[data-tab-key=notes]")
    WebElement notesTab;
    @FindBy (xpath="//li[@data-handle='job-form-tab']//a[contains(text(),'Flat Fees')]")
    WebElement FlatFeesTab;
    @FindBy (css= "[data-tab-key=item_list]")
    WebElement itemlistTab;
    @FindBy (css= "[data-tab-key=tarrif")
    WebElement tarrifTab;
    @FindBy (css="[data-tab-key=pack_boxes]")
    WebElement PackBoxesTab;
    @FindBy (css= "[data-tab-key=materials]")
    WebElement materialsTab;
    @FindBy (css= "[data-tab-key=movers]")
    WebElement moversTab;
    @FindBy (css= "[data-tab-key=documents]")
    WebElement documentsTab;
    @FindBy (css= "[data-tab-key=payments]")
    WebElement paymentsTab;

    @FindBy (name = "flat_fee_id")
    WebElement flatfeesDropdown;
    @FindBy(name = "flat_fee_quantity")
    WebElement flatFeesQuantity;
    @FindBy (name = "flat_fee_comments")
    WebElement flatFeesComment ;

    WebDriver driver ;
    public SetValuesinOtherTabs (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void _setValuesinTabs() throws InterruptedException {

        FlatFeesTab.click();
        Thread.sleep(2000);
        Select optionsFlatFees= new Select(flatfeesDropdown);
        optionsFlatFees.selectByVisibleText("Additional Coverage");
        Thread.sleep(2000);
        flatFeesQuantity.sendKeys("5");
        Thread.sleep(2000);
        flatFeesComment.sendKeys("abc def ghi jkl mno pqrs tuv wxyz ABC DEF GHI JKL MNO PQRS TUV WXYZ ! \"§ $%& /() =? * '<> |;");

    }

}
