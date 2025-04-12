package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TutorialNinjaLogin extends BasePage {
	public TutorialNinjaLogin(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement login;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement myAccountHome;
	
	public void clkMyAccount() {
		myAccount.click();
	}
	
	public void clkLogin() {
		myAccount.click();
	}
	
	public void setEmail(String Email) {
		email.sendKeys(Email);
	}
	
	public void setPassword(String Password) {
		password.sendKeys(Password);
	}
	
	public void loginClk() {
		loginBtn.click();
	}
	
	public void MyAccountHome() {
		Boolean myAccountHomePage=myAccountHome.isDisplayed();
		System.out.println(myAccountHomePage+""+"/t"+myAccountHome.getText());
		
	}
}
