package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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
	
	//mat-toolbar[@class='mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted']
	
	@FindBy(xpath="//mat-toolbar[@class='mat-toolbar mat-primary mat-toolbar-single-row ng-star-inserted']") 
	public WebElement LMSToolbar;
	
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
	
	/*
	public void getSpellcheck() {
		
		SpellChecker checker = new SpellChecker();
		SpellResponse spellResponse = checker.check( "helloo worlrd" );
		for( SpellCorrection sc : spellResponse.getCorrections() )
		System.out.println( sc.getValue() );
	}*/
}
