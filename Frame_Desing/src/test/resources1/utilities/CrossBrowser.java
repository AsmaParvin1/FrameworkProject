package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowser {
  WebDriver driver;
  String filepath=
		"C:\\Users\\amina\\eclipse-workspace\\Nexxvali_JavaDemos\\Frame_Desing\\config.properties";
  
  public WebDriver browser_Test() throws IOException  {
	  
	//step-1
	  FileInputStream fl=new FileInputStream(filepath);
	  //step-2
	  
	  Properties p=new Properties();
	//step-3
	  p.load(fl);
	  
	String browsername=p.getProperty("browser") ; 
	
	switch(browsername) {
	
	
	case "chrome":
	driver=new ChromeDriver();	
	driver.get(p.getProperty("url"));
	break;
	
	case"firefox":
		
		driver=new FirefoxDriver();
		driver.get(p.getProperty("url"));
		break;
		
	case"edge":
		
		driver=new EdgeDriver();
		driver.get(p.getProperty("url"));
		
		break;
	}
	  
	return driver;
	  
  }
  
  
}
