package PageObject;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.excelDataReader;

public class B_DashboardPOM {

	public WebDriver driver;

		
	public B_DashboardPOM(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()=' Manage Program']") 
	public WebElement manageProgramTittle;
	
	@FindBy(xpath="//span[text()=' LMS - Learning Management System ']") 
	public WebElement LMSTittle;
	
	@FindBy(xpath="//button[@class='mat-focus-indicator mat-button mat-button-base' or @class='mat-focus-indicator mat-button mat-button-base ng-star-inserted']") 
	public List<WebElement> navigationelement;
	
	//button[@id='logout']
	@FindBy(xpath="//button[@id='logout']") 
	public WebElement Logout;
	
	public String getManageProgramTittle() {
		
		return manageProgramTittle.getText();
	}
	
	public String getLMSTittle() {
		
		return LMSTittle.getText();
	}
	
	public void logout() {
		
		Logout.click();
	}
}
