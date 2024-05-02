package stepDefinations;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utility.TestSetupManager;

public class Hooks {

	TestSetupManager testSetupManager;
	
	public Hooks(TestSetupManager testSetupManager) {
		
		this.testSetupManager= testSetupManager;
	
		
	}
	
	@After
	public void CloseBrowser() throws IOException {
		//testSetupManager.testbase.WebDriverManager().manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		//testSetupManager.testbase.WebDriverManager().quit();
		//testSetupManager.webdrivermngr.getDriver().quit();
	}

	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException
	{
		WebDriver driver =testSetupManager.testbase.WebDriverManager();
		
		if(scenario.isFailed()) {
			byte[] screenshottaken= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshottaken, "image/png", "errorscreen");
			
			
			}
		/*
		if(scenario.isFailed())
		{
		//screenshot
			
		File sourcePath= 	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
		scenario.attach(fileContent, "image/png", "image");
		
		}*/
	}
}
