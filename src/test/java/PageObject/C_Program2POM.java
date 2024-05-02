package PageObject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.plaf.basic.BasicCheckBoxMenuItemUI;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.TestBase;
import utility.reusableMethods;


public class C_Program2POM extends TestBase {
	
	public String heading;
	String programName ;
	List<String> programNames = new ArrayList<String>();
	
	
	@FindBy(xpath = "//*[text() = 'Program']") public WebElement program;
	@FindBy(xpath = "(//*[@id='deleteProgram'])[1]")public WebElement btn_delete;
	@FindBy(xpath = "//*[text() = 'Confirm']") public WebElement heading_delete_confirm;
	@FindBy(xpath = "//*[contains(@class , ' p-dialog-header-icon p-dialog-header-close p-link ng-star-inserted')]")public WebElement closebtn;
	
	@FindBy(xpath = "//*[text() = 'No']") public WebElement confirm_No_btn;
	@FindBy(xpath = "//*[text() = 'Yes']") public WebElement confirm_Yes_btn;
	@FindBy(xpath = "//*[@class='p-datatable-tbody']//tr[1]//td[2]") private WebElement programNameToDelte;
	@FindBy(xpath = "//*[contains(text(), 'Are you sure you want to delete ')]") private WebElement deleteMessage;
	
	@FindBy(xpath = "(//tr[@class = 'ng-star-inserted'])[2]//td[1]//*[@role = 'checkbox']") WebElement checkbox;
	@FindBy(xpath = "(//*[@role = 'checkbox'])[2]") WebElement paricularCheckbox;
	@FindBy(id = "filterGlobal")public WebElement SeachText;
	
	@FindBy(xpath = "//*[@class = 'ng-tns-c133-4']") WebElement messageDialogbox;
	
	@FindBy(xpath = "//*[@class = 'p-button-danger p-button p-component p-button-icon-only']")public WebElement deleteAllbtn;
	@FindBy(xpath = "((//tr[@class = 'ng-star-inserted'])[2]//td[1]//*[@role = 'checkbox']/following::td)[1]")
	WebElement programnameselectedformultiplrdelete;
	
	@FindBys(value = { @FindBy(how = How.XPATH, using = "(//*[@class = 'p-datatable-tbody']//tr//td)//*[@role = 'checkbox']") })
	List<WebElement> multiplecheckBoxes;
	
	//@FindBy(xpath = "//*[@class = 'p-d-flex p-ai-center p-jc-between ng-star-inserted']") WebElement totalprogramsInfo;
	
	@FindBy(xpath = "//*[@psortablecolumn = 'programName']//i")public WebElement programeNameSortIcon;
	@FindBy(xpath = "//*[@psortablecolumn = 'programDescription']//i")public WebElement programdescriptionSortIcon;
	@FindBy(xpath = "//*[@psortablecolumn = 'programStatus']//i")public WebElement programStatusSortIcon;
	
	@FindBy(xpath = "(//*[@type = 'button']//span)[3]")public WebElement nextPageLink;
	@FindBy(xpath = "(//*[@type = 'button']//span)[4]")public WebElement lastPageLink;
	@FindBy(xpath = "(//*[@type = 'button']//span)[1]")public WebElement startPageLink;
	@FindBy(xpath = "(//*[@type = 'button']//span)[2]")public WebElement previousPageLink;
	
	@FindBy(xpath = "//*[text() = 'Batch']")public WebElement batchLink;
	@FindBy(xpath = "//*[text() = ' Manage Batch']")public WebElement batchHeading;
	
	@FindBy(xpath = "//*[text() = 'User']")public WebElement userLink;
	@FindBy(xpath = "//*[text() = ' Manage User']")public WebElement userHeading;
	
	@FindBy(xpath = "//button[@id= 'logout']")public WebElement logoutLink;
	@FindBy(xpath = "//*[text() = 'Please login to LMS application']")public WebElement lmsLoginInfopageHeading;
	
	@FindBys(value = { @FindBy(how = How.XPATH, using = "//*[@class = 'p-paginator-pages ng-star-inserted']//button") })
	List<WebElement> pagesCount;
	
	@FindBys(value = { @FindBy(how = How.XPATH, using = "//*[@class = 'p-datatable-tbody']//tr//td[2]") })
	public List<WebElement> programCountInEachPage;
	@FindBys(value = { @FindBy(how = How.XPATH, using = "//*[@class = 'p-datatable-tbody']//tr//td[3]") })
	public List<WebElement> programdescriptionInEachPage;
	
	@FindBys(value = { @FindBy(how = How.XPATH, using = "//*[@class = 'p-datatable-tbody']//tr//td[4]") })
	public List<WebElement> programStatusInEachPage;
	
