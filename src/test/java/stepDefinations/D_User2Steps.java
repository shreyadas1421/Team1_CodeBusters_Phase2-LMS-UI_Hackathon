package stepDefinations;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import PageObject.D_User2POM;
import io.cucumber.java.en.*;
import utility.reusableMethods;

public class D_User2Steps extends D_User2POM {
	
	List<String> beforeSortrecordsList;
	List<String> actualSortedrecordsList;
	
	//public static WebDriver driver;
	public  D_User2Steps() {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	@Given("Admin is on Manage User Page")
	public void admin_is_on_manage_user_page() {
	    reusableMethods.click(userLink);
	}
	@When("Admin clicks the delete icon")
	public void admin_clicks_the_delete_icon() {
	    reusableMethods.selectProgram("sreevidya", SeachText);
	    clickOnCheckbox("sreevidya");
	    reusableMethods.click(btn_delete);
	}
	
	@Given("Admin is on Confirm Deletion alert in user")
	public void admin_is_on_confirm_deletion_alert_in_user() {
		if(reusableMethods.isElementpresent(heading_delete_confirm)) {
			System.out.println("delete confirm method from inside loop");
			reusableMethods.click(btn_delete);
		}
		 else  {
	    	reusableMethods.click(btn_delete);
		    System.out.println("this message ofter if coinditon if confirm is not present ----- ");
	    }
	}
	@When("Admin clicks <NO> button on the alert in User")
	public void admin_clicks_no_button_on_the_alert_in_user() {
		reusableMethods.click(confirm_No_btn);
	}

	@Then("Admin gets a message {string} alert and do not see that user in the data table in user")
	public void admin_gets_a_message_alert_and_do_not_see_that_user_in_the_data_table_in_user(String string) {
		String ActualMsg = reusableMethods.CreationMsgValidation("//p-toast//div[contains(@class, 'p-toast-detail')]");
		System.out.println("program delted info " +ActualMsg);
		System.out.println("expected message  " + string);
		Assert.assertTrue(ActualMsg.contains(string));
		SeachText.clear();
		reusableMethods.flentWait(userLink);
	}
	@Then("Admin gets a message {string} alert and do not see that user in the data table")
	public void admin_gets_a_message_alert_and_do_not_see_that_user_in_the_data_table(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("Admin clicks any checkbox in the data table in User page")
	public void admin_clicks_any_checkbox_in_the_data_table_in_user_page() {
		// reusableMethods.selectProgram("Mary", SeachText);
		  //  clickOnCheckbox("Mary");
		   // reusableMethods.click(c);
		   
	}
	@Given("Admin is on Confirm Deletion alert by click on delete all button in User")
	public void admin_is_on_confirm_deletion_alert_by_click_on_delete_all_button_in_user() {
		if(isProgramChecked()) {
			System.out.println("Inside codition is progarmchecked ");
			reusableMethods.click(deleteAllbtn);
			
		}else {
			System.out.println("outside condition of is programchecked");
			reusableMethods.selectProgram("sreevidya", SeachText);
		    clickOnCheckbox("sreevidya");
			reusableMethods.click(deleteAllbtn);
		}
	}
	
	@Given("Admin is on Confirm Deletion alert by click on delete all button in User ofter selecting multiple user")
	public void admin_is_on_confirm_deletion_alert_by_click_on_delete_all_button_in_user_ofter_selecting_multiple_user() {
		if(isProgramChecked()) {
			System.out.println("Inside codition is progarmchecked ");
			reusableMethods.selectProgram("######", SeachText);
		    clickOnCheckbox("######");
			reusableMethods.click(deleteAllbtn);
			
		}else {
			
			System.out.println("outside condition of is programchecked");
			reusableMethods.selectProgram("sreevidya", SeachText);
			clickOnCheckbox("sreevidya");
			reusableMethods.selectProgram("######", SeachText);
		    clickOnCheckbox("######");
		    reusableMethods.click(deleteAllbtn);
		    }
			
		
	}

	
@Then("Admin should land on Manage User page and can see the selected user is not deleted from the data table")
public void admin_should_land_on_manage_user_page_and_can_see_the_selected_user_is_not_deleted_from_the_data_table() {
    System.out.println("user not deletede from table");
}

@Then("Admin should land on Manage User page and can see the selected users are deleted from the data table")
public void admin_should_land_on_manage_user_page_and_can_see_the_selected_users_are_deleted_from_the_data_table() {
    System.out.println("user deleted succesfully with delete alla");
}


@When("Admin clicks on ID sort icon")
public void admin_clicks_on_id_sort_icon() {
	beforeSortrecordsList= getProgramNames(userIdsInEachPage);
    reusableMethods.click(userIdSortIcon);
}

@Then("Admin should see User details are sorted by id")
public void admin_should_see_user_details_are_sorted_by_id() {
    Collections.sort(beforeSortrecordsList, String.CASE_INSENSITIVE_ORDER);
	actualSortedrecordsList = getProgramNames(userIdsInEachPage);
    System.out.println("we sorted list program description    " +beforeSortrecordsList);
    System.out.println("actual list program description   " +actualSortedrecordsList);
	Assert.assertEquals(actualSortedrecordsList, beforeSortrecordsList );
}

@When("Admin clicks on name sort icon")
public void admin_clicks_on_name_sort_icon() {
	reusableMethods.click(startPageLink);
	beforeSortrecordsList= getProgramNames(userNamesInEachPage);
    reusableMethods.click(userNameSortIcon);
}

@Then("Admin should see User details are sorted by name")
public void admin_should_see_user_details_are_sorted_by_name() {
	Collections.sort(beforeSortrecordsList, String.CASE_INSENSITIVE_ORDER);
	actualSortedrecordsList = getProgramNames(userNamesInEachPage);
    System.out.println("we sorted list program description    " +beforeSortrecordsList);
    System.out.println("actual list program description   " +actualSortedrecordsList);
	Assert.assertEquals(actualSortedrecordsList, beforeSortrecordsList );
	
}

@When("Admin clicks on Location sort icon")
public void admin_clicks_on_location_sort_icon() {
	
	reusableMethods.click(startPageLink);
	beforeSortrecordsList= getProgramNames(userLocationInEachPage);
	 reusableMethods.click(userLocationSortIcon);
}

@Then("Admin should see User details are sorted by Location")
public void admin_should_see_user_details_are_sorted_by_location() {
	Collections.sort(beforeSortrecordsList, String.CASE_INSENSITIVE_ORDER);
	actualSortedrecordsList = getProgramNames(userLocationInEachPage);
    System.out.println("we sorted list program description    " +beforeSortrecordsList);
    System.out.println("actual list program description   " +actualSortedrecordsList);
	Assert.assertEquals(actualSortedrecordsList, beforeSortrecordsList );
	
}

@When("Admin clicks on Phone number sort icon")
public void admin_clicks_on_phone_number_sort_icon() {
	reusableMethods.click(startPageLink);
	beforeSortrecordsList= getProgramNames(userPhonenumberInEachPage);
	 reusableMethods.click(userPhoneNumberSortIcon);
}

@Then("Admin should see User details are sorted by Phone number")
public void admin_should_see_user_details_are_sorted_by_phone_number() {
	Collections.sort(beforeSortrecordsList, String.CASE_INSENSITIVE_ORDER);
	actualSortedrecordsList = getProgramNames(userPhonenumberInEachPage);
    System.out.println("we sorted list program description    " +beforeSortrecordsList);
    System.out.println("actual list program description   " +actualSortedrecordsList);
	Assert.assertEquals(actualSortedrecordsList, beforeSortrecordsList );
	reusableMethods.click(startPageLink);
}




	

}
