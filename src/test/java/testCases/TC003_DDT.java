package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Login;
import pageObjects.LogoutNuvizz;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_DDT extends BaseClass{
	@Test(dataProvider="LoginData",dataProviderClass = DataProviders.class, groups="Datadriven")
	public void verify_loginNuvizz(String companyCode, String userName, String password, String exp) {
		logger.info("********TC started***********");
		try {
		Login lg=new Login(driver);
		lg.logo();
		lg.DispatchText();
		lg.setCompanyCode(companyCode);
		lg.setUserName(userName);
		lg.setPassword(password);
		lg.loginBtn();
//		lg.dashboard();
//		logger.info("*Launching application****");
		LogoutNuvizz ln=new LogoutNuvizz(driver);
		
		
		
		if(exp.equalsIgnoreCase("Valid")) {
			if(lg.dashboard()==true) {
				
				ln.companyNameClick();
				ln.logoutClick();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid")) {
			if(lg.dashboard()==true) {
				
				ln.companyNameClick();
				ln.logoutClick();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e){
			Assert.fail();
		}
		
		logger.info("*******TC Finished*********");
	}
}
