package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.TestBase;
import utility.excelDataReader;

import java.time.Duration;
import java.util.*;


public class E_UserPOM extends TestBase {
	Map<String, String> excelmap;
	public excelDataReader datamap;
	Set hashset=new HashSet();
	
	
	

	@FindBy(xpath = "//span[text()='User']") public WebElement usermodule;
	@FindBy(xpath = "//span[text()='Program']") public WebElement ProgramModule;
	@FindBy(xpath = "//span[text()='Logout']") public WebElement logout;
	@FindBy(xpath = "//div[text()=' Manage User']") public WebElement manageuserheader;
	@FindBy(xpath = "//span[@class='p-paginator-current ng-star-inserted']") public WebElement UserPagination;
	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-double-left']") public WebElement UserPaginationdlefticon;
	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-left']") public WebElement UserPaginationslefticon;
	@FindBy(xpath = "//span[@class='p-paginator-pages ng-star-inserted']") public WebElement UserPaginationpages;
	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-right']") public WebElement UserPaginationsright;
	@FindBy(xpath = "//span[@class='p-paginator-icon pi pi-angle-double-right']") public WebElement UserPaginationdright;
	@FindBy(xpath = "//*[text()='ID ']") public WebElement UserColID;
	@FindBy(xpath = "//*[text()='Name ']") public WebElement UserColName;
	@FindBy(xpath = "//*[text()='Location ']") public WebElement UserColLocation;
	@FindBy(xpath = "//*[text()='Phone Number ']") public WebElement UserColPhone;
	@FindBy(xpath = "//*[text()=' Edit / Delete']") public WebElement UserColEditDelete;
	@FindBy(xpath = "//*/div/button[@icon='pi pi-trash']") public WebElement UserDeleteMultiple;
	@FindBy(xpath = "//*[@label='Add New User' and @icon='pi pi-plus']") public WebElement UserAddNewUser;
	@FindBy(xpath = "//*[@label='Assign Student' and @icon='pi pi-plus']") public WebElement UserAssignStudent;
	@FindBy(xpath = "//*[@label='Assign Staff' and @icon='pi pi-plus']") public WebElement UserAssignStaff;
	@FindBy(xpath = "//span[@class='p-input-icon-left']/input") public WebElement UserSearchBox;
	@FindBy(xpath = "//div[@class='p-datatable p-component p-datatable-hoverable-rows']") public WebElement UserDataTable;
	@FindBy(xpath = "//tbody/tr[1]/td[3]") public WebElement UserValidSearchData;
	//public WebElement UserValidSearchDataResult=driver.findElement(By.xpath("//tbody[@class='p-datatable-tbody']/tr/td[3]"));
	@FindBy(xpath = "//span[@class='p-paginator-current ng-star-inserted']") public WebElement UserinValidSearchDataResult;

	@FindBy(xpath = "//tr[@class='ng-star-inserted']/th[2]") public WebElement UserTableHeadercount;
	
	@FindBys({
        @FindBy(xpath = "//form//*/div[@class='col']")
    }) public List<WebElement> UserDetailsPageElements;
	
