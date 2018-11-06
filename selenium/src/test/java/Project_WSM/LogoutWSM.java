package Project_WSM;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LogoutWSM extends WSM{
	@BeforeTest 
	 public void access() throws InterruptedException {
		//System.setProperty("webdriver.gecko.driver", "src/lib/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "src/lib/chromedriver.exe");
		driver = new ChromeDriver();	
		driver.get(url_WSM);
		sleep(10);
    }
	 
	//check logout successfully
	@Test(priority = 0)
	public void case1_Logout() throws InterruptedException {
		loginWSM();
		sleep(10);
		clickAction(img);
		sleep(10);
		clickAction(btLogout);
		sleep(10);
		String actualmsgLogout = gettext(flashmsg);
		assertEquals(actualmsgLogout, expected_msgLogout);
	}
	
	//check system redirects to login page
	@Test(priority = 1)
	public void case2_Logout(){	
		String expectTitle = "Working space";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectTitle, actualTitle);
	}
  
	//check that user session is clear
	@Test(priority = 2)
	public void case3_Logout(){	
		driver.get(tryUrl);
		String actualmsgTryLogin = gettext(flashmsg);
		assertEquals(actualmsgTryLogin, expected_msgTrylogin);
	}
  
	//check that systems is redirected to login page when access any url of wsm
	@Test(priority = 3)
	public void case4_Logout() throws InterruptedException{
		loginWSM();
		sleep(10);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		driver.get(tryUrl1);
		sleep(10);
		clickAction(img);
		sleep(10);
		clickAction(btLogout);
		sleep(10);
		String actualmsgLogout = gettext(flashmsg);
		assertEquals(actualmsgLogout, expected_msgLogout);
	}
  
	//check that system isn't redirected any page when click on back button of browser
	@Test(priority = 4)
	public void case5_Logout()  throws InterruptedException{
		case1_Logout();
		driver.navigate().back();
  }
}
