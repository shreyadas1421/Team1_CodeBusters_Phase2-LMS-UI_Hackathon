package stepDefinations;

import PageObject.C_ProgramPOM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utility.reusableMethods;
//import utility.TestSetupManager;

public class ManageProgram extends C_ProgramPOM {


    private final reusableMethods reusablemethod = new reusableMethods(driver);
    PageObject.A_LoginPOM a_loginPOM = new PageObject.A_LoginPOM(driver);

    //TestSetupManager testSetupManager;
//    C_ProgramPOM c_programPOM;
    public ManageProgram() {
        driver = driver;
        PageFactory.initElements(driver, this);
    }


//    public ManageProgram(TestSetupManager testSetupManager) {
//        this.testSetupManager= testSetupManager;
//        SetDriver(driver);
//        //this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }

//    public ManageProgram(TestSetupManager testSetupManager) {
//        this.testSetupManager= testSetupManager;
//    }

    //    @Given("Logged on the LMS portal as Admin")
//    public void logged_on_the_lms_portal_as_admin() {
//        reusablemethod.explicitWait(pageObjectManager.getlogin().username);
//
//        boolean LogInPageTittle = pageObjectManager.getlogin().getTittle();
//        //System.out.println(LogInPageTittle);
//        Assert.assertEquals(LogInPageTittle, true);
//
//        System.out.println("user in main login page");
//    }
//
//    @When("User submits userName and password")
//    public void user_submits_user_name_and_password() {
//        reusablemethod.explicitWait(pageObjectManager.getlogin().username);
//
//        pageObjectManager.getlogin().userlog("Login", 1);
//
//    }
//
//    @Then("User lands on dashboard page")
//    public void user_lands_on_dashboard_page() {
//        reusablemethod.explicitWait(pageObjectManager.getlogin().dashboard);
//        boolean dashboard = pageObjectManager.getlogin().getDashboard();
//        Assert.assertEquals(dashboard, true);
//        System.out.println("user is in dashboard page");
//
//    }
//
    @Given("Program Module Admin is on dashboard page after Login")
    public void program_module_admin_is_on_dashboard_page_after_login() {
//        reusablemethod.explicitWait(A_LoginPOM.dashboard);
//        boolean dashboard = pageObjectManager.getlogin().getDashboard();
//        Assert.assertEquals(dashboard, true);
//        System.out.println("user is on dashboard page");

        Assert.assertEquals(a_loginPOM.dashboard.isDisplayed(), true);

    }

    @When("Program Module Admin clicks program link on the navigation bar")
    public void admin_clicks_on_the_navigation_bar() {
        clickProgramLink();
    }

    @Then("Program Module Admin should see URL with Manage Program")
    public void admin_should_see_url_with() {
        Assert.assertEquals(manageProgramIsVisible(), true);
    }


    @Then("Program Module Admin should see a heading with text Manage Program on the page")
    public void admin_should_see_a_heading_with_text_manage_program_on_the_page() {
        Assert.assertTrue(doesURLContaineManageProgram());
    }

    @Then("Program Module Admin should see the text as Showing x to y of z entries along with Pagination icon below the table.x- starting record number on that page.y-ending record number on that page.z-Total number of records")
    public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table_x_starting_record_number_on_that_page_y_ending_record_number_on_that_page_z_total_number_of_records() {
        Assert.assertTrue(paginationCountDisplay());
    }

    @Then("Program Module Admin should see the footer as {string}.z- Total number of records")
    public void admin_should_see_the_footer_as_z_total_number_of_records(String string) {
        Assert.assertTrue(isPaginationBelowTextVisible());
    }

    @Then("Program Module Admin should see a Delete button on the top left hand side as Disabled")
    public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() {
        Assert.assertTrue(isTableLevelDeleteButtonDisbaled());
    }

    @Then("Program Module Admin should see a +A New Program button on the program page above the data table")
    public void admin_should_see_a_button_on_the_program_page_above_the_data_table() {
        Assert.assertTrue(addNewProgramButtonVisible());
    }

    @Then("Program Module Admin should see the number of records \\(rows of data in the table) displayed on the page are 5")
    public void admin_should_see_the_number_of_records_rows_of_data_in_the_table_displayed_on_the_page_are() {
        Assert.assertEquals(5, checkCountNumberOfProgramsInTable());
    }

    @Then("Program Module Admin should see data table on the Manage Program Page with following column headers \\(Program Name, Program Description, Program Status, Edit,Delete)")
    public void admin_should_see_data_table_on_the_manage_program_page_with_following_column_headers_program_name_program_description_program_status_edit_delete() {
        Assert.assertTrue(isAllColumnHeaderAvailable());
    }

    @When("Program Module Admin clicks Program on the navigation bar")
    public void admin_clicks_program_on_the_navigation_bar() {

    }

