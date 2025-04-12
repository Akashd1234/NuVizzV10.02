package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BasePage {
	public Login(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//img[@alt='logo']")
	WebElement logo;
	
	@FindBy(xpath="//h3[normalize-space()='Dispatch Portal Login']")
	WebElement text;
	
	@FindBy(xpath="//input[@id='companyCode']")
	WebElement CompanyCode;
	
	@FindBy(xpath="//input[@id='userName']")
	WebElement userName;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//span[@class='px-4']/parent::button")
	WebElement loginButton;
	
	@FindBy(xpath="//label[normalize-space()='Current Dashboard']")
	WebElement currentDashboard;
	
	public void logo() {
		logo.isDisplayed();
	}
	
	public void DispatchText() {
		text.isDisplayed();
	}
	
	public void setCompanyCode(String companyCode) {
		CompanyCode.sendKeys(companyCode);
	}
	
	public void setUserName(String UserName) {
		userName.sendKeys(UserName);
	}
	
	public void setPassword(String Password) {
		password.sendKeys(Password);
	}
	
	public void loginBtn() {
		loginButton.click();
	}
	
	public boolean dashboard() {
		return true;
	}
}