	@FindBy(xpath = "//div/input[@data-placeholder='Email address']") public WebElement UserDetailsEmail;
	@FindBy(xpath = "//span[text()='User Details']") public WebElement UserDetailsHeader;
	@FindBy(xpath = "//div/input[@formcontrolname='userFirstName']") public WebElement UserDetailsFirstName;
	@FindBy(xpath = "//div/input[@formcontrolname='userMiddleName']") public WebElement UserDetailsMiddleName;
	@FindBy(xpath = "//div/input[@formcontrolname='userLastName']") public WebElement UserDetailsLastName;
	@FindBy(xpath = "//div/input[@formcontrolname='userLocation']") public WebElement UserDetailsLocation;
	@FindBy(xpath = "//div/input[@formcontrolname='userPhoneNumber']") public WebElement UserDetailsPhoneNumber;
	@FindBy(xpath = "//div/input[@formcontrolname='userLinkedinUrl']") public WebElement UserDetailsLinkedIn;
	@FindBy(xpath = "//div/label[text()='User Role']") public WebElement UserDetailsUserRole;
	@FindBy(xpath = "//div/label[text()='User Role Status']") public WebElement UserDetailsUserRoleStatus;
	@FindBy(xpath = "//div/label[text()='User Visa Status']") public WebElement UserDetailsUserVisaStatus;
	@FindBy(xpath = "//div/input[@formcontrolname='userEduUg']") public WebElement UserDetailsUserEduUg;
	@FindBy(xpath = "//div/input[@formcontrolname='userEduPg']") public WebElement UserDetailsUserEduPg;
	@FindBy(xpath = "//div/input[@formcontrolname='userTimeZone']") public WebElement UserDetailsUserTimeZone;
	@FindBy(xpath = "//div/input[@formcontrolname='userComments']") public WebElement UserDetailsUserComments;
	//@FindBy(css="span[class='p-dialog-header-close-icon ng-tns-c132-6 pi pi-times']") public WebElement UserDetailsCloseIcon;
	@FindBy(xpath = "//button[contains(@class,'p-dialog-header-icon p-dialog-header-close')]") public WebElement UserDetailsCloseIcon;
	@FindBy(xpath = "//button/span[text()='Cancel']") public WebElement UserDetailsUserCancel;
	@FindBy(xpath = "//button/span[text()='Submit']") public WebElement UserDetailsUserSubmit;
	//@FindBy(xpath = "//button[@type='submit']") public WebElement UserDetailsUserSubmit1;
	
	@FindBy(xpath = "//div/label[text()='User Role']/../p-dropdown") public WebElement UserDetailsUserRoleDropDown;
	@FindBy(xpath = "//div/label[text()='User Role Status']/../p-dropdown") public WebElement UserDetailsUserRoleStatusDropDown;
	@FindBy(xpath = "//div/label[text()='User Visa Status']/../p-dropdown") public WebElement UserDetailsUserVisaStatusDropDown;
	@FindBy(xpath = "//button[@icon='pi pi-pencil']") public WebElement UserDetailsEditIcon;


	public void userModuleEditClick() {
		UserDetailsEditIcon.click();
	}

	public void userModuleClick() {
		usermodule.click();
	}

	public void PaginationValidationTest() {

		String paginationText = UserPagination.getText();
		String[] parts = paginationText.split(" ");
		int x = Integer.parseInt(parts[1]); // "start"
		int y = Integer.parseInt(parts[3]); // "end"
		int z = Integer.parseInt(parts[5]); // "total"

		Assert.assertTrue(z >= x, "End value should be greater than or equal to start value");
		Assert.assertTrue(z >= y, "Total value should be greater than or equal to the end value");

	}

	public void UserSearchBoxPosition() {
		Point searchBoxPosition = UserSearchBox.getLocation();
		Point dataTablePosition = UserDataTable.getLocation();
		int searchBoxY = searchBoxPosition.getY();
		int dataTableY = dataTablePosition.getY();
		Assert.assertTrue(searchBoxY < dataTableY, "Search box should be positioned above the data table");

	}

