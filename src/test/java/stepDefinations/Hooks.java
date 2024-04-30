package stepDefinations;

import java.io.IOException;
import java.time.Duration;

import io.cucumber.java.After;
import utility.TestSetupManager;

public class Hooks {

	TestSetupManager testSetupManager;
	
	public Hooks(TestSetupManager testSetupManager) {
		
		this.testSetupManager= testSetupManager;
	
		
	}
	
	@After
	public void CloseBrowser() throws IOException {
		//testSetupManager.testbase.WebDriverManager().manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		testSetupManager.testbase.WebDriverManager().quit();
		//testSetupManager.webdrivermngr.getDriver().quit();
	}
}
