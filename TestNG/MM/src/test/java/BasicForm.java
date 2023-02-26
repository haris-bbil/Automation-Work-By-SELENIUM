import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BasicForm {
 @FindBy (className = "select2-results__option")
    List<WebElement> selectOption;
@FindBy (id="save-job")
    WebElement SaveJobBtn ;
@FindBy (className = "swal-button--confirm")
    WebElement confirmModal;

    @FindBy (css= "[data-tab-key=basic_form]")
    WebElement basicFromTab;
    @FindBy (id = "entered_date")
    WebElement EnteredDatefld;
    @FindBy (id = "expires_date")
    WebElement ExpiresDatefld;
    @FindBy (id = "select2-status-container")
    WebElement StatusDropdown;
    @FindBy (id ="select2-est_method-container")
    WebElement ESTMethodDropdown ;
    @FindBy (id = "ose_date")
    WebElement OSEDatefld ;
    @FindBy (id = "source")
    WebElement SourceDropdown;
    @FindBy (id = "ose_time_start")
    WebElement OSETimeStart;
    @FindBy (id = "ose_time_end")
    WebElement OSETimeEnd ;
    @FindBy (id="select2-estimator-container")
    WebElement estimatorDropdown;
    @FindBy(id = "commercial_move")
    WebElement CommercialMoveCheck;

    @FindBy (id = "move_date")
    WebElement MoveDatefld;
    @FindBy (id = "move_time")
    WebElement MoveTimefld;
    @FindBy (id = "move_load_from")
    WebElement LoadFromDatefld;
    @FindBy (id = "move_load_to")
    WebElement LoadToDatefld;
    @FindBy (id = "packing_date")
    WebElement PackingDatefld;
    @FindBy (id = "packing_time")
    WebElement PackingTimefld;
    @FindBy (id = "unpacking_date")
    WebElement UnpackingDatefld;
    @FindBy (id = "box_delivery")
    WebElement BoxDeliveryDatefld;
    @FindBy (id = "delivery_from")
    WebElement DeliveryFromDatefld;
    @FindBy (id = "delivery_to")
    WebElement DeliveryToDatefld;
    @FindBy (id = "actual_delivery_date")
    WebElement ActualDeliveryDatefld;
    @FindBy (id = "delivery_time")
    WebElement ActualDeliveryTimefld;
    @FindBy (id = "booked_date")
    WebElement BookedDatefld;

    @FindBy (id = "from_address")
    WebElement FromAdress;
    @FindBy (id = "to_address")
    WebElement ToAddress;
    @FindBy (id = "from_address_2")
    WebElement FromAdress2;
    @FindBy (id = "to_address_2")
    WebElement ToAddress2;
    @FindBy (id = "from_additional_pickup")
    WebElement FronAdditionalPickUp;
    @FindBy (id = "to_additional_pickup")
    WebElement ToAdditionalPickUp;

    @FindBy (id = "select2-dead_lead_reason-container")
    WebElement ReasonforDeadLead ;
    @FindBy (name = "original_est")
    WebElement OriginalEstimate ;
    @FindBy (id = "select2-lead_generation_by-container")
    WebElement LeadGenerator ;
    @FindBy (id = "distance")
    WebElement Distance ;
    @FindBy (id = "ld_trip_name")
    WebElement LdTripName ;
    @FindBy (id = "select2-storage_job-container")
    WebElement StorageDropdown;

    @FindBy (id = "sidebar_weight")
    WebElement WeightValue;


        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate todayDate = LocalDate.now();
        LocalDate tomorrowDate = todayDate.plusDays(1);
        LocalDate RandomToDate = todayDate.plusDays(7);
        String TomorrowDateFld = FORMATTER.format(tomorrowDate);
        String RandomtoDateFld = FORMATTER.format(RandomToDate);


    WebDriver driver ;
    public BasicForm(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void _setDateValues() throws InterruptedException {

        MoveDatefld.sendKeys("" + TomorrowDateFld);
            Thread.sleep(1000);
                LoadFromDatefld.sendKeys(""+ TomorrowDateFld);
                    Thread.sleep(1000);
                        PackingDatefld.sendKeys("" + TomorrowDateFld);
                            Thread.sleep(1000);
                                UnpackingDatefld.sendKeys("" + TomorrowDateFld);
                                    Thread.sleep(1000);
                                        DeliveryFromDatefld.sendKeys("" + TomorrowDateFld);
                                            Thread.sleep(1000);
                                                DeliveryToDatefld.sendKeys("" + RandomtoDateFld);
                                            Thread.sleep(1000);
                                        ActualDeliveryDatefld.sendKeys(""+ TomorrowDateFld);


// SELECT SOURCE From DROPDOWN
        Select sourceValue = new Select(SourceDropdown);
        sourceValue.selectByVisibleText("");
        sourceValue.selectByValue("5");

    }

}