	public void ValidateDataTableData() {
		
		int totalEntries = Integer.parseInt(getPaginationCounts()[5]);
		int columnEnd = Integer.parseInt(getPaginationCounts()[3]);

		// loop for rows
		int row= 1;
		for (int i = 1; i <= totalEntries; i++) {
			

			// loop for columns
			for (int j = 1; j <= 5; j++) {

				String xpathExpression = "//tbody[@class='p-datatable-tbody']/tr[" + row + "]/td[" + j + "]";

				WebElement UserRowData = driver.findElement(By.xpath(xpathExpression));
				
				
				
				if(SearchDataForCreatedUser!=null) {
				
				hashset.add(UserRowData.getText());
				Assert.assertEquals(UserRowData.isDisplayed(), true);
				}

//				System.out.println("xpath" + xpathExpression);
//				System.out.println("Row Data:" + UserRowData.getText());
				
				Assert.assertEquals(UserRowData.isDisplayed(), true);

			}
			row ++;
			//System.out.println("first loop i: " + i);
			if (i == columnEnd && columnEnd != totalEntries) {
				UserPaginationsright.click();
				row= 1;
				columnEnd = Integer.parseInt(getPaginationCounts()[3]);
				//System.out.println("columnEnd:" + columnEnd);
			}
		}
	}

	private String[] getPaginationCounts() {
		String paginationText = UserPagination.getText();
		return paginationText.split(" ");

	}
	
	public void ValidateDataTableCheckBox() {
		UserPaginationdlefticon.click();
		int totalEntries = Integer.parseInt(getPaginationCounts()[5]);
		int columnEnd = Integer.parseInt(getPaginationCounts()[3]);
		
		int row= 1;
		  	
           for (int i = 1; i <= totalEntries; i++) {
			
				
				String xpathExpression="//tbody/tr[" + row + "]/td//div[@role='checkbox']";
				WebElement UserCheckbox = driver.findElement(By.xpath(xpathExpression));

				Assert.assertEquals(UserCheckbox.isEnabled(), true);
				
				if (i == columnEnd && columnEnd != totalEntries) {
					UserPaginationsright.click();
					row= 1;
					columnEnd = Integer.parseInt(getPaginationCounts()[3]);
					//System.out.println("columnEnd:" + columnEnd);
				
	           }
				else {
					row ++;
				}
				

			}
			
			
			}
	
	public void ValidateDataTableEditIcon() {
		UserPaginationdlefticon.click();
		int totalEntries = Integer.parseInt(getPaginationCounts()[5]);
		int columnEnd = Integer.parseInt(getPaginationCounts()[3]);
		
		int row= 1;
			
           for (int i = 1; i <= totalEntries; i++) {
			
				
				String xpathExpression="//tbody/tr[" + row + "]/td//button[@icon='pi pi-pencil']";
				WebElement UserEdit = driver.findElement(By.xpath(xpathExpression));
				Assert.assertEquals(UserEdit.isEnabled(), true);
				Assert.assertEquals(UserEdit.isDisplayed(), true);
				
				if (i == columnEnd && columnEnd != totalEntries) {
					UserPaginationsright.click();
					row= 1;
					columnEnd = Integer.parseInt(getPaginationCounts()[3]);
					//System.out.println("columnEnd:" + columnEnd);
				
	           }
				else {
					row ++;
				}
				

			}
			
			
			}
	
	public void ValidateDataTableDeleteIcon() {
		UserPaginationdlefticon.click();
		int totalEntries = Integer.parseInt(getPaginationCounts()[5]);
		int columnEnd = Integer.parseInt(getPaginationCounts()[3]);
		
		int row= 1;
			
           for (int i = 1; i <= totalEntries; i++) {
			
				
				String xpathExpression="//tbody/tr[" + row + "]/td//button[@icon='pi pi-trash']";
				WebElement UserDelete = driver.findElement(By.xpath(xpathExpression));
				Assert.assertEquals(UserDelete.isEnabled(), true);
				Assert.assertEquals(UserDelete.isDisplayed(), true);
				
				if (i == columnEnd && columnEnd != totalEntries) {
					UserPaginationsright.click();
					row= 1;
					columnEnd = Integer.parseInt(getPaginationCounts()[3]);
					//System.out.println("columnEnd:" + columnEnd);
				
	           }
				else {
					row ++;
				}
				

			}
			
			
			}
	
	public void UserSearch(String data) {
		UserSearchBox.clear();
		UserSearchBox.sendKeys(data);
	}
	
