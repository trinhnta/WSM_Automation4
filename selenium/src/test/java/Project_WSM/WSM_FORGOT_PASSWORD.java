package Project_WSM;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WSM_FORGOT_PASSWORD extends WSM{

// Open forgot password screen
	@BeforeMethod
    void openBrowser() throws InterruptedException {
		open_forgot_password();
    }
	
@AfterMethod
	public void closedriver() throws InterruptedException
	{
		driver.close();
	}

//TC For_pass_001: Verify that User is redirected to "Forgot password" screen when clicking on "Forgot Password" link	
	@Test (priority = 0)
	 public void For_pass_001() {
		 		
	//Verify Point
	String actual = driver.findElement(By.cssSelector(".container-forgot-password > .login-title")).getText();
	System.out.println(actual);
	Assert.assertEquals(actual,"FORGOT PASSWORD");
					  }
	
//For_pass_002: Verify that the FORGOT PASSWORD screen contains elements
	@Test(priority = 1)
	 
	  public void For_pass_002() {
			
		 	//Verify Point
			WebElement emailtxb = driver.findElement(By.id("user_email"));
			WebElement OKbtn = driver.findElement(By.cssSelector("#devise-forgot-password-form > div.text-center.pd-top-20 > button[name=\"button\"]"));
			WebElement Cancelbtn = driver.findElement(By.linkText("Cancel"));
			WebElement Backlink = driver.findElement(By.linkText("Back to login"));
			Assert.assertEquals(true, emailtxb.isDisplayed());
			Assert.assertEquals(true, OKbtn.isDisplayed());
			Assert.assertEquals(true, Cancelbtn.isDisplayed());
			Assert.assertEquals(true, Backlink.isDisplayed());
			
	  } 

//For_pass_004: Verify that User is redirected to Login page when clicking on "Back to login" link
	@Test (priority = 2)
		public void For_pass_004() throws InterruptedException {
		
		//Click Back link
		clickAction(fp_backlink);
		sleep(10);
		
		//Verify point
		String actual = driver.findElement(By.className("login-title")).getText();
		System.out.println(actual);
		Assert.assertEquals(actual,"LOGIN");
		
		} 
//For_pass_005, For_pass_006, For_pass_007
	@Test(priority = 6)
	
	  public void for_pass_005_006_007() throws InterruptedException {
		//Enter email
		driver.findElement(By.cssSelector("#devise-forgot-password-form > div.input-field > div.login-text-field > #user_email")).sendKeys(wsm_email);
		
		//Click OK button
		driver.findElement(By.cssSelector("#devise-forgot-password-form > div.text-center.pd-top-20 > button[name=\"button\"]")).click();
		sleep(30);
		
//For_pass_005: Verify that users can request forgot password with valid email
		assertEquals(gettext(fp_alert_mess), fp_send_succes);
		
//For_pass_006: Verify that email is sent to user after requesting forgot password successully
		//Open gmail login screen
		driver.get(gmail_url);
		
		//Enter email and click Next button
		send_keys(gmail_emailtxb, wsm_email);
		clickAction(gmail_next1btn);;
		sleep(20);
		
		//Enter Password of email and click Next button
		send_keys(gmail_passtxb, gmail_pw);
		clickAction(gmail_next2btn);
		sleep(30);
		
		
		//VerifyPoint
		Assert.assertEquals(gettext(gmail_subject_label), email_fp_subject);

//For_pass_007 and For_pass_008: 
		//Open email
		driver.findElement(By.id(":35")).click();
		sleep(20);
				
				//Click Change Password link on email
				js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(email_changepw_link)));
				clickAction(email_changepw_link);
				
				String oldTab = driver.getWindowHandle();
				ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
				newTab.remove(oldTab);
			    // change focus to new tab
			    driver.switchTo().window(newTab.get(0));
			    
			    //Verify Point off For_pass_007
			    Assert.assertEquals(gettext(cp_title_lb), "Change password");
			    
			    //Verify Point off For_pass_008
			    check_visibleElement(cp_newpass_txb);
			    check_visibleElement(cp_confirmpass_txb);
			    Assert.assertEquals(gettext(cp_newpass_lb), "New password");
			    Assert.assertEquals(gettext(cp_confirmpass_lb), "Password confirmation");
	} 
//For_pass_009: Verify that User is not able to Request forgot password with blank Email
	@Test (priority = 3)
	public void for_pass_009() throws InterruptedException {
		//Click OK button without entering email
		clickAction(fp_Okbtn);
		Assert.assertEquals(gettext(fp_error_message),fp_without_email);
		
	}
//For_pass_010: Verify that User is not able to Request forgot password with invaid Email
	@Test (priority = 4)
	public void for_pass_010() throws InterruptedException {
		
		driver.findElement(By.cssSelector("#devise-forgot-password-form > div.input-field > div.login-text-field > #user_email")).sendKeys(invalid_email);
		clickAction(fp_Okbtn);
		sleep(5);
		Assert.assertEquals(gettext(fp_error_message),fp_invalid_email);
 }