	@FindBy(xpath = "//*[@class = 'p-d-flex p-ai-center p-jc-between ng-star-inserted']") public WebElement totalCountOfPrograms;
	
	
	public void selectProgram(String programName) {
		SeachText.clear();
		reusableMethods.sendkeys(SeachText, programName);
		clickOnCheckbox(programName);
		
	}
	
	public void selectProgramforDeleteAllbtn(String programName) {
		SeachText.clear();
		reusableMethods.sendkeys(SeachText, programName);
		reusableMethods.explicitWait(paricularCheckbox);
		if(!paricularCheckbox.isSelected()) {
			reusableMethods.click(paricularCheckbox) ;
		}
		
	}
	
	
	public String confirmDelete() {
		
		boolean yes = reusableMethods.isElementpresent(confirm_Yes_btn);
		boolean no = reusableMethods.isElementpresent(confirm_No_btn);

		if(yes && no) {
			heading = heading_delete_confirm.getText();
			
		}
		
		return heading;
	}
	
	
	
	public String ConfirmDeletemessageProgramName() {
		
		return deleteMessage.getText();
	}
	
	public String ProgramName() {
		return programNameToDelte.getText();
		
	}
	
	public void clickOnNobtn() {
		reusableMethods.click(confirm_No_btn);
	}
	public void clickOnYesbtn() {
		reusableMethods.click(confirm_Yes_btn);
	}
	
	public void clickOnCheckbox(String recordName) {
		//String dynamicCheckboxpath = "//*[@class = 'p-datatable-tbody']//tr//td[text() ='"+recordName+"' ]/preceding-sibling::td[1]//*[@role = 'checkbox']";
		String dynamicCheckboxpath = "//*[@class = 'p-datatable-tbody']//tr//td[contains(text(), '"+recordName+"') ]/preceding-sibling::td[1]//*[@role = 'checkbox']";

		driver.findElement(By.xpath(dynamicCheckboxpath)).click();
		//reusableMethods.click(checkbox);
	}
	
	public boolean isdeletedprogramNamepresent() {
		return reusableMethods.isElementpresent(programnameselectedformultiplrdelete);
	}
	public boolean isProgramChecked() {
		if(checkbox.getAttribute("aria-checked").equalsIgnoreCase("true")) {
			System.out.println("check box is checked  --" +checkbox.getAttribute("aria-checked"));
			return true;
		}
		return false;
	}
	
	
	public String getSuccessMessage() {
		return messageDialogbox.getText();
	}
	
	public void clickOnprogramSortIcon() {
		reusableMethods.click(programeNameSortIcon);
	}
	public void clickOnProgramDescriptionSortIcon() {
		reusableMethods.click(programdescriptionSortIcon);
	}
	public void clickOnProgramStatusSortIcon() {
		reusableMethods.click(programStatusSortIcon);
	}
	
	
	public String verifyBatchheading() {
		return batchHeading.getText();
	}
	
	public String verifyUserheading() {
		return userHeading.getText();
	}
	public String verifyLoginPage() {
		return lmsLoginInfopageHeading.getText();
	}
	
	public int highligtedPageNumber() {
		int highlightedPage=0;
		for(WebElement page : pagesCount) {
			String attributevalue = page.getAttribute("class");
			if(attributevalue.contains("p-highlight")) {
				String highlightedPageString = page.getText();
				//System.out.println("string page number + + + + " +highlightedPageString);
				highlightedPage = Integer.parseInt(highlightedPageString);
				
			}
			
		}
		return highlightedPage;
		
	}
	
	public int pagesCountMethod() {
		if(!reusableMethods.isEnabled(lastPageLink)) {
			lastPageLink.click();
			return highligtedPageNumber();
		}
		System.out.println("frompages count method - - - - - -  " +highligtedPageNumber() );
		return highligtedPageNumber();
		
	}
	
	public void clickOnMultiplecheckBoxes() {
		for(WebElement Cbox: multiplecheckBoxes) {
			reusableMethods.click(Cbox);
		}
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
	public  int getCountOfRecords() {
		String paginationText = totalCountOfPrograms.getText().trim();
		String[] parts = paginationText.split(" ");
		System.out.println(parts.length);
		System.out.println(parts[0]  +"  " + parts[1] + "  " +parts[2]  +"  " + parts[4]);
		int count = 0;
		try {
	        count = Integer.parseInt(parts[4]);
	    } catch (NumberFormatException e) {
	        System.err.println("Error parsing integer from parts[4]: " + e.getMessage());
	    }
	    return count;
		
		
	}
	
}
	
	
	
	

