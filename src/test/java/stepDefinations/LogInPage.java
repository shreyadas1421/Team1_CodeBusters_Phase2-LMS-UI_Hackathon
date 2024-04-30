package stepDefinations;

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

	@Given("user navigate to the login page")
	public void user_navigate_to_the_login_page() {
		testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().username);

		boolean  LogInPageTittle=testSetupManager.pageObjectManager.getlogin().getTittle();
		//System.out.println(LogInPageTittle);
		Assert.assertEquals(LogInPageTittle,true );

		System.out.println("user in main login page");

	}

	@When("user enter valid user id & password {string} and {int}")
	public void user_enter_valid_user_id_password_and(String sheetname, Integer rownum) {
		testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().username);

		testSetupManager.pageObjectManager.getlogin().userlog(sheetname,rownum);
	}

	@Then("user should be in home page")
	public void user_should_be_in_home_page() {

		testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().dashboard);
		boolean  dashboard=testSetupManager.pageObjectManager.getlogin().getDashboard();
		Assert.assertEquals(dashboard,true );
		System.out.println("user is in dashboard page");
	}




}
