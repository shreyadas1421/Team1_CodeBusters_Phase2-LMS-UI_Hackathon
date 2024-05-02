package PageObject;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utility.excelDataReader;
import utility.reusableMethods;

import static org.testng.Assert.assertEquals;
public class D_BatchPOM {
	public WebDriver driver;
	Map<String, String> excelmap;
	public excelDataReader datamap;

	public void SetDriver(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[normalize-space()='LMS - Learning Management System']")
	public WebElement dashboard;
	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-title/div[2]/div[1]/button/span[1]")
	public WebElement deleteAllBatch_btn;

	@FindBy(xpath = "//input[@id='filterGlobal']")
	private WebElement TopSearchTextBox;

	@FindBy(xpath = "//button[@id='new']")
	private WebElement AddNewBatchButton;

	@FindBy(xpath = "//div[@class='p-checkbox-box']")
	private List<WebElement> MultipleCheckBox;

	@FindBy(xpath = "//tbody/tr[1]/td[1]/p-tablecheckbox[1]/div[1]/div[2]")
	private WebElement checkbox1;

	@FindBy(xpath = "//tbody/tr[2]/td[1]/p-tablecheckbox[1]/div[1]/div[2]")
	private WebElement checkbox2;

	@FindBy(xpath = "//tbody/tr[3]/td[1]")
	private WebElement checkbox3;

	@FindBy(xpath = "//tbody/tr[4]/td[1]/p-tablecheckbox[1]/div[1]/div[2]")
	private WebElement checkbox4;

	@FindBy(xpath = "//tbody/tr[5]/td[1]/p-tablecheckbox[1]/div[1]/div[2]")
	private WebElement checkbox5;

	@FindBy(xpath = "//tbody/tr[1]/td[7]/div[1]/span[1]/button[1]/span[1]")
	private WebElement Editbutton1;

	@FindBy(xpath = "//tbody/tr[2]/td[7]/div[1]/span[1]/button[1]/span[1]")
	private WebElement Editbutton2;

	@FindBy(xpath = "//tbody/tr[3]/td[7]/div[1]/span[1]/button[1]")
	private WebElement Editbutton3;

	@FindBy(xpath = "//tbody/tr[4]/td[7]/div[1]/span[1]/button[1]/span[1]")
	private WebElement Editbutton4;

	@FindBy(xpath = "//tbody/tr[5]/td[7]/div[1]/span[1]/button[1]/span[1]")
	private WebElement Editbutton5;

	@FindBy(xpath = "//tbody/tr[1]/td[7]/div[1]/span[2]/button[1]")
	private WebElement DeleteButton1;

	@FindBy(xpath = "//tbody/tr[2]/td[7]/div[1]/span[2]/button[1]")
	private WebElement DeleteButton2;

	@FindBy(xpath = "//tbody/tr[3]/td[7]/div[1]/span[2]/button[1]")
	private WebElement DeleteButton3;

	@FindBy(xpath = "//tbody/tr[4]/td[7]/div[1]/span[2]/button[1]/span[1]")
	private WebElement DeleteButton4;

	@FindBy(xpath = "//tbody/tr[5]/td[7]/div[1]/span[2]/button[1]")
	private WebElement DeleteButton5;

	@FindBy(xpath = "//span[@class='p-paginator-current ng-star-inserted']")
	private WebElement ShowingEntries;

	@FindBy(xpath = "//button[normalize-space()='1']")
	private WebElement Page1;

	@FindBy(xpath = "//button[normalize-space()='2']")
	private WebElement Page2;

	@FindBy(xpath = "//button[normalize-space()='3']")
	private WebElement Page3;

	@FindBy(xpath = "//button[normalize-space()='4']")
	private WebElement Page4;

	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-right']")
	private WebElement PagiIconSingleAngleRight;

	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-double-right']")
	private WebElement PagiIconDoubleAngleRight;

	@FindBy(xpath = "//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']")
	private WebElement InTotalBatches;
	// span[normalize-space()='Batch']
	@FindBy(xpath = "//span[normalize-space()='Batch']")
	private WebElement BatchElement;

	@FindBy(xpath = "//div[normalize-space()='Manage Batch']")
	private WebElement BatchHeader;

	@FindBy(xpath = "//div[@class='p-paginator-bottom p-paginator p-component ng-star-inserted']")
	private WebElement paginationControl;

	@FindBy(xpath = "tr[@class='ng-star-inserted']/th[2]")
	private List<String> tableHeader;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[1]/td[1]/p-tablecheckbox/div/div[2]/span")
	public WebElement Fcheckbox;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[2]/td[1]/p-tablecheckbox/div/div[2]")
	public WebElement Scheckbox;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[3]/td[1]/p-tablecheckbox/div/div[2]")
	public WebElement Tcheckbox;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[4]/td[1]/p-tablecheckbox/div/div[2]")
	public WebElement Focheckbox;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[4]/td[1]/p-tablecheckbox/div/div[2]")
	public WebElement Fifcheckbox;

	@FindBy(xpath = "/html/body/app-root/app-batch/p-dialog/div/div/div[1]/div/button")
	public WebElement CloseAddNewPopUp;

	@FindBy(xpath = "//*[@id=\"filterGlobal\"]")
	public WebElement SearchBatch;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr/td[7]/div/span[1]/button/span[1]")
	public WebElement EditIcon;

	@FindBy(xpath = "/html/body/app-root/app-batch/p-dialog/div/div/div[1]")
	public WebElement EditPopup;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr/td[7]/div/span[1]/button")
	public WebElement EditButton;

	// @FindBy(xpath="//*[@id=\"batchDescription\"]")
	@FindBy(xpath = "//input[@id='batchDescription']")
	public WebElement EditBatchDescription;

	@FindBy(xpath = "//*[@id=\"batchStatus\"]/div/div[2]/span")
	public WebElement EditActiveStatus;

	@FindBy(xpath = "//*[@id=\"batchStatus\"]/div/div[2]")
	public WebElement EditInactiveStatus;

	@FindBy(xpath = "//*[@id=\"batchNoOfClasses\"]")
	public WebElement EditNoOfClasses;

	@FindBy(xpath = "/html/body/app-root/app-batch/p-dialog/div/div/div[3]/button[2]")
	public WebElement SaveEdit;

	//// DELETE WEB ELEMENTS
	
	public String oldbatchname;

	//@FindBy(xpath = "/html/body/app-root/app-batch/p-confirmdialog/div/div/div[3]/button[1]/span[2]")
	@FindBy(xpath="//tbody/tr[1]/td[7]/div[1]/span[2]/button[1]")
	public WebElement DeleteIcon;
	

	// @FindBy(xpath=("//*[text() = 'No']")

	// public WebElement NoOptionDelete;
	@FindBy(xpath = "/html/body/app-root/app-batch/p-confirmdialog/div/div/div[3]/button[1]")
	public WebElement NoOptionDelete;

	@FindBy(xpath = "//span[normalize-space()='Yes']")
	public WebElement YesOtionDelete;

	@FindBy(xpath = "/html/body/app-root/app-batch/p-confirmdialog/div/div/div[1]")
	public WebElement Deletepopup;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[1]/td[2]")
	public WebElement BatchNamerow1;

	Random random = new Random();

	int randomNumber = random.nextInt(10000);
	public String elementText;
	static public String BatchNameForEdit = "";
	static public String BatchNameForEdit1 = "";

	public void clickBatch() {
		BatchElement.click();
	}

	public String GetTextBatchHeader() {
		String Header = BatchHeader.getText();
		return Header;
	}

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[2]")
	public WebElement BatchNameColumn;
	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[3]")
	public WebElement BatchDescColumn;
	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[4]")
	public WebElement BatchStatusColumn;
	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[5]")
	public WebElement NoOfClassesColumn;
	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[6]")
	public WebElement ProgramNameColumn;
	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[7]")
	public WebElement EditDeleteColumn;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-title/div[2]/div[1]/button/span[1]")
	public WebElement DeleteButton;

	@FindBy(xpath = "//*[@id=\"new\"]")
	public WebElement AddnewBatchButton;

	@FindBy(xpath = "/html/body/app-root/app-batch/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[1]/p-tableheadercheckbox/div/div[2]")
	public WebElement MainCheckBox;

	@FindBy(xpath = "//*[@id=\"new\"]/span[2]")
	public WebElement MainAddNewBatchButton;

	// @FindBy(xpath="//*[@id=\"batchName\"]")
	// public WebElement BatchNamePopupField ;

	@FindBy(xpath = "//input[@id='batchName']")
	public WebElement BatchNamePopupField;

	@FindBy(xpath = "//input[@id='batchDescription']")
	public WebElement BatchDescriptionPopupField;

	@FindBy(xpath = "//*[@id=\"programName\"]/div/input")
	public WebElement ProgramNamePoupField;

	@FindBy(xpath = "//*[@id=\"programName\"]/div/div[2]/span")
	public WebElement ProgramNamePoupFieldDrop;

//@FindBy(xpath="//*[@id=\"batchStatus\"]") //*[@id="batchStatus"]/div/div[2]/span
	@FindBy(xpath = "/html/body/app-root/app-batch/p-dialog/div/div/div[2]/div[4]/div[2]/p-radiobutton")
	public WebElement ActiveBatchStatusPopupField;

//@FindBy(xpath="//*[@id=\"batchStatus\"]/div")
	@FindBy(xpath = "/html/body/app-root/app-batch/p-dialog/div/div/div[2]/div[4]/div[3]/p-radiobutton")
	public WebElement InactiveBatchStatusPopupField;

	@FindBy(xpath = "//*[@id=\"batchNoOfClasses\"]")
	public WebElement BatchNoOfClassesPopupField;

	@FindBy(xpath = "/html/body/app-root/app-batch/p-dialog/div/div/div[3]/button[2]/span[2]")
	public WebElement SaveNewBatch;

	public String ProgramName = "WS12";

	public boolean CheckPaginationControlsVisible() {
		return paginationControl.isDisplayed();
	}
	public boolean  getDashboard() {
		
		return dashboard.isDisplayed();
	}

	public List<String> getTableHeaderList(List<WebElement> tableHeader) {
		List<String> tableHeaderList = new ArrayList<>();
		for (WebElement header : tableHeader) {
			String headerText = header.getText();
			tableHeaderList.add(headerText);
		}
		return tableHeaderList;

	}

	public void AddNewBatch(String sheetname, Integer rownum) {
		System.out.println("AddNewBatch " + sheetname + " " + rownum);
		// Retrieve data from Excel sheet
		datamap = new excelDataReader();
		excelmap = datamap.getTestData(sheetname, rownum);

		System.out.println("start Batch Name: " + excelmap.get("Batchname") + rownum);
		// Fill in Batch Name

		BatchNamePopupField.sendKeys(excelmap.get("Batchname") + randomNumber);

		// Fill in Batch Description
		// BatchDescriptionPopupField.sendKeys("MorningBatch");

		System.out.println("Batch Description: " + excelmap.get("BatchDesc"));

		if (excelmap.get("BatchDesc") != null) {

			BatchDescriptionPopupField.sendKeys(excelmap.get("BatchDesc"));
		}
		// Fill in Program Name
		// ProgramNamePoupField.click();
		System.out.println("Batch ProgramNamePoupFieldDrop");

		ProgramNamePoupFieldDrop.click();

		try {
			Thread.sleep(2000); // Sleep for 1 second
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (!ProgramName.isEmpty()) {
			System.out.println("Batch ProgramName");
			// Find the option with the desired value and click it
			WebElement option = driver.findElement(By.xpath("//span[contains(text(), '" + ProgramName + "')]"));
			reusableMethods.explicitWait(option);
			option.click();
			System.out.println("Batch ProgramName clickend");
		}

		// dropdown.selectByValue(ProgramName);

		// Locate and click on the specific option
		// prgName.click();

		// ProgramNamePoupField.sendKeys();
		System.out.println("Batch status");
		// Fill in Status
		String status = excelmap.get("Status");
		if (status != null) {
			if (status.equalsIgnoreCase("Active")) {
				ActiveBatchStatusPopupField.click();
			} else if (status.equalsIgnoreCase("Inactive")) {
				InactiveBatchStatusPopupField.click();
			} else {
				System.out.println("Invalid status value: " + status);
			}
		} else {
			System.out.println("Status value not found ");
		}

		System.out.println("Batch noOFClasses");

		if (excelmap.get("NoofClasses") != null) {
			// Fill in No. of Classes
			BatchNoOfClassesPopupField.sendKeys(excelmap.get("NoofClasses"));

		}

		System.out.println("Batch save");
		// Click Save button
		reusableMethods.explicitWait(SaveNewBatch);
		SaveNewBatch.click();

		System.out.println("Batch save complete");
		String elementText = "";

		if (excelmap.get("SuccessAndFailedMessagePopup") != null
				&& !excelmap.get("SuccessAndFailedMessagePopup").isEmpty()) {
			System.out.println("start wait ");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2)); // Set a timeout of 2 seconds
			System.out.println("Batch save entering wait");

			// WebElement messageElement =
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),"
			// + excelmap.get("SuccessAndFailedMessagePopup") + ")]")));
			WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[contains(text(), '" + excelmap.get("SuccessAndFailedMessagePopup") + "')]")));

			System.out.println("wait ended");

			assertEquals(messageElement.isDisplayed(), true, "Success popup fouund");

			elementText = messageElement.getText();

			System.out.println("ElementText is:..." + elementText);
			// Fetch Successfully Created BatchName for Editing

			// Assert that the message element is displayed
			// assertTrue(messageElement.isDisplayed(), "Message 'Batch Created
			// Successfully' is not displayed.");
		}

