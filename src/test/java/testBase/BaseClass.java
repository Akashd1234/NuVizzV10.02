package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import freemarker.template.SimpleDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	
	public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setUp(String os, String br) throws IOException  {
		
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities=new DesiredCapabilities();
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("linux")) {
				capabilities.setPlatform(Platform.LINUX);
			}
			else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}
			
			else {
				System.out.println("No matching os found");
				return;
			}
			
			switch(br.toLowerCase()) {
			case "chrome":capabilities.setBrowserName("chrome");break;
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		
		switch(br.toLowerCase()) {
		case "chrome":driver=new ChromeDriver();break;
		//case "edge":driver=new EdgeDriver();break;
		//default: System.out.println("Invalid browser name");return;
		}
//		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		
		//driver.get("");
		driver.get(p.getProperty("appURL1"));
		//driver.get(p.getProperty("appURL2"));
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}
	
	public String randomeAlphabetic() {
		String generatedAlphabetic=RandomStringUtils.randomAlphabetic(5);
		return generatedAlphabetic;
	}
	
	public String randomAlphanumeric() {
		String generatedAlphanumeric=RandomStringUtils.randomAlphanumeric(5);
		return generatedAlphanumeric;
	}
	
	public String randomNumeric() {
		String generatedNumeric=RandomStringUtils.randomNumeric(10);
		return generatedNumeric;
	}
	
	public String captureScreen(String tname) {
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File sourceType=ts.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		File targetFile=new File(targetFilePath);
		
		sourceType.renameTo(targetFile);
		return targetFilePath;
	}
}