	public void navigateToDashboard() {
		ProgramModule.click();;
	}
	public void clickAddNewUser() throws InterruptedException {
		

			UserAddNewUser.click();
		

		
	}
	

	
	
	public void userDetailsClose() {
		
		wait.until(ExpectedConditions.elementToBeClickable(UserDetailsCloseIcon));
		
		UserDetailsCloseIcon.click();
	}
	public void userDetailsCancel() {
		wait.until(ExpectedConditions.elementToBeClickable(UserDetailsUserCancel));
		UserDetailsUserCancel.click();
	}
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
	Actions action =new Actions(driver);
	public void scrollDown() {
		
		
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		
	}
	public void scrollUp() {
		action.sendKeys(Keys.PAGE_UP).build().perform();
	}
	
	public String SearchDataForCreatedUser;
	public void UserCreateData(String sheetname, int rownum) {
		datamap= new excelDataReader();
		excelmap=datamap.getTestData(sheetname, rownum);
		//SearchDataForCreatedUser=excelmap.get("FirstName");
		UserDetailsFirstName.sendKeys(excelmap.get("FirstName"));
		//UserDetailsMiddleName.sendKeys(excelmap.get("MiddleName"));
		UserDetailsMiddleName.sendKeys(excelmap.get("MiddleName"));
		UserDetailsLastName.sendKeys(excelmap.get("LastName"));
		UserDetailsLocation.sendKeys(excelmap.get("Location"));
		
		Random random = new Random();
        int randomNumber = 10000 + random.nextInt(90000);
		UserDetailsPhoneNumber.sendKeys(excelmap.get("PhoneNumber")+randomNumber);
		UserDetailsLinkedIn.sendKeys(excelmap.get("LinkedIn"));
		
        UserDetailsUserRoleDropDown.click();
		
		WebElement option = driver.findElement(By.xpath("//span[contains(text(), '" + excelmap.get("Role") + "')]"));
		option.click();
		
	
		UserDetailsUserRoleStatusDropDown.click();
		
		WebElement option1 = driver.findElement(By.xpath("//span[contains(text(), '" + excelmap.get("RoleStatus") + "')]"));
		
		
		option1.click();
		
		UserDetailsUserVisaStatusDropDown.click();
		
		WebElement option2 = driver.findElement(By.xpath("//li/span[contains(text(), '" + excelmap.get("Visa Status") + "')]"));
		wait.until(ExpectedConditions.elementToBeClickable(option2));
		if(option2==null) {
			scrollDown();
		}
		else {
		option2.click();
		}
		
		String randomString = generateRandomString(6);
		
		UserDetailsEmail.sendKeys(randomString+"_"+excelmap.get("Email"));
		
		UserDetailsUserEduUg.sendKeys(excelmap.get("EduUg"));
		UserDetailsUserEduPg.sendKeys(excelmap.get("EduPg"));
		UserDetailsUserTimeZone.sendKeys(excelmap.get("TimeZone"));
		scrollDown();
		UserDetailsUserComments.sendKeys(excelmap.get("Comments"));
		wait.until(ExpectedConditions.elementToBeClickable(UserDetailsUserSubmit));
		UserDetailsUserSubmit.click();
		
	}
	String Phone;
	public void UserCreateDataUnique(String sheetname, int rownum) {
		datamap= new excelDataReader();
		excelmap=datamap.getTestData(sheetname, rownum);
		String randomString = generateRandomString(6);
		SearchDataForCreatedUser=excelmap.get("FirstName")+randomString;
		UserDetailsFirstName.sendKeys(SearchDataForCreatedUser);
		UserDetailsMiddleName.sendKeys(excelmap.get("MiddleName"));
		UserDetailsLastName.sendKeys(excelmap.get("LastName"));
		UserDetailsLocation.sendKeys(excelmap.get("Location"));
		
		Random random = new Random();
        int randomNumber = 10000 + random.nextInt(90000);
         Phone=excelmap.get("PhoneNumber")+randomNumber;
		UserDetailsPhoneNumber.sendKeys(Phone);
		UserDetailsLinkedIn.sendKeys(excelmap.get("LinkedIn"));
		
        UserDetailsUserRoleDropDown.click();
		
		WebElement option = driver.findElement(By.xpath("//span[contains(text(), '" + excelmap.get("Role") + "')]"));
		option.click();
		
	
		UserDetailsUserRoleStatusDropDown.click();
		
		WebElement option1 = driver.findElement(By.xpath("//span[contains(text(), '" + excelmap.get("RoleStatus") + "')]"));
		
		
		option1.click();
		
		UserDetailsUserVisaStatusDropDown.click();
		
		WebElement option2 = driver.findElement(By.xpath("//li/span[contains(text(), '" + excelmap.get("Visa Status") + "')]"));
		wait.until(ExpectedConditions.elementToBeClickable(option2));
		if(option2==null) {
			scrollDown();
		}
		else {
		option2.click();
		}
		
		
		
		UserDetailsEmail.sendKeys(randomString+"_"+excelmap.get("Email"));
		
		UserDetailsUserEduUg.sendKeys(excelmap.get("EduUg"));
		UserDetailsUserEduPg.sendKeys(excelmap.get("EduPg"));
		UserDetailsUserTimeZone.sendKeys(excelmap.get("TimeZone"));
		scrollDown();
		UserDetailsUserComments.sendKeys(excelmap.get("Comments"));
		wait.until(ExpectedConditions.elementToBeClickable(UserDetailsUserSubmit));
		UserDetailsUserSubmit.click();
		
	}
	
