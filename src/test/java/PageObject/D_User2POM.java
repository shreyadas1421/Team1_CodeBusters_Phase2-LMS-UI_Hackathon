package PageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import utility.TestBase;

public class D_User2POM extends TestBase {
	
	
	@FindBy(xpath = "//*[text() = 'User']")public WebElement userLink;
	@FindBy(id = "filterGlobal")public WebElement SeachText;
	@FindBy(xpath = "(//*[@icon = 'pi pi-trash'])[2]")public WebElement btn_delete;
	
	@FindBy(xpath = "//*[text() = 'Confirm']") public WebElement heading_delete_confirm;
	@FindBy(xpath = "//*[text() = 'No']") public WebElement confirm_No_btn;
	@FindBy(xpath = "//*[text() = 'Yes']") public WebElement confirm_Yes_btn;
	
	@FindBy(xpath = "//*[@class = 'p-button-danger p-button p-component p-button-icon-only']")public  WebElement deleteAllbtn;
	@FindBy(xpath = "(//tr[@class = 'ng-star-inserted'])[2]//td[1]//*[@role = 'checkbox']") WebElement checkbox;
	
	@FindBy(xpath = "//*[@field = 'userId']//i")public WebElement userIdSortIcon;
	@FindBy(xpath = "//*[@field = 'userFirstName']//i")public WebElement userNameSortIcon;
	@FindBy(xpath = "//*[@field = 'userLocation']//i")public WebElement userLocationSortIcon;
	@FindBy(xpath = "//*[@field = 'userPhoneNumber']//i")public WebElement userPhoneNumberSortIcon;
	@FindBy(xpath = "(//*[@type = 'button']//span)[1]")public WebElement startPageLink;
	
	@FindBys(value = { @FindBy(how = How.XPATH, using = "//*[@class = 'p-datatable-tbody']//tr//td[2]") })
	public List<WebElement> userIdsInEachPage;
	@FindBys(value = { @FindBy(how = How.XPATH, using = "//*[@class = 'p-datatable-tbody']//tr//td[3]") })
	public List<WebElement> userNamesInEachPage;
	@FindBys(value = { @FindBy(how = How.XPATH, using = "//*[@class = 'p-datatable-tbody']//tr//td[4]") })
	public List<WebElement> userLocationInEachPage;
	@FindBys(value = { @FindBy(how = How.XPATH, using = "//*[@class = 'p-datatable-tbody']//tr//td[5]") })
	public List<WebElement> userPhonenumberInEachPage;
	
	
	
	public void clickOnCheckbox(String recordName) {
		String dynamicCheckboxpath = "//*[@class = 'p-datatable-tbody']//tr//td[contains(text(),'"+recordName+"')]/preceding-sibling::td[2]//*[@role = 'checkbox']";

		driver.findElement(By.xpath(dynamicCheckboxpath)).click();
		
	}
	public boolean isProgramChecked() {
		if(checkbox.getAttribute("aria-checked").equalsIgnoreCase("true")) {
			System.out.println("check box is checked  --" +checkbox.getAttribute("aria-checked"));
			return true;
		}
		return false;
	}
	
	public List<String> getProgramNames(List<WebElement> elements)  {
	    List<String> programNames = new ArrayList<String>();
	    boolean hasNextPage = true;

	    do {
	        for (WebElement program : elements) {
	            String name = program.getText();
	            programNames.add(name);
	        }
	        try {
	            WebElement nextPageLink = driver.findElement(By.xpath("//*[@class = 'p-paginator-next p-paginator-element p-link p-ripple']"));
	            nextPageLink.click();
	        } catch (NoSuchElementException e) {
	            hasNextPage = false; 
	        }
	    } while (hasNextPage);

	    return programNames;
	
	}
	


	
}
