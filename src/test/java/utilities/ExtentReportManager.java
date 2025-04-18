package utilities;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.bidi.module.Browser;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {
		public ExtentSparkReporter sparkReporter;
		public ExtentReports extent;
		public ExtentTest test;
		
		String repName;
		public void onStart(ITestContext testContext) {
			String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			repName="Test-Report-"+timeStamp+" .html";
			
			
			sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);
			sparkReporter.config().setDocumentTitle("nuVizz Automation report");
			sparkReporter.config().setReportName("nuVizz functional testing");
			sparkReporter.config().setTheme(Theme.DARK);
			
			extent=new ExtentReports();
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Application", "nuVizz");
			extent.setSystemInfo("Module", "Administer user");
			extent.setSystemInfo("SubModule", "ManageUser");
			extent.setSystemInfo("UserName", System.getProperty("user.name"));
			extent.setSystemInfo("Environment", "UAT");
			
			String os=testContext.getCurrentXmlTest().getParameter("os");
			extent.setSystemInfo("Operating System", os);
			
			String browser=testContext.getCurrentXmlTest().getParameter("browser");
			extent.setSystemInfo("Browser", browser);
			
			List<String> includedGroups=testContext.getCurrentXmlTest().getIncludedGroups();
			if(!includedGroups.isEmpty()) {
				extent.setSystemInfo("Groups", includedGroups.toString());
			}
		}
		
		public void onTestSuccess(ITestResult result) {
			test=extent.createTest(result.getTestClass().getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.PASS,result.getName()+" got Successfully executed");
		}
		
		public void onTestFailure(ITestResult result) {
			test=extent.createTest(result.getClass().getName());
			test.assignCategory(result.getMethod().getGroups());
			
			test.log(Status.FAIL,result.getName()+" got failed");
			test.log(Status.INFO, result.getThrowable().getMessage());
			
			try {
			String imgPath=new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public void onTestSkipped(ITestResult result) {
			test=extent.createTest(result.getClass().getName());
			test.assignCategory(result.getMethod().getGroups());
			test.log(Status.SKIP,result.getName()+"got Skipped");
			test.log(Status.INFO,result.getThrowable().getMessage());
		}
		
		public void onFinish(ITestContext context) {
			extent.flush();
			
			String pathOfExtentReport=System.getProperty("user.dir")+"\\reports\\"+repName;
			File extentReport=new File(pathOfExtentReport);
			
			try {
				Desktop.getDesktop().browse(extentReport.toURI());
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
}
