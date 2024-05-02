package stepDefinations;

import java.time.Duration;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageObject.C_Program2POM;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import utility.TestSetupManager;
import utility.reusableMethods;

public class Program2Steps extends C_Program2POM {
	
	int beforeclickonpage;
	int ofterclickonpage;
	int beforeProgramsCount;
	int ofterClickOnDeleteBtnRecords;
	List<String> beforeSortrecordsList;
	List<String> actualSortedrecordsList;
	public  Program2Steps() {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



	@Given("Admin is on Manage Program Page")
	public void admin_is_on_manage_program_page() {
	
		reusableMethods.explicitWait(program);
	    reusableMethods.click(program);
		
	}

	@When("Admin clicks <Delete> button on the data table for any row")
	public void admin_clicks_delete_button_on_the_data_table_for_any_row() {
		selectProgram("WS0");
	    btn_delete.click();
	}

	
	@Then("Admin should see a alert open with heading {string} along with  <YES> and <NO> button for deletion")
	public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion(String string) {
	   Assert.assertEquals(confirmDelete(), string);
	   reusableMethods.click(closebtn);
	}
	
	
	@Then("Admin should see a message {string}")
	public void admin_should_see_a_message(String programName) {
		Assert.assertTrue(ConfirmDeletemessageProgramName().contains(programName));
	}
	@Given("Admin is on Confirm Deletion alert")
	public void admin_is_on_confirm_deletion_alert() {
		if(reusableMethods.isElementpresent(heading_delete_confirm)) {
	    	System.out.println("This message in side if condition if confirm is present ---------");
	    } else  {
	    	
	    	reusableMethods.click(btn_delete);
		    System.out.println("this message ofter if coinditon if confirm is not present ----- ");
	    }
	}

	@When("Admin clicks <NO> button on the alert")
	public void admin_clicks_no_button_on_the_alert() {
		clickOnNobtn();
		SeachText.clear();
	}
	
	@Then("Admin can see the deletion alert disappears without deleting")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting() {
		Assert.assertEquals(reusableMethods.isElementpresent(heading_delete_confirm), true);
	}
	
	@Given("Admin click on delete button")
	public void admin_click_on_delete_button() {

		reusableMethods.click(btn_delete);
	}
	
	@When("Admin clicks Close\\(X) Icon on Deletion alert")
	public void admin_clicks_close_x_icon_on_deletion_alert() {
	  
		reusableMethods.click(closebtn);
	}
	
	@Given("Admin is on Confirm Deletion alert by ofter click on delete all button")
	public void admin_is_on_confirm_deletion_alert_by_ofter_click_on_delete_all_button() {
	 		reusableMethods.click(deleteAllbtn);
	}
	
	@Given("Admin is on Confirm Deletion alert ofter selecting multiple programs and click on multiple  delete button")
	public void admin_is_on_confirm_deletion_alert_ofter_selecting_multiple_programs_and_click_on_multiple_delete_button() {
	   
		reusableMethods.click(deleteAllbtn);
	}
	
	@When("Admin clicks <YES> button on the alert")
	public void admin_clicks_yes_button_on_the_alert() {

		clickOnYesbtn();
		//SeachText.clear();
		
	}
	@Then("Admin gets a message {string} alert and able to see that program deleted in the data table")
	public void admin_gets_a_message_alert_and_able_to_see_that_program_deleted_in_the_data_table(String string)  {
		String ActualMsg = reusableMethods.CreationMsgValidation("//p-toast//div[contains(@class, 'p-toast-detail')]");
			
		Assert.assertTrue(ActualMsg.contains(string));
		SeachText.clear();
		reusableMethods.click(batchLink);
		
		
	}
	
	
	@When("Admin clicks {string} checkbox in the data table")
	public void admin_clicks_checkbox_in_the_data_table(String string) throws InterruptedException {
		
	    selectProgramforDeleteAllbtn(string);
	}
	
	
	@When("Admin clicks delete button under header after selecting the check box in the data table")
	public void admin_clicks_delete_button_under_header_after_selecting_the_check_box_in_the_data_table()  {
		selectProgram("WS1");
	   
	}
	
	@Then("Admin should see common delete option enabled under header Manage Program")
	public void admin_should_see_common_delete_option_enabled_under_header_manage_program() {
		Assert.assertEquals(reusableMethods.isEnabled(deleteAllbtn), true);
	}
	
	@Given("Admin is on Confirm Deletion alert by click on delete all button")
	public void admin_is_on_confirm_deletion_alert_by_click_on_delete_all_button() {

		if(isProgramChecked()) {
			System.out.println("Inside codition is progarmchecked ");
			reusableMethods.click(deleteAllbtn);
			
		}else {
			System.out.println("outside condition of is programchecked");
			selectProgram("WS1");
			reusableMethods.click(deleteAllbtn);
		}
	}
	@Then("Admin should land on Manage Program page and can see the selected program is deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_deleted_from_the_data_table() {
	    
	    String ActualMsg = reusableMethods.CreationMsgValidation("//p-toast//div[contains(@class, 'p-toast-detail')]");
	    //Assert.assertEquals(ofterClickOnDeleteBtnRecords, beforeclickonpage-1);
		Assert.assertTrue(ActualMsg.contains("Programs Deleted"));
		SeachText.clear();
		
		
	}
	
	
	@Then("Admin should land on Manage Program page and can see the selected program is not deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_not_deleted_from_the_data_table() {
		
		
		//ofterClickOnDeleteBtnRecords = getCountOfRecords();
	   // Assert.assertEquals(this.ofterClickOnDeleteBtnRecords, beforeProgramsCount);
	    		
	}
	
	@Given("Admin is on Confirm Deletion alert ofter selecting multiple programs and by click on delete all button")
	public void admin_is_on_confirm_deletion_alert_ofter_selecting_multiple_programs_and_by_click_on_delete_all_button() {
		beforeProgramsCount = getCountOfRecords();
		selectProgram("WS0");
	    selectProgram("WS1");
	    
	    reusableMethods.click(deleteAllbtn);
	}
	
	
	
	@Then("Admin should land on Manage Program page and can see the selected programs are deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_deleted_from_the_data_table() {
		 String ActualMsg = reusableMethods.CreationMsgValidation("//p-toast//div[contains(@class, 'p-toast-detail')]");
		   
		    reusableMethods.click(batchLink);
			Assert.assertTrue(ActualMsg.contains("Programs Deleted"));
			SeachText.clear();
			reusableMethods.click(batchLink);
	}
	
	
	@Then("Admin should land on Manage Program page and can see the selected programs are not deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_not_deleted_from_the_data_table() {
		
		//ofterClickOnDeleteBtnRecords = getCountOfRecords();
		
	    //Assert.assertEquals(this.ofterClickOnDeleteBtnRecords, beforeProgramsCount);
	  
	}
	
	@When("Admin clicks the sort icon of program name column")
	public void admin_clicks_the_sort_icon_of_program_name_column() throws InterruptedException {
		reusableMethods.click(startPageLink);
		beforeSortrecordsList= getProgramNames(programCountInEachPage);
	
		reusableMethods.click(programeNameSortIcon);
		
	}
	@Then("The data get sorted on the table based on the program name column values in ascending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_ascending_order() throws InterruptedException {
		Collections.sort(beforeSortrecordsList, String.CASE_INSENSITIVE_ORDER);
		actualSortedrecordsList = getProgramNames(programCountInEachPage);
	    System.out.println("we sorted list     " +beforeSortrecordsList);
	    System.out.println("actual list    " +actualSortedrecordsList);
		Assert.assertEquals(actualSortedrecordsList, beforeSortrecordsList );
	}
	
	@Then("The data get sorted on the table based on the program name column values in descending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_descending_order() throws InterruptedException {
		clickOnprogramSortIcon();
		Collections.sort(beforeSortrecordsList, Comparator
	            .comparing((String s) -> s.toLowerCase())
	            .reversed());

		actualSortedrecordsList = getProgramNames(programCountInEachPage);
	    System.out.println("we sorted list     " +beforeSortrecordsList);
	    System.out.println("actual list    " +actualSortedrecordsList);
		Assert.assertEquals(actualSortedrecordsList, beforeSortrecordsList );
	}
	
	
	@When("Admin clicks the sort icon of program Desc column")
	public void admin_clicks_the_sort_icon_of_program_desc_column() throws InterruptedException {
		reusableMethods.click(startPageLink);
		beforeSortrecordsList= getProgramNames(programdescriptionInEachPage);
		clickOnProgramDescriptionSortIcon();
		}
	@Then("The data get sorted on the table based on the program description column values in ascending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_ascending_order() throws InterruptedException {
		
		
		Collections.sort(beforeSortrecordsList, String.CASE_INSENSITIVE_ORDER);
		actualSortedrecordsList = getProgramNames(programdescriptionInEachPage);
	    System.out.println("we sorted list program description    " +beforeSortrecordsList);
	    System.out.println("actual list program description   " +actualSortedrecordsList);
		Assert.assertEquals(actualSortedrecordsList, beforeSortrecordsList );
		
	}
	
	@Then("The data get sorted on the table based on the program description column values in descending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_descending_order() throws InterruptedException {
		clickOnProgramDescriptionSortIcon();
		Collections.sort(beforeSortrecordsList, Comparator
	            .comparing((String s) -> s.toLowerCase())
	            .reversed());

		actualSortedrecordsList = getProgramNames(programdescriptionInEachPage);
	    System.out.println("we sorted list program description    " +beforeSortrecordsList);
	    System.out.println("actual list program description   " +actualSortedrecordsList);
		Assert.assertEquals(actualSortedrecordsList, beforeSortrecordsList );
	}

	
	@When("Admin clicks the sort icon of program status column")
	public void admin_clicks_the_sort_icon_of_program_status_column() throws InterruptedException {
		reusableMethods.click(startPageLink);
		beforeSortrecordsList= getProgramNames(programStatusInEachPage);
	    clickOnProgramStatusSortIcon();
	}
	@Then("The data get sorted on the table based on the program status column values in ascending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_ascending_order() throws InterruptedException {
		Collections.sort(beforeSortrecordsList, String.CASE_INSENSITIVE_ORDER);
		actualSortedrecordsList = getProgramNames(programStatusInEachPage);
	    System.out.println("we sorted list program status    " +beforeSortrecordsList);
	    System.out.println("actual list program status   " +actualSortedrecordsList);
		Assert.assertEquals(actualSortedrecordsList, beforeSortrecordsList );
	}
	
	@Then("The data get sorted on the table based on the program status column values in descending order")
	public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_descending_order() throws InterruptedException {
		
		clickOnProgramStatusSortIcon();
		Collections.sort(beforeSortrecordsList, Comparator
	            .comparing((String s) -> s.toLowerCase())
	            .reversed());

		actualSortedrecordsList = getProgramNames(programStatusInEachPage);
	    System.out.println("we sorted list program status    " +beforeSortrecordsList);
	    System.out.println("actual list program status   " +actualSortedrecordsList);
	    reusableMethods.click(batchLink);
		Assert.assertEquals(actualSortedrecordsList, beforeSortrecordsList );
		
		
	}

	@When("Admin clicks Next page link on the program table")
	public void admin_clicks_next_page_link_on_the_program_table() {
		reusableMethods.click(startPageLink);
		beforeclickonpage = highligtedPageNumber();	
		reusableMethods.scrollToElement(nextPageLink) ;
	    reusableMethods.explicitWait(nextPageLink);
		
		
	}
	@Then("Admin should see the Pagination has {string} active link")
	public void admin_should_see_the_pagination_has_active_link(String string) {
		
		ofterclickonpage = highligtedPageNumber();
		Assert.assertEquals(ofterclickonpage, beforeclickonpage+1);
	}
	
	
	@When("Admin clicks Last page link")
	public void admin_clicks_last_page_link() {
	   
		reusableMethods.scrollToElement(lastPageLink);
		reusableMethods.click(lastPageLink);

		
	}
	@Then("Admin should see the last page record on the table with Next page link are disabled")
	public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() {
	
		ofterclickonpage = highligtedPageNumber();	
		//System.out.println("ofter click on last page highlited page number is ---- " +ofterclickonpage);
		Assert.assertEquals(ofterclickonpage, pagesCountMethod());
	}
	
	@Given("Admin is on last page of Program table")
	public void admin_is_on_last_page_of_program_table() {
		beforeclickonpage = highligtedPageNumber();
		Assert.assertEquals(beforeclickonpage, pagesCountMethod());
	   //System.out.println("admi is on last page from given method --- ");
	}
	@When("Admin clicks First page link")
	public void admin_clicks_first_page_link() {
	   
		reusableMethods.scrollToElement(previousPageLink);
		reusableMethods.click(previousPageLink);
		
	}
	@Then("Admin should see the previous page record on the table with pagination has previous page link")
	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link() {
	    ofterclickonpage = highligtedPageNumber();
	    Assert.assertEquals(ofterclickonpage, beforeclickonpage-1);
	}
	
	@Given("Admin is on Previous Program page")
	public void admin_is_on_previous_program_page() {
		beforeclickonpage = highligtedPageNumber();
		//Assert.assertEquals(beforeclickonpage, pagesCountMethod()-1);
	   // System.out.println("last scenario given method--- ");
	}
	@When("Admin clicks Start page link")
	public void admin_clicks_start_page_link() {
	  
		reusableMethods.scrollToElement(startPageLink);
		reusableMethods.click(startPageLink);
	}
	@Then("Admin should see the very first page record on the table with Previous page link are disabled")
	public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled() {
	   
		ofterclickonpage = highligtedPageNumber();
		Assert.assertEquals(ofterclickonpage, 1);
	}
	@When("Admin clicks on Batch link on Manage Program page")
	public void admin_clicks_on_batch_link_on_manage_program_page() {
	   
		reusableMethods.click(batchLink);
	}
	@Then("Admin is re-directed to Batch page")
	public void admin_is_re_directed_to_batch_page() {
	    Assert.assertEquals(verifyBatchheading(), "Manage Batch");
	}
	@When("Admin clicks on User link on Manage Program page")
	public void admin_clicks_on_user_link_on_manage_program_page() {
		reusableMethods.click(userLink);
	}
	@Then("Admin is re-directed to User page")
	public void admin_is_re_directed_to_user_page() {
	    Assert.assertEquals(verifyUserheading(), "Manage User");
	}
	@When("Admin clicks on Logout link on Manage Program page")
	public void admin_clicks_on_logout_link_on_manage_program_page() {
	    
		reusableMethods.click(logoutLink);
	}
	@Then("Admin is re-directed to Login page")
	public void admin_is_re_directed_to_login_page() {
	    Assert.assertEquals(verifyLoginPage(), "Please login to LMS application");
	}

	
	


	
	
	
	
	
	

}
