package cucumber.option;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(plugin = {"pretty",
		"html:target/Cucumber_html_report",
		"json:target/Cucumber_json_report.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},  
publish=true,
//features={"src/test/resources/features/A_Login.feature",
//		"src/test/resources/features/B_Dashboard.feature","src/test/resources/features/C_A_ManageProgram.feature",
//		"src/test/resources/features/C_B_ManageProgram.feature","src/test/resources/features/C_C_ManageProgram.feature",
//		"src/test/resources/features/D_A_BatchPageValidation.feature","src/test/resources/features/D_B_AddNewBatch.feature",
//		"src/test/resources/features/D_C_EditBatch.feature"},
//	"src/test/resources/features/E_02_User_Add_New_User.feature","src/test/resources/features/E_03_User_Edit_User.feature"},
// features={"src/test/resources/features/A_Login.feature","src/test/resources/features/B_Dashboard.feature",
//		"src/test/resources/features/C_A_ManageProgram.feature","src/test/resources/features/C_B_ManageProgram.feature",
//		"src/test/resources/features/C_C_ManageProgram.feature","src/test/resources/features/D_A_BatchPageValidation.feature",
//		"src/test/resources/features/D_B_AddNewBatch.feature","src/test/resources/features/D_C_EditBatch.feature"},

//features={"src/test/resources/features/A_Login.feature","src/test/resources/features/B_Dashboard.feature",
//		"src/test/resources/features/D_A_BatchPageValidation.feature",
//		"src/test/resources/features/D_B_AddNewBatch.feature","src/test/resources/features/D_C_EditBatch.feature"},

features={"src/test/resources/features"},

glue="stepDefinations")

public class TestRunner  extends AbstractTestNGCucumberTests{

}
