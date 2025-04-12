package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ManageUser extends BasePage {
	public ManageUser(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//img[normalize-space()='Manage Users']")
	WebElement manageUser;
	
	@FindBy(xpath="//span[@title='Administer Users']")
	WebElement adminUser;
	
	@FindBy(xpath="//iframe[@id='iFrameMicroservice']")
	WebElement frame;
	
	@FindBy(xpath="//button[normalize-space()='+ User']")
	WebElement addUser;
	
	@FindBy(xpath="//a[normalize-space()='Create New User']")
	WebElement createNewUser;
	
	@FindBy(xpath="//span[normalize-space()='Create New User']")
	WebElement text;
	
	@FindBy(xpath="//a[normalize-space()='User Management']")
	WebElement userManagement;
	
	@FindBy(xpath="//a[normalize-space()='Home']")
	WebElement home;
	
	@FindBy(xpath="//div[@class='row m-0 px-1 row-cols-5']//div[@class='pr-3 p-0']//div//input[@placeholder='Type here']")
	WebElement fName;
	
	@FindBy(xpath="(//div[@class='pr-3']/div/input[@placeholder='Type here'])[1]")
	WebElement mName;
	
	@FindBy(xpath="//div[@class='col-12 my-3 user-inp-flds']//div[3]//div[1]//input[1]")
	WebElement lName;
	
	@FindBy(xpath="//div[@class='col-12 my-3 user-inp-flds']//div[4]//div[1]//input[1]")
	WebElement title;
	
	@FindBy(xpath="//div[@class='row m-0 px-1 row-cols-5']//div[@class='pr-3 p-0 user-inp-flds']//div//input[@placeholder='Type here']")
	WebElement email;
	
	@FindBy(xpath="//div[@class='tooltip-inner']")
	WebElement emailTooltip;
	
	@FindBy(xpath="//div[@class='pr-3 user-inp-flds']//div//input[@placeholder='Type here']")
	WebElement mobile;
	
	@FindBy(xpath="//input[@class='form-control min-width']")
	WebElement userName;
	
	@FindBy(xpath="//div[@class='col-2 p-0']//div//span[@class='slider round margin-top-8px']")
	WebElement sendInvite;
	
	@FindBy(xpath="//div[@class='new-pwd-fld p-relative ml-4 pl-3 pr-1']//div[@class='d-flex pwd-border']/child::input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//div[@class='pr-3 ml-3']//div[@class='d-flex pwd-border']/child::input[@placeholder='Type here']")
	WebElement cpassword;
	
	@FindBy(xpath="//div[@class='col-12 my-3']//div[@class='select-user-crt']/div[@class='v-select vs--multiple vs--searchable']//div[@class='vs__selected-options']/child::input[@aria-labelledby='vs2__combobox']")
	WebElement userRolesSelect;
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement user_Save;
	
	Actions act=new Actions(driver);
	
	
	public void switchManageUser() {
		manageUser.click();
	}
	
	public void switchAdminUser() {
		adminUser.click();
	}
	
	public void switchToFrame() {
		driver.switchTo().frame(frame);
	}
	
	public void selectUser() {
		addUser.click();
	}
	
	public void addNewUser() {
		createNewUser.click();
	}
	
	public void createNewUserText() {
		boolean createNewUserText1=text.isDisplayed();
		System.out.println(createNewUserText1);
	}
	
	public void userManagementHyperlink() {
		boolean hyper=userManagement.isEnabled();
		System.out.println(hyper);
	}
	
	public void home() {
		boolean hyperHome=home.isEnabled();
		System.out.println(hyperHome);
	}
	
	public void SetFirstName(String fname) {
		fName.sendKeys(fname);
	}
	
	public void SetLastName(String lname) {
		lName.sendKeys(lname);
	}
	
	public void SetMName(String mname) {
		mName.sendKeys(mname);
	}
	
	public void setTitle(String Title) {
		title.sendKeys(Title);
	}
	
	public void Setemail(String Email) {
		email.sendKeys(Email);
	}
	
	public void setMobile(String Mobile) {
		mobile.sendKeys(Mobile);
	}
	
	public void setUsername(String UserName) {
		userName.sendKeys(UserName);
	}
	
	public void EnableSendInvite() {
		sendInvite.click();
	}
	
	public void setPassword(String Password) {
		password.sendKeys(Password);
	}
	
	public void setCPassword(String CPassword) {
		cpassword.sendKeys(CPassword);
	}
	
	public void setUserRoles() {
		userRolesSelect.click();
		//userRolesSelect.sendKeys(userRoles);
		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
	}
	
	public void userSave() {
		user_Save.click();
	}
	
}
