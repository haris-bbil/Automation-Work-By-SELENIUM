import org.testng.annotations.Test;

public class TestRunner extends Setup {
    @Test (priority = 1)
    public void adminLogin() throws InterruptedException {
        Login login=new Login(driver);
        driver.get("https://dev.movemanager.us/login");
        String homePageName = login.dologin();
        if (homePageName.contains("Home Dashboard")){
            System.out.println("Test Case Passed");
        }
        else
            System.out.println( "Test Case Failed");
    }
    @Test (enabled = false)
    public void LdJobCreate() throws InterruptedException {
        CreateLDJob createJob = new CreateLDJob(driver);
        createJob._createLDJob();
        Thread.sleep(1000);
    }
    @Test (priority = 2)
    public void createlocaljob () throws InterruptedException {
        CreateLocalJob localjobcreateobj = new CreateLocalJob(driver);
        localjobcreateobj._createLocalJob();
        Thread.sleep(1000);
    }

    @Test (enabled = false)
    public void setValuesinTabs() throws InterruptedException {
    SetValuesinOtherTabs setValues = new SetValuesinOtherTabs(driver);
    setValues._setValuesinTabs();
}

}