    @Then("Program Module Admin should see the sort arrow icon beside to each column header except Edit and Delete")
    public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
        Assert.assertTrue(columnHeaderWithSortIcon());
    }

//    Second feature in ProgramModule:

    @Given("Admin is on dashboard page after Login and clicks Program on the navigation bar")
    public void admin_is_on_dashboard_page_after_login_and_clicks_program_on_the_navigation_bar() {
        program.click();
    }

    @Given("Admin is on Manage Program Page")
    public void admin_is_on_manage_program_page() {
        Assert.assertEquals(manageProgram.getText(), "Manage Program");

    }

    @When("Admin clicks A New Program button")
    public void admin_clicks_a_new_program_button() {
        clickAddNewProgramButton();
    }

    @Then("Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
    public void admin_should_see_a_popup_open_for_program_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
        System.out.println("my test ");
        Assert.assertTrue(isSaveAndCancelVisibleInAddProgramPopup());
        closeEditProgramPopup();
    }

    @Given("Admin is on Manage Program Page after clicks Program on the navigation bar")
    public void admin_is_on_manage_program_page_after_clicks_program_on_the_navigation_bar() {
        Assert.assertEquals(manageProgram.getText(), "Manage Program");

    }

    @When("Admin clicks Edit button on the data table for any row")
    public void admin_clicks_edit_button_on_the_data_table_for_any_row() {
        updateSearchProgram();
    }

    @Then("Admin should see a popup open for Program details to edit")
    public void admin_should_see_a_popup_open_for_program_details_to_edit() {
        Assert.assertTrue(editPopUp.isDisplayed());
        closeEditProgramPopup();


    }

    @Given("Admin is on Program Details Popup window to Edit")
    public void admin_is_on_program_details_popup_window_to_edit() {
        updateSearchProgram();
    }

    @When("Admin edits the Name column and clicks save button")
    public void admin_edits_the_name_column_and_clicks_save_button() {
        editProgramNamefield();
        clickSaveButtonOnAddProgramPopup();
    }

    @When("Admin edits the Description column and clicks save button")
    public void admin_edits_the_description_column_and_clicks_save_button() {
        editProgramDescriptionField();
        clickSaveButtonOnAddProgramPopup();

    }

    @Then("Admin gets a message {string} alert and able to see the updated description in the table for the particular program")
    public void admin_gets_a_message_alert_and_able_to_see_the_updated_description_in_the_table_for_the_particular_program(String string) {


    }

    @When("Admin changes the Status and clicks save button")
    public void admin_changes_the_status_and_clicks_save_button() {
        editStatusIconProgram();
        clickSaveButtonOnAddProgramPopup();
    }

    @Then("Admin gets a message {string} alert and able to see the updated status in the table for the particular program")
    public void admin_gets_a_message_alert_and_able_to_see_the_updated_status_in_the_table_for_the_particular_program(String string) {


    }

    @When("Admin clicks Cancel button on edit popup")
    public void admin_clicks_cancel_button_on_edit_popup() {
        disappearEditPopupBox();

    }

    @Then("Admin can see the Program details popup disappears and can see nothing changed for particular program")
    public void admin_can_see_the_program_details_popup_disappears_and_can_see_nothing_changed_for_particular_program() {
        Assert.assertFalse(isEditPopupVisibleAndContentsChanged());
    }

    @When("Admin clicks Save button on edit popup")
    public void admin_clicks_save_button_on_edit_popup() {
        clickSavebuttonProgram();
    }

    @Then("Admin gets a message Successful Program Updated alert and able to see the updated details in the table for the particular program")
    public void admin_gets_a_message_successful_program_updated_alert_and_able_to_see_the_updated_details_in_the_table_for_the_particular_program() {

    }


    @Then("Admin should see two input fields and their respective text boxes in the program details window")
    public void admin_should_see_two_input_fields_and_their_respective_text_boxes_in_the_program_details_window() {
        Assert.assertTrue(programNameAndDescriptionTextBoxVisible());
        closeEditProgramPopup();
    }

    @Then("Admin should see two radio button for Program Status")
    public void admin_should_see_two_radio_button_for_program_status() {
        Assert.assertEquals(2, numberOfRadioButtonsOnAddProgramPopup());
        closeEditProgramPopup();
    }

    @Given("Admin is on Program Details Popup window")
    public void admin_is_on_program_details_popup_window() {
        clickAddNewProgramButton();
    }

    @When("Admin clicks Save button without entering any data")
    public void admin_clicks_save_button_without_entering_any_data() {
        System.out.println("admin_clicks_save_button_without_entering_any_data");
        clickSaveButtonOnAddProgramPopup();
    }

    @Then("Admin gets a Error message alert")
    public void admin_gets_a_error_message_alert() {
        Assert.assertTrue(errorMessagesOnAddProgramPopup());
        closeEditProgramPopup();
    }

    @When("Admin enters only Program Name in text box and clicks Save button")
    public void admin_enters_only_program_name_in_text_box_and_clicks_save_button() {
        addProgramNameField("lmskb001");
        clickSaveButtonOnAddProgramPopup();
    }

    @Then("Admin gets a message alert Description is required")
    public void admin_gets_a_message_alert_description_is_required() {
        Assert.assertTrue(checkForErrorMessage("Description is required."));
        closeEditProgramPopup();
    }


