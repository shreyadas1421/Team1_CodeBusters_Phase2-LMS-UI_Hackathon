package cucumber.option;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"pretty",
		"html:target/Cucumber_html_report",
		"json:target/Cucumber_json_report.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},  
publish=true,
features={"src/test/resources/features/A_Login.feature",
		"src/test/resources/features/E_05_Assign_Staff.feature"},
//features={"src/test/resources/features/A_Login.feature","src/test/resources/features/E_01_User_Page_Validation.feature",
		//"src/test/resources/features/E_02_User_Add_New_User.feature","src/test/resources/features/E_03_User_Edit_User.feature"},

//features={"src/test/resources/features"},

glue="stepDefinations")
public class TestRunner  extends AbstractTestNGCucumberTests{

}
