package Project_WSM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WSM {

    //constant
    public final int TIME_OUT = 20;
    public final Boolean expectTrue = true;
    public final String disbaleTrue = "true";

    //Variable
    public Boolean actual;
    public String actualText;
    public String actualDisabled;
    public WebDriver driver;

    //xpath login screen
    public final String login_btn = "//a[@class='wsm-btn btn-login']";
    public final String user_password = "//input[@id='user_password']";
    public final String user_email = "//input[@id='user_email']";
    public final String ok = "//button[@class='wsm-btn login-success']";

    //xpath WSM home screen
    public final String personal_request = "//span[contains(text(),'Personal requests')]";
    public final String overtime = "//a[contains(text(),'Overtime')]";

    //xpath Request Overtime list screen
    public final String create_overtime = "//a[@class='btn btn-primary']";
    public final String employeeXpath = "//tbody[@class='list-request-ots']//td[1]";
    public final String staffNameXpath = "//tbody[@class='list-request-ots']//td[2]";
    public final String dateOfCreationXpath = "//tbody[@class='list-request-ots']//td[3]";
    public final String fromXpath = "//tbody[@class='list-request-ots']//td[4]";
    public final String toXpath = "//tbody[@class='list-request-ots']//td[5]";
    public final String projectNameXpath = "//tbody[@class='list-request-ots']//td[6]";
    public final String reasonXpath = "//tbody[@class='list-request-ots']//td[7]";
    public final String statusXpath = "//tbody[@class='list-request-ots']//td[8]";
    public final String beingHandledByXpath = "//tbody[@class='list-request-ots']//td[9]";
    public final String requestHoursXpath = "//tbody[@class='list-request-ots']//td[10]";
    public final String actual01 = "//h1[contains(text(),'Request overtime')]";

    //xpath Create Request Overtime screen
    public final String staff_nameLabel = "//label[text()='Staff name']";
    public final String staff_nameTextbox = "//input[@id='employee_name']";
    public final String staff_codeLabel = "//label[text()='Staff code']";
    public final String staff_codeTextbox = "//input[@id='employee_code']";
    public final String branchLabel = "//label[text()='Branch']";
    public final String branchTextbox = "//span[@id='select2-chosen-1']";
    public final String groupLabel = "//label[text()='Group']";
    public final String groupTextbox = "//span[@id='select2-chosen-2']";
    public final String groupDropDown = "//span[@id='select2-chosen-3']";
    public final String optionDropDown = "//div[@role='option']";
    public final String checkboxOT = "//span[text()='Do you OT for other group?']";
    public final String projectLabel = "//label[text()='Project']";
    public final String projectTextbox = "//input[@id='request_ot_project_name']";
    public final String fromLabel = "//label[text()='From']";
    public final String fromTextbox = "//input[@id='request_ot_from_time']";
    public final String toLabel = "//label[text()='To']";
    public final String toTextbox = "//input[@id='request_ot_end_time']";
    public final String reasonLabel = "//label[text()='Reason']";
    public final String reasonTextbox = "//textarea[@id='request_ot_reason']";
    public final String saveBtn = "//input[@value='Save']";
    public final String error = "//li[@class='text-danger']";
    public final String errorProjectName = "//div[@id='request_ot_project_name-error']";
    public final String errorFrom = "//div[@id='request_ot_from_time-error']";
    public final String errorTo = "//div[@id='request_ot_end_time-error']";
    public final String errorReason = "//div[@id='request_ot_reason-error']";
    public final String newRequestScr = "//h3[contains(text(),'New request for overtime')]";

    //variables in logout
    public String img = "//img[@src='/assets/user_avatar_default-bc6c6c40940226d6cf0c35571663cd8d231a387d5ab1921239c2bd19653987b2.png']";
    public String btLogout = "//a[@class='button-logout']";

    //Url test
    public String url_WSM = "https://edev.framgia.vn";
    public String url_OverTime = "https://wsm.framgia.vn/en/dashboard/users/367/request_ots";
    public String tryUrl = "https://edev.framgia.vn/en/dashboard/user_settings/edit";
    public String tryUrl1 = "https://edev.framgia.vn/en/dashboard/import_timesheets";

    //message 
    public String expected_msgEmailPassword = "Invalid email or password.";
    public String expected_msgEmail = "Please enter a valid email address";
    public String expected_msgEmailnull = "Email is required";
    public String expected_msgPwlnull = "Password is required";
    public String expected_msgLogin = "Signed in successfully.";

    public String expected_msgLogout = "Signed out successfully.";
    public String expected_msgTrylogin = "You need to sign in or sign up before continuing.";

    //variables in login
    public String remember = "//label[@class ='checkbox-remember']";
    public String btCancel = "//a[@class='wsm-btn login-cancel']']";
    public String forgotpw = "//a[@class='btn-forgot-password']";

    //variable message
    public String msgError = "//p[@class='alert alert-danger']";
    public String msgEmail = "//p[@for='user_email']";
    public String msgPassword = "//p[@for='user_password']";
    public String flashmsg = "//div[@id='flash-message']";

    public String expectedTitle = "Your timesheet | Working space";

    //Login to WSM function
    void loginWSM() throws InterruptedException {
        clickAction(login_btn);
        wait_TimeOut();
        send_keys(user_email, InformationTest.email);
        send_keys(user_password, InformationTest.password);
        sleep(1);
        clickAction(ok);
    }

    //action click element xpath
    void clickAction(String element) {
        driver.findElement(By.xpath(element)).click();

    }

    //action clear element xpath
    void clearText(String element) {
        driver.findElement(By.xpath(element)).clear();

    }

    //action gettext element xpath
    String gettext(String element) {
        return driver.findElement(By.xpath(element)).getText();

    }

    //action send keys element xpath
    void send_keys(String element, String keys) {
        driver.findElement(By.xpath(element)).sendKeys(keys);

    }

    // check visible element xpath
    Boolean check_visibleElement(String element) {
        if (driver.findElement(By.xpath(element)).isDisplayed()) return true;
        return false;
    }

    // wait timeout function
    void wait_TimeOut() {
        driver.manage().timeouts().implicitlyWait(TIME_OUT, TimeUnit.SECONDS);
    }

    // wait element visible function
    void wait_element(String element) {
        new WebDriverWait(driver, TIME_OUT).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(element))));
    }

    // Sleep function
    void sleep(int time) throws InterruptedException {
        Thread.sleep(time * 100);
    }

}