//    @When("Enter all the required fields with valid values by reading through excel {string}, {integer} and click Save button")
//    public void enter_all_the_required_fields_with_valid_values_by_reading_through_excel_and_click_save_button(String sheetName, String rowNumber) {
//
//    }

    @When("Admin enters only Program description in text box and clicks Save button")
    public void admin_enters_only_program_description_in_text_box_and_clicks_save_button() {
        addProgramDescriptionField("lmskb001");
        clickSaveButtonOnAddProgramPopup();
    }

    @Then("Admin gets a message alert Name is required")
    public void admin_gets_a_message_alert_name_is_required() {
        Assert.assertTrue(checkForErrorMessage("Program name is required."));
        closeEditProgramPopup();
    }

    @When("Admin selects only Status and clicks Save button")
    public void admin_selects_only_status_and_clicks_save_button() {
        clickOnRadioButtonOnManageProgramPopup("Active");
        clickSaveButtonOnAddProgramPopup();
    }

    @Then("Admin gets a message alert Name and Description required")
    public void admin_gets_a_message_alert() {
        Assert.assertTrue(checkForErrorMessage("Program name is required."));
        Assert.assertTrue(checkForErrorMessage("Description is required."));
        closeEditProgramPopup();
    }

    @When("Admin enters only numbers or special char in name and desc column")
    public void admin_enters_only_numbers_or_special_char_in_name_and_desc_column() {


    }

    @Then("Program Details popup window should be closed without saving")
    public void program_details_popup_window_should_be_closed_without_saving() {


    }

    @When("Enter all the required fields with valid values and click Save button")
    public void enter_all_the_required_fields_with_valid_values_and_click_save_button() {
        addProgramAllfieldsValidValues();
        clickSavebuttonProgram();

    }

    @Then("Admin gets a message Successful Program Created alert and able to see the new program added in the data table")
    public void admin_gets_a_message_alert_and_able_to_see_the_new_program_added_in_the_data_table() throws InterruptedException {
        Assert.assertEquals(programCreationMsgValidation(), "Program Created Successfully");

    }

    @When("Admin clicks <Cancel>button")
    public void admin_clicks_cancel_button() {


    }

    @Then("Admin can see the Program details popup disappears without creating any program")
    public void admin_can_see_the_program_details_popup_disappears_without_creating_any_program() {

    }

    @Then("Admin gets a message Successful Program Updated alert and able to see the updated name in the table for the particular program")
    public void admin_gets_a_message_successful_program_updated_alert_and_able_to_see_the_updated_name_in_the_table_for_the_particular_program() throws InterruptedException {
        Assert.assertEquals(programCreationMsgValidation(), "Program Updated");
    }

    @Then("Admin gets a message Successful Program Updated alert and able to see the updated description in the table for the particular program")
    public void admin_gets_a_message_successful_program_updated_alert_and_able_to_see_the_updated_description_in_the_table_for_the_particular_program() throws InterruptedException {
        Assert.assertEquals(programCreationMsgValidation(), "Program Updated");
    }

    @Then("Admin gets a message Successful Program Updated alert and able to see the updated status in the table for the particular program")
    public void admin_gets_a_message_successful_program_updated_alert_and_able_to_see_the_updated_status_in_the_table_for_the_particular_program() throws InterruptedException {
        Assert.assertEquals(programCreationMsgValidation(), "Program Updated");
    }

    @When("Enter all the required fields with valid values by reading through excel {string}, {string} and click Save button")
    public void enterAllTheRequiredFieldsWithValidValuesByReadingThroughExcelAndClickSaveButton(String sheetName, String rowNumber) {
        System.out.println(sheetName);
        System.out.println(rowNumber);
        readProgramInfoFromExcel(sheetName, Integer.parseInt(rowNumber));
        clickSavebuttonProgram();
    }

    @When("Admin clicks Cancel\\/Close\\(X) Icon on Program Details form")
    public void adminClicksCancelCloseXIconOnProgramDetailsForm() {
        closeEditProgramPopup();
    }

//    @When("Enter all the required fields with valid values by reading through excel {string}, {int} and click Save button")
//    public void enterAllTheRequiredFieldsWithValidValuesByReadingThroughExcelRowNumberAndClickSaveButton(String sheetName, Integer rowNumber) {
//        readProgramInfoFromExcel(sheetName, rowNumber);
//    }

}
