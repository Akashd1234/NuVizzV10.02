package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutNuvizz extends BasePage{
	public LogoutNuvizz(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='relative inline-block text-left']/div/child::button[@type='button']")
	WebElement clkCompanyName;
	
	@FindBy(xpath="//a[@id='headlessui-menu-item-14']")
	WebElement clkLogout;
	
	
	
	
	
	public void companyNameClick() {
		clkCompanyName.click();
	}
	
	public void logoutClick() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(clkLogout));
		clkLogout.click();
	}
}
