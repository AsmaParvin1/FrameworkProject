package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 public class Homepage {
 WebDriver driver;
 @FindBy(xpath="//*[@id=\"MenuContent\"]")
 WebElement signin;
 public Homepage(WebDriver driver) {
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
	 
 }
  public void singin() {
	  signin.click();
  }
}