	public void UserCreateDataOptinalfeilds(String sheetname, int rownum) {
		datamap= new excelDataReader();
		excelmap=datamap.getTestData(sheetname, rownum);
		
		UserDetailsFirstName.sendKeys(excelmap.get("FirstName"));
		//UserDetailsMiddleName.sendKeys(excelmap.get("MiddleName"));
		UserDetailsMiddleName.sendKeys(excelmap.get("MiddleName"));
		UserDetailsLastName.sendKeys(excelmap.get("LastName"));
		UserDetailsLocation.sendKeys(excelmap.get("Location"));
		
		
		UserDetailsPhoneNumber.sendKeys(excelmap.get("PhoneNumber"));
		UserDetailsLinkedIn.sendKeys(excelmap.get("LinkedIn"));
		
        UserDetailsUserRoleDropDown.click();
		
		WebElement option = driver.findElement(By.xpath("//span[contains(text(), '" + excelmap.get("Role") + "')]"));
		option.click();
		
	
		UserDetailsUserRoleStatusDropDown.click();
		
		WebElement option1 = driver.findElement(By.xpath("//span[contains(text(), '" + excelmap.get("RoleStatus") + "')]"));
		
		
		option1.click();
		
		UserDetailsUserVisaStatusDropDown.click();
		
		WebElement option2 = driver.findElement(By.xpath("//li/span[contains(text(), '" + excelmap.get("Visa Status") + "')]"));
		wait.until(ExpectedConditions.elementToBeClickable(option2));
		if(option2==null) {
			scrollDown();
		}
		else {
		option2.click();
		}
		
		
		
		UserDetailsEmail.sendKeys(excelmap.get("Email"));
		
		UserDetailsUserEduUg.sendKeys(excelmap.get("EduUg"));
		UserDetailsUserEduPg.sendKeys(excelmap.get("EduPg"));
		UserDetailsUserTimeZone.sendKeys(excelmap.get("TimeZone"));
		//scrollDown();
		UserDetailsUserComments.sendKeys(excelmap.get("Comments"));
		
		//wait.until(ExpectedConditions.elementToBeClickable(UserDetailsUserSubmit1));
		
		UserDetailsUserSubmit.click();
		
	}
	public void UserCreateDataManual() {
		 String Role="R01";
		
//		UserDetailsFirstName.sendKeys("sree");
//		//UserDetailsMiddleName.sendKeys(excelmap.get("MiddleName"));
//		UserDetailsMiddleName.sendKeys("vidya");
//		UserDetailsLastName.sendKeys("malineni");
//		UserDetailsLocation.sendKeys("GA");
//		Random random = new Random();
//        int randomNumber = 10000 + random.nextInt(90000);
//		UserDetailsPhoneNumber.sendKeys("66666"+randomNumber);
//		UserDetailsLinkedIn.sendKeys("www.linkedin.com");
		UserDetailsUserRoleDropDown.click();
		
		WebElement option = driver.findElement(By.xpath("//span[contains(text(), '" + Role + "')]"));
		option.click();
		
	
		UserDetailsUserRoleStatusDropDown.click();
		
		WebElement option1 = driver.findElement(By.xpath("//span[contains(text(), '" + "Active" + "')]"));
		
		
		option1.click();
		
		UserDetailsUserVisaStatusDropDown.click();
		
		WebElement option2 = driver.findElement(By.xpath("//li/span[contains(text(), '" + "H4-EAD" + "')]"));
		if(option2==null) {
			scrollDown();
		}
		else {
		option2.click();
		}
		//scrollDown();
		UserDetailsUserSubmit.click();
		
//		String randomString = generateRandomString(6);
//		
//		UserDetailsEmail.sendKeys(randomString+"_"+"sthh1@gmail.com");
//		
//		UserDetailsUserEduUg.sendKeys("BE");
//		UserDetailsUserEduPg.sendKeys("MSC");
//		UserDetailsUserTimeZone.sendKeys("EST");
//		scrollDown();
//		UserDetailsUserComments.sendKeys("abc");
		
		
	}
	public void toastMsgClose() {
		WebElement toastclose = driver.findElement(By.xpath("//button[contains(@class,'p-toast-icon-close')]"));
		toastclose.click();
	}
	public String ActualMsg;
	
