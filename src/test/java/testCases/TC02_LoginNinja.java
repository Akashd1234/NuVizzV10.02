package testCases;

import org.testng.annotations.Test;

import pageObjects.TutorialNinjaLogin;
import testBase.BaseClass;

public class TC02_LoginNinja extends BaseClass {
	
	@Test(groups={"Regression","Master"})
	public void loginTutorial() {
		
		logger.info("*****Starting the test case*******");
		TutorialNinjaLogin tn=new TutorialNinjaLogin(driver);
		tn.clkMyAccount();
		tn.clkLogin();
		tn.setEmail(p.getProperty("email"));
		tn.setPassword(p.getProperty("password"));
		tn.loginClk();
		tn.MyAccountHome();
	}
}
