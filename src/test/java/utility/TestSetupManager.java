package utility;

import java.io.IOException;

import PageObject.PageObjectManager;

public class TestSetupManager {

	public PageObjectManager pageObjectManager;
	public TestBase testbase;
	public reusableMethods reusablemethod;
	//public WebDriverManager webdrivermngr;

	
	public TestSetupManager() throws IOException {
		testbase= new TestBase();
		
		pageObjectManager= new PageObjectManager(testbase.WebDriverManager());
	    reusablemethod= new reusableMethods(testbase.WebDriverManager());
	    //webdrivermngr= new WebDriverManager();
		//pageObjectManager= new PageObjectManager(webdrivermngr.getDriver());
		//reusablemethod= new reusableMethods(webdrivermngr.getDriver());

	}
}
