package stepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.TestSetupManager;

public class LogInPage {



	TestSetupManager testSetupManager;

	public LogInPage(TestSetupManager testSetupManager) {
		this.testSetupManager= testSetupManager;
	}
	
	//Positive_01	
	
		@Given("Admin launch the browser")
		public void admin_launch_the_browser() {
			System.out.println("initialize the browser");
		}
		
		@When("Admin gives the correct LMS portal URL")
		public void admin_gives_the_correct_lms_portal_url() throws IOException {
			String urlActual=testSetupManager.testbase.WebDriverManager().getCurrentUrl();
			String urlExpected="https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/login";
			Assert.assertEquals(urlActual, urlExpected);
			System.out.println("launch valid url");
		
		}
		
		@Then("Admin should land on the home page with all {string}")
		public void admin_should_land_on_the_home_page_with_all(String element) {
			
			testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().username);
			
			if(element.equalsIgnoreCase("pageTittle"))
			{	boolean  LogInPageTittle=testSetupManager.pageObjectManager.getlogin().getTittle();
					//System.out.println(LogInPageTittle);
					Assert.assertEquals(LogInPageTittle,true );
					System.out.println("Page Tittle validated");
					}
		
				else if(element.equalsIgnoreCase("logo"))
				{
					boolean  logo=testSetupManager.pageObjectManager.getlogin().getLogo();
					//System.out.println(LogInPageTittle);
					Assert.assertEquals(logo,true );
					System.out.println("Logo validated");
				}
				else if(element.equalsIgnoreCase("LoginText"))
				{
					boolean  LoginText=testSetupManager.pageObjectManager.getlogin().getText();
					//System.out.println(LogInPageTittle);
					Assert.assertEquals(LoginText,true );
					System.out.println("Text field of login details validated");
				}
				else if (element.equalsIgnoreCase("countofTxtField"))
				{
					int count=testSetupManager.pageObjectManager.getlogin().getTextboxcount();
					Assert.assertEquals(count,2 );
					System.out.println(count);
				}else if(element.equalsIgnoreCase("Login"))
				{
					boolean  LoginButton=testSetupManager.pageObjectManager.getlogin().getLoginbutton();
					Assert.assertEquals(LoginButton,true );
					System.out.println("LoginButton is present");
				}else if(element.equalsIgnoreCase("User"))
				{
					String user=testSetupManager.pageObjectManager.getlogin().username.getAttribute("data-placeholder");
					System.out.println(testSetupManager.pageObjectManager.getlogin().username.getAttribute("data-placeholder"));
					String userText="User";
					Assert.assertEquals(user,userText );
					
					String rgbFormat = testSetupManager.pageObjectManager.getlogin().username.getCssValue("color");

					System.out.println(rgbFormat);     //In RGB Format the value will be print

					String hexcolor = Color.fromString(rgbFormat).asHex(); //converted Into HexFormat
					System.out.println(hexcolor);// Output of Hex code
					
				}else if(element.equalsIgnoreCase("Password"))
				{
					String user=testSetupManager.pageObjectManager.getlogin().password.getAttribute("data-placeholder");
					System.out.println(testSetupManager.pageObjectManager.getlogin().password.getAttribute("data-placeholder"));
					String userText="Password";
					Assert.assertEquals(user,userText );
					
					String rgbFormat = testSetupManager.pageObjectManager.getlogin().password.getCssValue("color");

					System.out.println(rgbFormat);     //In RGB Format the value will be print

					String hexcolor = Color.fromString(rgbFormat).asHex(); //converted Into HexFormat
					System.out.println(hexcolor);// Output of Hex code
					
				}
					
				System.out.println("user in main login page");
				
		}
		

		
		@Then("Admin should see {string} on the centre of the page")
		public void admin_should_see_on_the_centre_of_the_page(String element) {
	
			if(element.equalsIgnoreCase("Login")) {
				WebElement submit= testSetupManager.pageObjectManager.getlogin().submit;
				Rectangle button=submit.getRect();
				
				System.out.println("X cord->" + button.x+ ""+ button.getX());
				System.out.println("Y cord->" + button.y+ ""+ button.getY());
				System.out.println("widgth cord->" + button.width+ ""+ button.getWidth());
				System.out.println("height cord->" + button.height+ ""+ button.getHeight());

			}else if (element.equalsIgnoreCase("TextFields")) {
				
				List<WebElement> inputfield=testSetupManager.pageObjectManager.getlogin().txtBox;
				int count=inputfield.size();
				
				for(int i=0;i<count;i++) {
					Rectangle inputfld=inputfield.get(i).getRect();
					
					System.out.println("X cord->" + inputfld.x+ ""+ inputfld.getX());
					System.out.println("Y cord->" + inputfld.y+ ""+ inputfld.getY());
					System.out.println("widgth cord->" + inputfld.width+ ""+ inputfld.getWidth());
					System.out.println("height cord->" + inputfld.height+ ""+ inputfld.getHeight());
				}
				}
					}

