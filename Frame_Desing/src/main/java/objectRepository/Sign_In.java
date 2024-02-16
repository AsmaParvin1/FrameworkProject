package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sign_In {
  WebDriver driver;
  @FindBy(xpath="//*[@id=\"Catalog\"]/a")
  WebElement register_now;
  
  public Sign_In(WebDriver driver) {
	  this.driver=driver;
	  PageFactory.initElements(driver,this);
  }
	  public void register () {
		  register_now.click();
		  
	  }
	  
	  
  }