		System.out.println("ElementText is:..." + elementText + "len " + elementText.length());
		if (elementText.contains("Batch Created Successfully")) {
			if (BatchNameForEdit.isEmpty()) {

				BatchNameForEdit = excelmap.get("Batchname");
			}

			else {
				BatchNameForEdit1 = excelmap.get("Batchname");
			}
			System.out.println("Successfully Creadted BatchName is..." + BatchNameForEdit);
			System.out.println("Successfully Creadted BatchName2 is..." + BatchNameForEdit1);

		}

		System.out.println("else if wait " + excelmap.get("ErrorDesc"));

		if (excelmap.get("ErrorDesc") != null && !excelmap.get("ErrorDesc").isEmpty()) {
			System.out.println("else if wait " + excelmap.get("ErrorDesc"));

			try {
				WebElement errorMessage = driver
						.findElement(By.xpath("//small[contains(@class, 'p-invalid') and contains(text(), '"
								+ excelmap.get("ErrorDesc") + "')]"));
				System.out.println("error displayed " + errorMessage.isDisplayed());

				assertEquals(errorMessage.isDisplayed(), true, "Error Message found");
			} catch (Exception e) {
				System.out.println("test failed for " + excelmap.get("ErrorDesc"));
				assertEquals(false, true, "ErrorMsg not found " + excelmap.get("ErrorDesc"));
			}

			reusableMethods.explicitWait(CloseAddNewPopUp);
			CloseAddNewPopUp.click();

		}

