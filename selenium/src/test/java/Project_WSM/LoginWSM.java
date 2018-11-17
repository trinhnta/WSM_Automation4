package Project_WSM;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginWSM extends WSM {

    @BeforeTest
    public void access() throws InterruptedException {
        //System.setProperty("webdriver.gecko.driver", "lib/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "src/lib/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url_WSM);
        sleep(10);
        clickAction(login_btn);
    }

    //check exist variables
    @Test(priority = 0)
    public void case1() {
        String expectTitle = "Login";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectTitle, actualTitle);

        actual = check_visibleElement(user_email);
        Assert.assertEquals(actual, expectTrue);

        actual = check_visibleElement(user_password);
        Assert.assertEquals(actual, expectTrue);

        actual = check_visibleElement(remember);
        Assert.assertEquals(actual, expectTrue);

        actual = check_visibleElement(ok);
        Assert.assertEquals(actual, expectTrue);

        actual = check_visibleElement(btCancel);
        Assert.assertEquals(actual, expectTrue);

        actual = check_visibleElement(forgotpw);
        Assert.assertEquals(actual, expectTrue);
    }

    //check status of remember me radio button
    @Test(priority = 1)
    public void case2() {
        boolean check = driver.findElement(By.id("user_remember_me")).isSelected();
        assertEquals(check, false);
    }

    //check password is encrypted
    @Test(priority = 2)
    public void case3() {
        String actual = driver.findElement(By.id("user_password")).getAttribute("value");
        System.out.println(actual);
    }

    //check login success
    @Test(priority = 3)
    public void case6() {
        send_keys(user_email, InformationTest.email);
        send_keys(user_password, InformationTest.password);
        clickAction(ok);
        String actualmsgLogin = gettext(flashmsg);
        Assert.assertEquals(actualmsgLogin, expected_msgLogin);
    }

    //check directory when login success
    @Test(priority = 4)
    public void case7() {
        String expectedTitle = "Working space";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    //check directory when click back button of browser
    @Test(priority = 5)
    public void case8() {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    //check status when close browser
    @Test(priority = 6)
    public void case9() throws InterruptedException {
        Thread.sleep(1000);
        driver.close();
        driver.get(url_WSM);
        String actualmsgLogin = gettext(flashmsg);
        Assert.assertEquals(actualmsgLogin, expected_msgLogin);
    }

    //check login fail with email and password are null
    @Test(priority = 7)
    public void case10() throws InterruptedException {
        driver.quit();
        access();
        send_keys(user_email, "");
        send_keys(user_password, "");
        sleep(10);
        clickAction(ok);
        sleep(10);
        String actualemail = gettext(msgEmail);
        System.out.println(actualemail);
        Assert.assertEquals(expected_msgEmailnull, actualemail);
        String actualpw = gettext(msgPassword);
        System.out.println(actualpw);
        Assert.assertEquals(expected_msgPwlnull, actualpw);
    }

    //check login fail with invalid email and password
    @Test(priority = 8)
    public void case11() throws InterruptedException {
        driver.quit();
        access();
        send_keys(user_email, "abc@framgia.com");
        send_keys(user_password, "Framgia123");
        clickAction(ok);
        sleep(10);
        String actualmsg = gettext(msgError);
        System.out.println(actualmsg);
        Assert.assertEquals(actualmsg, expected_msgEmailPassword);
    }

    //check login fail with password don't corresponding with email
    @Test(priority = 9)
    public void case12() throws InterruptedException {
        driver.quit();
        access();
        send_keys(user_email, InformationTest.email);
        send_keys(user_password, "Framgia123");
        clickAction(ok);
        sleep(10);
        String actualmsg = gettext(msgError);
        System.out.println(actualmsg);
        Assert.assertEquals(actualmsg, expected_msgEmailPassword);
    }

    //check login fail with invalid email
    @Test(priority = 10)
    public void case13() throws InterruptedException {
        driver.quit();
        access();
        send_keys(user_email, "nguyen.thi.truc.na");
        send_keys(user_password, "Framgia123");
        clickAction(ok);
        sleep(10);
        String actualmsg = gettext(msgError);
        System.out.println(actualmsg);
        Assert.assertEquals(actualmsg, expected_msgEmailPassword);
    }
}
