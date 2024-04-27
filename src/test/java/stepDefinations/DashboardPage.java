package stepDefinations;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.TestSetupManager;

public class DashboardPage {

	TestSetupManager testSetupManager;

	public DashboardPage(TestSetupManager testSetupManager) {
		this.testSetupManager= testSetupManager;
	}
	
	@Then("Admin should see {string} in dashboard page")
	public void admin_should_see_in_dashboard_page(String element) {
		testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().dashboard);
	    boolean  dashboard=testSetupManager.pageObjectManager.getlogin().getDashboard();
	    Assert.assertEquals(dashboard,true );
	    System.out.println("user is in dashboard page");
	    
	    if (element.equalsIgnoreCase("Manage Program"))
	    {
	    String tittle= testSetupManager.pageObjectManager.getDashboard().getManageProgramTittle();
	    System.out.println(tittle);
	    Assert.assertEquals(tittle,element);
	    }
	    else if (element.equalsIgnoreCase("LMS - Learning Management System")){
	    	String LMStittle= testSetupManager.pageObjectManager.getDashboard().getLMSTittle();
		    System.out.println(LMStittle);
		    Assert.assertEquals(LMStittle,element);
	    }
	    
	}
	
	@Then("Admin should see {string} in the {int} of place")
	public void admin_should_see_in_the_of_place(String element, Integer position) {
		
		testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().dashboard);
	    boolean  dashboard=testSetupManager.pageObjectManager.getlogin().getDashboard();
	    Assert.assertEquals(dashboard,true );
	    System.out.println("user is in dashboard page");

	    List<WebElement> list= testSetupManager.pageObjectManager.getDashboard().navigationelement;
	    
	    Assert.assertEquals(element,list.get(position).getText()); 
	    System.out.println(element + "is in "+ position +" position");
	    
	    
	}

//Logout
	
	@When("Admin click Logout button on navigation bar")
	public void admin_click_logout_button_on_navigation_bar() {
		testSetupManager.pageObjectManager.getDashboard().logout();
		System.out.println("Logout successfull");
	}

	@Then("Admin should land on login in page")
	public void admin_should_land_on_login_in_page() {
	    
		boolean  LogInPageTittle=testSetupManager.pageObjectManager.getlogin().getTittle();
		Assert.assertEquals(LogInPageTittle,true );
		
		System.out.println("user in main login page");
	}
	
}