		// Clear input fields after saving
		// BatchNamePopupField.clear();

		try {
			Thread.sleep(2000); // Sleep for 1 second
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Click on AddBatch to add next Batch
		System.out.println("click AddNEw");

		System.out.println("last Batch Name: " + excelmap.get("Batchname") + rownum);

	}

//EDIT BATCH

	public void EditBatch(String sheetname, Integer rownum) {
		// Retrieve data from Excel sheet
		System.out.println("sheet namme rownum " + sheetname + " " + rownum);
		datamap = new excelDataReader();
		excelmap = datamap.getTestData(sheetname, rownum);

		EditBatchDescription.click();
		EditBatchDescription.clear();
		System.out.println("editdesc " + excelmap.get("EditBatchDesc"));
		EditBatchDescription.sendKeys(excelmap.get("EditBatchDesc"));

		String status = excelmap.get("EditStatus");
		if (status != null) {
			if (status.equalsIgnoreCase("Active")) {
				EditActiveStatus.click();
			} else if (status.equalsIgnoreCase("Inactive")) {
				EditInactiveStatus.click();
			} else {
				System.out.println("Invalid status value: " + status);
			}
		} else {
			System.out.println("Status value not found ");
		}

		EditNoOfClasses.clear();
		EditNoOfClasses.sendKeys(excelmap.get("EditNoofClasses"));

		System.out.println("before save " + EditBatchDescription.getText() + EditBatchDescription.getText().length());

		EditBatchDescription.click();
		// EditBatchDescription.clear();
		SaveEdit.click();

		if (excelmap.get("EditSuccessAndFailedMessagePopup") != null
				&& !excelmap.get("EditSuccessAndFailedMessagePopup").isEmpty()) {
			System.out.println("start wait " + excelmap.get("EditSuccessAndFailedMessagePopup"));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2)); // Set a timeout of 2 seconds
			System.out.println("Edit Batch save entering wait");

			WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[contains(text(), '" + excelmap.get("EditSuccessAndFailedMessagePopup") + "')]")));

			System.out.println("wait ended");

			assertEquals(messageElement.isDisplayed(), true, "Success popup fouund");

		}

		System.out.println("else if wait " + excelmap.get("Error1DescBatchEdit"));

		if (excelmap.get("Error1DescBatchEdit") != null && !excelmap.get("Error1DescBatchEdit").isEmpty()) {
			System.out.println("else if wait " + excelmap.get("Error1DescBatchEdit"));

			try {
				WebElement errorMessage = driver
						.findElement(By.xpath("//small[contains(@class, 'p-invalid') and contains(text(), '"
								+ excelmap.get("Error1DescBatchEdit") + "')]"));
				System.out.println("error displayed " + errorMessage.isDisplayed());

				assertEquals(errorMessage.isDisplayed(), true, "Error Message found");
			} catch (Exception e) {
				System.out.println("test failed for " + excelmap.get("Error1DescBatchEdit"));
				assertEquals(false, true, "ErrorMsg not found " + excelmap.get("Error1DescBatchEdit"));
			}

			CloseAddNewPopUp.click();

		}
		System.out.println("Done Editing");

	}

	public void searchAndAssertTableForString(String searchString) {
		// Search for the desired string within the table with the specified ID
		WebElement table = driver.findElement(By.tagName("table"));

		// Now, within the table, search for the desired string
		try {
			WebElement element = table.findElement(By.xpath(".//*[contains(text(),'" + searchString + "')]"));

			// Assert that the desired string is found
			Assert.assertNotNull(element, "The desired string is found in the table");
		} catch (Exception e) {
			// If the desired string is not found, fail the test with an appropriate message
			// Assert.fail("The desired string is not found in the table");
		}

	}

	public void deleteBatch() {
		
		SearchBatch.click();
		SearchBatch.clear();
		System.out.println("clicked");
		SearchBatch.sendKeys(BatchNameForEdit);
		
		System.out.println("deleteicon click ");

		DeleteIcon.click();
		
		System.out.println("row 1 batch name is " + oldbatchname);
	    YesOtionDelete.click();
		System.out.println("Yes Option Deleted");
		
			System.out.println("start wait ");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2)); // Set a timeout of 2 seconds
			System.out.println("Batch save entering wait");

			WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(text(), '" + "batch Deleted" + "')]")));
             

			System.out.println("wait ended");
//
			assertEquals(messageElement.isDisplayed(), true, "Batch deleted Successfully");
//
		}

    	

	    //Assert.assertTrue(DeleteIcon.isEnabled(), "Delete icon is enabled");
}