//For_pass_011: Verify that User is not able to Request forgot password with valid Email but not existing 
	@Test (priority = 5)
	public void for_pass_011() throws InterruptedException {
		driver.findElement(By.cssSelector("#devise-forgot-password-form > div.input-field > div.login-text-field > #user_email")).sendKeys(not_existed_email);
		clickAction(fp_Okbtn);
		sleep(5);
		Assert.assertEquals(gettext(fp_alert_mess),fp_notfound_email);
	} 
	
//For_pass_017: Verify that User is not able to Request forgot password with blank "New password" and "Password confirmation"
	@Test (priority = 7)
	public void for_pass_017() throws InterruptedException {
		open_changepass(wsm_email);
		sleep(10);
		clickAction(cp_Okbtn);
		sleep(5);
		Assert.assertEquals(gettext(cp_newpass_errorlb),cp_without_bothpass);
		Assert.assertEquals(gettext(cp_confirmpass_errorlb),cp_without_bothpass);
	
		delete_email();
	}

//For_pass_018: Verify that User is not able to Request forgot password with invaid password < 6 characters
	@Test (priority = 8)
	public void for_pass_018() throws InterruptedException {
		open_changepass(wsm_email);
		sleep(10);
		send_keys(cp_newpass_txb, cp_invalid_leastpass);
		send_keys(cp_confirmpass_txb, cp_invalid_leastpass);
		clickAction(cp_Okbtn);
		sleep(5);
		Assert.assertEquals(gettext(cp_newpass_errorlb),cp_least_bothpass);
		Assert.assertEquals(gettext(cp_confirmpass_errorlb),cp_least_bothpass);
	
		delete_email();
	}
//For_pass_019: Verify that User is not able to Request forgot password with invaid password >128 characters
	@Test (priority = 9)
	public void for_pass_019() throws InterruptedException {
		open_changepass(wsm_email);
		sleep(10);
		send_keys(cp_newpass_txb, cp_invalid_morepass);
		send_keys(cp_confirmpass_txb, cp_invalid_morepass);
		clickAction(cp_Okbtn);
		sleep(5);
		Assert.assertEquals(gettext(cp_newpass_errorlb),cp_more_bothpass);
		Assert.assertEquals(gettext(cp_confirmpass_errorlb),cp_more_bothpass);
	
		delete_email();
	}
//For_pass_020: Verify that User is not able to Request forgot password with "New password" and "Password confirmation" does not match
	@Test (priority = 10)
	public void for_pass_020() throws InterruptedException {
		open_changepass(wsm_email);
		sleep(10);
		send_keys(cp_newpass_txb, cp_newpass);
		send_keys(cp_confirmpass_txb, cp_confirmpw);
		clickAction(cp_Okbtn);
		sleep(5);
		Assert.assertEquals(gettext(cp_confirmpass_errorlb),cp_notmatch_pass);
	
		delete_email();
	}

//For_pass_013 and For_pass_014 and For_pass_015:
	@Test (priority = 11)
	public void for_pass_013_014() throws InterruptedException {
	open_changepass(wsm_email);
	sleep(10);
	send_keys(cp_newpass_txb, cp_newpass);
	send_keys(cp_confirmpass_txb, cp_newpass);
	clickAction(cp_Okbtn);
	sleep(10);
	//For_pass_013
	Assert.assertEquals(gettext(ts_alert),ts_cpsuccess);
	
	//For_pass_014
	Assert.assertEquals(gettext(ts_title),"Timesheet");
	
	//For_pass_015
	
		//Logout
    clickAction(ts_avatar);
    clickAction(ts_logout_btn);
    sleep(10);
    
    	//Login account
    clickAction(login_btn);
    sleep(5);
    send_keys(user_email, wsm_email);
    send_keys(user_password, cp_newpass);
    clickAction(ok);
    sleep(10);
    	//Verify point
    Assert.assertEquals(gettext(ts_title),"Timesheet");
    
	delete_email();
}

//For_pass_016:
@Test (priority = 12)
public void for_pass_016() throws InterruptedException {
	//Pre-condition:
	open_changepass(wsm_email);
	change_password(cp_oldpass);
	delete_email();
	//Open forgot password
	open_forgot_password();
	open_changepass(wsm_email);
	change_password(cp_newpass);
	//Login with old pass
	clickAction(login_btn);
    sleep(5);
    send_keys(user_email, wsm_email);
    send_keys(user_password, cp_oldpass);
    clickAction(ok);
    sleep(10);
	
    //Verify point
    Assert.assertEquals(gettext(login_alert_mess),"Invalid email or password");
}
@Test (priority = 13)
public void for_pass_008() throws InterruptedException {
	//Pre-condition:
	open_changepass(wsm_email);
	change_password(cp_oldpass);
	
	//Steps
	open_forgot_password();
		//Enter email
		driver.findElement(By.cssSelector("#devise-forgot-password-form > div.input-field > div.login-text-field > #user_email")).sendKeys(wsm_email);
			
		//Click OK button
		driver.findElement(By.cssSelector("#devise-forgot-password-form > div.text-center.pd-top-20 > button[name=\"button\"]")).click();
		sleep(30);
		
		//Login with old pass
		clickAction(login_btn);
	    sleep(5);
	    send_keys(user_email, wsm_email);
	    send_keys(user_password, cp_oldpass);
	    clickAction(ok);
	    sleep(10);
	    
	    //Verify Point
	    Assert.assertEquals(gettext(ts_title),"Timesheet");
}
}