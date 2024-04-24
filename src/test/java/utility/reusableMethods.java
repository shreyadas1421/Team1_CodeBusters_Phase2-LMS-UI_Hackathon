package utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class reusableMethods {

	WebDriver driver;
	
	
	public reusableMethods(WebDriver driver) {
		
		this.driver=driver;
	
	}
	
	
	public void explicitWait(WebElement item) {
		
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		 wait.until(ExpectedConditions.visibilityOf(item));
		
	}
	
}
