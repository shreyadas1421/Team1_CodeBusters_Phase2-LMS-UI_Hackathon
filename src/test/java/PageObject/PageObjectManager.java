package PageObject;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	
	public A_LoginPOM Login;
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		this.driver= driver;
	}

	public A_LoginPOM getlogin() {

		Login= new A_LoginPOM(driver);

		return Login;
	}
	
}
