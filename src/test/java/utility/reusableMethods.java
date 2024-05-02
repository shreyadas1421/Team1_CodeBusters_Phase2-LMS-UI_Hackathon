package utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class reusableMethods {

	static WebDriver driver;
	Actions action;
	
	public reusableMethods(WebDriver driver) {
		
		this.driver=driver;
	
	}
	
	
//	public void explicitWait(WebElement item) {
//		
//		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
//		 wait.until(ExpectedConditions.visibilityOf(item));
//		
//	}
	
	public Actions action() {
		action = new Actions(driver);
		
		return action;
	}
	public static void  explicitWait(WebElement item) {
		
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		 wait.until(ExpectedConditions.elementToBeClickable(item));
		
	}
	public static void flentWait(WebElement element) {
		FluentWait<WebDriver> wait = new FluentWait<>(driver)
	            .withTimeout(Duration.ofSeconds(30))
	            .pollingEvery(Duration.ofSeconds(2));
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	    element.click();
	
	}
	
	public static void scrollToElement(WebElement element) {
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView(true);", element);
   }

	
	public static void sendkeys(WebElement element, String inptValue) {
		
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		//wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(inptValue);
		element.sendKeys(inptValue);
	}

	public static void click(WebElement element) {
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		//wait.until(ExpectedConditions.visibilityOf(element)).click();;
		element.click();
		
	}
	
	public static boolean isElementpresent(WebElement element) {
		if(element.isDisplayed()) {
			return true;
		}
		return false;
		
	}
	
	public static boolean isEnabled(WebElement element) {
	if(element.isEnabled()) {
		return true;
	}
	return false;
}
	
	
	public  static void selectProgram(String programName, WebElement search) {
		search.clear();
		reusableMethods.sendkeys(search, programName);
		
		
	}
	
	public static String CreationMsgValidation(String xpath)  {
		String ActualMsg;
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		
		WebElement msg = driver.findElement(By.xpath(xpath));	
		wait.until(ExpectedConditions.visibilityOf(msg));
		ActualMsg=msg.getText();
		//toastMsgClose();
		
		System.out.println("actual msg: "+ActualMsg);
		wait.until(ExpectedConditions.invisibilityOf(msg));
		return ActualMsg;
		
	}
	
	
	
}
