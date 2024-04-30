package PageObject;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.excelDataReader;

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



	public void userlog(String sheetname, int rownum) {


		datamap= new excelDataReader();
		excelmap=datamap.getTestData(sheetname, rownum);
		username.sendKeys(excelmap.get("username"));
		password.sendKeys(excelmap.get("password"));
		submit.click();

	}

	public boolean  getTittle() {

		return logo.isDisplayed();
	}

	public boolean  getDashboard() {

		return dashboard.isDisplayed();
	}
}