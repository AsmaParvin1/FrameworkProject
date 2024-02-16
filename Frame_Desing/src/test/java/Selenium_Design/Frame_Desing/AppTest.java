package Selenium_Design.Frame_Desing;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import objectRepository.Homepage;
import objectRepository.Registration_Info;
import objectRepository.Sign_In;
import utilities.CrossBrowser;
import utilities.ExcelData;


public class AppTest 
{ WebDriver driver;
    String data[]=new String[5];
    
    ExtentReports report=new ExtentReports();
    ExtentSparkReporter spark=new ExtentSparkReporter("C:\\Users\\amina\\eclipse-workspace\\Nexxvali_JavaDemos\\Frame_Desing\\target\\report.html");
    ExtentTest test=report.createTest("Registration application");
    

    @BeforeTest
    //before run the test, first open the browser.
    public void OpenBrowser() throws IOException {
    	
    	 CrossBrowser cr=new CrossBrowser();
         driver=cr.browser_Test();
         
    } 
    @Test(dataProvider="AcData")
    public void application(String fn,String ln,String el,String ph,String ad1,String ad2,
			String ct,String st,String z,String cty) throws IOException
    {
    	report.attachReporter(spark);

        Homepage hp= new Homepage(driver);
        hp.singin();
        test.log(Status.PASS, "user open the home page");
        report.flush();
        Sign_In sn=new Sign_In(driver);
        sn.register();
        test.log(Status.PASS, "user has clicked on sign in");
        report.flush();
        ExcelData ed=new ExcelData();
        data= ed.readExcel();
        String UserId=data[0];
        String Newpass=data[1];
        String r_pass=data[2];
    
        Registration_Info rg=new Registration_Info(driver);
        rg.user_info(UserId, Newpass, r_pass);
        rg.Ac_Info(fn, ln, el, ph, ad1, ad2, ct, st, z, cty);
        rg.profile_carendial();
        rg.saveinfo();
        rg.Msgverify();
        test.log(Status.PASS, "user has enterted valid credentials");
        report.flush();
    }
    @DataProvider(name="AcData")
	public Object[][] Ac_Info(){
	 {
		Object[][] data= {{"rini","reza","rm2@gmail.com","215-222-3088","64 Rd","apt#2",
			"Murphy","TX","74598","USA"}};
		return data; 	
    }
    }
    //after run the class takescreenshot and save the shot local File.
      @AfterTest
      public void FailedReport() throws IOException {
    	TakesScreenshot shot =(TakesScreenshot) driver;
        File src = shot.getScreenshotAs(OutputType.FILE);
        File dset=new File("D:\\Test_Screenshot\\shot.jpeg");
    	FileUtils.copyFile(src, dset);
    	 test.log(Status.FAIL, "Registration Page");
    	report.flush();
    }

}










