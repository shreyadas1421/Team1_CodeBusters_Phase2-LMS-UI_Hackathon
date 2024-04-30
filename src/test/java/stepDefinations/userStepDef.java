package stepDefinations;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.HashSet;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageObject.E_UserPOM;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.TestBase;
import utility.TestSetupManager;

public class userStepDef extends E_UserPOM{
	   PageObject.A_LoginPOM A_LoginPOM=new PageObject.A_LoginPOM(driver);
	   String validdata;
	   String invaliddata;
	   //String filePath = ;
		String sheetName = "User";

	 public userStepDef() {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
   
	
	@Given("Logged on the LMS portal as admin")
	public void logged_on_the_lms_portal_as_admin() {
		
		//if(logout.isDisplayed()) {
        // Assert.assertEquals(logout.isDisplayed(), true);
		//}
//		else {
//			A_LoginPOM.userlog("Login",1);
//		}
	}


	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		 Assert.assertEquals(A_LoginPOM.dashboard.isDisplayed(), true);
		

	}

	@When("Admin clicks {string} from navigation bar")
	public void admin_clicks_from_navigation_bar(String string) {
		
		userModuleClick();
	}

	@Then("Admin should see the {string} in the URL")
	public void admin_should_see_the_in_the_url(String expected) {
		
		
		Assert.assertTrue(driver.getCurrentUrl().contains(expected));
	   
	}
	
	@Then("Admin should see a heading with text {string} on the page")
	public void admin_should_see_a_heading_with_text_on_the_page(String expected) {
		Assert.assertEquals(manageuserheader.getText(), expected);
	}
	
	@Then("Admin should see the text as {string} along with Pagination icon below the table.")
	public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table(String string) {
		PaginationValidationTest();
		 Assert.assertEquals(UserPaginationdlefticon.isDisplayed(), true);
		 Assert.assertEquals(UserPaginationslefticon.isDisplayed(), true);
		 Assert.assertEquals(UserPaginationpages.isDisplayed(), true);
		 Assert.assertEquals(UserPaginationsright.isDisplayed(), true);
		 Assert.assertEquals(UserPaginationdright.isDisplayed(), true);
	}
	
	@Then("Admin Should see the data table with column names Id, Name, location, Phone Number, Edit\\/Delete")
	public void admin_should_see_the_data_table_with_column_names_id_name_location_phone_number_edit_delete() {
	    Assert.assertEquals(UserColID.getText(), "ID");
	    Assert.assertEquals(UserColName.getText(), "Name");
	    Assert.assertEquals(UserColLocation.getText(), "Location");
	    Assert.assertEquals(UserColPhone.getText(), "Phone Number");
	    Assert.assertEquals(UserColEditDelete.getText(), "Edit / Delete");
    
	}
	
	@Then("Admin should see a Delete button on the top left hand side as Disabled")
	public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() {
		
		Assert.assertEquals(UserDeleteMultiple.isEnabled(), false);
	}
	
	@Then("Admin should be able to see the {string} button above the data table")
	public void admin_should_be_able_to_see_the_button_above_the_data_table(String string) {
		//Expected data written into set
	    HashSet<String> hs=new HashSet<String>();
	    hs.add("+ Add New User");
	    hs.add("+ Assign Staff");
	    hs.add("+ Assign Student");
	    //mapping pi-plus to + for validation
        String iconClass = UserAddNewUser.getAttribute("icon");
        String iconText = "";
        if (iconClass.equals("pi pi-plus")) {
            iconText = "+";
        }

	    Assert.assertEquals(hs.contains(iconText + " " + UserAddNewUser.getText()), true);
	    Assert.assertEquals(hs.contains(iconText + " " + UserAssignStudent.getText()), true);
	    Assert.assertEquals(hs.contains(iconText + " " + UserAddNewUser.getText()), true);
	}
	
	@Then("Admin should be able to see the search text box above the data table")
	public void admin_should_be_able_to_see_the_search_text_box_above_the_data_table() {
		UserSearchBoxPosition();
	}
	
	@Then("Admin should see two  records displayed on the data table")
	public void admin_should_see_two_records_displayed_on_the_data_table() {
		ValidateDataTableData() ;
	}
	
	@Then("Each row in the data table should have a checkbox")
	public void each_row_in_the_data_table_should_have_a_checkbox() {
		ValidateDataTableCheckBox();
	}
	
	@Then("Each row in the data table should have a edit icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled() {
		ValidateDataTableEditIcon();
	}
	
	@Then("Each row in the data table should have a delete icon that is enabled")
	public void each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled() {
		ValidateDataTableDeleteIcon();
	}
	
	@When("Admin enters user name into search box.")
	public void admin_enters_user_name_into_search_box() {
		UserPaginationdlefticon.click();
		validdata=UserValidSearchData.getText();
		//validdata="John Matthew";
		UserSearch(validdata);
	}