	public void userCreationMsgValidation() throws InterruptedException {
		
		WebElement msg = driver.findElement(By.xpath("//p-toast//div[contains(@class, 'p-toast-detail')]"));
		

		
		ActualMsg=msg.getText();
		//toastMsgClose();
		
		System.out.println("actual msg: "+ActualMsg);
		wait.until(ExpectedConditions.invisibilityOf(msg));
		
		
	}
	public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder randomString = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();
    }
	
	public void createUserMandatoryMsgValidation() {
		List<WebElement> expectedMsg = driver.findElements(By.xpath("//mat-error[@role='alert']"));
		String[] actualMsg= {"First name is required","Middle name is required","Last name is required","Location is required",
				"Phone number is required","LinkedIn Url is required","Email address is required","Under Graduate is required",
				"Post Graduate is required","Time Zone is required","User Comments is required"};
		
		 
			 for(int i=0;i<=expectedMsg.size()-1;i++) {
	          
	            String rgb= expectedMsg.get(i).getCssValue("color");
	            String hexcolor = Color.fromString(rgb).asHex();
	            Assert.assertEquals(expectedMsg.get(i).getText(), actualMsg[i]);
	            Assert.assertEquals(hexcolor, "#f44336");
	        
		 }
			 
			 userDetailsCancel();
			 
		
	}
	
	public void userModuleSubmit() {
		//reusableMethods.explicitWait(UserDetailsUserSubmit);
		wait.until(ExpectedConditions.elementToBeClickable(UserDetailsUserSubmit));
		UserDetailsUserSubmit.click();
	}
	
	public void ValidateDataTableDataForCreatedUser() {

				//System.out.println("set: "+hashset.toString());
				//Assert.assertTrue(hashset.contains(SearchDataForCreatedUser));
				Assert.assertTrue(hashset.contains(Phone));

	}
	
	}

