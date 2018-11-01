package Project_WSM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
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
        Assert.assertEquals(actualText, InformationTest.staffName);
    }

    @Test(priority = 06)
    void PER_REQ_OT_007() throws InterruptedException {
        PER_REQ_OT_003();
        actualText = driver.findElement(By.xpath(staff_codeTextbox)).getAttribute("value");
        Assert.assertEquals(actualText, InformationTest.staffCode);
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
        clickAction(checkboxOT);
        wait_element(groupDropDown);
        actual = check_visibleElement(groupDropDown);
        Assert.assertEquals(actual, expect);
    }

    @Test(priority = 9)
    void PER_REQ_OT_010() throws InterruptedException {
        PER_REQ_OT_003();
        clickAction(checkboxOT);
        wait_element(groupDropDown);
        clickAction(groupDropDown);
        wait_element(optionDropDown);
        List<WebElement> group = driver.findElements(By.xpath(optionDropDown));
        actualText = group.get(0).getText();
        Assert.assertEquals(actualText, InformationTest.group[1]);
        actualText = group.get(1).getText();
        Assert.assertEquals(actualText, InformationTest.group[2]);
        actualText = group.get(2).getText();
        Assert.assertEquals(actualText, InformationTest.group[3]);
        actualText = group.get(3).getText();
        Assert.assertEquals(actualText, InformationTest.group[4]);
        actualText = group.get(4).getText();
        Assert.assertEquals(actualText, InformationTest.group[5]);
        actualText = group.get(5).getText();
        Assert.assertEquals(actualText, InformationTest.group[6]);
        actualText = group.get(6).getText();
        Assert.assertEquals(actualText, InformationTest.group[7]);
        actualText = group.get(7).getText();
        Assert.assertEquals(actualText, InformationTest.group[8]);
        actualText = group.get(8).getText();
        Assert.assertEquals(actualText, InformationTest.group[9]);
    }

    @Test(priority = 10)
    void PER_REQ_OT_011() throws InterruptedException {
        PER_REQ_OT_003();
        send_keys(projectTextbox, InformationTest.datatest11[0]);
        send_keys(fromTextbox, InformationTest.datatest11[1]);
        clickAction(toTextbox);
        sleep(1);
        clearText(toTextbox);
        send_keys(toTextbox, InformationTest.datatest11[2]);
        send_keys(reasonTextbox, InformationTest.datatest11[3]);
        clickAction(saveBtn);
        wait_TimeOut();
        Assert.assertEquals(gettext(employeeXpath), InformationTest.ouput11[0]);
        Assert.assertEquals(gettext(staffNameXpath), InformationTest.ouput11[1]);
        Assert.assertEquals(gettext(dateOfCreationXpath), InformationTest.ouput11[2]);
        Assert.assertEquals(gettext(fromXpath), InformationTest.ouput11[3]);
        Assert.assertEquals(gettext(toXpath), InformationTest.ouput11[4]);
        Assert.assertEquals(gettext(projectNameXpath), InformationTest.ouput11[5]);
        Assert.assertEquals(gettext(reasonXpath), InformationTest.ouput11[6]);
        Assert.assertEquals(gettext(statusXpath), InformationTest.ouput11[7]);
        Assert.assertEquals(gettext(beingHandledByXpath), InformationTest.ouput11[8]);
        Assert.assertEquals(gettext(requestHoursXpath), InformationTest.ouput11[9]);
    }

    @Test(priority = 11)
    void PER_REQ_OT_012() throws InterruptedException {
        PER_REQ_OT_003();
        send_keys(projectTextbox, InformationTest.datatest12[0]);
        clickAction(checkboxOT);
        send_keys(fromTextbox, InformationTest.datatest12[1]);
        clickAction(toTextbox);
        sleep(1);
        clearText(toTextbox);
        send_keys(toTextbox, InformationTest.datatest12[2]);
        send_keys(reasonTextbox, InformationTest.datatest12[3]);
        clickAction(saveBtn);
        wait_TimeOut();
        Assert.assertEquals(gettext(employeeXpath), InformationTest.ouput12[0]);
        Assert.assertEquals(gettext(staffNameXpath), InformationTest.ouput12[1]);
        Assert.assertEquals(gettext(dateOfCreationXpath), InformationTest.ouput12[2]);
        Assert.assertEquals(gettext(fromXpath), InformationTest.ouput12[3]);
        Assert.assertEquals(gettext(toXpath), InformationTest.ouput12[4]);
        Assert.assertEquals(gettext(projectNameXpath), InformationTest.ouput12[5]);
        Assert.assertEquals(gettext(reasonXpath), InformationTest.ouput12[6]);
        Assert.assertEquals(gettext(statusXpath), InformationTest.ouput12[7]);
        Assert.assertEquals(gettext(beingHandledByXpath), InformationTest.ouput12[8]);
        Assert.assertEquals(gettext(requestHoursXpath), InformationTest.ouput12[9]);
    }

    @Test(priority = 12)
    void PER_REQ_OT_013() throws InterruptedException {
        PER_REQ_OT_003();
        send_keys(projectTextbox, InformationTest.datatest13[0]);
        send_keys(fromTextbox, InformationTest.datatest13[1]);
        clickAction(toTextbox);
        sleep(1);
        clearText(toTextbox);
        send_keys(toTextbox, InformationTest.datatest13[2]);
        send_keys(reasonTextbox, InformationTest.datatest13[3]);
        clickAction(saveBtn);
        wait_TimeOut();
        Assert.assertEquals(gettext(employeeXpath), InformationTest.ouput13[0]);
        Assert.assertEquals(gettext(staffNameXpath), InformationTest.ouput13[1]);
        Assert.assertEquals(gettext(dateOfCreationXpath), InformationTest.ouput13[2]);
        Assert.assertEquals(gettext(fromXpath), InformationTest.ouput13[3]);
        Assert.assertEquals(gettext(toXpath), InformationTest.ouput13[4]);
        Assert.assertEquals(gettext(projectNameXpath), InformationTest.ouput13[5]);
        Assert.assertEquals(gettext(reasonXpath), InformationTest.ouput13[6]);
        Assert.assertEquals(gettext(statusXpath), InformationTest.ouput13[7]);
        Assert.assertEquals(gettext(beingHandledByXpath), InformationTest.ouput13[8]);
        Assert.assertEquals(gettext(requestHoursXpath), InformationTest.ouput13[9]);
    }

    @Test(priority = 13)
    void PER_REQ_OT_014() throws InterruptedException {
        PER_REQ_OT_003();
        send_keys(projectTextbox, InformationTest.datatest14[0]);
        send_keys(fromTextbox, InformationTest.datatest14[1]);
        clickAction(toTextbox);
        sleep(1);
        clearText(toTextbox);
        send_keys(toTextbox, InformationTest.datatest14[2]);
        send_keys(reasonTextbox, InformationTest.datatest14[3]);
        clickAction(saveBtn);
        wait_TimeOut();
        Assert.assertEquals(gettext(employeeXpath), InformationTest.ouput14[0]);
        Assert.assertEquals(gettext(staffNameXpath), InformationTest.ouput14[1]);
        Assert.assertEquals(gettext(dateOfCreationXpath), InformationTest.ouput14[2]);
        Assert.assertEquals(gettext(fromXpath), InformationTest.ouput14[3]);
        Assert.assertEquals(gettext(toXpath), InformationTest.ouput14[4]);
        Assert.assertEquals(gettext(projectNameXpath), InformationTest.ouput14[5]);
        Assert.assertEquals(gettext(reasonXpath), InformationTest.ouput14[6]);
        Assert.assertEquals(gettext(statusXpath), InformationTest.ouput14[7]);
        Assert.assertEquals(gettext(beingHandledByXpath), InformationTest.ouput14[8]);
        Assert.assertEquals(gettext(requestHoursXpath), InformationTest.ouput14[9]);
    }

    @Test(priority = 14)
    void PER_REQ_OT_015() throws InterruptedException {
        PER_REQ_OT_003();
        send_keys(projectTextbox, InformationTest.datatest15[0]);
        send_keys(fromTextbox, InformationTest.datatest15[1]);
        clickAction(toTextbox);
        sleep(1);
        clearText(toTextbox);
        send_keys(toTextbox, InformationTest.datatest15[2]);
        send_keys(reasonTextbox, InformationTest.datatest15[3]);
        clickAction(saveBtn);
        wait_TimeOut();
        wait_element(actual01);
        actual = check_visibleElement(actual01);
        Assert.assertEquals(actual, expect);

    }

    @Test(priority = 15)
    void PER_REQ_OT_016() throws InterruptedException {
        PER_REQ_OT_003();
        send_keys(projectTextbox, InformationTest.datatest16[0]);
        send_keys(fromTextbox, InformationTest.datatest16[1]);
        clickAction(toTextbox);
        sleep(1);
        clearText(toTextbox);
        send_keys(toTextbox, InformationTest.datatest16[2]);
        send_keys(reasonTextbox, InformationTest.datatest16[3]);
        clickAction(saveBtn);
        wait_TimeOut();
        wait_element(actual01);
        actualText = gettext(fromXpath);
        Assert.assertEquals(actualText, InformationTest.output16);

    }

    @Test(priority = 16)
    void PER_REQ_OT_017() throws InterruptedException {
        PER_REQ_OT_003();
        send_keys(projectTextbox, InformationTest.datatest17[0]);
        send_keys(fromTextbox, InformationTest.datatest17[1]);
        clickAction(toTextbox);
        sleep(1);
        clearText(toTextbox);
        send_keys(toTextbox, InformationTest.datatest17[2]);
        send_keys(reasonTextbox, InformationTest.datatest17[3]);
        clickAction(saveBtn);
        wait_TimeOut();
        Assert.assertEquals(gettext(employeeXpath), InformationTest.ouput17[0]);
        Assert.assertEquals(gettext(staffNameXpath), InformationTest.ouput17[1]);
        Assert.assertEquals(gettext(dateOfCreationXpath), InformationTest.ouput17[2]);
        Assert.assertEquals(gettext(fromXpath), InformationTest.ouput17[3]);
        Assert.assertEquals(gettext(toXpath), InformationTest.ouput17[4]);
        Assert.assertEquals(gettext(projectNameXpath), InformationTest.ouput17[5]);
        Assert.assertEquals(gettext(reasonXpath), InformationTest.ouput17[6]);
        Assert.assertEquals(gettext(statusXpath), InformationTest.ouput17[7]);
        Assert.assertEquals(gettext(beingHandledByXpath), InformationTest.ouput17[8]);
        Assert.assertEquals(gettext(requestHoursXpath), InformationTest.ouput17[9]);
    }

    @Test(priority = 17)
    void PER_REQ_OT_018() throws InterruptedException {
        PER_REQ_OT_003();
        send_keys(projectTextbox, InformationTest.datatest18[0]);
        send_keys(fromTextbox, InformationTest.datatest18[1]);
        clickAction(toTextbox);
        sleep(1);
        clearText(toTextbox);
        send_keys(toTextbox, InformationTest.datatest18[2]);
        send_keys(reasonTextbox, InformationTest.datatest18[3]);
        clickAction(saveBtn);
        wait_element(error);
        actual = check_visibleElement(error);
        Assert.assertEquals(actual, expect);
        actualText = gettext(error);
        Assert.assertEquals(actualText, InformationTest.msgOutput18);
    }

    @Test(priority = 18)
    void PER_REQ_OT_019() throws InterruptedException {
        PER_REQ_OT_003();
        send_keys(projectTextbox, InformationTest.datatest19[0]);
        send_keys(fromTextbox, InformationTest.datatest19[1]);
        clickAction(toTextbox);
        sleep(1);
        clearText(toTextbox);
        send_keys(toTextbox, InformationTest.datatest19[2]);
        send_keys(reasonTextbox, InformationTest.datatest19[3]);
        clickAction(saveBtn);
        wait_element(errorProjectName);
        actual = check_visibleElement(errorProjectName);
        Assert.assertEquals(actual, expect);
        actualText = gettext(errorProjectName);
        Assert.assertEquals(actualText, InformationTest.msgOutput19);
    }

    @Test(priority = 19)
    void PER_REQ_OT_020() throws InterruptedException {
        PER_REQ_OT_003();
        send_keys(projectTextbox, InformationTest.datatest20[0]);
        send_keys(toTextbox, InformationTest.datatest20[2]);
        send_keys(reasonTextbox, InformationTest.datatest20[3]);
        clickAction(saveBtn);
        wait_element(errorFrom);
        actual = check_visibleElement(errorFrom);
        Assert.assertEquals(actual, expect);
        actualText = gettext(errorFrom);
        Assert.assertEquals(actualText, InformationTest.msgOutput20);
    }

    @Test(priority = 20)
    void PER_REQ_OT_021() throws InterruptedException {
        PER_REQ_OT_003();
        send_keys(projectTextbox, InformationTest.datatest21[0]);
        send_keys(fromTextbox, InformationTest.datatest21[1]);
        send_keys(reasonTextbox, InformationTest.datatest21[3]);
        clickAction(saveBtn);
        wait_element(errorTo);
        actual = check_visibleElement(errorTo);
        Assert.assertEquals(actual, expect);
        actualText = gettext(errorTo);
        Assert.assertEquals(actualText, InformationTest.msgOutput21);
    }

    @Test(priority = 21)
    void PER_REQ_OT_022() throws InterruptedException {
        PER_REQ_OT_003();
        send_keys(projectTextbox, InformationTest.datatest22[0]);
        send_keys(fromTextbox, InformationTest.datatest22[1]);
        clickAction(toTextbox);
        sleep(1);
        clearText(toTextbox);
        send_keys(toTextbox, InformationTest.datatest22[2]);
        clickAction(saveBtn);
        wait_element(errorReason);
        actual = check_visibleElement(errorReason);
        Assert.assertEquals(actual, expect);
        actualText = gettext(errorReason);
        Assert.assertEquals(actualText, InformationTest.msgOutput22);
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