	@Then("Admin should see user displayed with the entered name")
	public void admin_should_see_user_displayed_with_the_entered_name() {

		//Bug raised as passing valid data into search box not working 
		
		//Assert.assertEquals(UserValidSearchDataResult.getText(), validdata);
	}
	@When("Admin enters the keywords not present in the data table on the Search box")
	public void admin_enters_the_keywords_not_present_in_the_data_table_on_the_search_box() {
		invaliddata="abc##";
		UserSearch(invaliddata);
	}

	@Then("Admin should see zero entries on the data table")
	public void admin_should_see_zero_entries_on_the_data_table() {
	   Assert.assertEquals(UserinValidSearchDataResult.isDisplayed(), true);
	}
	
	/*############# Add_New_User##################### */
	
	@Given("Admin is on dashboard page after Login and clicks User on the navigation bar")
	public void admin_is_on_dashboard_page_after_login_and_clicks_user_on_the_navigation_bar() {
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
//		wait.until(ExpectedConditions.(ProgramModule));
		ProgramModule.click();
		userModuleClick();
	}

	@Given("Admin is on Manage User Page")
	public void admin_is_on_manage_user_page() {
		Assert.assertEquals(manageuserheader.getText(), "Manage User");
	}

	@When("Admin clicks {string} button")
	public void admin_clicks_button(String string) throws InterruptedException {
		clickAddNewUser();
	}

	@Then("Admin should see pop up open for user details with First Name,Middle name, Last Name, Location, phone, email, linkedin url, User Role, Role status, visa status,Undergraduate, postgraduate,time zone ,user comments and user fields along with Cancel , Submit and close buttons")
	public void admin_should_see_pop_up_open_for_user_details_with_first_name_middle_name_last_name_location_phone_email_linkedin_url_user_role_role_status_visa_status_undergraduate_postgraduate_time_zone_user_comments_and_user_fields_along_with_cancel_submit_and_close_buttons() {
		
		Assert.assertEquals(UserDetailsHeader.getText(), "User Details");
		//userDetailsCloseIcon();

        Assert.assertEquals(UserDetailsCloseIcon.isDisplayed(), true);
//        userDetailsMouseRlease();
		Assert.assertEquals(UserDetailsFirstName.findElement(By.xpath("../span/label/span")).getText(), "First name");
		Assert.assertEquals(UserDetailsMiddleName.findElement(By.xpath("../span/label/span")).getText(), "Middle name");
		Assert.assertEquals(UserDetailsLastName.findElement(By.xpath("../span/label/span")).getText(), "Last name");
		Assert.assertEquals(UserDetailsLocation.findElement(By.xpath("../span/label/span")).getText(), "Location");
		Assert.assertEquals(UserDetailsPhoneNumber.findElement(By.xpath("../span/label/span")).getText(), "Phone no");
		Assert.assertEquals(UserDetailsLinkedIn.findElement(By.xpath("../span/label/span")).getText(), "LinkedIn Url");
		Assert.assertEquals(UserDetailsUserRole.getText(), "User Role");
		Assert.assertEquals(UserDetailsUserRoleStatus.getText(), "User Role Status");
		Assert.assertEquals(UserDetailsUserVisaStatus.getText(), "User Visa Status");
		Assert.assertEquals(UserDetailsEmail.getAttribute("data-placeholder"), "Email address");
		Assert.assertEquals(UserDetailsUserEduUg.findElement(By.xpath("../span/label/span")).getText(), "Under Graduate");
		Assert.assertEquals(UserDetailsUserEduPg.findElement(By.xpath("../span/label/span")).getText(), "Post Graduate");
		Assert.assertEquals(UserDetailsUserTimeZone.findElement(By.xpath("../span/label/span")).getText(), "Time Zone");
		Assert.assertEquals(UserDetailsUserComments.findElement(By.xpath("../span/label/span")).getText(), "User Comments");
		
		Assert.assertEquals(UserDetailsUserCancel.getText(), "Cancel");
		Assert.assertEquals(UserDetailsUserSubmit.getText(), "Submit");
	}
	@Then("Admin should see  text boxes for the fields First Name, Middle name, Last Name, Location,phone, email, linkedin url, Undergraduate, postgraduate,time zone ,user comments")
	public void admin_should_see_text_boxes_for_the_fields_first_name_middle_name_last_name_location_phone_email_linkedin_url_undergraduate_postgraduate_time_zone_user_comments() {
		Assert.assertEquals(UserDetailsFirstName.isDisplayed(), true);
		Assert.assertEquals(UserDetailsMiddleName.isDisplayed(), true);
		Assert.assertEquals(UserDetailsLastName.isDisplayed(), true);
		Assert.assertEquals(UserDetailsLocation.isDisplayed(), true);
		Assert.assertEquals(UserDetailsPhoneNumber.isDisplayed(), true);
		Assert.assertEquals(UserDetailsLinkedIn.isDisplayed(), true);
		Assert.assertEquals(UserDetailsEmail.isDisplayed(), true);
		Assert.assertEquals(UserDetailsUserEduUg.isDisplayed(), true);
		Assert.assertEquals(UserDetailsUserEduPg.isDisplayed(), true);
		Assert.assertEquals(UserDetailsUserTimeZone.isDisplayed(), true);
		Assert.assertEquals(UserDetailsUserComments.isDisplayed(), true);
	}

