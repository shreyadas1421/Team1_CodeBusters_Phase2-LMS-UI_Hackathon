package utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class reusableMethods {

	WebDriver driver;
	Actions action;
	
	public reusableMethods(WebDriver driver) {
		
		this.driver=driver;
	
	}
	
	
	public void explicitWait(WebElement item) {
		
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		 wait.until(ExpectedConditions.visibilityOf(item));
		
	}
	
	public Actions action() {
		action = new Actions(driver);
		
		return action;
	}
	
	
	
}
