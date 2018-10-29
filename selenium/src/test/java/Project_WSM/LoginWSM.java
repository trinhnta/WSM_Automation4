package wsm_TrucNa;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginWSM{
	public WebDriver driver;
    public String baseUrl = "https://wsm.framgia.vn/en";
    public boolean expect = true;
    public boolean actual;
    
    
	@BeforeClass
	public void access() throws InterruptedException{
		System.setProperty("webdriver.gecko.driver", "lib/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		driver = new ChromeDriver();	
		driver.get(baseUrl);
		Thread.sleep(1000);
		driver.findElement(By.linkText("LOGIN")).click();
	}
	
	@Test(priority = 0)
	public void case1(){	
		String expectTitle = "Working space";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectTitle, actualTitle);
		
		actual = driver.findElement(By.id("user_email")).isDisplayed();
		Assert.assertEquals(actual, expect);
		
		actual = driver.findElement(By.id("user_password")).isDisplayed();
		Assert.assertEquals(actual, expect);
		
		actual = driver.findElement(By.className("fa fa-sign-in")).isDisplayed();
		Assert.assertEquals(actual, expect);
		
		actual = driver.findElement(By.className("fa fa-times-circle-o")).isDisplayed();
		Assert.assertEquals(actual, expect);
		
		actual = driver.findElement(By.id("user_remember_me")).isDisplayed();
		Assert.assertEquals(actual, expect);
		
		actual = driver.findElement(By.className("btn-forgot-password")).isDisplayed();
		Assert.assertEquals(actual, expect);
	}
	
	@Test(priority = 1)
	public void case2() {
		boolean check = driver.findElement(By.id("user_remember_me")).isSelected();
		assertEquals(check, false);
	}
	
	@Test(priority = 2)
	public void case3() {		
		String actual = driver.findElement(By.id("user_password")).getAttribute("value");
		System.out.println(actual);
	}	
	
	@Test(priority = 3)
	public void case6() {
		driver.findElement(By.id("user_email")).sendKeys(Datatest.email);
		driver.findElement(By.id("user_password")).sendKeys((Datatest.password));
		driver.findElement(By.name("button")).click();
	}
	
	@Test(priority = 4)
	public void case7() {
		String expectedTitle = "Working space";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority = 5)
	public void case9() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
		driver.get(baseUrl);
	}
	
	@Test(priority = 6)
	public void case10() throws InterruptedException {
		driver.quit();
		access();
		driver.findElement(By.name("button")).click();
		Thread.sleep(1000);
		String expectedemail = "Email is required";
		String actualemail = driver.findElement(By.id("user_email-error")).getText();
		Assert.assertEquals(expectedemail, actualemail);
		String expectedpw = "Password is required";
		String actualpw = driver.findElement(By.id("user_password-error")).getText();
		Assert.assertEquals(expectedpw, actualpw);
	}
	
	@Test(priority = 7)
	public void case11() throws InterruptedException {
		driver.quit();
		access();
		driver.findElement(By.id("user_email")).sendKeys("abc@framgia.com");
		driver.findElement(By.id("user_password")).sendKeys(("Framgia123"));
		driver.findElement(By.name("button")).click();
		Thread.sleep(1000);
		String expectedmsg = "Invalid email or password.";
		String actualmsg = driver.findElement(By.className("login-error")).getText();
		Assert.assertEquals(actualmsg, expectedmsg);
	}
	
	@Test(priority = 8)
	public void case12() throws InterruptedException {
		driver.quit();
		access();
		driver.findElement(By.id("user_email")).sendKeys(Datatest.email);
		driver.findElement(By.id("user_password")).sendKeys(("Framgia123"));
		driver.findElement(By.name("button")).click();
		Thread.sleep(1000);
		String expectedmsg = "Invalid email or password.";
		String actualmsg = driver.findElement(By.className("login-error")).getText();
		Assert.assertEquals(actualmsg, expectedmsg);
	}
	
	@Test(priority = 9)
	public void case13() throws InterruptedException {
		driver.quit();
		access();
		driver.findElement(By.id("user_email")).sendKeys("nguyen.thi.thanh.ly");
		driver.findElement(By.id("user_password")).sendKeys(("Framgia123"));
		driver.findElement(By.name("button")).click();
		Thread.sleep(1000);
		String expectedmsg = "Please enter a valid email address";
		String actualmsg = driver.findElement(By.id("user_email-error")).getText();
		Assert.assertEquals(actualmsg, expectedmsg);
	}
}
