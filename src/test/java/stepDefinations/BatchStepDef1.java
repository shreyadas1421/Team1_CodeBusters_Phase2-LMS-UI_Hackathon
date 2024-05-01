package stepDefinations;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import PageObject.E_UserPOM;
import PageObject.D_BatchPOM;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.TestSetupManager;

public class BatchStepDef1 extends  D_BatchPOM {
	
	  // PageObject.A_LoginPOM A_LoginPOM=new PageObject.A_LoginPOM(driver);

	
	TestSetupManager testSetupManager;
//	public BatchStepDef1(TestSetupManager testSetupManager) {
//		this.testSetupManager= testSetupManager;
//		   PageObject.A_LoginPOM A_LoginPOM=new PageObject.A_LoginPOM(driver);


			 public BatchStepDef1(TestSetupManager testSetupManager) {
				 
				 this.testSetupManager= testSetupManager;
				 SetDriver(this.testSetupManager.testbase.driver);
			        //this.driver = driver;
			        PageFactory.initElements(driver, this);
			    }

				@Given("Logged on the LMS portal as admin")
				public void logged_on_the_lms_portal_as_admin() {
					
			        // Assert.assertEquals(logout.isDisplayed(), true);
					}
				

	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_Login() {
        //Assert.assertEquals(logout.isDisplayed(), true);

//		testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().username);
//		
//		boolean  LogInPageTittle=testSetupManager.pageObjectManager.getlogin().getTittle();
//		//System.out.println(LogInPageTittle);
//		Assert.assertEquals(LogInPageTittle,true );
//
//		testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().username);
//		
//		testSetupManager.pageObjectManager.getlogin().userlog("Login",1);
//
		System.out.println("Batch");
		//testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().dashboard);
	    boolean  dashboard=getDashboard();
		System.out.println("In Batch " + dashboard);
//
	    Assert.assertEquals(dashboard,true );
//	    System.out.println("user is in dashboard page");
	    System.out.println("given");
//	    
//		
//        
//		
	}

	@When("Admin clicks Batch from navigation bar")
	public void admin_clicks_Batch_from_navigation_bar() {
		System.out.println("when");
	    //testSetupManager.pageObjectManager.getbatch().clickBatch();
	    clickBatch();
	    System.out.println("when complete");
	}
   
    @Then("Admin should see the {string} in the Header of manage batch page")
    public void admin_should_see_the_in_the_Header_of_manage_batch_page(String expectedHeader) {
        // Implementation to verify if the expected header is displayed in the manage batch page header
		//testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().username);

    	String actualHeader = GetTextBatchHeader();
        System.out.print("Expected Header:- "+expectedHeader);
        System.out.print("Actual Header:-" +actualHeader);

        Assert.assertEquals(actualHeader, expectedHeader, "Header mismatch");
        //System.out.print("Header Matches");
    }

//    @Then("Admin should see the {string} in the Header of manage batch")
//    public void admin_should_see_the_in_the_Header_of_manage_batch(String expectedHeader) {
//        // Implementation to verify if the expected header is displayed in the manage batch page header
//		testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().username);
//
//    	String actualHeader = testSetupManager.pageObjectManager.getbatch().GetTextBatchHeader();
//        System.out.print("Expected Header1:-"+expectedHeader);
//        System.out.print("Actual Header1:-" +actualHeader);
//
//        Assert.assertEquals(actualHeader, expectedHeader, "Header mismatch");
//       // System.out.print("Header Matches");
//    }
    @Then("Admin should see the {string} in the Header of manage batch")
    public void admin_should_see_the_in_the_header_of_manage_batch(String string) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    @Then("Admin should see the pagination controls under the data table on manage batch page")
    public void admin_should_see_pagination_controls_under_data_table_on_manage_batch_page() {
		//testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().username);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    	boolean paginationVisible = CheckPaginationControlsVisible();
        Assert.assertTrue(paginationVisible, "Pagination controls are not visible under the data table");
    }
    
    @Then("Admin Should see the data table on manage batch")
    public void admin_should_see_the_data_table_on_manage_batch() {
    	
    Assert.assertEquals(BatchNameColumn.getText(), "Batch Name");
    Assert.assertEquals(BatchDescColumn.getText(), "Batch Description");
    Assert.assertEquals(BatchStatusColumn.getText(), "Batch Status");
    Assert.assertEquals(NoOfClassesColumn.getText(), "No Of Classes");
    Assert.assertEquals(ProgramNameColumn.getText(), "Program Name");
    Assert.assertEquals(EditDeleteColumn.getText(), "Edit / Delete");
}
    @Then("Data table should have a delete icon that is enabled on manage batch")
    public void data_table_should_have_a_delete_icon_that_is_enabled_on_manage_batch() {
       // Write code here that turns the phrase above into concrete actions
       //throw new io.cucumber.java.PendingException();
    	//testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().username);
//
   	   Assert.assertEquals(deleteAllBatch_btn.isEnabled(),true);
//
  }

