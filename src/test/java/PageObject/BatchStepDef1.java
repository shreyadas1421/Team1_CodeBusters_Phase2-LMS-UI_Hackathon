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

public class BatchStepDef1 extends D_BatchPOM {

	String oldbatchname;
	TestSetupManager testSetupManager;

	public BatchStepDef1(TestSetupManager testSetupManager) {

		this.testSetupManager = testSetupManager;
		SetDriver(this.testSetupManager.testbase.driver);
		// this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@Given("Logged on the LMS portal as admin")
	public void logged_on_the_lms_portal_as_admin() {

		// Assert.assertEquals(logout.isDisplayed(), true);
	}

	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_Login() {
		System.out.println("Batch");
		boolean dashboard = testSetupManager.pageObjectManager.getlogin().getDashboard();
		System.out.println("In Batch " + dashboard);

		Assert.assertEquals(dashboard, true);
		System.out.println("user is in dashboard page");
		System.out.println("given complete");

	}

	@When("Admin clicks Batch from navigation bar")
	public void admin_clicks_Batch_from_navigation_bar() {
		System.out.println("when");
		// testSetupManager.pageObjectManager.getbatch().clickBatch();
		clickBatch();

		System.out.println("when complete");
	}

	@Then("Admin should see the {string} in the Header of manage batch page")
	public void admin_should_see_the_in_the_Header_of_manage_batch_page(String expectedHeader) {

		String actualHeader = GetTextBatchHeader();
		System.out.print("Expected Header:- " + expectedHeader);
		System.out.print("Actual Header:-" + actualHeader);

		Assert.assertEquals(actualHeader, expectedHeader, "Header mismatch");
	}

	@Then("Admin should see the {string} in the Header of manage batch")
	public void admin_should_see_the_in_the_header_of_manage_batch(String string) {
		// Write code here that turns the phrase above into concrete actions
		// throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see the pagination controls under the data table on manage batch page")
	public void admin_should_see_pagination_controls_under_data_table_on_manage_batch_page() {
		// testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().username);
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

		Assert.assertEquals(deleteAllBatch_btn.isEnabled(), true);

	}

	@Then("Admin should be able to see the + A New batch button on manage batch")
	public void admin_should_be_able_to_see_the_a_new_batch_button_on_manage_batch() {

	}

	@Then("Data table should have a checkbox on manage batch")
	public void data_table_should_have_a_checkbox_on_manage_batch() {

		Assert.assertEquals(MainCheckBox.isDisplayed(), true);
		// Assert.assertEquals(Fcheckbox.isDisplayed(), true);
		Assert.assertEquals(Scheckbox.isDisplayed(), true);
		Assert.assertEquals(Tcheckbox.isDisplayed(), true);
		Assert.assertEquals(Focheckbox.isDisplayed(), true);
		Assert.assertEquals(Fifcheckbox.isDisplayed(), true);

	}

	///////////////////////// ADD NEW BATCH FEATURE ///////////////////

	@Then("Admin clicks + A New Batch button")
	public void admin_clicks_a_new_batch_button() {
		// testSetupManager.reusablemethod.explicitWait(testSetupManager.pageObjectManager.getlogin().username);

		// MainAddNewBatchButton.click();
		System.out.println("Add new Batch clicked");
	}

	@Then("The pop up should include fields like Name Number of classes Description Status and Program Name in Mangage Batch")
	public void the_pop_up_should_include_fields_like_name_number_of_classes_description_status_and_program_name_in_mangage_batch() {

	}

	@When("Click on save after filling all the fields with valid values on batch details {string} and {int}")
	public void click_on_save_after_filling_all_the_fields_with_valid_values_on_batch_details_and(String sheetname,
			Integer rownum) {

		System.out.println("Add new Batch clicked really");
		MainAddNewBatchButton.click();

		AddNewBatch(sheetname, rownum);
		System.out.println("Add new Batch clicked ended");

	}

	@Then("The newly added batch should be present in the data table in Manage Batch page")
	public void the_newly_added_batch_should_be_present_in_the_data_table_in_manage_batch_page() {
		System.out.print("In addnewBatchAssertion");
	}
	/* EDIT BATCH */

	@Then("Admin clicks on the Search icon on batch page if it is enabled")
	public void admin_clicks_on_the_search_icon_on_batch_page_if_it_is_enabled() {

	}

	@When("Admin Enter Batch name in search input field and Click on edit icon")
	public void admin_enter_batch_name_in_search_input_field_and_click_on_edit_icon() {
	}

	@Then("A new pop up with {string} appears to edit")
	public void a_new_pop_up_with_appears_to_edit(String string) {
	}

	@When("Click save after updating the batch detail fields with valid values {string} and {int}")
	public void click_save_after_updating_the_batch_detail_fields_with_valid_values_and(String sheetname,
			Integer rownum) {
		System.out.println("@when edit " + sheetname + " " + rownum);
		SearchBatch.click();
		SearchBatch.clear();
		System.out.println("clicked");
		SearchBatch.sendKeys(BatchNameForEdit);
		System.out.println("serachadded");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		EditButton.click();
		System.out.println("edit cliecked");

		EditBatch(sheetname, rownum);
		System.out.println("edit end");

	}

	@Then("The updated batch details should appear on the data table")
	public void the_updated_batch_details_should_appear_on_the_data_table() {
	}

	///////// DELETE BATCH

  	@Then("Admin clicks on the delete icon on batch page if it is enabled")
    	public void admin_clicks_on_the_delete_icon_on_batch_page_if_it_is_enabled() {
    	    // Write code here that turns the phrase above into concrete actions
    	    //throw new io.cucumber.java.PendingException();
   	    //clickBatch();
//
//    		System.out.println("deleteicon click ");
//    		oldbatchname = BatchNamerow1.getText();
//    		System.out.println(" oldbatchname is " +oldbatchname);
//
//    		DeleteIcon.click();
//
//  	    //Assert.assertTrue(DeleteIcon.isEnabled(), "Delete icon is enabled");
  		deleteBatch();

//
    	}
//    	@When("Admin clicks Batch from navigation bar and clicks yes for delete batch")
//    	public void admin_clicks_batch_from_navigation_bar_and_clicks_yes_for_delete_batch() {
//    	    // Write code here that turns the phrase above into concrete actions
//    	    //throw new io.cucumber.java.PendingException();
//    	    
//    		System.out.println("row 1 batch name is " + oldbatchname);
//    		YesOtionDelete.click();
//  		    System.out.println("Yes Option Deleted");
//
//    	}
//    	@Then("Verify if batch deleted scuccessfully")
//    	public void verify_if_batch_deleted_scuccessfully() {
//    	    // Write code here that turns the phrase above into concrete actions
//    	    //throw new io.cucumber.java.PendingException();
//    		//String newbatchName = BatchNamerow1.getText();
//    		searchAndAssertTableForString(oldbatchname);
//    	//	System.out.println("row 1 new batch name is" +newbatchName );
//    		//Assert.assertNotEquals(oldbatchname, newbatchName, "Batch Deleted");
//    		System.out.println("Batch deleted complete " + oldbatchname);
//    		
//    		
//
//    		
//    	}
//    	
////        @When("Admin clicks No Option to delete batch")
////        public void admin_clicks_no_option_to_delete_batch() {
////            // Code to perform the action of clicking "No Option" to delete batch
////    		System.out.println("deleteicon click in no option ");
////    	    DeleteIcon.click();
////
////     		NoOptionDelete.click();
////    		System.out.println(" no option is clicked ");
////
////
////
////        	 
////        }
//    	
//    	   @When("Admin click No Otion to delete batch")
//    	   public void admin_click_no_otion_to_delete_batch() {
//    	    // Write code here that turns the phrase above into concrete actions
//    	    //throw new io.cucumber.java.PendingException();
//    			System.out.println("deleteicon click in no option ");
//    		    DeleteIcon.click();
//
//    			NoOptionDelete.click();
//    			System.out.println(" no option is clicked ");
//
//    	       
//    	   }
//
//
//        @Then("Batch delete popup should disappear")
//        public void batch_delete_popup_should_disappear() {
//            // Code to verify that the batch delete popup has disappeared
//        	Assert.assertFalse(Deletepopup.isDisplayed(), "Delete popup should disappear");
//
//        }
//    

}

//    	@Then("Admin clicks on the delete icon on batch page if it is enabled")
//    	public void admin_clicks_on_the_delete_icon_on_batch_page_if_it_is_enabled() {
//    	    // Write code here that turns the phrase above into concrete actions
//    	    //throw new io.cucumber.java.PendingException();
//    		System.out.println("delete 11");
//    	    clickBatch();
//    	    System.out.println("delete 12");
//    	    DeleteIcon.click();
//    	    System.out.println("delete 13");
//    	    DeleteIcon.isEnabled();
//    	    System.out.println("delete 14");
//    	    Assert.assertTrue(DeleteIcon.isEnabled(), "Delete icon is enabled");
//    	    System.out.println("delete 15");
//    	}
//    	@When("Admin click No option on delete batch")
//    	public void admin_click_no_option_on_delete_batch() {
//    	    // Write code here that turns the phrase above into concrete actions
//    	   // throw new io.cucumber.java.PendingException();
//    		System.out.println("clicking del");
//    		NoOptionDelete.click();
//    		System.out.println("clicking del done");
//    		
//    	}
//    	@Then("Batch is still listed in data table")
//    	public void batch_is_still_listed_in_data_table() {
//    	    // Write code here that turns the phrase above into concrete actions
//    	    //throw new io.cucumber.java.PendingException();
//    		Assert.assertFalse(NoOptionDelete.isDisplayed(), "NoOptionDelete has been clicked");
//
//    	}
//    	
//    	@When("Admin click yes option to delete batch")
//    	public void admin_click_yes_option_to_delete_batch() {
//    	    // Write code here that turns the phrase above into concrete actions
//    	   // throw new io.cucumber.java.PendingException();
//    	    //clickBatch();
//    	    //DeleteIcon.click();
//
//    		//YesOtionDelete.click();
//    		//Assert.assertFalse(YesOptionDelete.isDisplayed(), "YesOptionDelete has been clicked");
//
//    	}
//    	@Then("Batch deleted alert pops and batch is no more available in data table")
//    	public void batch_deleted_alert_pops_and_batch_is_no_more_available_in_data_table() {
//    	    // Write code here that turns the phrase above into concrete actions
//    	    //throw new io.cucumber.java.PendingException();
//    		//Assert.assertFalse(Deletepopup.isDisplayed(), "YesOptionDelete has been clicked");
//
//    	}
//   	

//    	// Get the page source
//    	String pageSource = driver.getPageSource();
//
//    	// Search for the message text within the page source
//    	boolean messageFound = pageSource.contains("Batch already exists with given Batch Name.");
//
//    	// Perform assertion using assertEquals
//    	assertEquals(messageFound, true, "Message 'Batch already exists with given Batch Name.' not found on the page.");
// Switch to the alert
// Alert alert = (Alert) driver.switchTo().activeElement();
//    	Alert alert = driver.switchTo().alert();
// alert.accept();

//
//
//    	// Get the text of the alert
//    	String alertText = alert.getText();
//    	System.out.println("Message is " + alertText);
//    	
//    	assertEquals(alertText, false,"Failed Batch cannot be created for a Program with Inactive status");
//    	
//    	assertEquals(alertText, false,"Successful Batch Created Successfully");

//
//    
//}
//}
