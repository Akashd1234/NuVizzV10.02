package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.Login;
import pageObjects.LogoutNuvizz;
import pageObjects.ManageUser;
import testBase.BaseClass;

public class Tc01_ManageUser extends BaseClass {
	
	@Test
	public void verify_User_Registration() {
		
		logger.info("***********Starting testCase*************");
		
		try
		{
		Login lg=new Login(driver);
		lg.logo();
		lg.DispatchText();
		lg.setCompanyCode(p.getProperty("companyCode"));
		lg.setUserName(p.getProperty("username"));
		lg.setPassword(p.getProperty("password"));
		lg.loginBtn();
		logger.info("*Launching application****");
		
		
		ManageUser user=new ManageUser(driver);
		
		logger.info("**Navigating to the user screen****");
		
		user.switchManageUser();
		user.switchAdminUser();
		user.switchToFrame();
		
		logger.info("****Clicking on add new user****");
		
		user.selectUser();
		user.addNewUser();
		user.home();
		user.userManagementHyperlink();
		user.createNewUserText();
		user.SetFirstName(randomeAlphabetic().toUpperCase());
		user.SetMName(randomeAlphabetic().toUpperCase());
		user.SetLastName(randomeAlphabetic().toUpperCase());
		user.setTitle("DCUAT1");
		user.Setemail(randomeAlphabetic().toUpperCase()+"@mailinator.com");
		user.setMobile(randomNumeric());
		user.setUsername(randomeAlphabetic().toUpperCase());
		user.EnableSendInvite();
		user.setPassword("P@ssw0rd");
		user.setCPassword("P@ssw0rd");
		user.setUserRoles();
		user.userSave();
		
		logger.info("Validating expected message...");
		
		
		
		LogoutNuvizz ln=new LogoutNuvizz(driver);
		ln.companyNameClick();
		ln.logoutClick();
		logger.info("*Launching application****");
		
	}
		catch(Exception e){
			logger.error("Test failed");
			logger.debug("Debug logs");
			Assert.fail();
		}
	}
	
	////li[@id='vs2__option-0']
	////li[@id='vs2__option-0']
	
	
	
}
