package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;



public class Registration_Info {
   WebDriver driver;
   //userId
   @FindBy(name="username")
   WebElement userId;
   
   @FindBy(name="password")
   WebElement newPassword;
   
   @FindBy(name="repeatedPassword")
   WebElement repeatPassword;
   
   //Acc_info
	@FindBy(name="account.firstName")	
	WebElement firstname;
	@FindBy(name="account.lastName")
	WebElement lastname;
	@FindBy(name="account.email")
	WebElement email;
	@FindBy(name="account.phone")
	WebElement phone;
	@FindBy(name="account.address1")
	WebElement Address1;
	@FindBy(name="account.address2")
	WebElement Address2;
	@FindBy( name="account.city")
	WebElement city;
	@FindBy( name="account.state")
	WebElement state;
	@FindBy( name="account.zip")
	WebElement zip ;
	@FindBy( name="account.country")
	WebElement country;
	
	//profile_info
	  
	  @FindBy	(name="account.languagePreference")
    WebElement Langpf;
		@FindBy(name="account.favouriteCategoryId")
	WebElement fabId;
		
	@FindBy(name="account.listOption")
	WebElement enableMylist;

	@FindBy(name="account.listOption")
	WebElement enableMyban;
    @FindBy(name="newAccount")
	WebElement save;
    
	//Msgverify
    @FindBy(name="/html/body/h1")
    WebElement errMsg;
	
//initilize the class
    
	public Registration_Info(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	//constrator
	public void user_info(String u1,String p,String p1) {
		userId.sendKeys(u1);
		newPassword.sendKeys(p);
		repeatPassword.sendKeys(p1);		
	}

	public  void Ac_Info(String fn,String ln,String el,String ph,String ad1,String ad2,
			String ct,String st,String z,String cty) {
		firstname.sendKeys(fn);
        lastname.sendKeys(ln);
        email.sendKeys(el);
        phone.sendKeys(ph);
        Address1.sendKeys(ad1);
        Address2.sendKeys(ad2);
        city.sendKeys(ct);
        state.sendKeys(st);
        zip.sendKeys(z);
        country.sendKeys(cty);	
	}
	
	  public void profile_carendial() {
			Select sc=new Select(Langpf);
			sc.selectByVisibleText("english");
		  Select sc1=new Select(fabId);
		 sc1.selectByVisibleText("BIRDS");
		 enableMylist.click();
		 enableMyban.click();
	  }

 public void saveinfo() {
	 
	 save.click();
 }
	public void Msgverify() {
		
		String actMsg = errMsg.getText();
        System.out.println("Actual Message: "+ actMsg);
        String expMsg = "Successfully registered";
        Assert.assertEquals(actMsg, expMsg);
        
    }    


		
		
	}
	