    @Then("Admin should be able to see the + A New batch button on manage batch")
    public void admin_should_be_able_to_see_the_a_new_batch_button_on_manage_batch() {
		//testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().username);

    	//Assert.assertEquals(AddnewBatchButton.isDisplayed(), true);

    }
//
    @Then("Data table should have a checkbox on manage batch")
    public void data_table_should_have_a_checkbox_on_manage_batch() {
		//testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().username);

    	Assert.assertEquals(MainCheckBox.isDisplayed(), true);
    	//Assert.assertEquals(Fcheckbox.isDisplayed(), true);
    	Assert.assertEquals(Scheckbox.isDisplayed(), true);
    	Assert.assertEquals(Tcheckbox.isDisplayed(), true);
    	Assert.assertEquals(Focheckbox.isDisplayed(), true);
    	Assert.assertEquals(Fifcheckbox.isDisplayed(), true);


    }

    
    

  ///////////////////////// ADD NEW BATCH FEATURE ///////////////////
    
    
    @Then("Admin clicks + A New Batch button")
    public void admin_clicks_a_new_batch_button() {
		//testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().username);

    	//MainAddNewBatchButton.click();
    	System.out.println("Add new Batch clicked");
    }
    	
    
    @Then("The pop up should include fields like Name Number of classes Description Status and Program Name in Mangage Batch")
    public void the_pop_up_should_include_fields_like_name_number_of_classes_description_status_and_program_name_in_mangage_batch() {
//    	Assert.assertEquals(BatchNamePopupField.isDisplayed(), true);
//    	Assert.assertEquals(BatchDescriptionPopupField.isDisplayed(), true);
// 	Assert.assertEquals(ProgramNamePoupField.isDisplayed(), true);
//    	Assert.assertEquals(ActiveBatchStatusPopupField.isDisplayed(), true);
//  	Assert.assertEquals(InactiveBatchStatusPopupField.isDisplayed(), true);
//    Assert.assertEquals(BatchNoOfClassesPopupField.isDisplayed(), true);
    
    	//CloseAddNewPopUp.click();

    }

    

    
    @When("Click on save after filling all the fields with valid values on batch details {string} and {int}")
    public void click_on_save_after_filling_all_the_fields_with_valid_values_on_batch_details_and(String sheetname, Integer rownum) {
        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();

    	System.out.println("Add new Batch clicked really");
    	MainAddNewBatchButton.click();
    	
    	AddNewBatch(sheetname,rownum);
    	System.out.println("Add new Batch clicked ended");
    	

    	


		//testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().username);

    }

    @Then("The newly added batch should be present in the data table in Manage Batch page")
    public void the_newly_added_batch_should_be_present_in_the_data_table_in_manage_batch_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    	//AddNewBatch(sheetname,rownum);
    	System.out.print("In addnewBatchAssertion");
    }
 /* EDIT BATCH */
    
	@Then("Admin clicks on the Search icon on batch page if it is enabled")
	public void admin_clicks_on_the_search_icon_on_batch_page_if_it_is_enabled() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		
		SearchBatch.click();
		SearchBatch.sendKeys(BatchNameForEdit);
		 try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

		EditButton.click();
		
	}
	
	@When("Admin Enter Batch name in search input field and Click on edit icon")
	public void admin_enter_batch_name_in_search_input_field_and_click_on_edit_icon() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	
	@Then("A new pop up with {string} appears to edit")
	public void a_new_pop_up_with_appears_to_edit(String string) {
	    // Write code here that turns the phrase above into concrete actions
	//    throw new io.cucumber.java.PendingException();
		EditPopup.isDisplayed();
	}
	
@When("Click save after updating the batch detail fields with valid values {string} and {int}")
    	public void click_save_after_updating_the_batch_detail_fields_with_valid_values_and(String sheetname, Integer rownum) {
    	    // Write code here that turns the phrase above into concrete actions
    	   // throw new io.cucumber.java.PendingException();
    		
    		EditBatch(sheetname,rownum);

    	}
    	
    	@Then("The updated batch details should appear on the data table")
    	public void the_updated_batch_details_should_appear_on_the_data_table() {
    	    // Write code here that turns the phrase above into concrete actions
    	   // throw new io.cucumber.java.PendingException();
    	}
    	


    	


//    	// Get the page source
//    	String pageSource = driver.getPageSource();
//
//    	// Search for the message text within the page source
//    	boolean messageFound = pageSource.contains("Batch already exists with given Batch Name.");
//
//    	// Perform assertion using assertEquals
//    	assertEquals(messageFound, true, "Message 'Batch already exists with given Batch Name.' not found on the page.");
    	// Switch to the alert
    	//Alert alert = (Alert) driver.switchTo().activeElement();
//    	Alert alert = driver.switchTo().alert();
    	//alert.accept();

//
//
//    	// Get the text of the alert
//    	String alertText = alert.getText();
//    	System.out.println("Message is " + alertText);
//    	
//    	assertEquals(alertText, false,"Failed Batch cannot be created for a Program with Inactive status");
//    	
//    	assertEquals(alertText, false,"Successful Batch Created Successfully");






    	

    	
    	



    
}
//
//    
//}
//}