//Positive_02

		@Given("Admin is in Home Page")
		public void admin_is_in_home_page()  {
		testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().username);
		
		boolean  LogInPageTittle=testSetupManager.pageObjectManager.getlogin().getTittle();
		//System.out.println(LogInPageTittle);
		Assert.assertEquals(LogInPageTittle,true );
		
		System.out.println("user in main login page");
		
	}
	
		@When("Admin enter valid credentials  and clicks login button  {string} and {int}")
		public void admin_enter_valid_credentials_and_clicks_login_button_and(String sheetname, Integer rownum) throws InterruptedException
		{
	
		testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().username);
		testSetupManager.pageObjectManager.getlogin().userlog(sheetname,rownum);
		testSetupManager.pageObjectManager.getlogin().clickSubmit();
	}
	
		@Then("Admin should land on dashboard page")
		public void admin_should_land_on_dashboard_page() {
		
		testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().dashboard);
	    boolean  dashboard=testSetupManager.pageObjectManager.getlogin().getDashboard();
	    Assert.assertEquals(dashboard,true );
	    System.out.println("user is in dashboard page");
	}
	
		

		@When("Admin enter valid credentials  and clicks login button through keyboard {string} and {int}")
		public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard_and(String sheetname, Integer rownum) {
			
			testSetupManager.pageObjectManager.getlogin().userlog(sheetname,rownum);
			
			WebElement submit= testSetupManager.pageObjectManager.getlogin().submit;
			
			submit.sendKeys(Keys.TAB);
			testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().submit);

			submit.sendKeys(Keys.ENTER);
			//testSetupManager.reusablemethod.action().keyDown(Keys.TAB).sendKeys("Login").build().perform();
		}

		@When("Admin enter valid credentials  and clicks login button through mouse {string} and {int}")
		public void admin_enter_valid_credentials_and_clicks_login_button_through_mouse_and(String sheetname, Integer rownum) {
			
			testSetupManager.pageObjectManager.getlogin().userlog(sheetname,rownum);
			WebElement submit= testSetupManager.pageObjectManager.getlogin().submit;
			testSetupManager.reusablemethod.action().moveToElement(submit).click().perform();
		}
		
		
		
//Negative
		

		@When("Admin gives the invalid LMS portal URL")
		public void admin_gives_the_invalid_lms_portal_url() throws IOException {
			String urlActual=testSetupManager.testbase.WebDriverManager().getCurrentUrl();
			System.out.println(urlActual);
			System.out.println(testSetupManager.testbase.WebDriverManager().getTitle());
			System.out.println(testSetupManager.testbase.WebDriverManager().getPageSource()) ;


			String urlExpected="https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/login";
			Assert.assertEquals(urlActual, urlExpected);
			System.out.println("invalid url");
			
			/*	if ( pageSource.contains("404") ) {
				assertTrue(true, "404 not found error." );
			}*/

		}
		

		@Then("Admin should recieve {int} page not found error")
		public void admin_should_recieve_page_not_found_error(Integer int1) throws IOException {
			System.out.println(testSetupManager.testbase.WebDriverManager().getPageSource()) ;
			System.out.println(testSetupManager.testbase.WebDriverManager().getTitle());
		}
		
		@When("Admin enter invalid credentials  and clicks login button   {string} and {int}")
		public void admin_enter_invalid_credentials_and_clicks_login_button_and(String sheetname, Integer rownum) throws InterruptedException {

	
		testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().username);
		testSetupManager.pageObjectManager.getlogin().userlog(sheetname,rownum);
		testSetupManager.pageObjectManager.getlogin().clickSubmit();
		
	}
		/*
		@Then("Error message please check username\\/password")
		public void error_message_please_check_username_password() {
			testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().loginErrormsg);
			String  loginerrormsg=testSetupManager.pageObjectManager.getlogin().getErrormsg();
			String actualErrormsg="please check username/password";
		    Assert.assertEquals(loginerrormsg,actualErrormsg ); 
		    System.out.println(loginerrormsg);
		}*/
		
		@Then("Validate {string} in login failure please check username\\/password")
		public void validate_in_login_failure_please_check_username_password(String Actualerrormsg) {
		   
			if(Actualerrormsg.equalsIgnoreCase("please check username/password"))
			{
				testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().loginErrormsg);
				String  loginerrormsg=testSetupManager.pageObjectManager.getlogin().getErrormsg();
			    Assert.assertEquals(loginerrormsg,Actualerrormsg ); 
			    System.out.println(loginerrormsg);
			}
			else if(Actualerrormsg.equalsIgnoreCase("Please enter your user name"))
			{
				testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().username);
				String  loginerrormsg1=testSetupManager.pageObjectManager.getlogin().getErrormsg1();
				Assert.assertEquals(loginerrormsg1,Actualerrormsg ); 
				System.out.println(loginerrormsg1);
			}
			else {
				System.out.println("No error message displayed");
			}
		}
		
		@When("Admin enter value only in password and clicks login button   {string} and {int}")
		public void admin_enter_value_only_in_password_and_clicks_login_button_and(String sheetname, Integer rownum) {
			testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().username);
			testSetupManager.pageObjectManager.getlogin().userlog(sheetname,rownum);
			testSetupManager.pageObjectManager.getlogin().clickSubmit();
		}

		@When("Admin enter value only in username and clicks login button   {string} and {int}")
		public void admin_enter_value_only_in_username_and_clicks_login_button_and(String sheetname, Integer rownum) {
			testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().username);
			testSetupManager.pageObjectManager.getlogin().userlog(sheetname,rownum);
			testSetupManager.pageObjectManager.getlogin().clickSubmit();
		}
}
