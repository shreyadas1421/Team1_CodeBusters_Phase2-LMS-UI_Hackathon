package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.excelDataReader;

import java.util.List;
import java.util.Map;

public class A_LoginPOM {

	public WebDriver driver;
	Map<String, String> excelmap;
	public excelDataReader datamap;
		
	public A_LoginPOM(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@class='images']") 
	public WebElement logo;
	@FindBy(xpath="//input[@id='username']") 
	public WebElement username;
	@FindBy(xpath="//input[@id='password']") 
	public WebElement password;
	@FindBy(xpath="//span[@class='mat-button-wrapper']") 
	public WebElement submit;
	@FindBy(xpath="//span[normalize-space()='LMS - Learning Management System']")
	public WebElement dashboard;
	//p[normalize-space()='Please login to LMS application']
	
	@FindBy(xpath="//p[normalize-space()='Please login to LMS application']")
	public WebElement LoginText;

	@FindBy(xpath="//input") public List<WebElement> txtBox;
	
	@FindBy(xpath="//mat-error[@id='errormessage']")
	public WebElement loginErrormsg;
	//mat-error[@id='mat-error-0']
	@FindBy(xpath="//mat-error[@id='mat-error-0']")
	public WebElement loginErrormsgnullUid;
	
	
public void userlog(String sheetname, int rownum) {
	
	
	datamap= new excelDataReader();
	excelmap=datamap.getTestData(sheetname, rownum);
	username.sendKeys(excelmap.get("username") == null ? "" : excelmap.get("username"));
	
	password.sendKeys(excelmap.get("password") == null ? "" :excelmap.get("password"));

	
	
}

public void userlogInvalidurl(String sheetname, int rownum) {
	
	
	datamap= new excelDataReader();
	excelmap=datamap.getTestData(sheetname, rownum);
	username.sendKeys(excelmap.get("username") == null ? "" : excelmap.get("username"));
	
	password.sendKeys(excelmap.get("password") == null ? "" :excelmap.get("password"));

	driver.get(excelmap.get("url"));
	
	
}
		
		public boolean getLoginbutton() {
			
			return submit.isDisplayed();
		}
		
		public void clickSubmit() {
			
			submit.click();
		}
		
		public boolean  getTittle() {
			
			return logo.isDisplayed();
		}
		
		public boolean  getDashboard() {
			
			return dashboard.isDisplayed();
		}
		
		public boolean getLogo() {
			return logo.isDisplayed();
		}
		
		public boolean getText() {
			return LoginText.isDisplayed();
		}
		
		public int getTextboxcount() {
			
		
			int countofTextBox= txtBox.size();
			return countofTextBox;
		}
		
		public String getErrormsg() {
			
			return loginErrormsg.getText();
		}
		
		public String getErrormsg1() {
			
			return loginErrormsgnullUid.getText();
		}
		
		public String userFieldgetText() {
			return username.getTagName();
		}
}