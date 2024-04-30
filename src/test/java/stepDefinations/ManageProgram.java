package stepDefinations;

import PageObject.A_LoginPOM;
//import PageObject.C_ProgramPOM;
import PageObject.C_ProgramPOM;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utility.TestSetupManager;
import utility.reusableMethods;

import static utility.TestBase.driver;
//import utility.TestSetupManager;

public class ManageProgram extends C_ProgramPOM {
PageObject.A_LoginPOM a_loginPOM = new PageObject.A_LoginPOM(driver);
     //TestSetupManager testSetupManager;
//    C_ProgramPOM c_programPOM;
     public ManageProgram() {
         this.driver = driver;
         PageFactory.initElements(driver, this);
     }

    private reusableMethods reusablemethod = new reusableMethods(driver);


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
        addNewProgramButton.click();
    }

    @Then("Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
    public void admin_should_see_a_popup_open_for_program_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
        System.out.println("my test ");
        Assert.assertTrue(isSaveAndCancelVisibleInAddProgramPopup());
    }

}
