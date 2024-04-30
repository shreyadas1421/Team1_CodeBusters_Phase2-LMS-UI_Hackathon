package stepDefinations;

import java.util.List;

import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.TestSetupManager;

public class DashboardPage {

	TestSetupManager testSetupManager;
	long totalTime;

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

	@When("Admin enter valid credentials & clicks login button  {string} and {int}")
	public void admin_enter_valid_credentials_clicks_login_button_and(String sheetname, Integer rownum) {
	    
		testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().username);
		testSetupManager.pageObjectManager.getlogin().userlog(sheetname,rownum);
		
		long start = System.currentTimeMillis();
		System.out.println(start);
		testSetupManager.pageObjectManager.getlogin().clickSubmit();
		long finish = System.currentTimeMillis();
		System.out.println(finish);
		
		totalTime = finish - start;
		System.out.println("Total Time for page load - "+totalTime);
		
		
		
	}
	
	@Then("Maximum navigation time in milliseconds, defaults to {int} seconds")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(long time) {
		
		boolean status =false;
		if (totalTime >time)
			status=true;
		Assert.assertFalse(status);	
		System.out.println("page loaded");
		}

	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {
		System.out.println(testSetupManager.pageObjectManager.getDashboard().LMSToolbar.getLocation());
		
	}
	
	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
		System.out.println(testSetupManager.pageObjectManager.getDashboard().LMSToolbar.getLocation());
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
