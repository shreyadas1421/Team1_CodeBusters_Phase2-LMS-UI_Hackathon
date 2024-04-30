package PageObject;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public WebDriver driver;
	public A_LoginPOM Login;
	public B_DashboardPOM Dashboard;
	public E_UserPOM User;
	
	
	public PageObjectManager(WebDriver driver) {
		this.driver= driver;
	}

	public A_LoginPOM getlogin() {
		
		Login= new A_LoginPOM(driver);
		
		return Login;
	}
	
	public B_DashboardPOM getDashboard() {
		
		Dashboard= new B_DashboardPOM(driver);
		
		return Dashboard;
	}
	
	public E_UserPOM getUser() {
			
			User= new E_UserPOM(driver);
			
			return User;
		}
}
