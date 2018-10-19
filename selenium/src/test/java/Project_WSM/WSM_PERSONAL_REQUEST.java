package Project_WSM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class WSM_PERSONAL_REQUEST extends WSM {


    @Test(priority = 0)
    void PER_REQ_OT_001() throws InterruptedException {
        loginWSM();
        wait_element(personal_request);
        clickAction(personal_request);
        clickAction(overtime);
        actual = check_visibleElement(actual01);
        Assert.assertEquals(actual, expect);
    }

    @Test(priority = 1)
    void PER_REQ_OT_002() {
        driver.get(url_OverTime);
        wait_TimeOut();
        wait_element(login_btn);
        actual = check_visibleElement(login_btn);
        Assert.assertEquals(actual, expect);
    }

    @Test(priority = 02)
    void PER_REQ_OT_003() throws InterruptedException {
        loginWSM();
        sleep(1);
        clickAction(personal_request);
        clickAction(overtime);
        wait_element(create_overtime);
        clickAction(create_overtime);
        actual = check_visibleElement(actual03);
        Assert.assertEquals(actual, expect);
    }

    @Test(priority = 03)
    void PER_REQ_OT_004() throws InterruptedException {
        PER_REQ_OT_003();
        actual = check_visibleElement(staff_nameLabel);
        Assert.assertEquals(actual, expect);
        actual = check_visibleElement(staff_nameTextbox);
        Assert.assertEquals(actual, expect);
        actual = check_visibleElement(staff_codeLabel);
        Assert.assertEquals(actual, expect);
        actual = check_visibleElement(staff_codeTextbox);
        Assert.assertEquals(actual, expect);
        actual = check_visibleElement(branchLabel);
        Assert.assertEquals(actual, expect);
        actual = check_visibleElement(branchTextbox);
        Assert.assertEquals(actual, expect);
        actual = check_visibleElement(groupLabel);
        Assert.assertEquals(actual, expect);
        actual = check_visibleElement(groupTextbox);
        Assert.assertEquals(actual, expect);
        actual = check_visibleElement(checkboxOT);
        Assert.assertEquals(actual, expect);
        actual = check_visibleElement(projectLabel);
        Assert.assertEquals(actual, expect);
        actual = check_visibleElement(projectTextbox);
        Assert.assertEquals(actual, expect);
        actual = check_visibleElement(fromLabel);
        Assert.assertEquals(actual, expect);
        actual = check_visibleElement(fromTextbox);
        Assert.assertEquals(actual, expect);
        actual = check_visibleElement(toLabel);
        Assert.assertEquals(actual, expect);
        actual = check_visibleElement(toTextbox);
        Assert.assertEquals(actual, expect);
        actual = check_visibleElement(reasonLabel);
        Assert.assertEquals(actual, expect);
        actual = check_visibleElement(reasonTextbox);
        Assert.assertEquals(actual, expect);
    }

    @Test(priority = 04)
    void PER_REQ_OT_005() throws InterruptedException {
        PER_REQ_OT_003();
        if (driver.findElement(By.xpath(checkboxOT)).isSelected()) actual = false;
        else actual = true;
        Assert.assertEquals(actual, expect);
    }

    @Test(priority = 05)
    void PER_REQ_OT_006() throws InterruptedException {
        PER_REQ_OT_003();
        actualText = driver.findElement(By.xpath(staff_nameTextbox)).getAttribute("value");
        Assert.assertEquals(actualText, InformationTest.staff_name);
    }

    @Test(priority = 06)
    void PER_REQ_OT_007() throws InterruptedException {
        PER_REQ_OT_003();
        actualText = driver.findElement(By.xpath(staff_codeTextbox)).getAttribute("value");
        Assert.assertEquals(actualText, InformationTest.staff_code);
    }

    @Test(priority = 07)
    void PER_REQ_OT_008() throws InterruptedException {
        PER_REQ_OT_003();
        actualText = driver.findElement(By.xpath(branchTextbox)).getText();
        Assert.assertEquals(actualText, InformationTest.branch);
    }
    @Test(priority = 8)
    void PER_REQ_OT_009() throws InterruptedException {
        PER_REQ_OT_003();
        actualText = driver.findElement(By.xpath(groupTextbox)).getText();
        Assert.assertEquals(actualText, InformationTest.group);
    }

    @BeforeMethod
    void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/lib/chromedriver");
        driver = new ChromeDriver();
        driver.get(url_WSM);
        wait_TimeOut();
    }

    @AfterMethod
    void closeBrowser() throws InterruptedException {
        driver.close();

    }

}
