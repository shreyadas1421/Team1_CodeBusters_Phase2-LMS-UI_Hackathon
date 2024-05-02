package stepDefinations;

import java.util.List;

import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageObject.A_LoginPOM;
import PageObject.B_DashboardPOM;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.TestSetupManager;

public class DashboardPage extends B_DashboardPOM{

	TestSetupManager testSetupManager;
	
	A_LoginPOM login= new A_LoginPOM();

	public DashboardPage(TestSetupManager testSetupManager) {
		this.testSetupManager= testSetupManager;
		SetDriver(this.testSetupManager.testbase.driver);
	}
	
	@Then("Admin should see elements in dashboard page")
	public void admin_should_see_elements_in_dashboard_page() {
	//	testSetupManager.reusablemethod.explicitWait(dashboard);
	//    Assert.assertEquals( getDashboard(),true );
	    
	    System.out.println("user is in dashboard page");
	   
	    Assert.assertEquals(getManageProgramTittle(),"Manage Program");
	    System.out.println(getManageProgramTittle());
	    
	 
	    Assert.assertEquals(getLMSTittle(),"LMS - Learning Management System");
	    System.out.println(getLMSTittle());
	 /*   
	    if (element.equalsIgnoreCase("Manage Program"))
	    {
	   // String tittle= testSetupManager.pageObjectManager.getDashboard().getManageProgramTittle();
	    System.out.println(getManageProgramTittle());
	    Assert.assertEquals(getManageProgramTittle(),element);
	    }
	    else if (element.equalsIgnoreCase("LMS - Learning Management System")){
	    	//String LMStittle= testSetupManager.pageObjectManager.getDashboard().getLMSTittle();
		    System.out.println(getLMSTittle());
		    Assert.assertEquals(getLMSTittle(),element);
		    
		    }
	    */
	}
	
	@Then("Admin should see elements in the number of place")
	public void admin_should_see_elements_in_the_number_of_place() {
	
		for(int i=0;i<navigationelement.size();i++)
		{
			if(i==0)
			{
			String element= navigationelement.get(i).getText();
			Assert.assertEquals(element, "Program");
			Assert.assertEquals(i, 0);
			System.out.println(element + " position is " + i);
			}
			else if(i==1) 
			{
				String element= navigationelement.get(i).getText();
				Assert.assertEquals(element, "Batch");
				Assert.assertEquals(i, 1);
				System.out.println(element + " position is " + i);
			}else if(i==2)
			{
				String element= navigationelement.get(i).getText();
				Assert.assertEquals(element, "User");
				Assert.assertEquals(i, 2);
				System.out.println(element + " position is " + i);
			}
			
		}
		
		
		/*
		testSetupManager.reusablemethod.explicitWait(dashboard);
	   // boolean  dashboard=testSetupManager.pageObjectManager.getlogin().getDashboard();
	    Assert.assertEquals(dashboard,true );
	    System.out.println("user is in dashboard page");

	    List<WebElement> list= getDashboard().navigationelement;
	    
	    Assert.assertEquals(element,list.get(position).getText()); 
	    System.out.println(element + "is in "+ position +" position");
	    */
	    
	}
	
	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {
		System.out.println(LMSToolbar.getLocation());
		
	}
	
	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() {
		System.out.println(LMSToolbar.getLocation());
	}

	
//Navigation time
	/*@When("Admin enter valid credentials & clicks login button  {string} and {int}")
	public void admin_enter_valid_credentials_clicks_login_button_and(String sheetname, Integer rownum) {
	    
		testSetupManager.reusablemethod.explicitWait(login.username);
		login.userlog(sheetname,rownum);
		
		long start = System.currentTimeMillis();
		System.out.println(start);
		login.clickSubmit();
		long finish = System.currentTimeMillis();
		System.out.println(finish);
		
		totalTime = finish - start;
		System.out.println("Total Time for page load - "+totalTime);
		
		
		
	}*/
	
	
//Logout
	
	@When("Admin click Logout button on navigation bar")
	public void admin_click_logout_button_on_navigation_bar() {
		logout();
		System.out.println("Logout successfull");
	}

	@Then("Admin should land on login in page")
	public void admin_should_land_on_login_in_page() {
	    
		
		Assert.assertEquals(login.getTittle(),true );
		
		System.out.println("user in main login page");
	}
	
}
