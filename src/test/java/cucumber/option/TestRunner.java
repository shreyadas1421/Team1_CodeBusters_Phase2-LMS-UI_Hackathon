package cucumber.option;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"pretty"},
        features={"src/test/resources/features/A_Login.feature",
                "src/test/resources/features/C_A_ManageProgram.feature",
                "src/test/resources/features/C_B_ManageProgram.feature",
                "src/test/resources/features/C_C_ManageProgram.feature"
        },
        glue="stepDefinations")
public class TestRunner  extends AbstractTestNGCucumberTests{

}