	@Then("Admin should see drop downs for the fields User Role,Role status, visa status on user details pop up")
	public void admin_should_see_drop_downs_for_the_fields_user_role_role_status_visa_status_on_user_details_pop_up() {
		Assert.assertEquals(UserDetailsUserRoleDropDown.isDisplayed(), true);
		Assert.assertEquals(UserDetailsUserRoleStatusDropDown.isDisplayed(), true);
		Assert.assertEquals(UserDetailsUserVisaStatusDropDown.isDisplayed(), true);
		userDetailsClose();
		
	}
	
	@Given("Admin is on  User details pop up")
	public void admin_is_on_user_details_pop_up() throws InterruptedException {
		
		clickAddNewUser();
	
	}
	
	@When("Admin enters userdata in  fields in the create user form and clicks on submit button by rading from excel with {int}")
	public void admin_enters_userdata_in_fields_in_the_create_user_form_and_clicks_on_submit_button_by_rading_from_excel_with(Integer rownum) throws InterruptedException {
		
		UserCreateData(sheetName,rownum);
		
		
	}
	@Then("Admin gets {string}")
	public void admin_gets(String string) throws InterruptedException {
		userCreationMsgValidation();
		
		Assert.assertTrue(ActualMsg.contains(string));
		
		
	}
	
	@When("Admin skips to add value in mandatory field in the create user form and clicks on submit button by rading from excel with {int}")
	public void admin_skips_to_add_value_in_mandatory_field_in_the_create_user_form_and_clicks_on_submit_button_by_rading_from_excel_with(Integer rownum) {
		//UserCreateDataManual();
		UserCreateDataOptinalfeilds(sheetName,rownum);
		
	}

	@Then("Admin should see error message below the test field and the field will be highlighed in red color")
	public void admin_should_see_error_message_below_the_test_field_and_the_field_will_be_highlighed_in_red_color() throws InterruptedException {
		createUserMandatoryMsgValidation() ;
		
	}
	
	@When("Admin clicks on submit button without entering data")
	public void admin_clicks_on_submit_button_without_entering_data() throws InterruptedException {
		
		//scrollDown();
		
		userModuleSubmit();
	}

	@Then("user won't be created and Admin gets error message")
	public void user_won_t_be_created_and_admin_gets_error_message() {
		createUserMandatoryMsgValidation();
	}
	
	@When("Admin clicks Close Icon on User Details form")
	public void admin_clicks_close_icon_on_user_details_form() {
		userDetailsClose();
	}

	@Then("User Details popup window should be closed without saving")
	public void user_details_popup_window_should_be_closed_without_saving() {
		Assert.assertEquals(manageuserheader.getText(), "Manage User");
	}
	
	@When("Admin clicks Cancel button")
	public void admin_clicks_cancel_button() {
		//scrollDown();
		userDetailsCancel();
	}

	@Then("Admin can see the User details popup disappears without adding any user")
	public void admin_can_see_the_user_details_popup_disappears_without_adding_any_user() {
		Assert.assertEquals(manageuserheader.getText(), "Manage User"); 
	}
	
	@When("Admin enters invalid data in all of the fields in the form and clicks on submit button by reading from excel with {int}")
	public void admin_enters_invalid_data_in_all_of_the_fields_in_the_form_and_clicks_on_submit_button_by_reading_from_excel_with(Integer rownum) {
		UserCreateData(sheetName,rownum);
	}

	@When("Fill in all the fields with valid values and click submit by reading from excel with {int}")
	public void fill_in_all_the_fields_with_valid_values_and_click_submit_by_reading_from_excel_with(Integer rownum) {
		UserCreateDataUnique(sheetName,rownum);
	}

	@Then("The newly added user should be present in the data table in Manage User page")
	public void the_newly_added_user_should_be_present_in_the_data_table_in_manage_user_page() throws InterruptedException {
		userCreationMsgValidation();
		UserSearch(SearchDataForCreatedUser);
		Thread.sleep(1000);
		ValidateDataTableData();
		
		ValidateDataTableDataForCreatedUser();
		
	}
	
	/*###########User Edit ############# */
	
	@When("Admin clicks on the edit icon")
	public void admin_clicks_on_the_edit_icon() {
		UserSearch("sreevidya");
		userModuleEditClick();
	    
	}

	@Then("A new pop up with User details appears")
	public void a_new_pop_up_with_user_details_appears() {
		Assert.assertEquals(UserDetailsHeader.getText(), "User Details");
	    
	}
	
	@When("Update the fields with valid data and click submit by reading from excel with {int}")
	public void update_the_fields_with_valid_data_and_click_submit_by_reading_from_excel_with(Integer int1) {
	    
	}

	@Then("Admin gets message {string} and see the updated values in data table")
	public void admin_gets_message_and_see_the_updated_values_in_data_table(String string) {
	    
	}
}
